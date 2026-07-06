-- Transportadoras mais acessíveis, com os preços mais baixos.
CREATE VIEW transportadoras_mais_acessiveis AS
SELECT t.nome_transportadora, t.contratacao_mensal_tran
FROM TRANSPORTADORA AS t
ORDER BY t.contratacao_mensal_tran;

-- Avaliações organizadas de acordo com as piores notas, a fim de analisar as piores reclamações dos clientes e tomar uma atitude com relação a elas.
CREATE VIEW piores_avaliacoes AS
SELECT a.nota_avaliacao, a.desc_avaliacao
FROM AVALIACAO AS a
ORDER BY a.nota_avaliacao;

-- Produto mais solicitado, para descobrir a maior demanda.
CREATE VIEW produtos_mais_solicitados AS
SELECT SUM(c.quantidade_produtos_co) AS quantidade_produtos, p.nome_produto
FROM CARRINHO_CONTEM AS c
JOIN PRODUTO AS p ON c.FK_PRODUTO_id_produto = p.id_produto
GROUP BY nome_produto
ORDER BY quantidade_produtos DESC;

-- Produto menos solicitado, para descobrir a menor demanda.
CREATE VIEW produtos_menos_solicitados AS
SELECT SUM(c.quantidade_produtos_co) AS quantidade_produtos, p.nome_produto
FROM CARRINHO_CONTEM AS c
JOIN PRODUTO AS p ON c.FK_PRODUTO_id_produto = p.id_produto
GROUP BY nome_produto
ORDER BY quantidade_produtos ASC;

-- Ver os produtos mais bem avaliados.
CREATE VIEW melhores_produtos_avaliados AS
SELECT DISTINCT p.nome_produto 
FROM PRODUTO AS p
JOIN AVALIACAO AS a on p.id_produto = a.FK_PRODUTO_id_produto
WHERE a.nota_avaliacao > 3;

-- Ver os produtos com a menor quantidade no estoque, indicando uma reposição necessária.
CREATE VIEW produtos_menor_estoque AS
SELECT p.nome_produto, p.qtd_estoque_produto
FROM PRODUTO AS p
ORDER BY p.qtd_estoque_produto;

-- Métodos de pagamento mais utilizados pelos clientes.
CREATE VIEW metodos_pagamento_utilizados AS
SELECT p.forma_pagamento, COUNT(p.id_pagamento) AS quantidade_pagamentos
FROM PAGAMENTO AS p
GROUP BY p.forma_pagamento
ORDER BY quantidade_pagamentos DESC;

-- Compras mais caras realizadas pelos clientes.
CREATE VIEW compras_mais_caras AS
SELECT c.nome_cliente, pa.valor_pagamento
FROM CLIENTE AS c
JOIN PEDIDO AS p ON c.id_cliente = p.FK_CLIENTE_id_cliente
JOIN PAGAMENTO AS pa ON p.id_pedido = pa.FK_PEDIDO_id_pedido
ORDER BY pa.valor_pagamento DESC;

-- Categorias de produto mais vendidas.
CREATE VIEW categorias_mais_vendidas AS
SELECT c.nome_categoria,   SUM(co.quantidade_produtos_co) AS quantidade_vendida
FROM CATEGORIA AS c
JOIN PRODUTO AS p ON p.FK_CATEGORIA_id_categoria = c.id_categoria
JOIN CARRINHO_CONTEM AS co ON co.FK_PRODUTO_id_produto = p.id_produto
GROUP BY c.nome_categoria
ORDER BY quantidade_vendida DESC;

-- Quantidade de cada produto no estoque.
CREATE VIEW quantidade_estoque_produtos AS
SELECT p.nome_produto, p.qtd_estoque_produto
FROM PRODUTO AS p
ORDER BY p.qtd_estoque_produto DESC;


-- Cidade que mais utiliza o serviço de e-commerce.
CREATE VIEW cidade_mais_utilizadora AS
SELECT COUNT(c.cidade_cliente) AS quantidade_pedidos, c.cidade_cliente
FROM CLIENTE AS c
JOIN PEDIDO AS p ON c.id_cliente = p.FK_CLIENTE_id_cliente
GROUP BY c.cidade_cliente
ORDER BY quantidade_pedidos DESC;

