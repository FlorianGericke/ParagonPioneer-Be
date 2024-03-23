FROM openjdk:17-jdk-slim

COPY ./build/libs/ParagonPioneer-Be-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java","-jar","ParagonPioneer-Be-0.0.1-SNAPSHOT.jar"]