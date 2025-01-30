# Microservice Quiz App with API Gateway

This project implements a **Quiz App** using a **microservice architecture**. The app consists of two primary services:

1. **Quiz Service**: Manages quizzes and handles quiz-related logic.
2. **Question Service**: Manages the questions associated with quizzes.

Additionally, the app uses **Eureka Server** for service discovery and **Feign** for inter-service communication. A separate **API Gateway** is created to route requests to the appropriate services.

## Architecture Overview

- **Eureka Server**: Acts as a service registry where the services register themselves and can discover each other.
- **Quiz Service**: Provides endpoints to create, retrieve, and submit quizzes.
- **Question Service**: Provides endpoints to manage and retrieve quiz questions.
- **API Gateway**: Serves as a single entry point to route requests to the appropriate services.

## Technologies Used

- **Spring Boot**: For building the microservices.
- **Spring Cloud Netflix Eureka**: For service discovery.
- **Spring Cloud Feign**: For inter-service communication.
- **Spring Cloud Gateway**: For API Gateway functionality.
- **Maven**: For managing project dependencies and building the services.

