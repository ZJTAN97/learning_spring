FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package

FROM eclipse-temurin:latest
WORKDIR /opt/app
COPY --from=builder /usr/src/app/target/cards-service-0.0.1-SNAPSHOT.jar /opt/app/

EXPOSE 9000
ENTRYPOINT ["java", "-jar", "cards-service-0.0.1-SNAPSHOT.jar"]