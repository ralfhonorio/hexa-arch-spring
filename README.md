# Hexagonal Architecture Example with Spring Boot 🌟

This project demonstrates the implementation of Hexagonal Architecture (also known as Ports and Adapters Pattern) using Spring Boot for a simple Article CRUD application 📝. The goal is to illustrate how to decouple the application's core logic from external interfaces and frameworks, making the system more adaptable and easier to test 🚀.

## Overview 📊

Hexagonal Architecture promotes the separation of concerns by dividing an application into several layers. This project is structured around the following main components:

- **Core Domain** 💼: Contains the business logic and models.
- **Ports** 🚪: Interfaces that define the primary capabilities of the application. Divided into:
    - **Input Ports** ⬆️: Used by external actors to interact with the application.
    - **Output Ports** ⬇️: Used by the application to interact with external services or systems.
- **Adapters** 🔌: Implementations of the ports, adapting the external world to the application and vice versa.

## Tools and Technologies 🛠️

- **Spring Boot** 🌱: Framework for creating stand-alone, production-grade Spring-based applications.
- **Spring Web** 🕸️: For creating RESTful web services.
- **Spring Data JPA** 📊: For database access.
- **H2 Database** 🗃️: In-memory database for demo purposes.
- **Lombok** ✂️: To reduce boilerplate code.
- **ModelMapper** 🔀: For object mapping.
- **Gradle** 🏗️: Build tool.

## Getting Started 🚀

### Prerequisites 📋

- JDK 11 or newer 🍵
- Gradle 🛠

### Running the Application 🏃

1. Clone the repository: https://github.com/ralfhonorio/hexa-arch-spring.git
2. Build the project: gradle build
3. Run the application: gradle bootRun


## Structure 🏗

The project is organized into several packages following Hexagonal Architecture principles:

- `application` 📦: Contains application logic and bridges the domain and adapters.
- `domain` 🎯: Core business logic and models.
- `adapters` 🔄: Contains all adapters divided into `in` (for incoming adapters like REST controllers) and `out` (for outgoing adapters like database repositories).
- `config` ⚙️: Configuration classes for Spring and other components.
- `shared-kernel` 🧩: Common utilities and shared logic.

## Usage 📚

The application exposes a set of RESTful endpoints for managing articles:

- **Get all articles** 📖: `GET /articles`
- **Get article by ID** 🔍: `GET /articles/{id}`
- **Create a new article** ✍️: `POST /articles`
- **Update an existing article** 📝: `PUT /articles/{id}`
- **Delete an article** ❌: `DELETE /articles/{id}`
