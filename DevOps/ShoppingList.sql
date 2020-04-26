CREATE TABLE IF NOT EXISTS shoppingCart
(
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product
(
    product_Id  BIGINT      NOT NULL AUTO_INCREMENT,
    id          BIGINT,
    name        VARCHAR(32) NOT NULL,
    price       DECIMAL,
    category    VARCHAR(100),
    discount    DECIMAL,
    description VARCHAR(300),
    created     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (id) REFERENCES shoppingCart (id),
    PRIMARY KEY (product_Id)

)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS productsCart
(
    shopping_cart_id BIGINT NOT NULL,
    product_id       BIGINT NOT NULL
);

