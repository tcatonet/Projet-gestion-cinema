# syntax=docker/dockerfile:1

FROM maven:3.8-openjdk-15

WORKDIR src/

COPY src/  src/
COPY pom.xml .

ENTRYPOINT ["./mvn", "spring-boot:run"]