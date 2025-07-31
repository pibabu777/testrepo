# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the current directory contents into the container
COPY . .

# Compile the Java program
RUN javac Main.java User.java

# Run the Java program
CMD ["java", "Main"]
