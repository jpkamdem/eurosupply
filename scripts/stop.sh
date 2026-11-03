#!/bin/bash
docker stop \
  eurosupply-web \
  eurosupply-monitoring \
  eurosupply-monitoring-engine \
  eurosupply-database \
  eurosupply-database-manager \
  eurosupply-server

docker rm \
  eurosupply-web \
  eurosupply-monitoring \
  eurosupply-monitoring-engine \
  eurosupply-database \
  eurosupply-database-manager \
  eurosupply-server
