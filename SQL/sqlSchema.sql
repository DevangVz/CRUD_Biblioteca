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
DROP TABLE Client CASCADE;
DROP TABLE BOOK CASCADE;
drop table author cascade;
drop table genre cascade;
drop table publisher cascade;

/*********************************CREATE SECTION************************************/
CREATE TABLE Client(
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
aName varchar (50) not null,
lastName varchar (50) not null,
DOB date not null,
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
authorID int4 not null,
published date not null,
countrycode varchar (3),
ISBN varchar (17) not null unique,
genreID int4,
publisherID  int4,
pages int4,
FOREIGN KEY (authorID) references Author(ID),
FOREIGN KEY (genreID) references Genre(ID),
FOREIGN KEY (publisherID) references Publisher(ID)
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
ID int4 not null primary key auto_increment,
bookID int4 not null,
authorID int4 not null
);



/*CREATE TABLE Membership(
ID int4 primary key not null auto_increment,
ClientID int4,
StartDate date not null,
ExpirationDate date not null
);*/
