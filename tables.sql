CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY,
    nome_cliente VARCHAR(100),
    documento_cliente VARCHAR(15),
    email_cliente VARCHAR(100),
    telefone_cliente VARCHAR(20),
    cep_cliente VARCHAR(8),
    cidade_cliente VARCHAR(50),
    rua_cliente VARCHAR(100),
    ncasa_cliente VARCHAR(10)
);

CREATE TABLE transportadora (
    id_transportadora INT PRIMARY KEY,
    nome_transportadora VARCHAR(100),
    horario_abertura_transpo TIME,
    horario_fechamento_tran TIME,
    cnpj_transportadora VARCHAR(14),
    contratacao_mensal_tran DECIMAL(10,2)
);

CREATE TABLE fornecedor (
    id_fornecedor INT PRIMARY KEY,
    nome_fornecedor VARCHAR(100),
    cnpj_fornecedor VARCHAR(14),
    telefone_fornecedor VARCHAR(20)
);

CREATE TABLE categoria (
    id_categoria INT PRIMARY KEY,
    nome_categoria VARCHAR(50),
    desc_categoria TEXT
);

CREATE TABLE pedido (
    id_pedido INT PRIMARY KEY,
    data_pedido DATE,
    fk_cliente_id_cliente INT REFERENCES cliente(id_cliente),
    fk_transportadora_id_transportadora INT REFERENCES transportadora(id_transportadora)
);

CREATE TABLE pagamento (
    id_pagamento INT PRIMARY KEY,
    forma_pagamento VARCHAR(50),
    status_pagamento VARCHAR(50),
    valor_pagamento DECIMAL(10,2),
    fk_pedido_id_pedido INT REFERENCES pedido(id_pedido)
);

CREATE TABLE produto (
    id_produto INT PRIMARY KEY,
    nome_produto VARCHAR(100),
    preco_produto DECIMAL(10,2),
    qtd_estoque_produto INT,
    desc_produto TEXT,
    valor_compra_produto DECIMAL(10,2),
    valor_venda_produto DECIMAL(10,2),
    fk_fornecedor_id_fornecedor INT REFERENCES fornecedor(id_fornecedor),
    fk_categoria_id_categoria INT REFERENCES categoria(id_categoria)
);

CREATE TABLE avaliacao (
    id_avaliacao INT PRIMARY KEY,
    nota_avaliacao INT,
    desc_avaliacao TEXT,
    fk_produto_id_produto INT REFERENCES produto(id_produto)
);

CREATE TABLE carrinho_contem (
    quantidade_produtos_co INT,
    valor_compra DECIMAL(10,2),
    fk_pedido_id_pedido INT REFERENCES pedido(id_pedido),
    fk_produto_id_produto INT REFERENCES produto(id_produto),
    PRIMARY KEY (fk_pedido_id_pedido, fk_produto_id_produto)
);
