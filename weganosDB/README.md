# E-COMMERCE WEG

Este projeto consiste em um sistema de gestão desenvolvido em Java, utilizando o padrão DAO (Data Access Object) para comunicação com banco de dados.

O sistema funciona através de um menu interativo no terminal, permitindo realizar operações de CRUD (Create, Read, Update e Delete) em diversas entidades de um sistema de e-commerce, além de disponibilizar relatórios gerenciais.

---
## 🛠 Tecnologias Utilizadas

Java
JDBC
MySQL
Programação Orientada a Objetos (POO)
Padrão DAO

---

## 📂 Estrutura do Projeto

sql/
|
├── logico/
|   └── logico.png
|
├── mer/
|   └── der.png
|
├── scripts/
|   ├── 01_database.sql
|   ├── 02_tables.sql
|   ├── 03_inserts.sql
|   ├── 04_queries.sql
|   └── 05_locks.sql
|
src/
│
├── model/
│   ├── Cliente.java
│   ├── Produto.java
│   ├── Pedido.java
│   ├── ...
│   └── Main.java
│
├── dao/
│   ├── ClienteDAO.java
│   ├── ProdutoDAO.java
│   ├── PedidoDAO.java
│   ├── RelatorioDAO.java
│   └── ...
│
└── conexao/
    └── Conexao.java

---

## 🔐 Login

Ao iniciar o programa, é necessário realizar autenticação.

Exemplo:
Nome: nome_Que_Alguem_Salvou_Na_Table_LOGIN
Senha: senha_Que_Alguem_Salvou_Na_Table_LOGIN

Caso as credenciais estejam incorretas, o sistema é encerrado.

---

# 📌 Funcionalidades

## Menu Principal

1  - Cliente
2  - Transportadora
3  - Fornecedor
4  - Categoria
5  - Produto
6  - Pedido
7  - Compra ao Carrinho
8  - Pagamento
9  - Avaliação
10 - Login
11 - Relatórios
0  - Sair

---

# CRUD das Entidades

As entidades do sistema possuem a mesma estrutura de operações.

Cada módulo permite:

Criar um novo registro
Listar registros
Alterar um registro
Excluir um registro

---

## Exemplo de CRUD
1 - Cadastrar
2 - Listar
3 - Alterar
4 - Excluir
0 - Voltar

---

# 📊 Relatórios

O sistema possui um submenu exclusivo para consultas SQL utilizando Views e consultas agregadas.

Relatórios disponíveis:

1. Transportadoras mais acessíveis
2. Piores avaliações
3. Produtos mais solicitados
4. Produtos menos solicitados
5. Produtos com melhores avaliações
6. Produtos com menor estoque
7. Métodos de pagamento mais utilizados
8. Compras mais caras
9. Categorias mais vendidas
10. Quantidade em estoque de cada produto
11. Cidade que mais utiliza o serviço
12. Produtos mais solicitados no último mês
13. Quantidade de produtos fornecidos por fornecedor
14. Produtos com estoque baixo e seus fornecedores
15. Total recebido com vendas em 2026
16. Produtos com maior valor de venda
17. Avaliações relacionadas às transportadoras
18. Lucro total do e-commerce
19. Faturamento, custo e lucro por produto vendido
20. Pagamentos não realizados

---

# 📈 Relatório Geral

Também é possível gerar um relatório simples contendo:

Quantidade de clientes
Quantidade de transportadoras
Quantidade de fornecedores
Quantidade de categorias
Quantidade de produtos
Quantidade de pedidos
Quantidade de itens do carrinho
Quantidade de pagamentos
Quantidade de avaliações

Além disso, são exibidos alguns dados resumidos de cada entidade.

---

# 🗄 Banco de Dados

O sistema utiliza banco de dados relacional.

Cada entidade possui sua própria tabela, acessada através de uma classe DAO responsável pelas operações:

Inserção
Consulta
Atualização
Exclusão

Os relatórios são executados pela classe:
RelatorioDAO

---

# ▶ Como executar

1. Clone o projeto.
git clone <url-do-repositorio>

2. Configure o banco de dados MySQL.

3. Ajuste as credenciais de conexão.

4. Execute a classe:
Main.java

---

# 📚 Conceitos utilizados

Programação Orientada a Objetos
Encapsulamento
Classes e Objetos
JDBC
DAO (Data Access Object)
CRUD
SQL
Views
Relatórios Gerenciais
Tratamento de Exceções

---

# 👨‍💻 Desenvolvido por

@alannislange-ops
@AndreAugustoSilva
@joasschimidt-escolar
@pedrohschneider
@Marcosdeleprani