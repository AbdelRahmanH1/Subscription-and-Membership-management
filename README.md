# Subscription and Membership Management System

A backend system built with **Spring Boot** for managing users, plans, subscriptions, and payments with authentication and role-based access.

---

## 🚀 Features

- User authentication (JWT)
- Role-based authorization (Admin / User)
- Admin: Create, update, and delete subscription plans
- User: Subscribe to and cancel plans
- Payment simulation
- Swagger API docs

---

## 🧑‍💻 Tech Stack

- Java 17+
- Spring Boot 3+
- Spring Security
- JPA (Hibernate)
- MySQL
- Lombok
- Maven
- OpenAI (Swagger)

---

## 📁 Project Structure


```bash

src/main/java/com/system/subscriptionmembershipmanagement/

 controllers       # REST API endpoints (e.g., PlanController, SubscriptionController)
 services          # Business logic for plans, subscriptions, etc.
 repositories      # JPA repositories to interact with the database
 dtos              # Request/response DTO classes for validation and clarity
 mappers           # Mapper classes for transforming between entities and DTOs
 config            # Spring config classes (e.g., SecurityConfig, SwaggerConfig)
 utils             # Utility/helper classes (e.g., ResponseUtil, JWT helper)
 filters           # Custom filters (middleware) for requests, like JWT filters
 enums             # Enum types used across the app
 exceptions        # Custom exception classes and handlers

```

--
## ⚙️ Setup & Run

### 🧾 1. Clone the repo

```bash
git clone https://github.com/AbdelRahmanH1/Subscription-and-Membership-management.git
cd Subscription-and-Membership-management
```
### 🔐 2.Set up the `environment`
Create a .env file in the project root with the following keys:
```bash
DB_USERNAME = 
DB_PASSWORD =
JWT_SECRET =
```
###  🛠️  3.Configure `application.yaml`
The application.yaml is already set up to read from .env
```bash
spring:
  application:
    name: Subscription and Membership management

  datasource:
    url: jdbc:mysql://localhost:3306/subscription?createDatabaseIfNotExist=true
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}

  jpa:
    show-sql: true

  web:
    resources:
      add-mappings: false

  jwt:
    secret: ${JWT_SECRET}
    token-expiration: 604800   
```
### ▶️  4.Run the application
Use Maven Wrapper (no need to install Maven globally):
```bash
./mvnw spring-boot:run
```
Or, if Maven is already installed:
```bash
mvn spring-boot:run
```
## 📘 API Documentation
Visit Swagger after starting the app:
- [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### 🔐 Authentication Notes

- After login, copy the JWT token from the response.
- For protected routes, use this in the request header: `Authorization: Bearer <your_token_here>`


## ✨ Notes
- Admin-only routes: `/plans/**`
- Admin or user: `/subscription/**`
- Use JWT token in headers after login for protected endpoints.

## 🧪 Testing (optional)
You can use Postman or Swagger to test endpoints:
- Register admin
- login
- add, update, delete Plan (admin)
- Subscribe, Cancel Subscription (User)

## 🤝 Contributing
This project is open for suggestions and improvements. If you'd like to contribute, ``feel free to open an issue or submit a pull request.``

---

## 📬 Contact
`Feel free to check out the project, use it, and share feedback!`
- 💻 GitHub: [Abdelrahman Hossam](https://github.com/AbdelRahmanH1)
- 💼 LinkedIn: [Abdelrahman Hossam](https://www.linkedin.com/in/abdelrahmanh1/)

---
## 📄 License
This project is licensed under the MIT License.

MIT License

Copyright (c) 2025 Abdelrahman Hossam

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE  
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER  
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  
SOFTWARE.




