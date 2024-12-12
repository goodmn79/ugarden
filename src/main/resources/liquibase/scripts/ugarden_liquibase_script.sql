--liquibase formatted sql

--changeset VinogradovE:1
create table products(
id serial primary key,
species varchar(50) not null,
name varchar(50) not null,
size varchar(50),
description text not null,
price int not null,
count int,
constraint unique_product unique(species, name)
)