-- Active: 1782170922061@@sa-banco-de-dados-estudante-a8e2.d.aivencloud.com@24499@WeganosDB

CREATE USER 'alannis_b_lange' IDENTIFIED BY 'senha1234';
CREATE USER 'andre_a_silva' IDENTIFIED BY 'senha1234';
CREATE USER 'joas_schmidt' IDENTIFIED BY 'senha1234';
CREATE USER 'marcos' IDENTIFIED BY 'senha1234';
RENAME USER 'marcos' TO 'marcos_deleprani';
CREATE USER 'pedro_h_s_schneider' IDENTIFIED BY 'senha1234';
FLUSH PRIVILEGES;
GRANT ALL PRIVILEGES ON WeganosDB.* TO'joas_schmidt';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER ON WeganosDB.* TO'andre_a_silva';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER ON WeganosDB.* TO'alannis_b_lange';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER ON WeganosDB.* TO'marcos_deleprani';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER ON WeganosDB.* TO'pedro_h_s_schneider';
SELECT Host, Db, User, Select_priv, Insert_priv, Update_priv, Delete_priv, Create_priv, Drop_priv
FROM mysql.db 
WHERE Db = 'WeganosDB';