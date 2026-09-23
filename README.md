# EuroSupply

Application de gestion d'inventaire pour vaisseau spatial

### Stack

- Angular (20.3.37)
- Java Spring Boot (4.1.1)
- PostgreSQL (18.4)
- Docker (29.7.2)

### Prérequis

Crée `.env` à la racine du projet :
```env
APP_NAME=eurosupply
POSTGRES_DB=${APP_NAME}_db
POSTGRES_USER=myuser
POSTGRES_PASSWORD=mypassword
DB_HOST=database
DB_PORT=5432
PGADMIN_DEFAULT_EMAIL=${POSTGRES_USER}@gmail.com
PGADMIN_DEFAULT_PASSWORD=${POSTGRES_PASSWORD}
SPRING_DATASOURCE_URL=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${POSTGRES_DB}
```

Modifie `server/src/main/resources/application.yaml` :
```yaml
logging:
  level:
    org.springframework.security: DEBUG

server:
  port: 3000

spring:
  application:
    name: ${APP_NAME:eurosupply}
  datasource:
    url: ${SPRING_DATASOURCE_URL:jdbc:postgresql://127.0.0.1:5432/eurosupply_db}
    username: ${POSTGRES_USER:myuser}
    password: ${POSTGRES_PASSWORD:mypassword}
  jpa:
    show-sql: true
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    open-in-view: false
    hibernate:
      ddl-auto: validate
```

### API Endpoints

#### Healthcheck

- GET /health/ping

#### Food

- GET /api/foods/
- GET /api/foods/{id}
- POST /api/foods/
- PATCH /api/foods/{id}
- DELETE /api/foods/{id}

#### Material

- GET /api/materials/
- GET /api/materials/{id}
- POST /api/materials/
- PATCH /api/materials/{id}
- DELETE /api/materials/{id}

#### Medic

- GET /api/medics/
- GET /api/medics/{id}
- POST /api/medics/
- PATCH /api/medics/{id}
- DELETE /api/medics/{id}