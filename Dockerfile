# syntax=docker/dockerfile:1

# build project
FROM maven:3.8-openjdk-15 AS build
WORKDIR src/
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# package project
COPY --from=build /home/app/src/test.jar /usr/local/lib/test.jar
# EXPOSE 8080  # ADD PORTS foreach API

ENTRYPOINT ["java", "-jar", "/usr/local/lib/test.jar"]