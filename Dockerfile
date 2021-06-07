# Use OpenJDK 8 image
FROM openjdk:8-jdk-alpine

# Add user priveleges
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy the JAR
ARG JAR_FILE=build/libs/\*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Copy static files
# (This is hacky, I knowwww)
COPY src/main/resources/ .

ENTRYPOINT ["java","-jar","/app.jar"]
