#!/usr/bin/env bash

JAVA_OPTS="-Dspring.profiles.active=production"
EXEC="java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar"

$EXEC