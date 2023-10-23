# Exchange Rates Converter APP

Greetings! This is a test application for studies purposes. 
Here is some information about the application.

## Installation

In this project I used Java 17 and Spring Boot. Also, I used MongoDB as the database. Those are
very likely to be used in production environment for such application.

1. Clone the repository
2. Run `docker-compose up --build`

I assume you have docker and docker compose in your machine. Otherwise, [follow
the official documentation](https://docs.docker.com/compose/install/).

### Why Docker Compose ?

I used docker compose to make the installation process easier - and also to
showcase my skills with docker and DevOps in general.

## Usage

The application is a REST API. It has 3 endpoints:

1. http://localhost:8080/api/purchaseTransaction/save

It's a POST endpoint that receives the following example object:

```json
{
  "description": "Purchase transaction Test",
  "transactionDate": "2018-12-31T17:18",
  "amount": 15.30
}
```

It saves the transaction in the database and returns the saved object.

2. http://localhost:8080/api/purchaseTransaction/list

This is a simple GET endpoint that returns all the transactions in the database.

3. http://localhost:8080/api/purchaseTransaction/convert

This endpoint does the conversion of the transactions. It receives the following object:

```json
{
  "uuid": "203cbd49-c429-44a4-be80-d389ae655714",
  "record_date": "2018-12-31",
  "country_currency_desc": "GERMANY-EURO"
}
```
* Please replace the uuid with the uuid of the transaction you want to convert.

It returns the converted transaction:

```json
{
  "message": "Success",
  "convertedPurchase": {
    "id": "203cbd49-c429-44a4-be80-d389ae655714",
    "description": "Purchase transaction Test",
    "transactionDate": "2018-12-31T17:18:00",
    "original_amount": 15.3,
    "converted_amount": 13.35,
    "exchange_rate": 0.872,
    "country_currency_desc": "GERMANY-EURO"
  }
}
```

In case you send the wrong or nonexistent uuid, it shall return an error message. Also, if the found exchange rate is older than 6 months than the purchase 
transaction, it shall return an error message.

## Tests

The application will run a couple of unit testing for the service layer.
I admit the tests are simple... I would do more
complex integration tests using embedded databases, but the time run out for me.

