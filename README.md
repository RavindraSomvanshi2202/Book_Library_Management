# Book_Library_Management
## In this project I build REST APIs for a Library Management System Project using Spring Boot, Spring Data JPA (Hibernate), and MySQL database.
I'll create a simple version of the Library Management System with basic functionalities:
#### 1) Create a new User
#### 2) Fetch all the Users
#### 3) Add new book
#### 4) Fetch all the books
#### 5) Fetch specific book
#### 6) Delete a book
#### 7) Borrow a book
#### 8) Return a book

## APIs to run on postman
#### 1) Create a new User
     URL : http://localhost:8080/api/user/createUser
     Body: {
             "username": "xyz"
           }

#### 2) Fetch all the Users
     URL : http://localhost:8080/api/user/allUsers
     

#### 3) Fetch user by id
     URL : http://localhost:8080/api/user/{userId}
     

#### 4) Fetch all the books
     URL :http://localhost:8080/api/book/allBooks
     

#### 5) Add new book
     URL : http://localhost:8080/api/book/addBook
      Body: {
                  "title": "The Great Gatsby",
                  "author": "F. Scott Fitzgerald",
                  "borrowed": true,
                  "borrowedBy": "null"
            }
     

#### 6) Fetch specific book
     URL : http://localhost:8080/api/book/{bookId}
     

#### 7) Delete a book
     URL : http://localhost:8080/api/book/{bookId}
     

#### 8) Borrow a book
     URL : http://localhost:8080/api/book/{bookId}/borrowed/{userId}
     

#### 9) Return a book
     URL : http://localhost:8080/api/book/{bookId}/return
