# Customer Management System - Backend

This is the backend API for the Customer Management System, built with Spring Boot and SQLite.

## Setup and Installation

### Prerequisites

- Java JDK 1.8
- Maven 3.9.9

### Installation Steps

1. Clone the repository 
   ```
   git clone https://github.com/zainabAli-96/Backend-customerMS.git
   ```

2. Install dependencies
   Maven will automatically download all required dependencies defined in the `pom.xml` file when you build the project.

3. Configure the database
   - The application uses SQLite which doesn't require separate installation
   - Sample data will be loaded automatically on first run

## Running the Application

### Using Maven

To start the Spring Boot application using Maven:

```
mvn spring-boot:run
```


The backend API will be available at: http://localhost:8080

## Authentication

The application uses Spring Security with Basic Authentication:

- Default admin credentials:
  - **Username:** admin
  - **Password:** password123
  - You can change the credentials by modifying the username and password in class `Config`

## Ports

- The backend API runs on port 8080 by default
- You can change the port by modifying `application.properties`:
  ```
  server.port=8080
  ```
