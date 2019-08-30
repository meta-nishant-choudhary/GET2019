CREATE DATABASE student;

USE student;

CREATE TABLE student_detail(roll_no int primary key auto_increment,
                            first_name varchar(20), 
                            last_name varchar(20), 
                            father_name varchar(20), 
                            E_mail varchar(20) unique, 
                            class INT, 
                            Age INT
);


