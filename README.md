BankingAPI_Beta01 🏦

A simple yet powerful RESTful Banking API built with Spring Boot 3, Spring Data JPA, and MySQL, designed to demonstrate standard API development practices including CRUD operations, DTO mapping, exception handling, and a clean layered architecture.

📂 Project Overview

This project implements:

Spring Boot 3.5.3 (latest stable)

Spring Data JPA for data persistence

MySQL as the relational database

Lombok for boilerplate reduction

RESTful API principles with proper HTTP status codes

Global exception handling with custom error responses

✨ Features

✅ Create Bank Account✅ Get Account by ID✅ Deposit & Withdraw Amount (with validations)✅ Get All Accounts✅ Delete Account by ID or Delete All✅ Global Exception Handling with meaningful error codes✅ Uses Java 17 Records for immutable DTOs

🏠 Project Structure

src/main/java
└── com.bank
    ├── controller
    │   └── AccountController.java
    ├── dto
    │   └── AccountDTO.java
    ├── entity
    │   └── Account.java
    ├── exception
    │   ├── AccountException.java
    │   ├── ErrorDetails.java
    │   └── GlobalExceptionHandler.java
    ├── mapper
    │   └── AccountMapper.java
    ├── repository
    │   └── AccountRepository.java
    ├── service
    │   └── IAccountService.java
    └── service.impl
        └── AccountServiceImpl.java

🔧 How to Run

1⃣ Clone the repo

  git clone https://github.com/yourusername/BankingAPI_Beta01.git
  cd BankingAPI_Beta01

2⃣ Configure your MySQL

  Update your application.properties (or application.yml) to set database URL, username, and password.
  
  spring.datasource.url=jdbc:mysql://localhost:3306/bankingdb
  spring.datasource.username=root
  spring.datasource.password=yourpassword
  spring.jpa.hibernate.ddl-auto=update

3⃣ Run the application

  ./mvnw spring-boot:run

4⃣ Test the endpoints

  Use Postman / cURL to test endpoints like:
  
  POST /api/accounts/add_account
  
  GET /api/accounts/get_account_by_id/{id}
  
  PUT /api/accounts/deposit/{id}
  
  PUT /api/accounts/withdraw/{id}
  
  GET /api/accounts/get_all_accounts
  
  DELETE /api/accounts/delete_by_id/{id}
  
  DELETE /api/accounts/delete_all_account

🛠️ Tech Stack

Layer                  Tech

Backend                Spring Boot, Spring Data JPA

Database               MySQL

Build Tool             Maven

Java Version           Java 17

Others                 Lombok, JPA, REST API

⚡ Improvements Ideas

Integrate Spring Security for authentication/authorization.

Add Swagger / OpenAPI docs for easy testing.

Implement transaction management and validation framework.

Dockerize the app for containerized deployments.
