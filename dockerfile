FROM openjdk:17-jdk-slim

COPY ./build/libs/ParagonPioneer-Be.jar .

EXPOSE 8080

ENTRYPOINT ["java","-jar","ParagonPioneer-Be.jar"]