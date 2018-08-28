FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=docker-config","-jar","/app.jar"]
HEALTHCHECK \
  CMD wget http://localhost:1099/actuator/health || exit 1