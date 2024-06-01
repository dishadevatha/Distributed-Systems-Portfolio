FROM openjdk:17-jdk-slim
LABEL authors="Disha"
VOLUME /tmp
COPY target/partner-universities-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
