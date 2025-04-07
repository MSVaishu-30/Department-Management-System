# Department Management System

This is a backend-only Department Management System built with **Java**, **Spring Boot**, **PostgreSQL**, and **MongoDB**.

## 🔧 Technologies Used

- Java
- Spring Boot
- PostgreSQL (for Department and Student data)
- MongoDB (for Staff data)
- Maven
- JPA & Spring Data
- RESTful APIs

## 📁 Modules

- **Department**
- **Student**
- **Staff**

## 🗂️ Project Structure
src/ └── main/ ├── java/ │ └── com.deptmanagement.sys/ │ ├── controller/ │ ├── services/ │ ├── repository/ │ ├── domain/entity/ │ ├── dto/ │ ├── mapper/ │ └── exception/ └── resources/ ├── application.properties └── logback.xml



---

## ⚙️ Configuration (application.properties)

```properties
# ==== POSTGRESQL ====
spring.datasource.url=jdbc:postgresql://localhost:5432/Dept_management
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

# ==== MONGODB ====
spring.data.mongodb.uri=mongodb://localhost:27017/Dept_management

#How to Run
mvn spring-boot:run

#Note
Run this project using Postman for API testing.
It uses PostgreSQL for Department and Student data, and MongoDB for Staff data.
