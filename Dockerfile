FROM node:lts-bookworm-slim AS base
WORKDIR /app
RUN apt update && rm -rf /var/lib/apt/lists/

FROM base AS web-deps
WORKDIR /app
COPY web/package*.json .
RUN npm ci

FROM base AS web-production-deps
WORKDIR /app
COPY web/package*.json .
RUN npm ci --omit=dev

FROM base AS web-build
WORKDIR /app
COPY --from=web-deps /app/node_modules ./node_modules/
COPY web .
RUN npm run build

FROM node:lts-bookworm-slim AS angular
WORKDIR /app
COPY --from=web-production-deps /app/node_modules .
COPY --from=web-build /app/dist/web .
USER node
CMD [ "node", "./server/server.mjs" ]

FROM maven:3.9-eclipse-temurin-25 AS server-build
WORKDIR /app
COPY server/pom.xml .
RUN mvn dependency:go-offline -B
COPY server/src ./src
RUN mvn clean package -DskipTests -X

FROM eclipse-temurin:25-jre AS spring
WORKDIR /app
RUN apt update && apt install -y curl && rm -rf /var/lib/apt/lists/*
COPY --from=server-build /app/target/*.jar app.jar
RUN useradd -m appuser
USER appuser
EXPOSE 3000
CMD ["java", "-jar", "app.jar"]