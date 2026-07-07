package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;

public class RelatorioDAO {

    public void transportadorasMaisAcessiveis() {
        String sql = "SELECT * FROM transportadoras_mais_acessiveis";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            
            System.out.println("\n--- TRANSPORTADORAS MAIS ACESSÍVEIS ---");
            System.out.printf("%-25s | %-10s\n", "Nome", "Frete R$");
            System.out.println("---------------------------------------------------------");

            while (rs.next()) {
                String nome = rs.getString("nome_transportadora");
                double descAvaliacao = rs.getDouble("contratacao_mensal_tran");

                System.out.printf("%-25s | R$ %-9.2f\n", nome, descAvaliacao);
            }
            System.out.println("---------------------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void pioresAvaliacoes() {
        String sql = "SELECT * FROM piores_avaliacoes";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n--- PIORES AVALIAÇÕES ---");
            System.out.printf("%-5s | %-15s\n", "Nota", "Descrição");
            System.out.println("---------------------------------------------------------");

            while (rs.next()) {
                int nota = rs.getInt("nota_avaliacao");
                String descAvaliacao = rs.getString("desc_avaliacao");

                System.out.printf("%-5d | %-50s | R$ %-9.2f\n", nota, descAvaliacao);
            }
            System.out.println("---------------------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void produtosMaisSolicitados() {
        String sql = "SELECT * FROM produtos_mais_solicitados";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void produtosMenosSolicitados() {
        String sql = "SELECT * FROM produtos_menos_solicitados";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void melhoresProdutosAvaliados() {
        String sql = "SELECT * FROM melhores_produtos_avaliados";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void produtosMenorEstoque() {
        String sql = "SELECT * FROM produtos_menor_estoque";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void metodosPagamentoUtilizados() {
        String sql = "SELECT * FROM metodos_pagamento_utilizados";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void comprasMaisCaras() {
        String sql = "SELECT * FROM compras_mais_caras";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void categoriasMaisVendidas() {
        String sql = "SELECT * FROM categorias_mais_vendidas";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void quantidadeEstoqueProdutos() {
        String sql = "SELECT * FROM quantidade_estoque_produtos";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void cidadeMaisUtilizadora() {
        String sql = "SELECT * FROM cidade_mais_utilizadora";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void produtoMaisSolicitadoUltimoMes() {
        String sql = "SELECT * FROM produto_mais_solicitado_ultimo_mes";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void produtosFornecidosQuantidades() {
        String sql = "SELECT * FROM produtos_fornecidos_quantidades";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void produtosFornecedoresMenorEstoque() {
        String sql = "SELECT * FROM produtos_fornecedores_menor_estoque";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void valorTotal2026() {
        String sql = "SELECT * FROM valor_total_2026";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void precoVendaMaisCaros() {
        String sql = "SELECT * FROM preco_venda_mais_caros";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void avaliacoesTransportadora() {
        String sql = "SELECT * FROM avaliacoes_transportadora";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void faturamentoLucroCustoProdutos() {
        String sql = "SELECT * FROM faturamento_lucro_custo_produtos";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void totalLucrado() {
        String sql = "SELECT * FROM total_lucrado";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }

    public void pagamentosNaoRealizados() {
        String sql = "SELECT * FROM pagamentos_nao_realizados";

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

        } catch (SQLException e) {
            System.err.println("Erro ao listar view: " + e.getMessage());
        }
    }
}
