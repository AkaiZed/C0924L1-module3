create database student_management;
use student_management;

CREATE TABLE class (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL
);
CREATE TABLE teacher (
    id INT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    country VARCHAR(255) NOT NULL
);
insert into class(`name`) values ('Lớp 1'),
('Lớp 2'),
('Lớp 3');
insert into teacher (id,`name`,age,country) values(12, 'Phan Thanh Hà', 35, 'Quảng Ngãi'),
(11, 'Nguyễn Thị Ngân', 28, 'Quảng Nam'),
(6, 'Phạm Thị Hương',45,'Hà Nam');
SELECT 
    *
FROM
    class;
SELECT 
    *
FROM
    teacher;
    -- drop table Teacher; --
/* DELETE FROM Teacher 
ORDER BY id DESC 
LIMIT 1;*/