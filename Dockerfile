FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/cloudcomputing_1-0.0.1-SNAPSHOT.jar /app/cloudcomputing_1-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/cloudcomputing_1-0.0.1-SNAPSHOT.jar"]