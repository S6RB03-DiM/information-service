#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /opt/
COPY src /opt/src/
WORKDIR /opt
RUN mvn -f /opt/pom.xml package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /opt/target/information-service-0.0.1-SNAPSHOT.jar /usr/local/lib/infoservice.jar
ENV PORT 3307
EXPOSE 3307
ENTRYPOINT ["java","-jar","/usr/local/lib/infoservice.jar"]