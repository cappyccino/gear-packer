# Gear Tracker
Playing around with things for some beach-time practice.

A Spring Boot application using Java 8, serving a React app. Deployed on Heroku.

Production app is live at [gear-packer.herokuapp.com](https://gear-packer.herokuapp.com/)

### Guidlelines for Contributing
The codebase should be developed using TDD as much as possible. The tests follow the approach recommended by [Testing Library](https://testing-library.com/docs/queries/about#priority) of querying elements by their ARIA role. More information on roles can be found at [MDN](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/ARIA_Techniques#roles).

## Local Development

### Pre-requisites
Coming soon.

### Run front-end only via Yarn
By running with Yarn locally, you get the benefits of webpack's hot-reloading. This application uses the [gradle-node-plugin](https://github.com/node-gradle/gradle-node-plugin) which wraps Yarn commands in Gradle.

Start by running
```bash
./gradlew yarn_start
```
And visit at [localhost:3000](localhost:3000)

### Run via Gradle
You can boot up the Spring Application API, which also serves the static React site from the homepage (`/`).

Start by running
```bash
./gradlew bootRun
```

And visit the hosted React site at [localhost:8080](http://localhost:8080), or the health check endpoint at [localhost:8080/acutator/health](http://localhost:8080/acutator/health).

### Run via Docker
In Heroku, the application is running inside a Docker container. For debugging, you can run the container locally with:
```bash
docker build -t cappyccino/gear-packer . 
docker run -p 9000:8080 cappyccino/gear-packer
```
And visit at [localhost:9000](http://localhost:9000) (the default port Heroku runs on).

## Local Tests
| Command | Runs Jest tests | Runs Spring tests | Runs Integration tests | Notes|
| --- | :---: | :---: | :---: | --- |
| `./gradlew yarn_test` | ✓ | | | |
| `./gradlew build` | | ✓ | | |
| `./gradlew integration` | | | ✓ | Must first start the app inside a Docker container (see above) |
