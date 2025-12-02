CREATE DATABASE IF NOT EXISTS sistema_vacinas
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE sistema_vacinas;

CREATE TABLE pacientes (
    cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE,
    sexo VARCHAR(8),
    idade VARCHAR(20)
);

select * from pacientes;
CREATE TABLE profissionais_saude (
    id VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    registro VARCHAR(40),        -- EX: COREN, CRM, CRO, etc.
    cargo VARCHAR(50)
);

CREATE TABLE unidades_saude (
    id VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200),
    telefone VARCHAR(20)
);

CREATE TABLE vacinas (
    id VARCHAR(50) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    fabricante VARCHAR(100) NOT NULL,
    total_doses INT DEFAULT 1,
    intervalo_dias INT DEFAULT 0
);

CREATE TABLE doses_aplicadas (
    id VARCHAR(40) PRIMARY KEY,
    data DATE NOT NULL,
    unidade_id VARCHAR(20) NOT NULL,
    profissional_id VARCHAR(20) NOT NULL,
    lote VARCHAR(40),
    numero_dose INT NOT NULL,
    cpf_paciente VARCHAR(14) NOT NULL,
    vacina_id VARCHAR(50) NOT NULL,
    
    

    FOREIGN KEY (unidade_id) REFERENCES unidades_saude(id) ON DELETE CASCADE,
    FOREIGN KEY (profissional_id) REFERENCES profissionais_saude(id) ON DELETE CASCADE,
    FOREIGN KEY (cpf_paciente) REFERENCES pacientes(cpf) ON DELETE CASCADE,
    FOREIGN KEY (vacina_id) REFERENCES vacinas(id) ON DELETE CASCADE
);

ALTER TABLE doses_aplicadas
DROP PRIMARY KEY;

ALTER TABLE doses_aplicadas
MODIFY id INT NOT NULL AUTO_INCREMENT,
ADD PRIMARY KEY (id);
