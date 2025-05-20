# User Management API

This project is a simple REST API for managing users and their devices, built with Spring Boot. It uses Flyway for database migrations.

---

## API Endpoints

### Users

| Method | Endpoint          | Description                |
|--------|-------------------|----------------------------|
| GET    | `/users`          | Get all users              |
| GET    | `/users/{id}`     | Get user by ID             |
| POST   | `/users`          | Create a new user          |
| GET    | `/devices`          | Get all users            |
| GET    | `/subscriptions`     | Get all subscriptions   |


---

## Running the Application

1. Make sure you have a PostgreSQL database running and properly configured in `application.properties`.
2. Flyway migrations will run automatically on startup to set up your database schema.
3. Run the Spring Boot application.

---

## Handling Flyway Errors

If you change migration files after they've already been applied, you may encounter Flyway errors Or conflicts when rerunning migrations.

### Recommended steps to fix:

1. **Avoid modifying applied migration scripts.** Instead, create new migration scripts for changes.

2. If you **must** modify an applied migration (not recommended), you need to:

   - Repair Flyway's metadata table to sync with your current migrations:

     ```bash
     ./mvnw flyway:repair
     ```

     or if using Gradle:

     ```bash
     ./gradlew flywayRepair
     ```

   - This marks the failed or mismatched migrations as repaired so Flyway can continue.

3. Alternatively, you can **clean** the database (only recommended for development, as it deletes all data):

   ```bash
   ./mvnw flyway:clean
   ./mvnw flyway:migrate


