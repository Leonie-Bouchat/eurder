CREATE TABLE if not exists city (
    postal_code VARCHAR(50) PRIMARY KEY,
    city VARCHAR(50) NOT NULL
);

CREATE TABLE if not exists address (
    address_id VARCHAR(50) PRIMARY KEY,
    street_name VARCHAR(50) NOT NULL,
    street_number INT NOT NULL,
    postal_code VARCHAR(50) NOT NULL,
    CONSTRAINT FK_ADDRESS_CITY FOREIGN KEY (postal_code) REFERENCES city(postal_code)
);
