# Invoice Challenge

## API REST 

### Requirements
- Java 17
- SpringBoot 3.2.2
- Maven
- MySQL

### How to run the application?

Execute the sql script `database.sql` to generate the structure required for the application.

```cmd
cd ./challenge/challenge/
mvn spring-boot:run
```

It runs the application on `localhost:8080/invoices`

### Services available

#### Invoice

- Create a invoice
```json
POST /invoices/v1/invoice

{
    "client": "cliente 100",
    "taxId": "CF",
    "total": 100.0
}

HTTP OK 201
```

- Update the invoice
```json
PUT /invoices/v1/invoice/{id}

{
    "client": "cliente 100",
    "taxId": "CF",
    "total": 100.0
}

HTTP OK 201

```

- Delete the invoice
```json
DELETE /invoices/v1/invoice/{id}

HTTP OK 201

```

- Get all invoices
```json
GET /invoices/v1/invoice

HTTP OK 200

[
    {
        "id": 1,
        "client": "cliente 1",
        "taxId": "CF",
        "total": 100.0,
        "creationDate": "03:09:08",
        "modificationDate": "03:09:08",
        "deletionDate": null
    }
]

```

- Get invoice
```json
GET /invoices/v1/invoice/{id}

HTTP OK 200

{
    "id": 1,
    "client": "cliente 1",
    "taxId": "CF",
    "total": 100.0,
    "creationDate": "03:09:08",
    "modificationDate": "03:09:08",
    "deletionDate": null
}

```

#### InvoiceDetail

- Create a detail
```json
POST /invoices/v1/invoice/detail

{
    "product": "",
    "price": 10,
    "quantity": 100,
    "invoiceId": 100
}

HTTP OK 201
```

- Update the detail
```json
PUT /invoices/v1/invoice/detail/{id}

{
    "product": "",
    "price": 10,
    "quantity": 100,
    "invoiceId": 100
}

HTTP OK 201

```

- Delete the detail
```json
DELETE /invoices/v1/invoice/detail/{id}

HTTP OK 201

```

- Get all details or by invoiceId
```json
GET /invoices/v1/invoice/detail?invoiceId={invoiceId}

HTTP OK 200

[
    {
        "id": 5,
        "product": "Leche",
        "quantity": 123,
        "price": 123.0,
        "invoiceId": 32,
        "creationDate": "17:40:12",
        "modificationDate": "17:40:12"
    }
]

```

- Get detail
```json
GET /invoices/v1/invoice/detail/{id}

HTTP OK 200

{
    "id": 5,
    "product": "Leche",
    "quantity": 123,
    "price": 123.0,
    "invoiceId": 32,
    "creationDate": "17:40:12",
    "modificationDate": "17:40:12"
}

```

## Frontend

### Requirements

- npm 10.4.0
- react.js

### How to run the application?

```cmd
cd ./invoice-challenge
npm install
npm start
```
It runs the application on `localhost:3000`


