# Sincronizar horario:
SET GLOBAL TIME_ZONE = '-3:00'; 

# Criando o banco de dados
CREATE DATABASE banco_projeto;

USE banco_projeto;

# Criando tabela login para armazenar usuarios e senhas:
CREATE TABLE tb_usuario (
	id INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(200),
    senha VARCHAR(200)
);

# Criando tabela  fila para armazenar as pessoas:
CREATE TABLE tb_fila (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200),
    idade INT,
    areaSaude BOOLEAN,
    endereco VARCHAR(200),
    dataVacinacao VARCHAR(200)
);

# Inserindo o usuario admin
INSERT INTO tb_usuario (usuario, senha) VALUES ("admin", "admin");

# Listar as bases que já existem no MySQL:
SHOW DATABASES;
# Listar as tabelas criadas:
SHOW TABLES;
# Tazer todos os registros da tabela:
SELECT * FROM tb_usuario;
# Tazer todos os registros da tabela:
SELECT * FROM tb_fila;