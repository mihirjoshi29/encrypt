#!/bin/sh
echo hello
mvn clean install
cd service
mvn spring-boot:run -Dagentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000