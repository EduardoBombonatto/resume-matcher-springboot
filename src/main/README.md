# Resume Matcher Portfolio

Resume Matcher Portfolio is a web application that analyzes resumes against job descriptions, highlighting matching and missing keywords. The backend is built with Java (Spring Boot), uses PostgreSQL for data storage, and integrates with an external analysis API.

## Features

- User management (CRUD operations)
- Resume analysis with match percentage and keyword extraction
- RESTful API endpoints
- PostgreSQL database integration
- Docker support for easy deployment

## Project Structure

```
src/
├── main/
│   ├── java/              # Java source code
│   └── resources/         # Application properties
└── test/
    └── java/              # Unit tests
Dockerfile                 # Docker build instructions
compose.yaml               # Docker Compose configuration
pom.xml                    # Maven build file
```

## Getting Started

### Prerequisites

- Docker & Docker Compose
- Java 21
- Maven

### Running with Docker

1. Build and start the application:

```bash
docker compose up --build
```

2. The backend will be available at `http://localhost:8080`

### Local Development

1. Start PostgreSQL (see `compose.yaml` for configuration)
2. Configure `src/main/resources/application.properties` if needed
3. Build and run:

```bash
./mvnw spring-boot:run
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/users` | Create a user |
| GET | `/users/{id}` | Get user by ID |
| GET | `/users` | List all users |
| PUT | `/users/{id}` | Update user |
| DELETE | `/users/{id}` | Delete user |
| POST | `/analysis/{userId}` | Analyze resume for a user |

## Configuration

Database and API settings are in `src/main/resources/application.properties`.

## Author

**Eduardo Bombonatto Lorenzetti**

## License

This project is open source and available under the [MIT License](LICENSE).