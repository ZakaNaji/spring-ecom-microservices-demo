-- Sequences (explicit)
CREATE SEQUENCE IF NOT EXISTS categories_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS products_seq START WITH 1 INCREMENT BY 1;

-- Category
CREATE TABLE IF NOT EXISTS categories
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('categories_seq'),
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

-- Product
CREATE TABLE IF NOT EXISTS products
(
    id                 BIGINT PRIMARY KEY DEFAULT nextval('products_seq'),
    name               VARCHAR(255)   NOT NULL,
    description        TEXT,
    available_quantity INT            NOT NULL,
    price              NUMERIC(19, 2) NOT NULL,
    category_id        BIGINT         NOT NULL,
    CONSTRAINT fk_products_category
        FOREIGN KEY (category_id) REFERENCES categories (id)
);