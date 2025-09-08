# RESTful Bookstore API 
This is a backend Restful API application.This project demonstrates where the user can perform CRUD.
Developed by RISHIRAAM GOPINATH

# Technologies
- Java 1.8
- Spring
- Spring Boot
- H2 Database (in-memory)
- Maven Build Tool Download
- Swagger UI

# Swagger UI Link
URL: http://localhost:8080/swagger-ui

# Database Access
Datasource URL: http://localhost:8080/h2-console

To connect data source use below credentials
JDBC URL: `jdbc:h2:mem:bookstoredb`

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
  - bookstore-postman.json


# Sample Postman Screen Shot

- Add Book
  <img width="940" height="584" alt="image" src="https://github.com/user-attachments/assets/eddcfa47-83c0-48f9-8ee7-a7f14c90af5d" />

- Get All Books
  <img width="940" height="433" alt="image" src="https://github.com/user-attachments/assets/01681cd0-b4d9-40a4-8259-fbd8309faf98" />
  <img width="940" height="270" alt="image" src="https://github.com/user-attachments/assets/9ecf6564-db33-40fd-a00d-867b9cf39ae0" />
  <img width="940" height="133" alt="image" src="https://github.com/user-attachments/assets/59ee1aa6-1567-4cdd-ad84-c08ceb2c5c0c" />

- Update Book
  <img width="940" height="574" alt="image" src="https://github.com/user-attachments/assets/62d0fddd-762d-41d8-b3e0-3cb95ed510aa" />

- Delete Book
  <img width="940" height="508" alt="image" src="https://github.com/user-attachments/assets/d312f269-6a12-43b1-9e17-0fede7017dc4" />
  <img width="940" height="261" alt="image" src="https://github.com/user-attachments/assets/6cdc056c-4cde-4aa1-a269-8dd9c255ad49" />
  <img width="940" height="345" alt="image" src="https://github.com/user-attachments/assets/91e74c4c-9ea6-427b-893e-04f230cfcf79" />


- Add Author
  <img width="940" height="540" alt="image" src="https://github.com/user-attachments/assets/d4ceea0e-a3a4-48c3-a9c3-073826b65473" />

- Get All Author
  <img width="940" height="590" alt="image" src="https://github.com/user-attachments/assets/fe507996-8768-4912-8745-704963ab67da" />

- Update Author
  <img width="940" height="436" alt="image" src="https://github.com/user-attachments/assets/bf4d127b-84a3-436e-8b2f-e58b69b9af6e" />

- Delete Author
  <img width="940" height="464" alt="image" src="https://github.com/user-attachments/assets/fc4da1b0-8d80-4a6f-ac7e-250d04e32bfd" />
  <img width="940" height="396" alt="image" src="https://github.com/user-attachments/assets/3505eb8b-ee81-4095-8224-dab15752bb9e" />
  <img width="940" height="436" alt="image" src="https://github.com/user-attachments/assets/f0d4d176-eb29-45e3-9956-8cd52cc6fc81" />


