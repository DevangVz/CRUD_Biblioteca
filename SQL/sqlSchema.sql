/***********************************************************************************
************************************************************************************
************************************************************************************
*********************DATABASE SCHEMA FOR LIBRARY CRUD EXAMPLE***********************
*********************Devang Vazquez: devang.vazquez@gmail.com***********************
********************************May 24th 2016***************************************
************************************************************************************
*********************DO NOT USE USER ROOT FOR YOUR OWN SCHEMA***********************
************************************************************************************
************************************************************************************
************************************************************************************/

CREATE USER 'devang'@'localhost' IDENTIFIED BY '123456';
GRANT ALL ON *.* TO 'devang'@'localhost';
CREATE DATABASE Biblioteca;
GRANT ALL PRIVILEGES on Biblioteca.* to devang@localhost;

/*********************************DROP SECTION**************************************/

DROP TABLE Reservation cascade;
DROP TABLE User CASCADE;
DROP TABLE Book CASCADE;
drop table Author cascade;
drop table Genre cascade;
drop table Publisher cascade;
drop table AuthorBook cascade;
drop table PublisherBook cascade;

/*********************************CREATE SECTION************************************/
CREATE TABLE User(
ID int4 primary key not null auto_increment ,
cName varchar (50) not null,
lastName varchar (50) not null,
OCR varchar (13) not null unique
);

CREATE TABLE Genre(
ID int4 primary Key not null auto_increment unique,
genreName varchar (20),
description varchar (200)
);

CREATE TABLE Author(
ID int4 primary key not null auto_increment,
aName varchar (30) not null,
middleName varchar (50),
lastName varchar (50) not null,
DOB date,
nationality varchar (30)
);

CREATE TABLE Publisher (
ID int4 primary key not null auto_increment,
pName varchar (30) not null,
countrycode varchar (3),
address varchar(50),
ZC varchar(10)

);

CREATE TABLE Book(
ID int4 primary key not null auto_increment unique,
title  varchar (50) not null,
countrycode varchar (3),
ISBN varchar (17) not null unique,
genreID int4,
pages int4,
FOREIGN KEY (genreID) references Genre(ID)
);

CREATE TABLE Reservation(
ID int4 not null primary key auto_increment,
clientID int4 not null,
bookID int4 not null,
borrowedDate date not null,
returnDate date not null,
FOREIGN KEY (clientID) references Client(ID),
FOREIGN KEY (bookID) references Book(ID)
);

CREATE TABLE AuthorBook(
bookID int4 not null,
authorID int4 not null ,
Primary Key (bookID,authorID),
Foreign Key (bookID) references Book(ID),
Foreign key (authorID) references Author(ID)
);

CREATE TABLE PublisherBook(
bookID int4 not null,
publisherID int4 not null,
numberEdition int4 not null,
publishDate date not null,
Primary Key (bookID,publisherID,numberEdition),
Foreign Key (bookID) references Book(ID),
Foreign Key (publisherID) references Publisher(ID)
);
