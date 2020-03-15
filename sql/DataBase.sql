CREATE TABLE  USERS
   (
    ID varchar(40) NOT NULL PRIMARY KEY,
	NAME varchar(40) NOT NULL,
	SURNAME varchar(40) NOT NULL,
	PATRONYMIC varchar(40) NOT NULL,
	PASSPORT varchar(40) NOT NULL,
	PHONE_NO varchar(20) NOT NULL,
	PASSWORD_HASH varchar(20) NOT NULL
    );

INSERT INTO USERS VALUES ('U001', 'Ramasundar', 'Tyglyg', 'Ivanovich', '077-25814763', '911', '1');
INSERT INTO USERS VALUES ('U002', 'Alex ', 'Flex', 'Ivanovich', '075-12458969', '228', '2');
INSERT INTO USERS VALUES ('U003', 'Alford', 'Curly', 'Petrovich', '044-25874365', '282', '3');
INSERT INTO USERS VALUES ('U004', 'Ravi', 'Kumar', 'Maksimovich', '077-45625874', '010101', '4');
INSERT INTO USERS VALUES ('U005', 'Ramasundar', 'Bangalore', 'Krasavets', '077-25814763', '101010', '5');
INSERT INTO USERS VALUES ('U006', 'Alex ', 'Flex', 'Alfordovich', '075-12458969', '5553535', '6');

CREATE TABLE ACCOUNT
    (

    ID varchar(40) NOT NULL,
    NUMBER varchar(40) NOT NULL PRIMARY KEY,
    BALANCE numeric(12, 5) NOT NULL,
    CURRENCY varchar(40) NOT NULL
    );
INSERT INTO ACCOUNT VALUES ('U001', 'A001', 0, 'RU');
INSERT INTO ACCOUNT VALUES ('U002', 'A002', 10, 'RU');
INSERT INTO ACCOUNT VALUES ('U003', 'A003', 100, 'RU');
INSERT INTO ACCOUNT VALUES ('U004', 'A004', 1000, 'RU');
INSERT INTO ACCOUNT VALUES ('U005', 'A005', 5000, 'RU');
INSERT INTO ACCOUNT VALUES ('U006', 'A006', 15000, 'RU');
INSERT INTO ACCOUNT VALUES ('U001', 'A007', 20000, 'RU');
INSERT INTO ACCOUNT VALUES ('U002', 'A008', 200, 'EU');

CREATE TABLE TRANSACTION
    (
    ID varchar(40) NOT NULL PRIMARY KEY,
    CURRENCY varchar(40) NOT NULL,
    SUM numeric (12, 5) NOT NULL,
    DATE varchar (40) NOT NULL,
    SENDER_ID varchar(40) NOT NULL,
    RECEIVER_ID varchar(40) NOT NULL,
    TAG varchar(40) NOT NULL
    );


INSERT INTO TRANSACTION VALUES ('T001', 'RU',10, '01.01.01','A001', 'A002', 'RESTAURANT');
