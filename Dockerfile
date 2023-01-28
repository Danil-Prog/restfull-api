FROM openjdk:11-jre-slim-buster
VOLUME /tmp
ADD produc/restfull-api-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "/application.jar"]