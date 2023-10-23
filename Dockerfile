# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-17-alpine as builder
# Set the current working directory inside the image
WORKDIR /maven

# Copy sources
COPY . ./

# Package the application build no cache
RUN mvn package

## Stage 2: A minimal docker image with command to run the app
FROM openjdk:17-alpine as production

# Copy project dependencies from the build stage
COPY --from=builder /maven/target/wex-app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
