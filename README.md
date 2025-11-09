# Location API
A simple Spring Boot REST API for managing location data with region, name, and fare information.

# Features
RESTful endpoints for CRUD operations
In-memory H2 database for development
Spring Data JPA repository with custom query methods
H2 console enabled for database inspection
Configured for easy portability and testing

## Getting Started
### Prerequisites
* Java 17 or higher
* Maven 3.x
### Running the Application
1. Clone the repository
2. Build the project:

mvn clean package

### Run the application:
java -jar target/your-app-name.jar

### Or use:
mvn spring-boot:run

The server will start on port 8080.

## API Endpoints
* POST /api/locations - Save a new location
* GET /api/locations/region?region={region} - Find locations by region (case-insensitive)
* GET /api/locations/location?location={name} - Find location by name (case-insensitive)
* GET /api/locations/maxFare?maxAmount={amount} - Find locations with fare less than specified amount
* GET /api/locations/calculateFare?name={name}&numberOfCustomers={count} - Calculate total fare for multiple customers
* DELETE /api/locations/delete/{id} - Delete record by ID
## Database
The application uses an H2 in-memory database. Access the H2 console at:

http://localhost:8080/h2-console

#### Use the following settings:

JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave blank)
