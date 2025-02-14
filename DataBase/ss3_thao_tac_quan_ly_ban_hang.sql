create database if not exists thao_tac_quan_li_hang;
use thao_tac_quan_li_hang;

create table customer (
    c_id int primary key,
    c_name varchar(100),
    c_age tinyint
);

create table `order` (
    o_id int primary key,
    c_id int, 
    o_date date,
    o_total_price decimal(10,2) default null,
    foreign key (c_id) references customer(c_id)
);

create table product (
    p_id int primary key,
    p_name varchar(100),
    p_price decimal(10,2)
);

create table order_detail (
    o_id int,
    p_id int,
    od_qty int,
    primary key (o_id, p_id),
    foreign key (o_id) references `order`(o_id),
    foreign key (p_id) references product(p_id)
);

insert into customer (c_id, c_name, c_age) values
(1, 'Minh Quan', 10),
(2, 'Ngoc Oanh', 20),
(3, 'Hong Ha', 50);

insert into `order` (o_id, c_id, o_date, o_total_price) values
(1, 1, '2006-03-21', null),
(2, 3, '2006-03-23', null),
(3, 1, '2006-03-16', null);

insert into product (p_id, p_name, p_price) values
(1, 'may giat', 3),
(2, 'tu lanh', 5),
(3, 'dieu hoa', 7),
(4, 'quat', 1),
(5, 'bep dien', 2);

insert into order_detail (o_id, p_id, od_qty) values
(1, 1, 3),
(1, 3, 7),
(1, 2, 2),
(2, 1, 8),
(2, 4, 4),
(3, 3, 3);
-- hiển thị các thông tin
select o_id, o_date, o_total_price
from `order`;
-- hiển thị danh sách khách hàng đã mua hàng, danh sách sản phẩm được mua
select c.c_id, c.c_name, p.p_name, od.od_qty
from customer c
join `order` o on c.c_id = o.c_id
join order_detail od on o.o_id = od.o_id
join product p on od.p_id = p.p_id
order by c.c_id;

-- hiển thị khách hàng không mua 1 sản phẩm nào
select c.c_id, c.c_name
from customer c
left join `order` o on c.c_id = o.c_id
where o.o_id is null;

-- hiển thị mã hóa đơn, giá bán và giá tiền 
select o.o_id, o.o_date, 
       sum(od.od_qty * p.p_price) as total_price
from `order` o
join order_detail od on o.o_id = od.o_id
join product p on od.p_id = p.p_id
group by o.o_id, o.o_date;
