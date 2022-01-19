# Gear Packer
Playing around with things for some beach-time practice.

A Spring Boot application using Java 8, serving a React app. Deployed on Heroku.

Production app is live at [gearpacker.com](http://www.gearpacker.com/)

### Guidlelines for Contributing
The codebase should be developed using TDD as much as possible. The tests follow the approach recommended by [Testing Library](https://testing-library.com/docs/queries/about#priority) of querying elements by their ARIA role. More information on roles can be found at [MDN](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/ARIA_Techniques#roles).

## Local Development

### Pre-requisites
This section is a work in progress. More coming soon!

- Install PostgreSQL 13
    - `brew install postgresql@13.3`
    - Check by running `postgres --version`
    - Start server with `brew services start postgresql`
    - Create user "postgres" with `/usr/local/Cellar/postgresql/9.2.4/bin/createuser -s postgres`
- Must have Docker running
    - The Spring integration tests use [TestContainers](https://www.testcontainers.org/), which depends on a running instance of Docker
- npm 
    - version `7.15.1` 
- Yarn
    - version `1.22.10` 
- OpenJDK 17

### Running locally

| Name | Command | URL | Notes |
| --- | --- | --- | --- |
| Frontend with Yarn | `yarn start` | [localhost:3000](localhost:3000) | Get the benefits of webpack's hot-reloading. |
| Backend with Gradle | `./gradlew bootRun` | [localhost:8080/acutator/health](localhost:8080/acutator/health) | Start the Spring Boot app without building a fresh JS bundle (will serve a JS bundle if it exists, even if outdated) |
| Full app with Gradle and Yarn | `./gradlew bootRunApp` | [localhost:8080](localhost:8080) | Build a fresh JS bundle and start the Spring Boot, serving the front end app |

## Local Tests
| Command | Jest tests | JUnit tests | Capybara Integration tests | Notes |
| --- | :---: | :---: | :---: | --- |
| `yarn test` | ✓ | | | |
| `./gradlew test` | | ✓ | | |
| ` BUNDLE_GEMFILE="integration/Gemfile" bundle exec rspec integration/spec` | | | ✓ | The full app must be running for the Capybara tests to execute. You can start the app with `./gradlew bootrunApp` |


### Build JAR locally

Run
```bash
./gradlew buildApp
```

