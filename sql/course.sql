
use course_app;

create table course(
    c_id bigint primary key AUTO_INCREMENT,
    course_name varchar(25),
    description varchar(50)
);

insert into course ( course_name, description) values("C", "Powerfull Lang");
insert into course (course_name, description) values("CPP", "C + OOP");
insert into course ( course_name, description) values("Python", "Secure and Robust Lang");
