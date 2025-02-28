CREATE DATABASE IF NOT EXISTS el_gato_pedia;

USE el_gato_pedia;

CREATE TABLE IF NOT EXISTS picture (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     cat_id BIGINT,
     picture_name VARCHAR(100),
     url VARCHAR(1000),
    FOREIGN KEY (cat_id) REFERENCES cat(id)
    );