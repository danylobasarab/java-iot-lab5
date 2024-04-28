CREATE DATABASE IF NOT EXISTS project;
USE project;

DROP TABLE IF EXISTS establishment_review_of_establishment;
DROP TABLE IF EXISTS establishment;
DROP TABLE IF EXISTS street;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS review_of_establishment;
DROP TABLE IF EXISTS user_account;
DROP TABLE IF EXISTS type_of_establishment;
DROP TABLE IF EXISTS information_about_owner;
DROP TABLE IF EXISTS credential;
DROP TABLE IF EXISTS country;

CREATE TABLE information_about_owner (
    id INT NOT NULL,
    name VARCHAR(30) NULL,
    surname VARCHAR(40) NULL,
    age INT NULL,
    fortunes INT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE country (
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (name)
);

CREATE TABLE city (
    id INT NOT NULL,
    name VARCHAR(45) NULL,
    country_name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (country_name) REFERENCES country (name)
);

CREATE TABLE street (
    id INT NOT NULL,
    name VARCHAR(45) NULL,
    city_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (city_id) REFERENCES city (id)
);

CREATE TABLE credential (
    id INT NOT NULL,
    login VARCHAR(30) NULL,
    password VARCHAR(45) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_account (
    nickname VARCHAR(30) NOT NULL,
    name VARCHAR(30) NULL,
    surname VARCHAR(40) NULL,
    credential_id INT NOT NULL,
    PRIMARY KEY (nickname),
    FOREIGN KEY (credential_id) REFERENCES credential (id)
);

CREATE TABLE review_of_establishment (
    id INT NOT NULL,
    review VARCHAR(255) NOT NULL,
    user_account_nickname VARCHAR(30) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_account_nickname) REFERENCES user_account (nickname)
);

CREATE TABLE type_of_establishment (
    id INT NOT NULL,
    type_name VARCHAR(30) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE establishment (
    id INT NOT NULL,
    name VARCHAR(30) NULL,
    type_of_establishment_id INT NOT NULL,
    rating FLOAT(2,1) NOT NULL,
    street_id INT NOT NULL,
    information_about_owner_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (type_of_establishment_id) REFERENCES type_of_establishment (id),
    FOREIGN KEY (street_id) REFERENCES street (id),
    FOREIGN KEY (information_about_owner_id) REFERENCES information_about_owner (id)
);

CREATE TABLE establishment_review_of_establishment (
    review_of_establishment_id INT NOT NULL,
    establishment_id INT NOT NULL,
    PRIMARY KEY (review_of_establishment_id, establishment_id),
    FOREIGN KEY (review_of_establishment_id) REFERENCES review_of_establishment (id),
    FOREIGN KEY (establishment_id) REFERENCES establishment (id)
);

INSERT INTO information_about_owner (id, name, surname, age, fortunes) VALUES
(1, 'Pavlo', 'Turchynyak', 35, 15000),
(2, 'Oleg', 'Kiruch', 40, 300000),
(3, 'Igor', 'Vilkov', 25, 250000),
(4, 'Marko', 'Yaminskyy', 45, 85000),
(5, 'Denys', 'Izhyk', 60, 875000),
(6, 'Roman', 'Push', 23, 873525);

INSERT INTO country (name) VALUES
('Ukraine'),
('Poland'),
('USA'),
('France'),
('Germany'),
('Pidarasia'),
('Greece');

INSERT INTO city (id, name, country_name) VALUES
(1, 'Lviv', 'Ukraine'),
(2, 'Kyiv', 'Ukraine'),
(3, 'Warsaw', 'Poland'),
(4, 'Berlin', 'Germany'),
(5, 'Paris', 'France'),
(6, 'Dalos', 'USA');

INSERT INTO street (id, name, city_id) VALUES
(1, 'Veres', 2),
(2, 'Peace', 3),
(3, 'IoT', 1),
(4, 'Polytechic', 1),
(5, 'Ukrainer', 3),
(6, 'Zelensky', 5);

INSERT INTO credential (id, login, password) VALUES
(1, '32121', '32143311'),
(2, '32dgfda1', '3214rewrw1'),
(3, '354354ddsawewq', '32proradsa11'),
(4, '4bxfzrre21', '321gfdgdsasa1'),
(5, '3rewrew', 'rew2rerewr'),
(6, '54354dksaorjirkew', 'k3hjejmdkldspe'),
(7, 'o432432432', '3fdzldsds');

INSERT INTO user_account (nickname, name, surname, credential_id) VALUES
('mtk', 'Pavlo', 'Arach', 2),
('elena', 'Olena', 'Arach', 1),
('32Looo32', 'Igor', 'Rock', 5),
('krasava', 'Iryna', 'Pistun', 2);

INSERT INTO review_of_establishment (id, review, user_account_nickname) VALUES
(1, "324324fdsfdskjtrteihtjrejitre", 'mtk'),
(2, "324324dsadasdsadsadsadsadsatrteihtjrejitre", 'mtk'),
(3, "32435i4395430mvc,mfsnajfjjfnsjht bewkj akxdadsa,dsjoprjlre", 'elena'),
(4, "3kkwipoewqeowqp[wihtfdsfdsfdsxfdxfsdasjrejitre", 'krasava'),
(5, "432432", 'krasava');

INSERT INTO type_of_establishment (id, type_name) VALUES
(1, 'restoran'),
(2, 'caffe'),
(3, 'bar'),
(4, 'pub'),
(5, 'coffeer');

INSERT INTO establishment (id, name, type_of_establishment_id, rating, street_id, information_about_owner_id) VALUES
(1, '3FKDDLS',2, 4.3, 2, 2),
(2, '3FKdfsfdszS',3, 5.1, 5, 2),
(3, '3IOT', 2, 3.4, 1, 5),
(4, 'XSRE', 4, 5.0, 2, 2);

INSERT INTO establishment_review_of_establishment(review_of_establishment_id, establishment_id) VALUES
(1, 1), (2, 1), (3, 4), (2, 3), (4, 1), (4, 3);

CREATE INDEX name_index ON city(name);
CREATE INDEX name_index ON street(name);
CREATE INDEX name_index ON information_about_owner(name);
CREATE INDEX surname_index ON information_about_owner(surname);
CREATE INDEX rating_index ON establishment(rating);
CREATE INDEX name_index ON establishment(name);
CREATE INDEX name_index ON user_account(name);
CREATE INDEX surname_index ON user_account(surname);
