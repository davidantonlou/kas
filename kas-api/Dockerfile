FROM openjdk:8-jdk-alpine

COPY build/libs/kas-api*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar", "-Djetty.port=8080"]