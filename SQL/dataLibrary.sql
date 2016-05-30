/***********************************************************************************
************************************************************************************
************************************************************************************
*********************DATABASE SCHEMA FOR LIBRARY CRUD EXAMPLE***********************
*********************Devang Vazquez: devang.vazquez@gmail.com***********************
********************************May 24th 2016***************************************
************************************************************************************
************************************************************************************
************************************************************************************
**********************BE CAREFUL WITH INSERTS, THEY IMPLEMENT***********************
**********************LAST_INSERT_ID() THAT TOOKS THE LAST ID***********************
**********************AND THEN INSERT IT, SO, RUN THIS SCRIPT***********************
**************************************ONLY ONCE*************************************
************************************************************************************
************************************************************************************
***********************************************************************************/

INSERT INTO User (cName,lastname,OCR) VALUES('Ana','Cruz Martínez','1324567891244');
INSERT INTO User (cName,lastname,OCR) VALUES('Raul','Perez Suarez','1324567891235');
INSERT INTO User (cName,lastname,OCR) VALUES('Juan','Nava Zamudio','1324567891236');
INSERT INTO User (cName,lastname,OCR) VALUES('David','Vite Treviño','1324567891237');
INSERT INTO User (cName,lastname,OCR) VALUES('Apolinar','Alvizar de la Rosa','1324567891238');

INSERT INTO Author  (aName,middleName,lastName,DOB,nationality) VALUES('Octavio','','Paz Lozano',STR_TO_DATE('3-31-1954', '%m-%d-%Y'),'Mexican');
INSERT INTO Author  (aName,middleName,lastName,DOB,nationality) VALUES('Joanne','K','Rowling',STR_TO_DATE('07-31-1965', '%m-%d-%Y'),'English');
INSERT INTO Author  (aName,middleName,lastName,DOB,nationality) VALUES('Edgar','Allan','Poe',STR_TO_DATE('1-19-1809', '%m-%d-%Y'),'American');
INSERT INTO Author  (aName,middleName,lastName,DOB,nationality) VALUES('Gabriel','José de la Concordia','Garcia Marquez',STR_TO_DATE('3-6-1927', '%m-%d-%Y'),'Colombian');
INSERT INTO Author  (aName,middleName,lastName,DOB,nationality) VALUES('Howard','Philips','Lovecraft',STR_TO_DATE('8-20-1890', '%m-%d-%Y'),'American');
INSERT INTO Author  (aName,middleName,lastName,DOB,nationality) VALUES('Agatha','Mary Clarissa','Miller',STR_TO_DATE('9-15-1890', '%m-%d-%Y'),'English');
INSERT INTO Author  (aName,middleName,lastName,DOB,nationality) VALUES('Pablo','','Neruda',STR_TO_DATE('7-12-1904', '%m-%d-%Y'),'Chilean');

INSERT INTO Genre (genreName,description) VALUES('Horror', ' is intended to, or has the capacity to frighten, scare, disgust, or startle their readers or viewers by inducing feelings of horror and terror');
INSERT INTO Genre (genreName,description) VALUES('Fantasy', ' uses magic or other supernatural elements as a main plot element, theme, or setting. Many works within the genre take place in imaginary worlds where magic and magical creatures are common ');
INSERT INTO Genre (genreName,description) VALUES('Drama', ' Drama is the specific mode of narrative, typically fictional, represented in performance');

INSERT INTO Publisher (pName,countrycode,address,ZC) VALUES('Harlequin Enterprises', 'USA','asdlñkjasd','1345678900');
INSERT INTO Publisher (pName,countrycode,address,ZC) VALUES('Prentice Hall', 'USA','asdlñkjasd','1234567890');
INSERT INTO Publisher (pName,countrycode,address,ZC) VALUES('DIANA', 'MEX','asdlñkjasd','1234567890');
INSERT INTO Publisher (pName,countrycode,address,ZC) VALUES('Alfaguara', 'MEX','asdlñkjasd','1234567890');
INSERT INTO Publisher (pName,countrycode,address,ZC) VALUES('Editores Mexicanos', 'MEX','asdlñkjasd','1234567890');
INSERT INTO Publisher (pName,countrycode,address,ZC) VALUES('Porrua', 'MEX','asdlñkjasd','1234567890');

INSERT INTO Book (title,countrycode,ISBN,genreID,pages) VALUES('Cien años de soledad','MEX','9788423451839',1,456);
INSERT INTO Book (title,countrycode,ISBN,genreID,pages) VALUES('QWERTY','MEX','9788420451839',1,300);
INSERT INTO Book (title,countrycode,ISBN,genreID,pages) VALUES('ADFG','MEX','9788420471849',1,556);
INSERT INTO Book (title,countrycode,ISBN,genreID,pages) VALUES('ZXCVBB','MEX','9788420474839',1,876);

INSERT INTO Reservation (clientID,bookID,borrowedDate,returnDate) VALUES(1,1,STR_TO_DATE('2-12-2012', '%m-%d-%Y'),STR_TO_DATE('2-13-2012', '%m-%d-%Y'));
INSERT INTO Reservation (clientID,bookID,borrowedDate,returnDate) VALUES(1,2,STR_TO_DATE('2-12-2012', '%m-%d-%Y'),STR_TO_DATE('2-13-2012', '%m-%d-%Y'));
INSERT INTO Reservation (clientID,bookID,borrowedDate,returnDate) VALUES(2,1,STR_TO_DATE('2-12-2012', '%m-%d-%Y'),STR_TO_DATE('2-13-2012', '%m-%d-%Y'));
INSERT INTO Reservation (clientID,bookID,borrowedDate,returnDate) VALUES(1,2,STR_TO_DATE('2-12-2012', '%m-%d-%Y'),STR_TO_DATE('2-13-2012', '%m-%d-%Y'));

INSERT INTO AuthorBook (bookID, authorID) VALUES (1,3);
INSERT INTO AuthorBook (bookID, authorID) VALUES (1,4);
INSERT INTO AuthorBook (bookID, authorID) VALUES (2,4);
INSERT INTO AuthorBook (bookID, authorID) VALUES (4,3);

INSERT INTO PublisherBook (bookID, publisherID, numberEdition,publishDate) VALUES (1,2,1,STR_TO_DATE('2-12-2012', '%m-%d-%Y'));
INSERT INTO PublisherBook (bookID, publisherID, numberEdition,publishDate) VALUES(1,3,2,STR_TO_DATE('2-12-2012', '%m-%d-%Y'));
INSERT INTO PublisherBook (bookID, publisherID, numberEdition,publishDate) VALUES(3,1,4,STR_TO_DATE('2-12-2012', '%m-%d-%Y'));
INSERT INTO PublisherBook (bookID, publisherID, numberEdition,publishDate) VALUES(2,3,1,STR_TO_DATE('2-12-2012', '%m-%d-%Y'));
INSERT INTO PublisherBook (bookID, publisherID, numberEdition,publishDate) VALUES(1,3,1,STR_TO_DATE('2-12-2012', '%m-%d-%Y'));
INSERT INTO PublisherBook (bookID, publisherID, numberEdition,publishDate) VALUES(1,4,1,STR_TO_DATE('2-12-2012', '%m-%d-%Y'));
