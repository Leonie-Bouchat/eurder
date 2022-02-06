CREATE TABLE if not exists member (
      user_id VARCHAR(50) PRIMARY KEY,
      first_name VARCHAR(50) NOT NULL,
      last_name VARCHAR(50) NOT NULL,
      email VARCHAR(50) NOT NULL,
      address_id VARCHAR(50) NOT NULL,
      phone_number VARCHAR(50) NOT NULL,
      role VARCHAR(50) NOT NULL,
      CONSTRAINT FK_USER_ADDRESS FOREIGN KEY (address_id) REFERENCES address(address_id)
);