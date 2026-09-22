#!/bin/bash
docker compose down -v
docker rmi eurosupply/spring:0.5 eurosupply/angular:0.5
docker compose build --no-cache
docker compose up --wait