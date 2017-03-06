create table category
(
id identity,
name varchar(50),
description varchar(255),
image_url varchar(50),
constraint pk_category_id primary key(id)
);

insert into category (name,description,image_url) values ('mobile','all kinds of mobiles','covers2');