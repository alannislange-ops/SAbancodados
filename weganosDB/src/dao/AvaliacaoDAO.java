package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Avaliacao;
import model.Produto;

public class AvaliacaoDAO {
    public void salvar(Avaliacao avaliacao) {
        String sql = "INSERT INTO AVALIACAO (nota_avaliacao, desc_avaliacao, FK_PRODUTO_id_produto) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, avaliacao.getNotaAvaliacao());
            stmt.setObject(2, avaliacao.getDescAvaliacao());
            stmt.setInt(3, avaliacao.getFkProdutoIdProduto().getIdProduto());

            stmt.executeUpdate();
            System.out.println("Sucesso: Avaliação salva no banco de dados!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar Avaliação: " + e.getMessage());
        }
    }

    public static ArrayList<Avaliacao> listarTodos() {
        String sql = "SELECT * FROM AVALIACAO";
        ArrayList<Avaliacao> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao();

                avaliacao.setIdAvaliacao(rs.getInt("id_avaliacao"));
                avaliacao.setNotaAvaliacao(rs.getInt("nota_avaliacao"));
                avaliacao.setDescAvaliacao(rs.getString("desc_avaliacao"));
                
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("FK_PRODUTO_id_produto"));
                avaliacao.setFkProdutoIdProduto(produto);
                lista.add(avaliacao);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Avaliação: " + e.getMessage());
        }

        return lista;
    }

    public void alterar(Avaliacao avaliacao) {
        String sql = "UPDATE AVALIACAO SET nota_avaliacao = ?, desc_avaliacao = ?, FK_PRODUTO_id_produto = ?  WHERE id_avaliacao = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, avaliacao.getNotaAvaliacao());
            stmt.setString(2, avaliacao.getDescAvaliacao());
            stmt.setInt(3, avaliacao.getFkProdutoIdProduto().getIdProduto());

            stmt.setInt(4, avaliacao.getIdAvaliacao());
            
            stmt.executeUpdate();
            System.out.println("Avaliação atualizado com sucesso no banco!");

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Avaliação: " + e.getMessage());
        }
    }

    public void deletar(Avaliacao avaliacao) {

        String sql = "DELETE FROM AVALIACAO WHERE id_avaliacao = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, avaliacao.getIdAvaliacao());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Sucesso: Avaliação deletada com sucesso!");
            } else {
                System.out.println("Aviso: Nenhuma Avaliação encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar Avaliação: " + e.getMessage());
        }
    }
}