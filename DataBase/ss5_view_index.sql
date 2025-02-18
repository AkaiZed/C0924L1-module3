create database if not exists demo_bai5;
use demo_bai5;
create table products(
id int auto_increment primary key,
product_code int not null,
product_name varchar(100) not null,
product_price decimal(10,2),
product_amount decimal(8,2),
product_description varchar(255),
product_status int
);
insert into products (product_code, product_name, product_price, product_amount, product_description, product_status) values
(101, 'Laptop', 999.99, 10.00, 'High-performance gaming laptop', 1),
(102, 'Smartphone', 699.50, 25.00, 'Latest model smartphone with AI camera', 1),
(103, 'Headphones', 49.99, 50.00, 'Noise-canceling over-ear headphones', 1),
(104, 'Smartwatch', 199.95, 30.00, 'Waterproof smartwatch with health tracking', 1),
(105, 'Monitor', 299.99, 15.00, '27-inch 4K Ultra HD monitor', 1),
(106, 'Mechanical Keyboard', 89.75, 40.00, 'RGB mechanical gaming keyboard', 1),
(107, 'Gaming Mouse', 59.99, 35.00, 'Wireless ergonomic gaming mouse', 1),
(108, 'External SSD', 129.50, 20.00, '1TB portable external SSD', 1);
SELECT 
    *
FROM
    products;
    
    create unique index i_code on products(product_code);
    create unique index i_name_price on products(product_name,product_price);
    show index from products;
    
CREATE VIEW product_infor AS
    SELECT 
        product_code, product_name, product_price, product_status
    FROM
        products;    
        
        select * from product_infor;
        
SET SQL_SAFE_UPDATES = 0;        

UPDATE product_infor 
SET 
    product_price = product_price * 1.10
WHERE
    product_code % 2 = 0;
    
    
        UPDATE product_infor 
SET 
    product_price = product_price * 0.85
WHERE
    product_code % 3 = 0; 
    drop view product_infor;

DELIMITER //
CREATE PROCEDURE GetAllProducts()
BEGIN
    SELECT * FROM products;
END //
DELIMITER ;
CALL GetAllProducts();

DELIMITER //
CREATE PROCEDURE AddProduct(
    IN p_product_code INT,
    IN p_product_name VARCHAR(100),
    IN p_product_price DECIMAL(10,2),
    IN p_product_amount DECIMAL(8,2),
    IN p_product_description VARCHAR(255),
    IN p_product_status INT
)
BEGIN
    INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
    VALUES (p_product_code, p_product_name, p_product_price, p_product_amount, p_product_description, p_product_status);
END //
DELIMITER ;
CALL AddProduct(109, 'Tablet', 499.99, 15.00, 'High-resolution tablet for work and play', 1);

DELIMITER //
CREATE PROCEDURE UpdateProductById(
    IN p_id INT,
    IN p_product_code INT,
    IN p_product_name VARCHAR(100),
    IN p_product_price DECIMAL(10,2),
    IN p_product_amount DECIMAL(8,2),
    IN p_product_description VARCHAR(255),
    IN p_product_status INT
)
BEGIN
    UPDATE products
    SET 
        product_code = p_product_code,
        product_name = p_product_name,
        product_price = p_product_price,
        product_amount = p_product_amount,
        product_description = p_product_description,
        product_status = p_product_status
    WHERE id = p_id;
END //
DELIMITER ;
CALL UpdateProductById(1, 101, 'Laptop Pro', 1099.99, 5.00, 'Upgraded gaming laptop', 1);

DELIMITER //
CREATE PROCEDURE DeleteProductById(
    IN p_id INT
)
BEGIN
    DELETE FROM products WHERE id = p_id;
END //
DELIMITER ;
CALL DeleteProductById(1);
