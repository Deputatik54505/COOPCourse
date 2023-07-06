CREATE TABLE IF NOT EXISTS product
(
    id          INT PRIMARY KEY,
    name        TEXT,
    description TEXT,
    price       REAL
);

insert into product (id, name, description, price)
values (0, 'Carrot', 'fresh carrot', 0.2);