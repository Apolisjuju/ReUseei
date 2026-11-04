-- Remove e recria o banco limpo (opcional, cuidado se já tiver dados)

IF EXISTS (SELECT * FROM SYS.databases WHERE name = 'ReUseei')

BEGIN

    ALTER DATABASE ReUseei SET SINGLE_USER WITH ROLLBACK IMMEDIATE;

    DROP DATABASE ReUseei;

END

GO

CREATE DATABASE ReUseei;

GO

USE ReUseei;

GO

CREATE TABLE Categoria (

    id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,

    nome VARCHAR(45) NOT NULL,

    descricao VARCHAR(255) NULL,

    cod_status BIT NOT NULL

);

CREATE TABLE Produto (

    id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,

    nome VARCHAR(45) NOT NULL,

    tipo VARCHAR(45) NULL,

    descricao VARCHAR(255) NULL,

    valor_compra DECIMAL (5, 2) NULL,

    valor_venda DECIMAL (5, 2) NULL,

    quantidade_estoque INT NULL,

    categoria_id BIGINT NULL,

    cod_status BIT NOT NULL,

    CONSTRAINT fk_produto_categoria_id FOREIGN KEY (categoria_id) REFERENCES Categoria(id)

);

CREATE TABLE Usuario (

    id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,

    cpf VARCHAR(45) NOT NULL,

    tipo VARCHAR(10) NULL,

    email VARCHAR(45) NULL,

    senha VARCHAR(255) NOT NULL,

    sexo VARCHAR(20) NULL,

    logradouro VARCHAR(45) NULL,

    cep VARCHAR(10) NULL,

    bairro VARCHAR (45) NULL,

    cidade VARCHAR (45) NULL,

    uf CHAR(2) NULL,

    cod_status BIT NOT NULL

);

CREATE TABLE Pedido (

    id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,

    valor_pedido DECIMAL (5,2) NOT NULL,

    data_hora_pedido DATETIME2 NOT NULL,

    data_hora_entrega DATETIME2 NULL,

    status VARCHAR(20),

    cod_status BIT NOT NULL,

    cliente_id BIGINT NOT NULL,

    CONSTRAINT fk_pedido_usuario_id FOREIGN KEY (cliente_id) REFERENCES Usuario(id)

);

CREATE TABLE ItemPedido (

    id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,

    quantidade_item INT NOT NULL,

    valor_unitario DECIMAL (5,2) NOT NULL,

    cod_status BIT NOT NULL,

    status VARCHAR(20),

    produto_id BIGINT NOT NULL,

    pedido_id BIGINT NOT NULL,

    CONSTRAINT fk_itempedido_produto_id FOREIGN KEY (produto_id) REFERENCES Produto(id),

    CONSTRAINT fk_itempedido_pedido_id FOREIGN KEY (pedido_id) REFERENCES Pedido(id)

);
 