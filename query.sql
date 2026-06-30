-- Active: 1782240037245@@sa-banco-postgre-estudante-a8e2.l.aivencloud.com@24499@weganospostgredb
-- TransportadorAS mais acessíveis, com os preços mais baixos.
SELECT t.nome_transportadora, t.contratacao_mensal_tran
FROM transportadora AS t
ORDER BY t.contratacao_mensal_tran;

-- Avaliações organizadAS de acordo com AS piores notAS, a fim de analisar AS piores reclamações dos clientes e tomar uma atitude com relação a elAS.
SELECT a.nota_avaliacao, a.desc_avaliacao
FROM avaliacao AS a
ORDER BY a.nota_avaliacao;

-- Produto mais solicitado, para descobrir a maior demanda.
SELECT SUM(c.quantidade_produtos_co) AS quantidade_produtos, p.nome_produto
FROM carrinho_contem AS c
JOIN produto AS p ON c.fk_produto_id_produto = p.id_produto
GROUP BY nome_produto
ORDER BY quantidade_produtos DESC;

-- Produto menos solicitado, para descobrir a menor demanda.
SELECT SUM(c.quantidade_produtos_co) AS quantidade_produtos, p.nome_produto
FROM carrinho_contem AS c
JOIN produto AS p ON c.fk_produto_id_produto = p.id_produto
GROUP BY nome_produto
ORDER BY quantidade_produtos ASC;

-- Ver os produtos mais bem avaliados.
SELECT DISTINCT p.nome_produto 
FROM produto AS p
JOIN avaliacao AS a on p.id_produto = a.fk_produto_id_produto
WHERE a.nota_avaliacao > 3;

-- Ver os produtos com a menor quantidade no estoque, indicando uma reposição necessária.
SELECT p.nome_produto, p.qtd_estoque_produto
FROM produto AS p
ORDER BY p.qtd_estoque_produto;

-- Métodos de pagamento mais utilizados pelos clientes.
SELECT p.forma_pagamento, COUNT(p.id_pagamento) AS quantidade_pagamentos
FROM pagamento AS p
GROUP BY p.forma_pagamento
ORDER BY quantidade_pagamentos DESC;

-- ComprAS mais carAS realizadAS pelos clientes.
SELECT c.nome_cliente, pa.valor_pagamento
FROM cliente AS c
JOIN pedido AS p ON c.id_cliente = p.fk_cliente_id_cliente
JOIN pagamento AS pa ON p.id_pedido = pa.fk_pedido_id_pedido
ORDER BY pa.valor_pagamento DESC;

-- CategoriAS de produto mais vendidAS.
SELECT c.nome_categoria,   SUM(co.quantidade_produtos_co) AS quantidade_vendida
FROM categoria AS c
JOIN produto AS p ON p.FK_CATEGORIA_id_categoria = c.id_categoria
JOIN carrinho_contem AS co ON co.fk_produto_id_produto = p.id_produto
GROUP BY c.nome_categoria
ORDER BY quantidade_vendida DESC;

-- Quantidade de cada produto no estoque.
SELECT p.nome_produto, p.qtd_estoque_produto
FROM produto AS p
ORDER BY p.qtd_estoque_produto DESC;


-- Cidade que mais utiliza o serviço de e-commerce.
SELECT COUNT(c.cidade_cliente) AS quantidade_pedidos, c.cidade_cliente
FROM cliente AS c
JOIN pedido AS p ON c.id_cliente = p.fk_cliente_id_cliente
GROUP BY c.cidade_cliente
ORDER BY quantidade_pedidos DESC;

-- Produto mais solicitado no último mês do mini-mundo, para avaliar a demanda atual.
SELECT SUM(c.quantidade_produtos_co) AS quantidade_produtos, pr.nome_produto
FROM carrinho_contem AS c
JOIN produto AS pr ON c.fk_produto_id_produto = pr.id_produto
JOIN pedido AS pe ON c.fk_pedido_id_pedido = pe.id_pedido
WHERE pe.data_pedido >= '2026-08-01'
GROUP BY nome_produto
ORDER BY quantidade_produtos DESC;

-- Quantidade de produtos fornecidos por fornecedor, organizados da maior quantidade para a menor.
SELECT f.nome_fornecedor, COUNT(p.id_produto)
FROM fornecedor AS f
JOIN produto AS p ON f.id_fornecedor = p.fk_fornecedor_id_fornecedor
GROUP BY f.id_fornecedor
ORDER BY count(p.id_produto) DESC;

-- Produtos e seus respectivos fornecedores onde sua quantidade de estoque é menor que 10, indicando reposição necessária.
SELECT p.nome_produto, p.qtd_estoque_produto AS estoque_atual, f.nome_fornecedor, f.telefone_fornecedor
FROM produto AS p
JOIN fornecedor f ON p.FK_fornecedor_id_fornecedor = f.id_fornecedor
WHERE p.qtd_estoque_produto < 10
ORDER BY p.qtd_estoque_produto ASC;

-- Valor total recebido com AS vendAS no ano de 2026.
SELECT SUM(co.valor_compra) AS valor_total
FROM carrinho_contem AS co;

-- Maiores valores de venda organizados por produto.
SELECT p.nome_produto, co.quantidade_produtos_co, co.valor_compra FROM produto AS p
JOIN carrinho_contem AS co ON p.id_produto = co.fk_produto_id_produto
ORDER BY co.valor_compra DESC;

-- Avaliações relacionarAS a transportadora do produto.
SELECT a.nota_avaliacao, a.desc_avaliacao
FROM avaliacao AS a
WHERE a.desc_avaliacao LIKE '%transportadora%';

-- Faturamento, custo e lucro por produto vendido.
SELECT p.nome_produto, SUM(co.quantidade_produtos_co) AS total_produtos_vendido,
    SUM(co.quantidade_produtos_co * p.valor_venda_produto) AS faturamento_bruto,
    SUM(co.quantidade_produtos_co * p.valor_compra_produto) AS custo_total,
    SUM(co.quantidade_produtos_co * (p.valor_venda_produto - p.valor_compra_produto)) AS lucro_liquido
FROM produto AS p
JOIN carrinho_contem AS co ON co.fk_produto_id_produto = p.id_produto
GROUP BY p.id_produto, p.nome_produto
ORDER BY lucro_liquido DESC;

-- Total lucrado pelo serviço de ecommerce.
SELECT SUM(co.quantidade_produtos_co * (p.valor_venda_produto - p.valor_compra_produto)) AS lucro_liquido
FROM produto AS p
JOIN carrinho_contem AS co ON p.id_produto = co.fk_produto_id_produto;

-- Pagamentos não realizados
SELECT pa.id_pagamento, pa.status_pagamento, c.nome_cliente
FROM pagamento AS pa
JOIN pedido AS pe ON pe.id_pedido = pa.fk_PEDIDO_id_pedido
JOIN cliente AS c ON c.id_cliente = pe.fk_cliente_id_cliente
WHERE pa.status_pagamento = 'Aguardando Pagamento';