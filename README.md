# JPA Demo - Flight API

Spring Boot REST API for managing flights with a layered architecture (`controller`, `service`, `repository`, `model`) and JPA persistence.

## Endpoints

Base path: `/flights`

### Create flight
- **POST** `/flights`
- Request body:
```json
{
  "source": "NYC",
  "destination": "LAX",
  "departureDate": "2026-03-10"
}
```
- Response: `201 Created`

### Delete flight
- **DELETE** `/flights/{id}`
- Response:
  - `204 No Content` (deleted)
  - `404 Not Found` (id not found)

### Get all flights
- **GET** `/flights`
- Response: `200 OK`

### Get flight by id
- **GET** `/flights/{id}`
- Response: `200 OK` (if found)

### Search flights by route and date
- **GET** `/flights/{source}/{destination}/{departureDate}`
- Example: `/flights/NYC/LAX/2026-03-10`
- Response: `200 OK`

### Update flight
- **PUT** `/flights/{id}`
- Request body:
```json
{
  "source": "NYC",
  "destination": "SFO",
  "departureDate": "2026-03-11"
}
```
- Response: `200 OK`

## Project Structure

```text
src/main/java/org/hartford/jpademo/
  JpaDemoApplication.java
  controller/
    FlightController.java
  model/
    Flight.java
  repository/
    FlightRepository.java
  service/
    FlightService.java
src/main/resources/
  application.properties
```

## Run Locally

### Prerequisites
- Java (version should match your `pom.xml`)
- Maven (or Maven Wrapper included in this project)

### Start the app (Windows PowerShell)

```powershell
.\mvnw.cmd spring-boot:run
```

App default URL:
- `http://localhost:8080`

## Build and Test (Windows PowerShell)

```powershell
.\mvnw.cmd clean install
.\mvnw.cmd test
```

## Notes

- Configure your datasource in `src/main/resources/application.properties`.
- Date format for route search endpoint should match SQL date style (`yyyy-MM-dd`) because `departureDate` is handled as `java.sql.Date` in the controller.

## Suggested Improvements

- Add validation annotations and `@Valid`
- Add global exception handling with `@ControllerAdvice`
- Add Swagger/OpenAPI docs
- Add unit and integration tests
- Replace magic numbers with `HttpStatus` constants for readability (for example, `HttpStatus.CREATED`)

## Author

Practice Spring Boot JPA project.

