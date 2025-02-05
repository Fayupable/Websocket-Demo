# WebSocket Demo Project

## Overview
This project is a WebSocket-based application that allows users to connect and disconnect, with their status being tracked in real-time. The application is built using Java and Spring Boot, and it uses a PostgreSQL database for storing user data.

## Technologies Used
- **Java**: The primary programming language used for the backend.
- **Spring Boot**: A framework for building Java applications.
- **Spring Data JPA**: For database interactions.
- **WebSocket**: For real-time communication.
- **MySQL**: The database used for storing user data.
- **Maven**: For project management and dependency management.
- **Docker**: For containerizing the application.

## Project Structure
The project is structured as follows:
- `src/main/java/com/fayupable/websocketdemo`: Contains the main application code.
  - `controller`: Contains the REST and WebSocket controllers.
  - `entity`: Contains the entity classes representing the database tables.
  - `repository`: Contains the repository interfaces for database operations.
  - `service`: Contains the service classes implementing the business logic.
- `src/main/resources`: Contains the application configuration files.
- `src/test/java/com/fayupable/websocketdemo`: Contains the test cases.

## Setting Up the Project

### Prerequisites
- Java 11 or higher
- Maven
- Docker (if you want to use Docker Container for MySQL)

### Configuration

#### .env File
Create a `.env` file in the root directory of the project with the following content:

```
DB_HOST=localhost
DB_PORT=5432
DB_NAME=websocketdemo
DB_USER=yourusername
DB_PASSWORD=yourpassword
```

#### Docker Setup
If you prefer to use Docker for the PostgreSQL database, you can use the provided `docker-compose.yml` file. Run the following command to start the database:

```sh
docker-compose up -d
```

This will start a PostgreSQL container with the necessary configuration.

### Running the Application
1. Clone the repository:
   ```sh
   git clone [https://github.com/Fayupable/websocketdemo.git](https://github.com/Fayupable/Websocket-Demo)
   cd websocketdemo
   ```

2. Build the project using Maven:
   ```sh
   mvn clean install
   ```

3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`.

## API Endpoints

### WebSocket Endpoints
- **Add User**: `/user.addUser`
    - Payload: `User` object
    - Response: `User` object

- **Disconnect User**: `/user.disconnectUser`
    - Payload: `User` object
    - Response: `User` object

### REST Endpoints
- **Get Connected Users**: `GET /users`
    - Response: List of `User` objects with status `ONLINE`

## Testing
To run the tests, use the following command:
```sh
mvn test
```

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License.

## Acknowledgements
This project was inspired by the video tutorial from [Bouali Ali](https://www.youtube.com/watch?v=7T-HnTE6v64). Some modifications were made to better suit the specific requirements of this project.
```
This `README.md` provides a comprehensive overview of the project, including the technologies used, project structure, setup instructions, API endpoints, and more.
```
