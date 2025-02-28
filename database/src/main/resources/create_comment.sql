CREATE DATABASE IF NOT EXISTS el_gato_pedia;

USE el_gato_pedia;


CREATE TABLE IF NOT EXISTS comment
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    picture_id BIGINT,
    comment TEXT,
    FOREIGN KEY (picture_id) REFERENCES picture(id)
    );