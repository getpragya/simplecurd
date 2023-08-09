# Use the official OpenJDK base image
FROM openjdk:18-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file from the target directory to the container
COPY target/user-management.jar user-management.jar

# Specify the command to run the application
CMD ["java", "-jar", "user-management.jar"]
