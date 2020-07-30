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

DROP TABLE IF EXISTS details CASCADE;
CREATE TABLE details (id bigserial PRIMARY KEY , id_customer bigint, deal_price bigint, FOREIGN KEY (id_customer) REFERENCES customers (id));
INSERT INTO details (deal_price, id_customer) VALUES
(100, 1),
(40000 , 1),
(4, 3),
(2, 1),
(2, 1);

DROP TABLE IF EXISTS deal CASCADE;
CREATE TABLE deal (customer_id bigint, product_id bigint, deal_id bigint , FOREIGN KEY (customer_id) REFERENCES customers (id), FOREIGN KEY (product_id) REFERENCES product (id), FOREIGN KEY (deal_id) REFERENCES details (id));
INSERT INTO deal (customer_id, product_id, deal_id) VALUES
(1, 1 , 1),
(1, 2, 2),
(3, 3 , 3),
(3, 1, 4),
(2, 1, 5);


COMMIT;