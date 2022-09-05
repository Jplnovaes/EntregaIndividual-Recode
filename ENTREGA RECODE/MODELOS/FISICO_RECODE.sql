-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Reserva+Cliente (
Telefone VARCHAR(10),
CPF VARCHAR(10) PRIMARY KEY,
Nome VARCHAR(10),
Email VARCHAR(10),
Rg VARCHAR(10),
Endereco VARCHAR(10)
)

CREATE TABLE Destino (
CodDestino VARCHAR(10) PRIMARY KEY,
Hora VARCHAR(10),
Data VARCHAR(10),
Cidade VARCHAR(10),
CPF VARCHAR(10),
FOREIGN KEY(CPF) REFERENCES Reserva+Cliente (CPF)
)

CREATE TABLE Passagem (
CodPassagem VARCHAR(10) PRIMARY KEY,
Data VARCHAR(10),
Empresa VARCHAR(10),
Hora VARCHAR(10),
CPF VARCHAR(10),
FOREIGN KEY(CPF) REFERENCES Reserva+Cliente (CPF)
)

