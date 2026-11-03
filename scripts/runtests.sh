#!/bin/bash
cd web
npm run test
cd ../server
./mvnw clean verify
