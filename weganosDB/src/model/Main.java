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

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Transportadora> listaTransportadoras = new ArrayList<>();
        ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        ArrayList<CarrinhoContem> listaCarrinhos = new ArrayList<>();
        ArrayList<Pagamento> listaPagamentos = new ArrayList<>();
        ArrayList<Avaliacao> listaAvaliacoes = new ArrayList<>();

        listaClientes = ClienteDAO.listarTodos();

        while (rodando) {
            System.out.println("\n=============================================");
            System.out.println("          SISTEMA DE GESTAO - WEG            ");
            System.out.println("=============================================");
            System.out.println("1 -> Cadastrar Cliente");
            System.out.println("11 -> Mostrar clientes");
            System.out.println("2 -> Cadastrar Transportadora");
            System.out.println("3 -> Cadastrar Fornecedor");
            System.out.println("4 -> Cadastrar Categoria");
            System.out.println("5 -> Cadastrar Produto");
            System.out.println("6 -> Criar Pedido");
            System.out.println("7 -> Adicionar Produto ao Carrinho (Item Pedido)");
            System.out.println("8 -> Registrar Pagamento");
            System.out.println("9 -> Registrar Avaliacao de Produto");
            System.out.println("10 -> Relatorio Geral (Listar tudo da memoria)");
            System.out.println("0 -> Sair do Sistema");
            System.out.print("Escolha uma opcao: ");

            int opcao = lerNumeroInteiro(teclado);

            switch (opcao) {
                case 1:
                    System.out.println("\n--- [ NOVO CLIENTE ] ---");
                    
                    Cliente cliente = new Cliente(0,null,null,null,null,null,null,null,null);

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

                case 11:
                    for(Cliente c : listaClientes){
                        System.out.println("");
                        c.mostrarCliente();
                    }
                    
                    break;
                case 2:
                    System.out.println("\n--- [ NOVA TRANSPORTADORA ] ---");
                    Transportadora transportadora = new Transportadora();
                    System.out.print("ID da Transportadora: ");
                    transportadora.idTransportadora = lerNumeroInteiro(teclado);
                    System.out.print("Nome da Empresa: ");
                    transportadora.nomeTransportadora = teclado.nextLine();
                    System.out.print("Hora de Abertura (ex: 08): ");
                    int horaAb = lerNumeroInteiro(teclado);
                    transportadora.horarioAberturaTranspo = LocalTime.of(horaAb, 0);
                    System.out.print("Hora de Fechamento (ex: 18): ");
                    int horaFe = lerNumeroInteiro(teclado);
                    transportadora.horarioFechamentoTran = LocalTime.of(horaFe, 0);
                    System.out.print("CNPJ: ");
                    transportadora.cnpjTransportadora = teclado.nextLine();
                    System.out.print("Valor de Contratacao Mensal: R$ ");
                    transportadora.contratacaoMensalTran = lerPreco(teclado);

                    listaTransportadoras.add(transportadora);
                    System.out.println("Sucesso: Transportadora adicionada a lista.");
                    break;

                case 3:
                    System.out.println("\n--- [ NOVO FORNECEDOR ] ---");
                    Fornecedor fornecedor = new Fornecedor();
                    System.out.print("ID do Fornecedor: ");
                    fornecedor.idFornecedor = lerNumeroInteiro(teclado);
                    System.out.print("Nome da Empresa: ");
                    fornecedor.nomeFornecedor = teclado.nextLine();
                    System.out.print("CNPJ: ");
                    fornecedor.cnpjFornecedor = teclado.nextLine();
                    System.out.print("Telefone: ");
                    fornecedor.telefoneFornecedor = teclado.nextLine();

                    listaFornecedores.add(fornecedor);

                    System.out.println("Sucesso: Fornecedor adicionado a lista.");
                    break;

                case 4:
                    System.out.println("\n--- [ NOVA CATEGORIA ] ---");
                    Categoria categoria = new Categoria();
                    System.out.print("ID da Categoria: ");
                    categoria.idCategoria = lerNumeroInteiro(teclado);
                    System.out.print("Nome da Categoria: ");
                    categoria.nomeCategoria = teclado.nextLine();
                    System.out.print("Descricao: ");
                    categoria.descCategoria = teclado.nextLine();

                    listaCategorias.add(categoria);
                    System.out.println("Sucesso: Categoria adicionada a lista.");
                    break;

                case 5:
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

                case 6:
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

                case 7:
                    System.out.println("\n--- [ ADICIONAR AO CARRINHO ] ---");
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

                case 8:
                    System.out.println("\n--- [ REGISTRAR PAGAMENTO ] ---");
                    Pagamento pagamento = new Pagamento();
                    System.out.print("ID do Pagamento: ");
                    pagamento.idPagamento = lerNumeroInteiro(teclado);
                    System.out.print("Forma de Pagamento: ");
                    pagamento.formaPagamento = teclado.nextLine();
                    System.out.print("Status do Pagamento: ");
                    pagamento.statusPagamento = teclado.nextLine();
                    System.out.print("Valor Pago: R$ ");
                    pagamento.valorPagamento = lerPreco(teclado);
                    System.out.print("ID do Pedido: ");
                    pagamento.fkPedidoIdPedido = lerNumeroInteiro(teclado);
                    listaPagamentos.add(pagamento);
                    System.out.println("Sucesso: Pagamento adicionado a lista.");
                    break;
                case 9:
                    System.out.println("\n--- [ NOVA AVALIACAO ] ---");
                    Avaliacao avaliacao = new Avaliacao();
                    System.out.print("ID da Avaliacao: ");
                    avaliacao.idAvaliacao = lerNumeroInteiro(teclado);
                    System.out.print("Nota da Avaliacao (1 a 5): ");
                    avaliacao.notaAvaliacao = lerNumeroInteiro(teclado);
                    System.out.print("Texto da Avaliacao: ");
                    avaliacao.descAvaliacao = teclado.nextLine();
                    System.out.print("ID do Produto: ");
                    avaliacao.fkProdutoIdProduto = lerNumeroInteiro(teclado);
                    listaAvaliacoes.add(avaliacao);
                    System.out.println("Sucesso: Avaliacao adicionada a lista.");
                    break;
                case 10:
                    System.out.println("\n--- [ LISTAGEM DE DADOS ARMAZENADOS ] ---");
                    System.out.println("Total de Clientes: " + listaClientes.size());
                    for (Cliente c : listaClientes) {
                        System.out.println(" - ID: " + c.getId() + " | Nome: " + c.getNome());
                    }
                    System.out.println("Total de Transportadoras: " + listaTransportadoras.size());
                    System.out.println("Total de Fornecedores: " + listaFornecedores.size());
                    System.out.println("Total de Categorias: " + listaCategorias.size());
                    System.out.println("Total de Produtos: " + listaProdutos.size());
                    for (Produto p : listaProdutos) {
                        System.out.println(" - ID: " + p.idProduto + " | Nome: " + p.nomeProduto + " | Estoque: "
                                + p.qtdEstoqueProduto);
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