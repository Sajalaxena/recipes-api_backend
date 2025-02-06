# recipes-api_backend

📌 Overview

This is a Spring Boot REST API that loads recipe data from a third-party API (https://dummyjson.com/recipes) into an H2 in-memory database and exposes various endpoints to fetch and filter recipes.

The API follows RESTful standards, includes Swagger documentation, and supports filtering and sorting of recipes based on cuisine and calorie count.

🛠️ Tech Stack

Java 17

Spring Boot (Spring Web, Spring Data JPA)

H2 Database (In-Memory Database)

Swagger (OpenAPI 3.0)

Postman (For API testing)

🚀 Installation & Setup

1️⃣ Clone the Repository
git clone https://github.com/your-username/recipes-api_backend.git
cd recipes-api

2️⃣ Build and Run the Application
./mvnw spring-boot:run   # For Linux/MacOS
mvnw.cmd spring-boot:run # For Windows

🛠️ API Endpoints
![image](https://github.com/user-attachments/assets/b501a7a6-288e-4987-a5fc-4769e1c7022c)

🔍 How to Access Swagger UI

Once the application is running, open your browser and navigate to:
http://localhost:9090/swagger-ui/index.html
This will provide an interactive UI to test all API endpoints.


🗄️ View Data in H2 Database

To check stored recipes in the H2 in-memory database:

Open H2 Console in your browser:
http://localhost:9090/h2-console

🛠️ Contributing

Feel free to fork this repository and contribute by submitting a pull request!

🚀 Happy Coding! 🎯
