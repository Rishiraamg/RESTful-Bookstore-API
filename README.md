# Online Bookstore API - Spring Boot
This is a sample backend Rest API application.This project demonstrates where the user can perform CRUD and checkout operations.

# Technologies
- Java 1.8
- Spring
- Spring Boot
- H2 Database (in-memory)
- Maven Build Tool Download
- Swagger UI

# Database Access
Hit this Datasource URL in a browser: http://localhost:8080/h2-console

To connect data source use below credentials
JDBC URL : jdbc:h2:mem:testdb
User Name : sa
Password :

# Sample JSON to add book
`{
  "title": "Animal Farm",
  "isbn": "9780452284241",
  "publishedYear": 1945,
  "price": 199.00,
  "authorId": 1
}`

# Sample JSON for update book
`{
  "title": "Animal Farm (Updated Edition)",
  "isbn": "9780452284241",
  "publishedYear": 1945,
  "price": 249.00,
  "authorId": 1
}`

# Application Testing in Postman
- Exported All endpoints from postman as JSON format located in the root directory of this application, simply take the file and import in your postman.

# Sample Postman Screen Shot
