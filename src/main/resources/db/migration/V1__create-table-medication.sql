CREATE table tb_medication
(
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    name            VARCHAR(100) NOT NULL,
    route           VARCHAR(100) NOT NULL,
    batch           VARCHAR(100) NOT NULL,
    quantity        INT(20)      NOT NULL,
    expiration_date VARCHAR(100) NOT NULL,
    laboratory      VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);

