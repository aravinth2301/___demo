FROM openjdk:8-jdk-alpine
WORKDIR opt
COPY sample/target/*.jar opt/
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","opt/sample-run.jar"]