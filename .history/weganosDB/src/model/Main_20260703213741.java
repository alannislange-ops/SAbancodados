package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import dao.*;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean rodando = true;
        int opcao2 = 0;

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Transportadora> listaTransportadoras = new ArrayList<>();
        ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        ArrayList<CarrinhoContem> listaCarrinhos = new ArrayList<>();
        ArrayList<Pagamento> listaPagamentos = new ArrayList<>();
        ArrayList<Avaliacao> listaAvaliacoes = new ArrayList<>();
        ArrayList<Login> listaLogin = new ArrayList<>();

        listaClientes = ClienteDAO.listarTodos();
        listaTransportadoras = TransportadoraDAO.listarTodos();
        //listaAvaliacoes = AvaliacaoDAO.listarTodos();
        // listaFornecedores = FornecedorDAO.listarTodos();
        listaCategorias = CategoriaDAO.listarTodos();
        // listaProdutos = ProdutoDAO.listarTodos();
        // listaPedidos = PedidoDAO.listarTodos();
        // listaCarrinhos = CarrinhoContemDAO.listarTodos();
        // listaPagamentos = Pagamento.listarTodos();
        listaLogin = LoginDAO.listarTodos();


        while (rodando) {
            System.out.println("\n=============================================");
            System.out.println("          SISTEMA DE GESTAO - WEG            ");
            System.out.println("=============================================");
            System.out.println("1 -> Cliente");
            System.out.println("2 -> Transportadora");
            System.out.println("3 -> Fornecedor");
            System.out.println("4 -> Categoria");
            System.out.println("5 -> Produto");
            System.out.println("6 -> Pedido");
            System.out.println("7 -> Compra ao carrinho");
            System.out.println("8 -> Pagamento");
            System.out.println("9 -> Avaliação");
            System.out.println("10 -> Login");
            System.out.println("11 -> Relatorio Geral (Listar tudo da memoria)");
            System.out.println("0 -> Sair do Sistema");
            System.out.print("Escolha uma opcao: ");

            int opcao = lerNumeroInteiro(teclado);

            switch (opcao) {

                case 1:
                    System.out.println("\n=============================================");
                    System.out.println("                   CLIENTES                  ");
                    System.out.println("=============================================");
                    System.out.println("1 -> Create clientes");
                    System.out.println("2 -> Read clientes");
                    System.out.println("3 -> Update cliente");
                    System.out.println("4 -> Delete cliente");
                    System.out.println("0 -> Voltar");

                    opcao2 = lerNumeroInteiro(teclado);

                    switch (opcao2) {
                        case 1:
                            System.out.println("\n--- [ NOVO CLIENTE ] ---");

                            Cliente cliente = new Cliente(0, null, null, null, null, null, null, null, null);

                            System.out.print("Nome: ");
                            cliente.setNome(teclado.nextLine());
                            System.out.print("CPF (11 digitos): ");
                            cliente.setCpf(teclado.nextLine());
                            System.out.print("Email: ");
                            cliente.setEmail(teclado.nextLine());
                            System.out.print("Telefone: ");
                            cliente.setTelefone(teclado.nextLine());
                            System.out.print("CEP: ");
                            cliente.setCep(teclado.nextLine());
                            System.out.print("Cidade: ");
                            cliente.setCidade(teclado.nextLine());
                            System.out.print("Rua: ");
                            cliente.setRua(teclado.nextLine());
                            System.out.print("Numero da Casa: ");
                            cliente.setNcasa(teclado.nextLine());
                            ClienteDAO clienteDAO = new ClienteDAO();

                            clienteDAO.salvar(cliente);

                            System.out.println("Sucesso: Cliente cadastrado no banco de dados.");
                            break;
                        case 2:
                            System.out.println("\n--- [ LISTA DE CLIENTES ] ---");

                            listaClientes = ClienteDAO.listarTodos();
                            for (Cliente c : listaClientes) {
                                c.mostrarCliente();
                            }

                            break;
                        case 3:
                            System.out.println("\n--- [ ALTERAR CLIENTE ] ---");

                            Cliente clienteParaAlterar = new Cliente();

                            System.out.print("Digite o ID do cliente que deseja alterar: ");
                            clienteParaAlterar.setId(teclado.nextInt());
                            teclado.nextLine();
                            System.out.print("Novo Nome: ");
                            clienteParaAlterar.setNome(teclado.nextLine());
                            System.out.print("Novo CPF: ");
                            clienteParaAlterar.setCpf(teclado.nextLine());
                            System.out.print("Novo Email: ");
                            clienteParaAlterar.setEmail(teclado.nextLine());
                            System.out.print("Novo Telefone: ");
                            clienteParaAlterar.setTelefone(teclado.nextLine());
                            System.out.print("Novo CEP: ");
                            clienteParaAlterar.setCep(teclado.nextLine());
                            System.out.print("Nova Cidade: ");
                            clienteParaAlterar.setCidade(teclado.nextLine());
                            System.out.print("Nova Rua: ");
                            clienteParaAlterar.setRua(teclado.nextLine());
                            System.out.print("Novo Numero da Casa: ");
                            clienteParaAlterar.setNcasa(teclado.nextLine());

                            ClienteDAO daoAlterar = new ClienteDAO();

                            daoAlterar.alterar(clienteParaAlterar);
                            listaClientes = ClienteDAO.listarTodos();

                            break;
                        case 4:
                            System.out.println("\n--- [ DELETAR CLIENTE ] ---");

                            Cliente clienteParaDeletar = new Cliente();

                            System.out.print("Digite o ID do cliente que deseja EXCLUIR: ");
                            clienteParaDeletar.setId(teclado.nextInt());
                            teclado.nextLine();

                            ClienteDAO daoDeletar = new ClienteDAO();
                            daoDeletar.deletar(clienteParaDeletar);

                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Aviso: Opcao incorreta. Escolha um numero listado.");
                            break;
                    }
                    break;
                case 2:

                    System.out.println("\n=============================================");
                    System.out.println("                TRANSPORTADORA               ");
                    System.out.println("=============================================");
                    System.out.println("1 -> Create transportadora");
                    System.out.println("2 -> Read transportadora");
                    System.out.println("3 -> Update transportadora");
                    System.out.println("4 -> Delete transportadora");
                    System.out.println("0 -> Voltar");

                    opcao2 = lerNumeroInteiro(teclado);

                    switch (opcao2) {
                        case 1:
                            System.out.println("\n--- [ NOVA TRANSPORTADORA ] ---");

                            Transportadora transportadora = new Transportadora(0, null, null, null, null, null);

                            System.out.print("Nome da Empresa: ");
                            transportadora.setNomeTransportadora(teclado.nextLine());
                            System.out.print("Hora de Abertura (ex: 08): ");
                            int horaAb = lerNumeroInteiro(teclado);
                            transportadora.setHorarioAberturaTranspo(LocalTime.of(horaAb, 0));
                            System.out.print("Hora de Fechamento (ex: 18): ");
                            int horaFe = lerNumeroInteiro(teclado);
                            transportadora.setHorarioFechamentoTran(LocalTime.of(horaFe, 0));
                            System.out.print("CNPJ: ");
                            transportadora.setCnpjTransportadora(teclado.nextLine());
                            System.out.print("Valor de Contratacao Mensal: R$ ");
                            transportadora.setContratacaoMensalTran(lerPreco(teclado));

                            TransportadoraDAO transportadoraDAO = new TransportadoraDAO();

                            transportadoraDAO.salvar(transportadora);

                            System.out.println("Sucesso: Transportadora adicionada a lista.");
                            break;
                        case 2:
                            System.out.println("\n--- [ LISTA DE TRANSPORTADORAS ] ---");

                            listaTransportadoras = TransportadoraDAO.listarTodos();

                            for (Transportadora t : listaTransportadoras) {
                                t.mostrarTransportadora();
                            }

                            break;
                        case 3:
                            System.out.println("\n--- [ ALTERAR TRANSPORTADORA ] ---");

                            Transportadora transpoAlterar = new Transportadora();

                            System.out.print("Digite o ID da Transportadora que deseja alterar: ");
                            transpoAlterar.setIdTransportadora(lerNumeroInteiro(teclado));
                            System.out.print("Novo Nome da Empresa: ");
                            transpoAlterar.setNomeTransportadora(teclado.nextLine());
                            System.out.print("Nova Hora de Abertura (ex: 08): ");
                            int novaHoraAb = lerNumeroInteiro(teclado);
                            transpoAlterar.setHorarioAberturaTranspo(LocalTime.of(novaHoraAb, 0));
                            System.out.print("Nova Hora de Fechamento (ex: 18): ");
                            int novaHoraFe = lerNumeroInteiro(teclado);
                            transpoAlterar.setHorarioFechamentoTran(LocalTime.of(novaHoraFe, 0));
                            System.out.print("Novo CNPJ: ");
                            transpoAlterar.setCnpjTransportadora(teclado.nextLine());
                            System.out.print("Novo Valor de Contratação Mensal: R$ ");
                            transpoAlterar.setContratacaoMensalTran(lerPreco(teclado));

                            TransportadoraDAO dao = new TransportadoraDAO();

                            dao.alterar(transpoAlterar);

                            break;
                        case 4:
                            System.out.println("\n--- [ DELETAR TRANSPORTADORA ] ---");

                            Transportadora transpoDeletar = new Transportadora();

                            System.out.print("Digite o ID da Transportadora que deseja EXCLUIR: ");
                            transpoDeletar.setIdTransportadora(lerNumeroInteiro(teclado));

                            TransportadoraDAO tDeletar = new TransportadoraDAO();
                            tDeletar.deletar(transpoDeletar);

                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Aviso: Opcao incorreta. Escolha um numero listado.");
                            break;
                    }
                    break;
                case 3:

                    System.out.println("\n=============================================");
                    System.out.println("                  FORNECEDOR                 ");
                    System.out.println("=============================================");
                    System.out.println("1 -> Create fornecedor");
                    System.out.println("2 -> Read fornecedor");
                    System.out.println("3 -> Update fornecedor");
                    System.out.println("4 -> Delete fornecedor");
                    System.out.println("0 -> Voltar");

                    opcao2 = lerNumeroInteiro(teclado);

                    switch (opcao2) {
                        case 1:
                            System.out.println("\n--- [ NOVO FORNECEDOR ] ---");

                            Fornecedor fornecedor = new Fornecedor();
        
                            System.out.print("Nome da Empresa: ");
                            fornecedor.setNomeFornecedor(teclado.nextLine());
                            System.out.print("CNPJ: ");
                            fornecedor.setCnpjFornecedor(teclado.nextLine());
                            System.out.print("Telefone: ");
                            fornecedor.setTelefoneFornecedor(teclado.nextLine());

                            FornecedorDAO Cforrnecedor = new FornecedorDAO();
                            Cforrnecedor.salvar(fornecedor);
                            listaFornecedores.add(fornecedor);

                            System.out.println("Sucesso: Fornecedor adicionado a lista.");
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 4:

                    System.out.println("\n=============================================");
                    System.out.println("                  CATEGORIA                  ");
                    System.out.println("=============================================");
                    System.out.println("1 -> Create categoria");
                    System.out.println("2 -> Read categoria");
                    System.out.println("3 -> Update categoria");
                    System.out.println("4 -> Delete categoria");
                    System.out.println("0 -> Voltar");

                    opcao2 = lerNumeroInteiro(teclado);

                     switch (opcao2) {
                        case 1:
                            System.out.println("\n--- [ NOVA CATEGORIA ] ---");

                            Categoria categoria = new Categoria();
                            System.out.print("Nome da Categoria: ");
                            categoria.setNomeCategoria(teclado.nextLine());
                            System.out.print("Descricao: ");
                            categoria.setDescCategoria(teclado.nextLine());
                            CategoriaDAO categoriaDAO = new CategoriaDAO();

                            categoriaDAO.salvar(categoria);

                            System.out.println("Sucesso: Categoria adicionada a lista.");
                            break;
                        case 2:
                            System.out.println("\n--- [ LISTA DE CATEGORIAS ] ---");

                            listaCategorias = CategoriaDAO.listarTodos();
                            for (Categoria c : listaCategorias) {
                                c.mostrarCategoria();
                            }
                        
                            break;
                        case 3:
                            System.out.println("\n--- [ ALTERAR CATEGORIA ] ---");

                            Categoria categoriaParaAlterar = new Categoria();

                            System.out.print("Digite o ID da categoria que deseja alterar: ");
                            categoriaParaAlterar.setIdCategoria(teclado.nextInt());
                            teclado.nextLine();
                            System.out.print("Novo Nome: ");
                            categoriaParaAlterar.setNomeCategoria(teclado.nextLine());
                            System.out.print("Nova Descrição: ");
                            categoriaParaAlterar.setDescCategoria(teclado.nextLine());

                            CategoriaDAO daoAlterar = new CategoriaDAO();

                            daoAlterar.alterar(categoriaParaAlterar);
                            listaCategorias = CategoriaDAO.listarTodos();

                            break;
                        case 4:
                            System.out.println("\n--- [ DELETAR CATEGORIA ] ---");

                            Categoria categoriaDeletar = new Categoria();

                            System.out.print("Digite o ID da Categoria que deseja EXCLUIR: ");
                            categoriaDeletar.setIdCategoria(lerNumeroInteiro(teclado));

                            CategoriaDAO cDeletar = new CategoriaDAO();
                            cDeletar.deletar(categoriaDeletar);

                            break;
                        case 0:
                            break;
                    }
                    break;

                case 5:

                    System.out.println("\n=============================================");
                    System.out.println("                   PRODUTO                   ");
                    System.out.println("=============================================");
                    System.out.println("1 -> Create produto");
                    System.out.println("2 -> Read produto");
                    System.out.println("3 -> Update produto");
                    System.out.println("4 -> Delete produto");
                    System.out.println("0 -> Voltar");

                    opcao2 = lerNumeroInteiro(teclado);

                    switch (opcao2) {
                        case 1:
                            System.out.println("\n--- [ NOVO PRODUTO ] ---");

                            Produto produto = new Produto();

                            System.out.print("Nome do Produto: ");
                            produto.nomeProduto = teclado.nextLine();
                            System.out.print("Preco Base: R$ ");
                            produto.precoProduto = lerPreco(teclado);
                            System.out.print("Quantidade em Estoque: ");
                            produto.qtdEstoqueProduto = lerNumeroInteiro(teclado);
                            System.out.print("Descricao: ");
                            produto.descProduto = teclado.nextLine();
                            System.out.print("Valor de Compra: R$ ");
                            produto.valorCompraProduto = lerPreco(teclado);
                            System.out.print("Valor de Venda: R$ ");
                            produto.valorVendaProduto = lerPreco(teclado);

                            System.out.print("ID do Fornecedor vinculado: ");
                            produto.fkFornecedorIdFornecedor = lerNumeroInteiro(teclado);
                            System.out.print("ID da Categoria vinculada: ");
                            produto.fkCategoriaIdCategoria = lerNumeroInteiro(teclado);

                            listaProdutos.add(produto);
                            System.out.println("Sucesso: Produto adicionado a lista.");
                            break;
                        case 2:
                            System.out.println("\n--- [ LISTA DE PRODUTOS ] ---");

                            //listaProdutos = ProdutoDAO.listarTodos();
                            for (Produto p : listaProdutos) {
                                //p.mostrarCategoria();
                            }
                        
                            break;
                        case 3:
                            System.out.println("\n--- [ ALTERAR PRODUTO ] ---");

                            Produto produtoAlterar = new Produto();

                            System.out.print("Digite o ID do produto que deseja alterar: ");
                            produtoAlterar.setIdProduto(teclado.nextInt());
                            teclado.nextLine();
                            System.out.print("Novo Nome: ");
                            produtoAlterar.setNomeProduto(teclado.nextLine());
                            System.out.print("Novo Preço: ");
                            produtoAlterar.setPrecoProduto(teclado.nextBigDecimal());

                            CategoriaDAO daoAlterar = new CategoriaDAO();

                            //daoAlterar.alterar(produtoAlterar);
                            produtoAlterar.add
                            listaCategorias = CategoriaDAO.listarTodos();

                            break;
                        case 4:
                            System.out.println("\n--- [ DELETAR CATEGORIA ] ---");

                            Categoria categoriaDeletar = new Categoria();

                            System.out.print("Digite o ID da Categoria que deseja EXCLUIR: ");
                            categoriaDeletar.setIdCategoria(lerNumeroInteiro(teclado));

                            CategoriaDAO cDeletar = new CategoriaDAO();
                            cDeletar.deletar(categoriaDeletar);

                            break;
                        case 0:
                            break;
                    }
                    break;
                case 6:

                    System.out.println("\n=============================================");
                    System.out.println("                    PEDIDO                   ");
                    System.out.println("=============================================");
                    System.out.println("1 -> Create pedido");
                    System.out.println("2 -> Read pedido");
                    System.out.println("3 -> Update pedido");
                    System.out.println("4 -> Delete pedido");
                    System.out.println("0 -> Voltar");

                    opcao2 = lerNumeroInteiro(teclado);

                    switch (opcao2) {
                        case 1:
                            System.out.println("\n--- [ NOVO PEDIDO ] ---");
                            Pedido pedido = new Pedido();
                            System.out.print("ID do Pedido: ");
                            pedido.idPedido = lerNumeroInteiro(teclado);
                            pedido.dataPedido = LocalDate.now();
                            System.out.print("ID do Cliente associado: ");
                            pedido.fkClienteIdCliente = lerNumeroInteiro(teclado);
                            System.out.print("ID da Transportadora associada: ");
                            pedido.fkTransportadoraIdTransportadora = lerNumeroInteiro(teclado);

                            listaPedidos.add(pedido);
                            System.out.println("Sucesso: Pedido adicionado a lista.");
                            break;
                        case 2:

                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 0:
                            break;
                    }
                    break;

                case 7:

                    System.out.println("\n=============================================");
                    System.out.println("                    COMPRA                   ");
                    System.out.println("=============================================");
                    System.out.println("1 -> Create compra");
                    System.out.println("2 -> Read compra");
                    System.out.println("3 -> Update compra");
                    System.out.println("4 -> Delete compra");
                    System.out.println("0 -> Voltar");

                    opcao2 = lerNumeroInteiro(teclado);

                    switch (opcao2) {
                        case 1:
                            System.out.println("\n--- [ NOVA COMPRA AO CARRINHO ] ---");

                            CarrinhoContem carrinho = new CarrinhoContem();
                            System.out.print("ID do Pedido: ");
                            carrinho.fkPedidoIdPedido = lerNumeroInteiro(teclado);
                            System.out.print("ID do Produto: ");
                            carrinho.fkProdutoIdProduto = lerNumeroInteiro(teclado);
                            System.out.print("Quantidade de itens: ");
                            carrinho.quantidadeProdutosCo = lerNumeroInteiro(teclado);
                            System.out.print("Valor unitario do item: R$ ");
                            carrinho.valorCompra = lerPreco(teclado);

                            listaCarrinhos.add(carrinho);
                            System.out.println("Sucesso: Item associado ao carrinho.");
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 0:
                            break;
                    }
                    break;

                case 8:

                    System.out.println("\n=============================================");
                    System.out.println("                  PAGAMENTO                  ");
                    System.out.println("=============================================");
                    System.out.println("1 -> Create pagamento");
                    System.out.println("2 -> Read pagamento");
                    System.out.println("3 -> Update pagamento");
                    System.out.println("4 -> Delete pagamento");
                    System.out.println("0 -> Voltar");

                    opcao2 = lerNumeroInteiro(teclado);

                    switch (opcao2) {
                        case 1:
                            System.out.println("\n--- [ REGISTRAR PAGAMENTO ] ---");

                            Pagamento pagamento = new Pagamento();

                            System.out.print("Forma de Pagamento: ");
                            pagamento.setFormaPagamento(teclado.nextLine());
                            System.out.print("Status do Pagamento: ");
                            pagamento.setStatusPagamento(teclado.nextLine());
                            System.out.print("Valor Pago: R$ ");
                            pagamento.setValorPagamento(lerPreco(teclado));
                            System.out.print("ID do Pedido: ");
                            pagamento.setFkPedidoIdPedido(lerNumeroInteiro(teclado));

                            PagamentosDAO Cpagamento = new PagamentosDAO();
                            Cpagamento.salvar(pagamento);
                            listaPagamentos.add(pagamento);

                            System.out.println("Sucesso: Pagamento adicionado a lista.");
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 9:

                    System.out.println("\n=============================================");
                    System.out.println("                  AVALIAÇÃO                  ");
                    System.out.println("=============================================");
                    System.out.println("1 -> Create avaliação");
                    System.out.println("2 -> Read avaliação");
                    System.out.println("3 -> Update avaliação");
                    System.out.println("4 -> Delete avaliação");
                    System.out.println("0 -> Voltar");

                    opcao2 = lerNumeroInteiro(teclado);

                    switch (opcao2) {
                        case 1:
                            System.out.println("\n--- [ NOVA AVALIACAO ] ---");

                            Avaliacao avaliacao = new Avaliacao();
                            
                            System.out.print("Nota da Avaliacao (1 a 5): ");
                            avaliacao.setNotaAvaliacao(lerNumeroInteiro(teclado));
                            System.out.print("Texto da Avaliacao: ");
                            avaliacao.setDescAvaliacao(teclado.nextLine());
                            System.out.print("ID do Produto: ");
                            avaliacao.setFkProdutoIdProduto(lerNumeroInteiro(teclado));

                            AvaliacaoDAO Cavalia = new AvaliacaoDAO();
                            Cavalia.salvar(avaliacao);
                            listaAvaliacoes.add(avaliacao);
                            System.out.println("Sucesso: Avaliacao adicionada a lista.");
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 0:
                            break;
                    }
                    break;

                case 10:

                    System.out.println("\n=============================================");
                    System.out.println("                  LOGIN                  ");
                    System.out.println("=============================================");
                    System.out.println("1 -> Create login");
                    System.out.println("2 -> Read login");
                    System.out.println("3 -> Update login");
                    System.out.println("4 -> Delete login");
                    System.out.println("0 -> Voltar");

                    opcao2 = lerNumeroInteiro(teclado);

                    switch (opcao2) {
                        case 1:
                            System.out.println("\n--- [ NOVO LOGIN ] ---");

                            Login login = new Login(0,null,null);

                            System.out.println("Digite o nome da conta: ");
                            login.setNome_login(teclado.next());
                            System.out.println("Digite a senha: ");
                            login.setSenha_login(teclado.next());

                            LoginDAO loginDAO = new LoginDAO();

                            loginDAO.salvar(login);
                            listaLogin.add(login);
                            System.out.println("Sucesso: Login adicionado a lista.");
                            break;
                        case 2:
                            System.out.println("\n--- [ LISTA DE LOGIN ] ---");

                            listaLogin = LoginDAO.listarTodos();
                            for (Login l : listaLogin) {
                                l.mostrarLogin();
                            }
                            break;
                        case 3:
                            System.out.println("\n--- [ ALTERAR LOGIN ] ---");

                            Login Alogin = new Login();

                            System.out.print("Digite o ID do login que deseja alterar: ");
                            Alogin.setId_login(teclado.nextInt());
                            teclado.nextLine();
                            System.out.print("Novo Nome: ");
                            Alogin.setNome_login(teclado.nextLine());
                            System.out.print("Nova senha: ");
                            Alogin.setSenha_login(teclado.nextLine());
                            
                            LoginDAO daoLogin = new LoginDAO();

                            daoLogin.alterar(Alogin);
                            listaClientes = ClienteDAO.listarTodos();

                            break;
                        case 4:
                            System.out.println("\n--- [ DELETAR LOGIN ] ---");

                            Login Dlogin = new Login();

                            System.out.print("Digite o ID do login que deseja EXCLUIR: ");
                            Dlogin.setId_login(teclado.nextInt());
                            teclado.nextLine();

                            LoginDAO daoLoginD = new LoginDAO();
                            daoLoginD.deletar(Dlogin);

                            break;
                        case 0:
                            break;
                    }
                    break;
                case 11:

                    System.out.println("\n--- [ LISTAGEM DE DADOS ARMAZENADOS ] ---");
                    System.out.println("Total de Clientes: " + listaClientes.size());
                    for (Cliente c : listaClientes) {
                        c.mostrarCliente();
                    }
                    System.out.println("Total de Transportadoras: " + listaTransportadoras.size());
                    for (Transportadora t : listaTransportadoras) {
                        t.mostrarTransportadora();
                    }
                    System.out.println("Total de Fornecedores: " + listaFornecedores.size());
                    System.out.println("Total de Categorias: " + listaCategorias.size());
                    System.out.println("Total de Produtos: " + listaProdutos.size());
                    for (Produto p : listaProdutos) {
                        //p.mostrarProduto();
                    }
                    System.out.println("Total de Pedidos: " + listaPedidos.size());
                    System.out.println("Total de Itens de Carrinho: " + listaCarrinhos.size());
                    System.out.println("Total de Pagamentos: " + listaPagamentos.size());
                    System.out.println("Total de Avaliacoes: " + listaAvaliacoes.size());

                    break;
                case 0:
                    System.out.println("\nFinalizando o programa.");
                    rodando = false;
                    break;
                default:
                    System.out.println("Aviso: Opcao incorreta. Escolha um numero listado.");
                    break;
            }
        }
    }

    private static int lerNumeroInteiro(Scanner sc) {

        while (!sc.hasNextInt()) {
            System.out.print("Aviso: Digite um numero inteiro valido: ");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    private static BigDecimal lerPreco(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Aviso: Entrada incorreta. Use decimais: R$ ");
            sc.next();
        }
        double valor = sc.nextDouble();
        sc.nextLine();
        return BigDecimal.valueOf(valor);
    }
}