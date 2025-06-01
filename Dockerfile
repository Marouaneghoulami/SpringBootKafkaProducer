FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY app/pom.xml .
COPY app/src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
ENV JAR_NAME=app-0.0.1-SNAPSHOT.jar
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
COPY --from=builder /app/target/${JAR_NAME} /app/${JAR_NAME}
EXPOSE 8080
ENTRYPOINT java -jar /app/$JAR_NAME
