# Employee Management System (EMS)

A RESTful backend API for an Employee Management System built with Java and Spring Boot, designed to manage employee records efficiently.

## 🛠️ Built With

- Java 25
- Spring Boot 3.5.8
- Spring Data JPA
- MySQL
- Lombok

## ✨ Features

- Employee CRUD operations
- Find employee by ID or email
- Partial update support (email update)
- Global exception handling
- Custom error responses with timestamps

## 📋 Prerequisites

- Java 25
- Maven
- MySQL

## ⚙️ Setup & Installation

1. Clone the repository
```bash
   git clone https://github.com/NavodRajapaksha/EMS_Springboot-simple_Employee_management_System.git
```

2. Create a MySQL database
```sql
   CREATE DATABASE ems_bootcamp;
```

3. Update `application.yml` with your database credentials
```yaml
   spring:
     datasource:
       username: your_username
       password: your_password
```

4. Run the project
```bash
   mvn spring-boot:run
```

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/employee/save-obj` | Save an employee |
| GET | `/employee/all` | Get all employees |
| GET | `/employee/by-id/{id}` | Get employee by ID |
| DELETE | `/employee/by-id/{id}` | Delete employee by ID |
| PUT | `/employee/update` | Update an employee |
| PATCH | `/employee/update-email` | Update employee email |

## 📬 Contact

- LinkedIn: [Navod Rajapaksha](https://www.linkedin.com/in/navod-rajapaksha/)
- GitHub: [NavodRajapaksha](https://github.com/NavodRajapaksha)
