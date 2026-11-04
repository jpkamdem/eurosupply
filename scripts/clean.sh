#!/bin/bash
engine=$1
APP_NAME=$2
while [ -z "${engine}" ] || [ "${engine}" != "d" ] && [ "${engine}" != "p" ];
do
  read -p "Podman (p) ou Docker (d) : " engine
done

while [ -z "${APP_NAME}" ];
do
  read -p "APP_NAME=" APP_NAME
done

if [ "${engine}" = "d" ]; then
engine="docker"
else
engine="podman"
fi

"${engine}" rm \
  "${APP_NAME}"-web \
  "${APP_NAME}"-monitoring \
  "${APP_NAME}"-monitoring-engine \
  "${APP_NAME}"-database \
  "${APP_NAME}"-database-manager \
  "${APP_NAME}"-server

"${engine}" volume rm \
  "${APP_NAME}"-psql-data \
  "${APP_NAME}"-pgadmin-data \
  "${APP_NAME}"-prometheus-storage \
  "${APP_NAME}"-grafana-storage \

"${engine}" network rm \
  "${APP_NAME}"-isolated

"${engine}" rmi \
  -f \
  "${APP_NAME}"/web:1.0 \
  "${APP_NAME}"/server:1.0

"${engine}" image prune -f
