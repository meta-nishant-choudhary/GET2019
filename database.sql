create database storefront;
use storefront;
create table User(
Id INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(40),
Email_Id VARCHAR(30),
Password VARCHAR(20),
Contact_Number BIGINT);

create table product(
Id INT PRIMARY KEY AUTO_INCREMENT,
Price INT,
Name VARCHAR(30));

create table product_category(
Id INT PRIMARY KEY AUTO_INCREMENT,
Product_Id INT,
Category_Id INT);

create table category(
Id INT UNIQUE NOT NULL AUTO_INCREMENT,
Category_Name VARCHAR(30) PRIMARY KEY,
Parent_Id INT,
Parent_Category VARCHAR(30),
FOREIGN KEY(Parent_Id) REFERENCES category(Id));

ALTER TABLE product_category ADD FOREIGN KEY(Product_Id) REFERENCES Product(Id);
ALTER TABLE product_category ADD FOREIGN KEY(Category_Id) REFERENCES Category(Id);


create table image(
Id INT PRIMARY KEY AUTO_INCREMENT,
Product_id INT,
Image BLOB,
FOREIGN KEY(Product_id) REFERENCES product(Id));

create table address(
Id INT PRIMARY KEY AUTO_INCREMENT,
User_id INT,
Zip_code VARCHAR(7),
FOREIGN KEY(User_id) REFERENCES User(Id));

DESC product;
DESC product_category;
DESC category;
DESC address;

create table zip_code(
Code INT PRIMARY KEY,
City VARCHAR(30),
State VARCHAR(30),
Country VARCHAR(30));

alter table product add quantity INT UNSIGNED;

create table orders(
Id INT PRIMARY KEY AUTO_INCREMENT,
Date_of_order_placed DATE,
Amount INT,
Shipping_Address INT,
User_Id INT);

create table Item_List(
Id INT PRIMARY KEY AUTO_INCREMENT,
Product_Id INT,
Order_Number INT,
Status VARCHAR(10) CHECK (Status IN('Shipped', 'Cancelled', 'Returned')));

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE product;

create table product(
Id INT PRIMARY KEY AUTO_INCREMENT,
Price INT,
Name VARCHAR(30),
Quantity INT);
SET FOREIGN_KEY_CHECKS=1;

insert into user(name, email_id, password, contact_number) values
('Admin', 'admin@gmail.com', 'admin123', 1234567890),
('Twinkle', 'twinkle@gmail.com', 'twinkle123', 6767689739),
('Shubham', 'shubham@gmail.com', 'shubham123', 6356276377);

select * from category;

insert into category(category_name,parent_id) values
('clothes',NULL),
('electronics',NULL);
insert into category(category_name,parent_id,parent_category) values
('shirt',1,'clothes'),
('trouser',1,'clothes'),
('refrigerator',2,'electronics'),
('mobile phone',2,'electronics');

update category set parent_category='Top Category' where parent_id  is NULL;
insert into product(price,name,quantity) values
(1000,'shirt1',30),
(1200,'shirt2',50),
(2000,'trouser1',60),
(2500,'trouser2',20),
(18000,'refrigerator1',90),
(20000,'refrigerator2',40),
(30000,'mobile1',76),
(20800,'mobile2',54);
select * from product;

insert into product_category(product_id,category_id) values
(1,3),
(2,3),
(3,4),
(4,4),
(5,5),
(6,5),
(7,6),
(8,6);

select * from image;

insert into image(product_id,image) values
(1,'C:\Users\User21\Downloads\shirt1.jpg'),
(3,'C:\Users\User21\Downloads\trouser1.jpg'),
(5,'C:\Users\User21\Downloads\refrigerator1.jpg'),
(6,'C:\Users\User21\Downloads\refrigerator2.jpg'),
(7,'C:\Users\User21\Downloads\mobile1.jpg');



#Assignment 2

select p.id,p.name,p.price,c.category_name from product AS p, product_category AS pc, category AS c 
where pc.product_id=p.id AND pc.category_id=c.id ORDER BY p.id DESC;

select name from product where id NOT IN(Select DISTINCT product_id from image);

select id, parent_category, category_name from category ORDER BY parent_category;

select id, category_name, parent_category from category where category_name NOT IN (select parent_category from category);

select p.id, p.name from product p, product_category pc, category c
where c.category_name='mobile phone' AND pc.category_id=c.id AND pc.product_id=p.id;

#
select name as Product_Name from product where quantity<50;
                                    
#change in code
create table Stock(Id int primary key AUTO_INCREMENT,
                   quantity int, 
                   p_Id int,
                   Foreign key (p_Id) references product(Id)
                   );

insert into Stock values(1, 10, 1),
                        (2, 50, 2),
                        (3, 60, 3);

select p.Name from product AS p, Stock AS s where p.Id=s.p_Id group by s.quantity < 50;
#                                  

update product set quantity=quantity+100;

select * from orders;


#Assignment 3

1.) select * from orders ORDER BY date_of_order_placed LIMIT 50;

2.) select * from orders ORDER BY amount LIMIT 10;

insert into item_list (product_id, order_number, status) values
(4, 1, 'Cancelled'),
(5, 1, 'Shipped');

3.) SELECT o.id, o.date_of_order_placed, o.user_id, o.amount from orders AS o, item_list AS i where DATEDIFF(CURDATE(), o.date_of_order_placed) > 10 AND 
o.id=i.order_number AND i.status!='Shipped';

4.) select u.name from user u,role r where u.id=r.user_id and u.id NOT In(select user_id from orders where date_of_order_placed > CURDATE()-30);
                
5.) SELECT  u9.id, u.name, o.amount, o.date_of_order_placed, o.id
 from user as u, orders as o 
where u.id=o.user_id AND DATEDIFF(CURDATE(), o.date_of_order_placed) <=15;

6.) select i.id from orders AS o , item_list AS i where o.id = i.id AND i.status = 'Shipped';	

7.) SELECT p.name, p.price, o.date_of_order_placed
from orders as o, product as p, item_list as i
where i.order_number=o.id AND i.product_id=p.id AND p.price BETWEEN 20 AND 50;

