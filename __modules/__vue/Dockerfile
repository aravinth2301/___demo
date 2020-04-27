FROM openjdk:8-jdk-alpine
WORKDIR opt
COPY vue/target/*.jar opt/
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","opt/vue.jar"]