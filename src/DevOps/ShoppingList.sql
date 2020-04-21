CREATE TABLE IF NOT EXISTS shoppingCart
(
    shopping_cart_id   BIGINT      NOT NULL AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    PRIMARY KEY (shopping_cart_id)
);

CREATE TABLE IF NOT EXISTS product
(
    product_Id          BIGINT      NOT NULL AUTO_INCREMENT,
    shopping_cart_id BIGINT,
    name        VARCHAR(32) NOT NULL,
    price       DECIMAL,
    category    VARCHAR(100),
    discount    DECIMAL,
    description VARCHAR(300),
    created     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (shopping_cart_id) REFERENCES shoppingCart(id),
    PRIMARY KEY (product_Id)

)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS productsCart
(
    id        BIGINT    NOT NULL,
    shopping_cart_id    BIGINT   NOT NULL,
    product_Id BIGINT NOT NULL
);