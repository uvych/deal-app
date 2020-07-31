BEGIN;

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, title VARCHAR(255) , price bigint);
INSERT INTO product (title, price) VALUES
('Book', 150),
('Laptop', 60000),
('Phone', 30000);

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('Alexander'),
('Bob'),
('Jon');

DROP TABLE IF EXISTS deal CASCADE;
CREATE TABLE deal (deal_id  bigserial unique not null,customer_id bigint, product_id bigint , price bigint check ( price > 0), FOREIGN KEY (customer_id) REFERENCES customers (id),
                 FOREIGN KEY (product_id) REFERENCES product(id));
INSERT INTO deal (customer_id, product_id, price) VALUES
(1, 1, 567),
(1, 2, 1234),
(3, 3, 666),
(3, 1, 888),
(2, 1, 999);

COMMIT;