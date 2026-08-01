# API with Java — SouJava Brasília Workshop

Educational REST API created for a **SouJava Brasília** workshop about building a backend application with **Java 21** and **Spring Boot**.

The project demonstrates how a business requirement can be translated into domain models, application layers, persistence, and REST endpoints. The workshop uses an online learning platform as its example domain, with courses and modules.

## Purpose

This repository was created to help students understand the path from a business problem to a working Java API.

During the workshop, the project was used to introduce:

- REST API development with Spring Boot
- Layered architecture
- Controllers, services, repositories, entities, and DTOs
- Data persistence with Spring Data JPA
- In-memory databases with H2
- Course and module domain modeling
- HTTP requests and responses
- API testing with Postman
- Basic concepts related to microservices and system integration

> This is an educational project and is not intended to represent a production-ready application.

## Technologies

- Java 21
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Current Features

- Create a course
- Update an existing course
- Find a course by ID
- Prevent the creation of courses with duplicate names
- Store course level and course status
- Model the relationship between courses and modules
- Automatically register creation dates

## Domain

### Course

A course contains:

- ID
- Name
- Description
- Status
- Level
- Modules
- Creation date

### Course level
- `BEGINNER`

### Course statuses
- `CONCLUDED`

## API Endpoints

Base URL:

```text
http://localhost:8081
```

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/courses` | Creates a new course |
| `PUT` | `/courses/{id}` | Updates an existing course |
| `GET` | `/courses/{id}` | Finds a course by ID |

## Create a Course

### Request

```http
POST /courses
Content-Type: application/json
```

```json
{
  "name": "Java Backend Development",
  "description": "Introduction to REST APIs with Java and Spring Boot",
  "courseStatus": "INPROGRESS",
  "courseLevel": "BEGINNER",
  "modules": []
}
```

### Example response

```json
{
  "id": 1,
  "name": "Java Backend Development",
  "description": "Introduction to REST APIs with Java and Spring Boot",
  "courseStatus": "INPROGRESS",
  "courseLevel": "BEGINNER",
  "modules": null,
  "createdAt": "2026-08-01T16:00:00"
}
```

## Update a Course

```http
PUT /courses/1
Content-Type: application/json
```

```json
{
  "name": "Java Backend Development",
  "description": "Updated course about REST APIs with Java and Spring Boot",
  "courseStatus": "CONCLUDED",
  "courseLevel": "INTERMEDIARY",
  "modules": []
}
```

## Find a Course

```http
GET /courses/1
```

## Running the Project

### Requirements

- Java 21
- Git
- No external database is required

### Clone the repository

```bash
git clone https://github.com/arielborges/workshopSouJava-ApiComJava.git
cd workshopSouJava-ApiComJava
```

### Run on Linux or macOS

```bash
./mvnw spring-boot:run
```

### Run on Windows

```powershell
mvnw.cmd spring-boot:run
```

The application will be available at:

```text
http://localhost:8081
```

## H2 Database Console

The H2 console is available at:

```text
http://localhost:8081/h2-console
```

Use the following local development settings:

```text
JDBC URL: jdbc:h2:mem:workshop_db
Username: sa
Password: 1234
```

## Project Structure

```text
src/main/java/com/workshop/API/com/Java
├── controllers
├── dtos
├── enums
├── models
├── repositories
├── services
│   └── serviceImpl
└── ApiComJavaApplication.java
```

The application follows a layered structure:

```text
HTTP Request
    ↓
Controller
    ↓
Service
    ↓
Repository
    ↓
H2 Database
```

## Suggested Exercises

The workshop participants can continue the project by implementing:

- List all courses
- Delete a course
- Pagination
- Filters by course level and status
- Bean Validation
- Global exception handling
- MapStruct mapping
- Unit and integration tests
- OpenAPI and Swagger documentation
- Module endpoints
- Docker support

## Workshop Context

The workshop was designed to go beyond simply writing code. It introduced how a software project begins with a business problem, moves through requirements and architecture, and reaches the developer as an implementation task.

The example application represents part of an online learning platform where instructors can create courses, organize modules, and manage course progress.

## Author

**Ariel Borges**

Java Backend Developer and SouJava Brasília Coordinator.

- GitHub: https://github.com/arielborges
- LinkedIn: https://www.linkedin.com/in/arieldsborges
- Blog: https://borges.digital

## Community

This project was created for a workshop connected to **SouJava Brasília**, part of the SouJava Java User Group community.
