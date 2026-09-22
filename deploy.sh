#!/bin/bash
docker compose down -v
docker rmi eurosupply/spring:0.5 eurosupply/angular:0.5
docker build --no-cache --network host --file Dockerfile --target angular --tag eurosupply/angular:0.5 .
docker build --no-cache --network host --file Dockerfile --target spring --tag eurosupply/spring:0.5 .
docker compose up --wait