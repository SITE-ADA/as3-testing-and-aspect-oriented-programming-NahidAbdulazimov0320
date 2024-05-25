# Use an official Java runtime as a parent image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application's jar to the container
COPY build/libs/assignment_three-0.0.1-SNAPSHOT.jar assignment_three.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "assignment_three.jar"]
