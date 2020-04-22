CREATE SCHEMA IF NOT EXISTS shoppinglist DEFAULT CHARACTER SET utf8;
USE shoppinglist;

CREATE TABLE IF NOT EXISTS product
(
    id               BIGINT      NOT NULL AUTO_INCREMENT,
    shopping_cart_id BIGINT,
    name             VARCHAR(32) NOT NULL,
    price            DECIMAL,
    category         VARCHAR(100),
    discount         DECIMAL,
    description      VARCHAR(300),
    created          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    Foreign key (shopping_cart_id) REFERENCES shoppingCart (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS shoppingCart
(
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    PRIMARY KEY (id)
);


