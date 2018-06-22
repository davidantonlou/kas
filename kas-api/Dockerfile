FROM openjdk:8-jdk-slim

COPY build/libs/kas-api*.jar app.jar
COPY scripts/start.sh /usr/bin

RUN chmod +x /usr/bin/start.sh

EXPOSE 8080

ENTRYPOINT [ "/usr/bin/start.sh" ]