-- Produto mais solicitado no último mês do mini-mundo, para avaliar a demanda atual.
CREATE VIEW produto_mais_solicitado_ultimo_mes AS
SELECT SUM(c.quantidade_produtos_co) AS quantidade_produtos, pr.nome_produto
FROM CARRINHO_CONTEM AS c
JOIN PRODUTO AS pr ON c.FK_PRODUTO_id_produto = pr.id_produto
JOIN PEDIDO AS pe ON c.FK_PEDIDO_id_PEDIDO = pe.id_pedido
WHERE pe.data_pedido >= '2026-08-01'
GROUP BY nome_produto
ORDER BY quantidade_produtos DESC;

-- Quantidade de produtos fornecidos por fornecedor, organizados da maior quantidade para a menor.
CREATE VIEW produtos_fornecidos_quantidades AS
SELECT f.nome_fornecedor, COUNT(p.id_produto)
FROM FORNECEDOR AS f
JOIN PRODUTO AS p ON f.id_fornecedor = p.FK_FORNECEDOR_id_fornecedor
GROUP BY f.id_fornecedor
ORDER BY count(p.id_produto) DESC;

-- Produtos e seus respectivos fornecedores onde sua quantidade de estoque é menor que 10, indicando reposição necessária.
CREATE VIEW produtos_fornecedores_menor_estoque AS
SELECT p.nome_produto, p.qtd_estoque_produto AS estoque_atual, f.nome_fornecedor, f.telefone_fornecedor
FROM PRODUTO AS p
JOIN FORNECEDOR f ON p.FK_FORNECEDOR_id_fornecedor = f.id_fornecedor
WHERE p.qtd_estoque_produto < 10
ORDER BY p.qtd_estoque_produto ASC;

-- Valor total recebido com as vendas no ano de 2026.
CREATE VIEW valor_total_2026 AS
SELECT SUM(co.valor_compra) AS valor_total
FROM CARRINHO_CONTEM AS co;

-- Maiores valores de venda organizados por produto.
CREATE VIEW preco_venda_mais_caros AS
SELECT p.nome_produto, co.quantidade_produtos_co, co.valor_compra FROM PRODUTO AS p
JOIN CARRINHO_CONTEM AS co ON p.id_produto = co.FK_PRODUTO_id_produto
ORDER BY co.valor_compra DESC;

-- Avaliações relacionaras a transportadora do produto.
CREATE VIEW avaliacoes_transportadora AS
SELECT a.nota_avaliacao, a.desc_avaliacao
FROM AVALIACAO AS a
WHERE a.desc_avaliacao LIKE '%transportadora%';

-- Faturamento, custo e lucro por produto vendido.
CREATE VIEW faturamento_lucro_custo_produtos AS
SELECT p.nome_produto, SUM(co.quantidade_produtos_co) AS total_produtos_vendido,
    SUM(co.quantidade_produtos_co * p.valor_venda_produto) AS faturamento_bruto,
    SUM(co.quantidade_produtos_co * p.valor_compra_produto) AS custo_total,
    SUM(co.quantidade_produtos_co * (p.valor_venda_produto - p.valor_compra_produto)) AS lucro_liquido
FROM PRODUTO AS p
JOIN CARRINHO_CONTEM AS co ON co.FK_PRODUTO_id_produto = p.id_produto
GROUP BY p.id_produto, p.nome_produto
ORDER BY lucro_liquido DESC;

-- Total lucrado pelo serviço de ecommerce.
CREATE VIEW total_lucrado AS
SELECT SUM(co.quantidade_produtos_co * (p.valor_venda_produto - p.valor_compra_produto)) AS lucro_liquido
FROM PRODUTO AS p
JOIN CARRINHO_CONTEM AS co ON p.id_produto = co.fk_produto_id_produto;

-- Pagamentos não realizados
CREATE VIEW pagamentos_nao_realizados AS
SELECT pa.id_pagamento, pa.status_pagamento, c.nome_cliente
FROM PAGAMENTO AS pa
JOIN PEDIDO AS pe ON pe.id_pedido = pa.FK_PEDIDO_id_pedido
JOIN CLIENTE AS c ON c.id_cliente = pe.FK_CLIENTE_id_cliente
WHERE pa.status_pagamento = 'Aguardando pagamento';