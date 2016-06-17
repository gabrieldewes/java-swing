CREATE DATABASE IF NOT EXISTS aula18_ap3_agenda;
USE aula18_ap3_agenda;
DROP TABLE IF EXISTS contato;
CREATE TABLE contato (id int(11) NOT NULL AUTO_INCREMENT, nome varchar(45) NOT NULL, fone varchar(45) NOT NULL, PRIMARY KEY (id) );
