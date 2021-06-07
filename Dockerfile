# Use OpenJDK 8 image
FROM openjdk:8-jdk-alpine

# Add user priveleges
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy the JAR
ARG JAR_FILE=build/libs/\*.jar
COPY ${JAR_FILE} app.jar

# Install node
RUN curl -fsSL https://deb.nodesource.com/setup_16.x | sudo -E bash -
RUN sudo apt-get install -y nodejs

ENTRYPOINT ["java","-jar","/app.jar"]
