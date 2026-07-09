USE WeganosDB;
DROP DATABASE WeganosDB;
CREATE DATABASE WeganosDB;

--NINGUEM PODE USAR
lock tables CLIENTE READ;
lock tables CATEGORIA READ;
lock tables PRODUTO READ;
lock tables PEDIDO READ;
lock tables AVALIACAO READ;
lock tables TRANSPORTADORA READ;
lock tables LOGIN READ;
lock tables CARRINHO_CONTEM READ;
lock tables PAGAMENTO READ;
lock tables FORNECEDOR READ;

--EU POSSO USAR O BANCO/TABELA
lock tables CATEGORIA write;
lock tables PRODUTO write;
lock tables PEDIDO write;
lock tables AVALIACAO write;
lock tables TRANSPORTADORA write;
lock tables LOGIN write;
lock tables CARRINHO_CONTEM write;
lock tables PAGAMENTO write;
lock tables FORNECEDOR write;

--LIBERA TUDO
unlock tables ;
