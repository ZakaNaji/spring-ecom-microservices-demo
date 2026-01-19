-- Seed Categories (static reference data)
INSERT INTO categories (id, name, description) VALUES
                                                   (nextval('categories_seq'), 'Phones', 'Smartphones and accessories'),
                                                   (nextval('categories_seq'), 'Laptops', 'Laptops and ultrabooks'),
                                                   (nextval('categories_seq'), 'Gaming', 'Consoles and games');