Simple Notes API

A simple RESTful CRUD API for managing notes, built using Spring Boot and PostgreSQL.

Features

Create: Add new notes.

Read: Get all notes or a specific note by ID.

Update: Edit an existing note.

Delete: Remove a note by ID.

Technologies

Spring Boot (Java framework)

PostgreSQL (database)

Maven (build tool)

Getting Started

Prerequisites

Java 17+

Maven

PostgreSQL

Steps

Clone the repository:

bash

Copy code

git clone https://github.com/raviyd2/simple-notes-api.git

cd simple-notes-api

Set up PostgreSQL:

Create a database: CREATE DATABASE notes_db;

Optionally, create a user: CREATE USER notes_user WITH PASSWORD 'yourpassword';

Configure application.properties in src/main/resources/:

properties

Copy code

spring.datasource.url=jdbc:postgresql://localhost:5432/simple-notes-api

spring.datasource.username=notes_user

spring.datasource.password=yourpassword

Build and Run the app:

bash

Copy code

mvn clean install

mvn spring-boot:run

The app will run on http://localhost:8080.

API Endpoints

POST /api/notes: Create a new note.

GET /api/notes: Get all notes.

GET /api/notes/{id}: Get a note by ID.

PUT /api/notes/{id}: Update a note.

DELETE /api/notes/{id}: Delete a note.

Contributing

Fork the repo.

Create a branch (git checkout -b feature/your-feature).

Make changes and commit.

Push your branch (git push origin feature/your-feature).

Create a Pull Request.
