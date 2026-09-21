FROM maven:amazoncorretto AS server-build
WORKDIR /app
COPY server/pom.xml ./
RUN mvn dependency:go-offline -B
COPY server/src ./src
RUN mvn clean package -DskipTests

FROM openjdk:28-ea-slim-bookworm AS spring
RUN apt-get -y update; apt-get -y install curl
WORKDIR /app
COPY --from=server-build /app/target/*.jar app.jar
EXPOSE 3000
CMD ["java", "-jar", "app.jar"]