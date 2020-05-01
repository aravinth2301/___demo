FROM openjdk:8-jdk-alpine
WORKDIR opt
COPY target/*.jar opt/
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","opt/eureka.jar"]