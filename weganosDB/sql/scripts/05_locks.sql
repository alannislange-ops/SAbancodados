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
lock table CLIENTE write;
lock tables CATEGORIA write;
lock tables PRODUTO write;
lock tables PEDIDO write;
lock tables AVALIACAO write;
lock tables TRANSPORTADORA write;
lock tables LOGIN write;
lock tables CARRINHO_CONTEM write;
lock tables PAGAMENTO write;
lock tables FORNECEDOR write;

--o jdbc ja tem um auto-commit então não adianta esses comandos por fora: 
ROLLBACK;
COMMIT;

--LIBERA TUDO
unlock tables ;



--TESTANDO NA PRÁTICA--

--desativa o auto-commit
--iniciar toda vez depois de um commit ou rollback
START TRANSACTION;

INSERT INTO `LOGIN` (nome_usuario, senha_login) 
VALUES ('teste2','teste2');

SELECT * FROM `LOGIN`;

-- Se tudo estiver certo:
COMMIT;

-- se arrependeu e quer cancelar:
ROLLBACK;

SELECT * FROM `LOGIN`;