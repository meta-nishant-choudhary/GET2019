CREATE DATABASE student;

USE student;

CREATE TABLE student_detail(roll_no int primary key auto_increment,
                            first_name varchar(20), 
                            last_name varchar(20), 
                            father_name varchar(20), 
                            E_mail varchar(20), 
                            class INT, 
                            Age INT
);

show tables;

select * from student_detail;
update student_detail set 
first_name ='asdasd', 
last_name ='choudhary', 
father_name ='Choudhary', 
E_mail ='nishant@gmail.com', 
class =4, 
Age =4 
where roll_no =45;
