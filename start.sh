#!/bin/sh
echo hello
mvn clean install
cd service
mvn spring-boot:run