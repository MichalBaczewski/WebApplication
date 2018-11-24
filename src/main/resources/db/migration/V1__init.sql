--- recources->db->migration->V1__init.sql
CREATE TABLE CUSTOMER(
    ID INTEGER auto_increment NOT NULL,
    ADDRESS_LINE VARCHAR(255),
    CITY VARCHAR(255),
    EMAIL VARCHAR(255),
    FIRST_NAME VARCHAR(255),
    LAST_NAME VARCHAR(255),
    PHONE_NUMBER VARCHAR(255),
    ZIP_CODE VARCHAR(255),
    PRIMARY KEY (ID)
);
-- --
INSERT INTO CUSTOMER(ADDRESS_LINE, CITY, EMAIL, FIRST_NAME, LAST_NAME ,PHONE_NUMBER, ZIP_CODE)
VALUES('Malmeda 111','Warszawa','dd@example.com','Karol','Kowalski','999 888 777','00-999'),
('Malmeda 222','Warszawa','aa@example.com','Mietek','Mieczkowski','888 888 555','11-999'),
('Malmeda 333','Warszawa','bb@example.com','Witek','Witkowski','777 888 544','22-999'),
('Malmeda 444','Warszawa','cc@example.com','Marek','Dudzik','666 888 533','33-999');