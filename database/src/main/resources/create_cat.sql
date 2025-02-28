CREATE DATABASE IF NOT EXISTS el_gato_pedia;

USE el_gato_pedia;

CREATE TABLE IF NOT EXISTS cat
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (100) NOT NULL,
    description VARCHAR(100),
    age INTEGER
    );
