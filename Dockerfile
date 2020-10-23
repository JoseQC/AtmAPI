FROM openjdk:8-jdk-alpine
COPY "./target/AtmAPI-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "app.jar"]
