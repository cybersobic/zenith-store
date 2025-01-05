FROM openjdk:21-slim

WORKDIR /app

COPY . .

RUN ./mvnw clean package

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/store-0.0.1-SNAPSHOT.jar"]
