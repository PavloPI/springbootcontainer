FROM openjdk:17.0.1-jdk-slim

COPY build/libs/springbootcontainer-0.0.1.jar springbootcontainer.jar

EXPOSE 8080
CMD java -jar springbootcontainer.jar