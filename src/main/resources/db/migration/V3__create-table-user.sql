CREATE table tb_user
(
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    login    VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);

