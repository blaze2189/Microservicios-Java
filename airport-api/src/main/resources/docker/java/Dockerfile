# Use an official OpenJDK runtime as a parent image
FROM openjdk:24-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY airport-api-0.0.1-SNAPSHOT.jar airport-api-0.0.1-SNAPSHOT.jar

# Command to run the application
CMD ["java", "-jar", "airport-api-0.0.1-SNAPSHOT.jar","--spring.profiles.active=docker"]