CREATE TABLE CLIENTE (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nome_cliente VARCHAR(100),
    cpf_cliente VARCHAR(11),
    email_cliente VARCHAR(100),
    telefone_cliente VARCHAR(20),
    cep_cliente VARCHAR(8),
    cidade_cliente VARCHAR(50),
    ruu_cliente VARCHAR(100),
    ncasa_cliente VARCHAR(10)
);

CREATE TABLE TRANSPORTADORA (
    id_transportadora INT PRIMARY KEY AUTO_INCREMENT,
    nome_transportadora VARCHAR(100),
    horario_abertura_transpo TIME,
    horario_fechamento_tran TIME,
    cnpj_transportadora VARCHAR(14),
    contratacao_mensal_tran DECIMAL(10,2)
);

CREATE TABLE FORNECEDOR (
    id_fornecedor INT PRIMARY KEY AUTO_INCREMENT,
    nome_fornecedor VARCHAR(100),
    cnpj_fornecedor VARCHAR(14),
    telefone_fornecedor VARCHAR(20)
);

CREATE TABLE CATEGORIA (
    id_categoria INT PRIMARY KEY AUTO_INCREMENT,
    nome_categoria VARCHAR(50),
    desc_categoria TEXT
);

CREATE TABLE PEDIDO (
    id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    data_pedido DATE,
    FK_CLIENTE_id_cliente INT,
    FK_TRANSPORTADORA_id_transportadora INT,
    FOREIGN KEY (FK_CLIENTE_id_cliente) REFERENCES CLIENTE(id_cliente),
    FOREIGN KEY (FK_TRANSPORTADORA_id_transportadora) REFERENCES TRANSPORTADORA(id_transportadora)
);

CREATE TABLE PAGAMENTO (
    id_pagamento INT PRIMARY KEY AUTO_INCREMENT,
    forma_pagamento VARCHAR(50),
    status_pagamento VARCHAR(50),
    valor_pagamento DECIMAL(10,2),
    FK_PEDIDO_id_pedido INT,
    FOREIGN KEY (FK_PEDIDO_id_pedido) REFERENCES PEDIDO(id_pedido)
);

CREATE TABLE PRODUTO (
    id_produto INT PRIMARY KEY AUTO_INCREMENT,
    nome_produto VARCHAR(100),
    qtd_estoque_produto INT,
    desc_produto TEXT,
    valor_compra_produto DECIMAL(10,2),
    valor_venda_produto DECIMAL(10,2),
    FK_FORNECEDOR_id_fornecedor INT,
    FK_CATEGORIA_id_categoria INT,
    FOREIGN KEY (FK_FORNECEDOR_id_fornecedor) REFERENCES FORNECEDOR(id_fornecedor),
    FOREIGN KEY (FK_CATEGORIA_id_categoria) REFERENCES CATEGORIA(id_categoria)
);

CREATE TABLE AVALIACAO (
    id_avaliacao INT PRIMARY KEY AUTO_INCREMENT,
    nota_avaliacao INT,
    desc_avaliacao TEXT,
    FK_PRODUTO_id_produto INT,
    FOREIGN KEY (FK_PRODUTO_id_produto) REFERENCES PRODUTO(id_produto)
);


CREATE TABLE CARRINHO_CONTEM (
    quantidade_produtos_co INT,
    valor_compra DECIMAL(10,2),
    FK_PEDIDO_id_pedido INT,
    FK_PRODUTO_id_produto INT,
    PRIMARY KEY (FK_PEDIDO_id_pedido, FK_PRODUTO_id_produto),
    FOREIGN KEY (FK_PEDIDO_id_pedido) REFERENCES PEDIDO(id_pedido),
    FOREIGN KEY (FK_PRODUTO_id_produto) REFERENCES PRODUTO(id_produto)
);

CREATE TABLE LOGIN (
    id_login TINYINT PRIMARY KEY AUTO_INCREMENT,
    nome_usuario varchar(100),
    senha_login varchar(100) not null
);

