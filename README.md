# Gear Tracker
Playing around with things for some beach-time practice.

A Spring Boot application using Java 8, serving a React app. Deployed on Heroku.

## Local Development

### Pre-requisites
Coming soon.

### Run React app via Yarn
By running with Yarn locally, you get the benefits of webpack's hot-reloading. This application uses the [gradle-node-plugin](https://github.com/node-gradle/gradle-node-plugin) which wraps Yarn commands in Gradle.

Start by running
```bash
./gradlew yarn_start
```
And visit at [localhost:3000](localhost:3000)

### Run Spring app via Gradle
You can boot up the Spring Application API, which also serves the static React site from the homepage (`/`).

Start by running
```bash
./gradlew bootRun
```

And visit the compiled React site at [localhost:8080](localhost:8080), or the health check endpoint at [`localhost:8080/acutator/health`](localhost:8080/acutator/health).
