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

### Run front-end only via Yarn
By running with Yarn locally, you get the benefits of webpack's hot-reloading. 

Start by running
```bash
yarn start
```
And visit at [localhost:3000](localhost:3000)

### Run back-end only via Gradle
You can boot up the Spring Application API, which also serves the static React site from the homepage (`/`).

Start by running
```bash
./gradlew bootRun
```

And visit the health check endpoint at [localhost:8080/acutator/health](http://localhost:8080/acutator/health).

### Run full app via Gradle

Run
```bash
./gradlew bootRunApp
```

And visit the hosted React site at [localhost:8080](http://localhost:8080), or the health check endpoint at [localhost:8080/acutator/health](http://localhost:8080/acutator/health).

## Local Tests
| Command | Runs Jest tests | Runs Spring tests | Runs Integration tests | Notes|
| --- | :---: | :---: | :---: | --- |
| `yarn test` | ✓ | | | |
| `./gradlew build` | | ✓ | | |

[comment]: <> (https://medium.com/xebia-engineering/a-minimalistic-guide-to-building-and-deploying-monolithic-spring-boot-react-applications-39440035b27)
[comment]: <> (https://pretagteam.com/question/serve-react-app-and-backend-server-from-same-domain)
