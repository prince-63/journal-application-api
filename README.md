# Journal Application API

This Spring Boot application provides RESTful API endpoints for managing journal entries and user information.

## Getting Started

### Prerequisites

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) (version 8 or above)
- [Maven](https://maven.apache.org/download.cgi)
- [MongoDB](https://www.mongodb.com/try/download/community) (running on default port 27017)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/journal-application.git
    cd journal-application
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Run the application:

    ```bash
    java -jar target/journal-application.jar
    ```

The application will start on `http://localhost:8080`.

## API Endpoints

### Journal Controller

- **Save Journal for a User:**
  - **Endpoint:** `/journal/{userId}`
  - **Method:** POST

- **Save Multiple Journals for a User:**
  - **Endpoint:** `/journal/all/{userId}`
  - **Method:** POST

- **Get All Journals for a User:**
  - **Endpoint:** `/journal/all/{userId}`
  - **Method:** GET

- **Get a Specific Journal for a User:**
  - **Endpoint:** `/journal/{userId}/{journalId}`
  - **Method:** GET

- **Update a Specific Journal for a User:**
  - **Endpoint:** `/journal/{userId}/{journalId}`
  - **Method:** PUT

- **Delete All Journals for a User:**
  - **Endpoint:** `/journal/all/{userId}`
  - **Method:** DELETE

- **Delete a Specific Journal for a User:**
  - **Endpoint:** `/journal/{userId}/{journalId}`
  - **Method:** DELETE

### User Controller

- **Get All Users:**
  - **Endpoint:** `/users`
  - **Method:** GET

- **Get User by ID:**
  - **Endpoint:** `/users/{id}`
  - **Method:** GET

- **Create User:**
  - **Endpoint:** `/users`
  - **Method:** POST

- **Update User:**
  - **Endpoint:** `/users/{id}`
  - **Method:** PUT

- **Delete All Users:**
  - **Endpoint:** `/users`
  - **Method:** DELETE

- **Delete User by ID:**
  - **Endpoint:** `/users/{id}`
  - **Method:** DELETE

## Usage

- Use your preferred API testing tool (e.g., Postman) to interact with the endpoints.
- Replace `{userId}`, `{journalId}`, and `{id}` with actual values in the endpoint URLs.

## Contributing

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
