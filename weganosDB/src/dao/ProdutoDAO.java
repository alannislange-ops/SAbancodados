package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.*;

public class ProdutoDAO {

     public void salvar(Produto produto) {
        String sql = "INSERT INTO PRODUTO (nome_produto, preco_produto, qtd_estoque_produto, desc_produto, valor_compra_produto, valor_venda_produto, FK_FORNECEDOR_id_fornecedor, FK_CATEGORIA_id_categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNomeProduto());
            stmt.setBigDecimal(2, produto.getPrecoProduto());
            stmt.setInt(3, produto.getQtdEstoqueProduto());
            stmt.setString(4, produto.getDescProduto());
            stmt.setBigDecimal(5, produto.getValorCompraProduto());
            stmt.setBigDecimal( 6, produto.getValorVendaProduto());
            stmt.setInt(7, produto.getFkFornecedorIdFornecedor().getIdFornecedor());
            stmt.setInt(8, produto.getFkCategoriaIdCategoria().getIdCategoria());

            stmt.executeUpdate();
            System.out.println("Sucesso: Produto salvo no banco de dados!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar Produto: " + e.getMessage());
        }
    }

    public static ArrayList<Produto> listarTodos() {
        String sql = "SELECT * FROM PRODUTO";
        ArrayList<Produto> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setPrecoProduto(rs.getBigDecimal("preco_produto"));
                produto.setQtdEstoqueProduto(rs.getInt("qtd_estoque_produto"));
                produto.setDescProduto(rs.getString("desc_produto"));
                produto.setValorCompraProduto(rs.getBigDecimal("valor_compra_produto"));
                produto.setValorVendaProduto(rs.getBigDecimal("valor_venda_produto"));

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("FK_FORNECEDOR_id_fornecedor"));
                produto.setFkFornecedorIdFornecedor(fornecedor);

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("FK_CATEGORIA_id_categoria"));
                produto.setFkCategoriaIdCategoria(categoria);
                

                lista.add(produto);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Produto: " + e.getMessage());
        }

        return lista;
    }

    public void alterar(Produto produto) {
        String sql = "UPDATE PRODUTO SET nome_produto = ?, preco_produto = ?, qtd_estoque_produto = ?, desc_produto = ?, valor_compra_produto = ?, valor_venda_produto = ?, FK_FORNECEDOR_id_fornecedor = ?, FK_CATEGORIA_id_categoria = ? WHERE id_produto = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNomeProduto());
            stmt.setBigDecimal(2, produto.getPrecoProduto());
            stmt.setInt(3, produto.getQtdEstoqueProduto());
            stmt.setString(4, produto.getDescProduto());
            stmt.setBigDecimal(5, produto.getValorCompraProduto());
            stmt.setBigDecimal(6, produto.getValorVendaProduto());
            stmt.setInt(7, produto.getFkFornecedorIdFornecedor().getIdFornecedor());
            stmt.setInt(8, produto.getFkCategoriaIdCategoria().getIdCategoria());

            stmt.setInt(9, produto.getIdProduto());

            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso no banco!");

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Produto: " + e.getMessage());
        }
    }

    public void deletar(Produto produto) {

        String sql = "DELETE FROM PRODUTO WHERE id_produto = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produto.getIdProduto());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Sucesso: Produto deletado com sucesso!");
            } else {
                System.out.println("Aviso: Nenhum Produto encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar Produto: " + e.getMessage());
        }
    }
}