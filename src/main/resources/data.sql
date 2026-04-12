create table if not exists users(
    id int auto_increment primary key,
    name varchar(100),
    password varchar(100)
);

insert into users(name, password) values ('Tema', '1515'), ('Eldo', '2209');

