ALTER TABLE tb_medication ADD active TINYINT;
UPDATE tb_medication SET active = 1;