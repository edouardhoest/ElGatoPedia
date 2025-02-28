CREATE DATABASE IF NOT EXISTS el_gato_pedia;

USE el_gato_pedia;


CREATE TABLE IF NOT EXISTS comment
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cat_id BIGINT,
    comment TEXT,
    username TEXT,
    FOREIGN KEY (cat_id) REFERENCES cat(id)
    );