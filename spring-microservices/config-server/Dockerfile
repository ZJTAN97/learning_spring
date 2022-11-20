FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package

FROM eclipse-temurin:latest
WORKDIR /opt/app
COPY --from=builder /usr/src/app/target/config-server-0.0.1-SNAPSHOT.jar /opt/app/

EXPOSE 8071
ENTRYPOINT ["java", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]