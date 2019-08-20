create database storefront;
use storefront;


create table User(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(40),
    Email_Id VARCHAR(30),
    Contact_Number BIGINT(10)
);

create table product(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Price INT,
    Name VARCHAR(30),
    Quantity INT
);

create table product_category(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Product_Id INT,
    Category_Id INT,
    FOREIGN KEY(Product_Id) REFERENCES Product(Id)
);

create table category(
    Id INT UNIQUE NOT NULL AUTO_INCREMENT,
    Category_Name VARCHAR(30) PRIMARY KEY,
    Parent_Id INT,
    parent_category VARCHAR(30),
    FOREIGN KEY(Parent_Id) REFERENCES category(Id)
);

create table image(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Product_id INT,
    Image BLOB,
    FOREIGN KEY(Product_id) REFERENCES product(Id)
);

create table address(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    User_id INT,
    Shipping_Address VARCHAR(20),
    FOREIGN KEY(User_id) REFERENCES User(Id)
);

create table orders(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Date_of_order_placed DATE,
    Amount INT,
    Shipping_Address INT,
    User_Id INT,
    FOREIGN KEY(User_Id) REFERENCES User(Id)
);



create table Item_List(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Product_Id INT,
    Order_Id INT,
    Status VARCHAR(10) CHECK (Status IN('Shipped', 'Cancelled', 'Returned')),
    FOREIGN KEY(Product_Id) REFERENCES product(Id),
    FOREIGN KEY(Order_Id) REFERENCES orders(Id)
);


insert into user(name, email_id, contact_number) values
('Admin', 'admin@gmail.com', 1234567890),
('Twinkle', 'twinkle@gmail.com', 6767689739),
('Shubham', 'shubham@gmail.com', 6356276377);

select * from category;

insert into category(category_name,parent_id) values
('clothes',NULL),
('electronics',NULL);

insert into category(category_name,parent_id,parent_category) values
('shirt',1,'clothes'),
('trouser',1,'clothes'),
('refrigerator',2,'electronics'),
('mobile phone',2,'electronics');

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



insert into image(product_id,image) values
(1,'C:\Users\User21\Downloads\shirt1.jpg'),
(3,'C:\Users\User21\Downloads\trouser1.jpg'),
(5,'C:\Users\User21\Downloads\refrigerator1.jpg'),
(6,'C:\Users\User21\Downloads\refrigerator2.jpg'),
(7,'C:\Users\User21\Downloads\mobile1.jpg');



insert into product(price, name, quantity) 
values(700, 'coton shirt', 40);


insert into product_category(product_id, category_id) values
(9,1),
(9,3);

insert into orders values(NULL, '2019-07-10', 500, 3, 2),
                         (NULL, '2019-07-30', 700, 1, 3),
                         (NULL, '2018-06-04', 400, 2, 2);

insert into Item_List values(1, 4, 1,'Cancelled'),
                            (2, 5, 1, 'Shipped');
                            

#Assignment 2
#Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories
select p.id, p.name, (SELECT COUNT(*) FROM product_category where product_id=p.id) AS COUNT FROM product p group by p.id HAVING COUNT>1;



#Display Count of products as per price range
SELECT  '0 - 100' as 'Range in Rs.', COUNT(id) AS COUNT FROM product
WHERE price  BETWEEN 0 AND 100
UNION 
SELECT  '101 - 500' as 'Range in Rs', COUNT(id) AS COUNT FROM product
WHERE price  BETWEEN 101 AND 500
UNION 
SELECT  'ABOVE 500' as 'Range in Rs', COUNT(id) AS COUNT FROM product
WHERE price  >500;

#Display the Categories along with number of products under each category.
SELECT c.category_name, (SELECT COUNT(Id) FROM product_category where 
category_id=c.id) AS Number_Of_Products 
FROM category AS c GROUP BY c.id; 



#Assignment 3

#Display Shopper’s information along with number of orders he placed during last 30 days.
SELECT DISTINCT u.Id, u.Name, u.Email_Id, u.Contact_Number, count(o.Id)
FROM 
User AS u, orders AS o 
where o.User_Id=u.Id AND DATEDIFF(curdate(), o.Date_of_order_placed) <= 30;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT O.user_Id, u.Name, SUM(O.Amount)
FROM orders AS O 
inner join 
User AS u 
on u.id=o.user_Id 
where DATEDIFF(curdate(), O.Date_of_order_placed) <= 30 
GROUP BY O.user_Id LIMIT 10;



#Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT p.Name, count(o.Id)
FROM orders AS o 
inner join 
product AS p 
on p.Id=o.user_Id
where DATEDIFF(curdate(), o.Date_of_order_placed) <= 60
GROUP BY o.Id LIMIT 20;

#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT MONTH(o.Date_of_order_placed), sum(o.Amount) 
from orders as o 
where DATEDIFF(now(), o.Date_of_order_placed)<=180 
order by o.Date_of_order_placed desc;

#Mark the products as Inactive which are not ordered in last 90 days.
#safe mode error
update product 
set product.status = 'Inactive' 
where product.Id NOT IN (
select Id from (select i.Id 
from Item_List as i join product as p join orders as o 
where o.Id=i.order_Id 
AND 
i.product_Id=p.Id 
AND DateDiff(curdate(), o.Date_of_order_placed)<=90) as T);

#Given a category search keyword, display all the Products present in this category/categories. 
SELECT p.Name 
from product as p join product_category as pc join category as c 
where p.Id=pc.product_Id 
AND 
pc.category_Id=c.Id 
AND 
category_name = 'clothes';

#Display top 10 Items which were cancelled most.
select p.Id,MAX(i.status) from product as p, Item_List as i where i.product_Id=p.Id AND i.status = 'Cancelled' LIMIT 10;

#ASSIGNMENT 4

#Consider a form where providing a Zip Code populates associated City and State.

#Create appropriate tables and relationships for the same and write a SQL
#         query for that returns a Resultset containing Zip Code, City Names and
#         States ordered by State Name and City Name.

create table zip_code(
    Id INT PRIMARY KEY,
    zipcode INT,
    city_name varchar(20),
    states varchar(20),
    FOREIGN KEY (Id) REFERENCES orders(Shipping_Address)
);

insert into zip_code values(1, 305001, 'Ajmer', 'Raj'),
                           (2, 305022, 'Jaipur', 'Raj');


SELECT zipcode, city_name, states FROM zip_code ORDER BY city_name, states;

#ASSIGNMENT 5

# Create a view displaying the order information 
# (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
# with latest ordered items should be displayed first for last 60 days.

create view order_info AS
SELECT p.id, p.name AS title, p.price, u.name, u.email_id, o.date_of_order_placed, i.status
FROM product p join item_list i  join orders o join user u 
WHERE p.id=i.product_id AND i.order_Id=o.id AND o.user_id=u.id
AND DATEDIFF(CURDATE(), o.date_of_order_placed)<=60
ORDER BY o.date_of_order_placed DESC;

select * from order_info;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.
select id, title from order_info where status='Shipped';

#Use the above view to display the top 5 most selling products.
select id, title, COUNT(id) AS Number_of_items_sold 
from order_info
group by id
order by COUNT(id) DESC LIMIT 5;
