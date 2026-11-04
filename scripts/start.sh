#!/bin/bash
engine=$1
APP_NAME=$2
DB_USER=$3
DB_PASSWORD=$4
while [ -z "${engine}" ] || [ "${engine}" != "d" ] && [ "${engine}" != "p" ];
do
  read -p "Podman (p) ou Docker (d) : " engine
done

while [ -z "${APP_NAME}" ];
do
  read -p "APP_NAME=" APP_NAME
done

while [ -z "${DB_USER}" ];
do
  read -p "DB_USER=" DB_USER
done

while [ -z "${DB_PASSWORD}" ];
do
  read -p "DB_PASSWORD=" DB_PASSWORD
done

if [ "${engine}" = "d" ]; then
engine="docker"
else
engine="podman"
fi

services_run() {
"${engine}" run \
  --rm \
  -dtp 5432:5432 \
  --network "${APP_NAME}"-isolated \
  --name "${APP_NAME}"-database \
  --health-cmd="pg_isready" \
  --health-interval=10s \
  --health-timeout=10s \
  --health-start-period=30s \
  --health-retries=3 \
  -e POSTGRES_DB="${APP_NAME}"_db \
  -e POSTGRES_USER="${DB_USER}" \
  -e POSTGRES_PASSWORD="${DB_PASSWORD}" \
  -v "${APP_NAME}"-psql-data:/var/lib/postgresql \
  -v ./migration.sql:/docker-entrypoint-initdb.d/migration.sql:ro \
  postgres:18.6-trixie@sha256:1267c7e692de235fda2a50dbcdbcbca4672ea6a0298576a6bd9d07cafc319b32
"${engine}" run \
  --rm \
  -dtp 4444:80 \
  --network "${APP_NAME}"-isolated \
  --name "${APP_NAME}"-database-manager \
  --health-cmd="wget -O - http://127.0.0.1:80/misc/ping" \
  --health-interval=10s \
  --health-timeout=10s \
  --health-start-period=30s \
  --health-retries=3 \
  -e PGADMIN_DEFAULT_EMAIL=${DB_USER}@gmail.com \
  -e PGADMIN_DEFAULT_PASSWORD=${DB_PASSWORD} \
  -v "${APP_NAME}"-pgadmin-data:/var/lib/pgadmin \
  dpage/pgadmin4:9.18.0@sha256:c332c5f6dfba995d9ebc4af261d93506d6876085d712eaaa3defc8dd1a3f26de
"${engine}" run \
  --rm \
  -dtp 9090:9090\
  --network "${APP_NAME}"-isolated \
  --name "${APP_NAME}"-monitoring-engine \
  -v ./prometheus.yml:/etc/prometheus/prometheus.yml:ro \
  -v "${APP_NAME}"-prometheus-storage:/prometheus \
  prom/prometheus:main-distroless@sha256:a9581cffe6395a275d5712645284df1933a526aaf3d4c53aff46934ef1b8ac19
"${engine}" run \
  --rm \
  -dtp 7070:3000 \
  --network "${APP_NAME}"-isolated \
  --name "${APP_NAME}"-monitoring \
  -v "${APP_NAME}"-grafana-storage:/var/lib/grafana \
  grafana/grafana:nightly-distroless-slim@sha256:868db446935b5e84a7f24a9c199936357970cdc3cb467a1592ca02a33acaa2e4
}

echo "Techno choisie : "${engine}""
network=$("${engine}" network ls | grep "${APP_NAME}-isolated")
if [ -z "${network}" ]; then
  "${engine}" network create "${APP_NAME}"-isolated
fi

services_run
"${engine}" build -f Dockerfile --target angular -t "${APP_NAME}"/web:1.0 .
"${engine}" build -f Dockerfile --target spring -t "${APP_NAME}"/server:1.0 .
"${engine}" run \
  --rm \
  -dtp 3000:3000 \
  --name "${APP_NAME}"-server \
  --network "${APP_NAME}"-isolated \
  --health-cmd="curl -fkS http://127.0.0.1:3000/actuator/health" \
  --health-interval=10s \
  --health-timeout=10s \
  --health-start-period=30s \
  --health-retries=3 \
  -e APP_NAME="${APP_NAME}" \
  -e SPRING_DATASOURCE_URL="jdbc:postgresql://"${APP_NAME}-database":5432/"${APP_NAME}"_db" \
  -e POSTGRES_USER="${DB_USER}" \
  -e POSTGRES_PASSWORD="${DB_PASSWORD}" \
  "${APP_NAME}"/server:1.0
"${engine}" run \
  --rm \
  -dtp 8080:4000 \
  --name "${APP_NAME}"-web \
  --network "${APP_NAME}"-isolated \
  --health-cmd="node -e fetch('http://127.0.0.1:4000').then(res => console.log(res.status))" \
  --health-interval=10s \
  --health-timeout=10s \
  --health-start-period=30s \
  --health-retries=3 \
  "${APP_NAME}"/web:1.0
