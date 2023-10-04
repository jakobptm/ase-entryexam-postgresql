# Sample for ASE entryexam with postgres connection

## Setup
go to https://start.spring.io and create a new project with the following dependencies:
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Lombok
- Spring Boot DevTools

## Database setup
set in application.properties:
```
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=none

spring.datasource.url=jdbc:postgresql://localhost:5432/sample-db
spring.datasource.username=postgres
spring.datasource.password=postgres
```

## Create a new entity
[Student.java](src/main/java/at/ac/tuwien/postgresql/entity/Student.java)

## Create a new repository
[StudentRepository.java](src/main/java/at/ac/tuwien/postgresql/repository/StudentRepository.java)

## Create a new service
[StudentService.java](src/main/java/at/ac/tuwien/postgresql/service/StudentService.java)

## Create a new controller
[StudentController.java](src/main/java/at/ac/tuwien/postgresql/controller/StudentController.java)
