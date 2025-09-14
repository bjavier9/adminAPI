# Java API Service Starter

This is a minimal Java API service starter based on [Google Cloud Run Quickstart](https://cloud.google.com/run/docs/quickstarts/build-and-deploy/deploy-java-service).

## Getting Started

Server should run automatically when starting a workspace. To run manually, run:
```sh
mvn spring-boot:run
```

## Project Structure

```
.
├── .mvn
├── .idea
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── insurance
│   │   │           └── api
│   │   │               ├── adapters
│   │   │               │   ├── controller
│   │   │               │   └── repository
│   │   │               ├── application
│   │   │               │   └── usecase
│   │   │               ├── domain
│   │   │               │   ├── model
│   │   │               │   └── service
│   │   │               └── infrastructure
│   │   │                   ├── config
│   │   │                   └── security
│   │   └── resources
│   └── test
│       └── java
└── pom.xml
```

## Clean Architecture

This project follows the principles of Clean Architecture. This architectural pattern separates the code into distinct layers, each with its own responsibility. This separation of concerns makes the application more modular, scalable, and easier to maintain.

### Layers

*   **Domain:** This is the core of the application. It contains the business logic and entities, and it is independent of any other layer.
*   **Application:** This layer orchestrates the use cases of the application. It depends on the Domain layer, but not on the Infrastructure or Adapters layers.
*   **Adapters:** This layer contains the adapters that interact with external systems, such as controllers for the web interface and repositories for the database. It depends on the Application layer.
*   **Infrastructure:** This layer contains the frameworks and tools that the application uses, such as Spring Boot and the database driver. It is the outermost layer and all other layers depend on it.
