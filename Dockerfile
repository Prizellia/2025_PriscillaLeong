# Use a lightweight Java runtime image
FROM openjdk:17-jdk-alpine

# Set working directory in the container
WORKDIR /app

# Copy your JAR file into the container
COPY target/restapi-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Command to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
