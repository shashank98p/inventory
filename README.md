# Inventory Management API

This is a Spring Boot-based RESTful API for managing inventory items.  
It supports basic CRUD operations on inventory items using a PostgreSQL database.

The project demonstrates:
- REST API development using Spring Boot
- Database integration with Spring Data JPA
- Layered architecture with Controller, Service, and Repository layers
- PostgreSQL configuration and integration


# API Endpoints:

1.Get All Items - Retrieve a list of all inventory items
- Request - GET /items
- Response -
[
    {
    "id": 1,
    "name": "Pepsi",
    "quantity": 10,
    "price": 999.99
    },
    {
    "id": 2,
    "name": "Coke",
    "quantity": 20,
    "price": 49.99
    }
]

2.GET Item by ID - Retrieve a single item by its ID
- Request: GET /items/{id}

Example:
GET /items/1
- Response:
{
"id": 1,
"name": "Pepsi",
"quantity": 10,
"price": 999.99
}

3.POST  - Create a New Item
- Request: POST /items

- Request Body:
{
"name": "Mouse",
"quantity": 15,
"price": 25.00
}
- Response:
{
"id": 3,
"name": "Mouse",
"quantity": 15,
"price": 25.00
}

4.DELETE Item by ID - Delete an item using its ID if it exists
- Request: DELETE /items/{id}

Example:
DELETE /items/3
- Response:204 No Content



# Setup Instruction:
Before you begin, make sure you have the following installed:
- Java 21
- maven
- PostgreSQL
- Postman for API testing

# 1.Clone the repository:
- git clone URL
# 2.Setup PostgreSQL Database:
- CREATE DATABASE db_name;
# 3.Configure Database in Application Properties:
Edit the application properties file

- spring.datasource.url=jdbc:postgresql://localhost:port_number/db_name
- spring.datasource.username=your_username 
- spring.datasource.password=your_password 
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true

# 4. Build and Run the Project
 Using an IDE  run the InventoryManagementApplication.java class

# 5.Test the Application
Once the app starts, test the API using Postman
Url - http://localhost:8080/items


