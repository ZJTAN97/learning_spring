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

