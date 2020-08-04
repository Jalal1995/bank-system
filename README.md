## Ibar code challenge spring application

There is autoRun(CommandLineRunner) in utils package 
- email: test
- password: test

- `Authorization` = `Token Bearer`
    - Authorization token must be added to Postman
    - Authorization token is receivable at login or register POST body

- `localhost:8080/api/login`
    - POST - Request body => (email, password)
- `localhost:8080/api/register`
    - POST - Request body => email, password
- `localhost:8080/api/customers`
    - GET - Params => NONE
- `localhost:8080/api/confirmations`
    - GET - Params => amount
- `localhost:8080/api/customers`
    - POST - Params => amount

