create database if not exists quan_li_hang;
use quan_li_hang;
create table customer(
c_id int primary key,
c_name varchar(100),
c_age int
);
create table `order`(
o_id int primary key,
c_id int, 
o_date date,
o_total_price decimal(10,2),
foreign key (c_id) references customer(c_id)
);
create table product(
p_id int primary key,
p_name varchar(100),
p_price decimal(10,2)
);
create table order_detail(
o_id int,
p_id int,
od_qty int,
foreign key (o_id) references `order`(o_id),
foreign key (p_id) references product(p_id)
);

