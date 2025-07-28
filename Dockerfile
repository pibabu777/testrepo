# Use an official OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy your Java files into the container
COPY . .

# Compile the Java program
RUN javac Main.java

# Run the Java program
CMD ["java", "Main"]
