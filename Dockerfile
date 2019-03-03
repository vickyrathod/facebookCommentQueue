FROM openjdk:8-jdk-alpine
VOLUME /app
WORKDIR /app

# The application's jar file
ARG JAR_FILE=target/FetchService-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} FetchService-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/FetchService-0.0.1-SNAPSHOT.jar"]
