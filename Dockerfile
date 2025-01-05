FROM openjdk:21-slim

WORKDIR /app

ARG JAR_FILE=target/store-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]