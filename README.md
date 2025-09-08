# RESTful Bookstore API 
This is a backend Restful API application.This project demonstrates where the user can perform CRUD and checkout operations.

# Technologies
- Java 1.8
- Spring
- Spring Boot
- H2 Database (in-memory)
- Maven Build Tool Download
- Swagger UI

# Swagger UI Link
http://localhost:8080/swagger-ui

# Database Access
Hit this Datasource URL in a browser: http://localhost:8080/h2-console

To connect data source use below credentials
JDBC URL: jdbc:h2:mem:bookstoredb

# Sample JSON to Add Book (POST /api/books)
`{
  "title": "Animal Farm",
  "isbn": "9780452284241",
  "publishedYear": 1945,
  "price": 199.00,
  "authorId": 1
}`

# Sample JSON to Update Book (PUT /api/books/{id})
`{
  "title": "Animal Farm (Updated Edition)",
  "isbn": "9780452284241",
  "publishedYear": 1945,
  "price": 249.00,
  "authorId": 1
}`

# Sample JSON to Add Author (POST /api/authors)
`{
  "name": "George Orwell",
  "bio": "English novelist, essayist, and journalist."
}`

# Sample JSON to Update Author (PUT /api/authors/{id})
`{
  "name": "Eric Arthur Blair",
  "bio": "Known by pen name George Orwell; English novelist, essayist, and journalist."
}`

# Application Testing in Postman
- Exported All endpoints from postman as JSON format located in the root directory of this application, simply take the file and import in your postman.

# Sample Postman Screen Shot
