# School Service

A demo application with Eclipse Jersey Framework.

## How it works?

This service is exposing 2 endpoints:

- GET localhost:8080/alunos - find all students
  - Status: 200 - Success
- GET localhost:8080/alunos - find student by ID
  - Status: 200 - Success
  - Status: 404 - Aluno with given ID not found

## To run application (on terminal):
`mvn clean install exec:java`

