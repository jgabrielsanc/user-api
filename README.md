# user-api

This is a Spring Boot Application using Gradle.

## Setup

Build and run the unit tests

```bash
./gradlew clean build
```

Run the project

```bash
./gradlew bootRun 
```

## API Documentation

http://localhost:8080/api/swagger-ui/

## Database

This project is configured with H2 database in memory.

## Sample Requests

Success Request

POST http://localhost:8080/api/users

REQUEST

```json
{
    "name": "Jesus Test",
    "email": "test@test.com",
    "password": "@EstoEsUnaPreuba123",
    "phones" : [
        {
            "number": "8093433232",
            "citycode": "1",
            "countrycode": "57"
        },
        {
            "number": "8093435555",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}
```
RESPONSE

```json
{
  "id": "f141a7e5-f38e-4222-b468-7e01634936c5",
  "created": "2023-02-15 21:27:51",
  "modified": "2023-02-15 21:27:51",
  "last_login": "2023-02-15 21:27:51",
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3QuY29tIiwiaWF0IjoxNjc2NTgyODcxLCJleHAiOjE2NzY2NjkyNzF9.WiZVO-gevGMvZj5hrhRDzk82UONrrAxfgUQy3IXmSKQwuyIkm2OUkOuKXT1FdJbF2FwIkfZDSeUvsob2XrK18g",
  "isactive": true
}
```

Fail Request

POST http://localhost:8080/api/users

REQUEST
```json
{
    "name": "Jesus Test",
    "email": "testtest.com",
    "password": "@EstoEsUnaPreuba123",
    "phones" : [
        {
            "number": "8093433232",
            "citycode": "1",
            "countrycode": "57"
        },
        {
            "number": "8093435555",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}
```

RESPONSE
```json
{
  "message": "email: no tiene un formato valido"
}
```