use security_db

create table product(
    id int AUTO_INCREMENT,
    name varchar(20),
    description varchar(100),
    price decimal(8,3),
    PRIMARY KEY (id)
);

create table coupon(
    id int AUTO_INCREMENT,
    code varchar(20),
    discount decimal(8,3),
    exp_date varchar(100),
    PRIMARY KEY (id)
)

create TABLE user
(
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    email VARCHAR(20),
    password VARCHAR(256),
    PRIMARY KEY (ID),
    UNIQUE KEY (EMAIL)
);

CREATE TABLE role
(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    PRIMARY KEY (ID)
);

CREATE TABLE user_role(
    user_id int,
    role_id int,
    FOREIGN KEY (user_id)
    REFERENCES user(id),
    FOREIGN KEY (role_id)
    REFERENCES role(id)
);

insert into user(first_name,last_name,email,password) values ('doug','bailey','doug@bailey.com','$2a$10$U2STWqktwFbvPPsfblVeIuy11vQ1S/0LYLeXQf1ZL0cMXc9HuTEA2');
insert into user(first_name,last_name,email,password) values ('john','ferguson','john@ferguson.com','$2a$10$YzcbPL.fnzbWndjEcRkDmO1E4vOvyVYP5kLsJvtZnR1f8nlXjvq/G');

insert into role values(1,'ROLE_ADMIN');
insert into role values(2,'ROLE_USER');

insert into user_role values(1,1);
insert into user_role values(2,2);

select * from user;
select * from role;
select * from user_role;
