package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Categoria;

public class CategoriaDAO {
    
    public void salvar(Categoria categoria) {
        String sql = "INSERT INTO CATEGORIA (nome_categoria, desc_categoria) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setString(2, categoria.getDescCategoria());


            stmt.executeUpdate();
            System.out.println("Sucesso: Categoria salva no banco de dados!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar Categoria: " + e.getMessage());
        }
    }

    public static ArrayList<Categoria> listarTodos() {
        String sql = "SELECT * FROM CATEGORIA";
        ArrayList<Categoria> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();

                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                categoria.setDescCategoria(rs.getString("desc_categoria"));
                
                lista.add(categoria);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Categoria: " + e.getMessage());
        }

        return lista;
    }

    public void alterar(Categoria categoria) {
        String sql = "UPDATE CATEGORIA SET nome_categoria = ?, desc_categoria = ? WHERE id_categoria = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setString(2, categoria.getDescCategoria());

            stmt.setInt(3, categoria.getIdCategoria());

            stmt.executeUpdate();
            System.out.println("Categoria atualizada com sucesso no banco!");

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Categoria: " + e.getMessage());
        }
    }

    public void deletar(Categoria categoria) {

        String sql = "DELETE FROM CATEGORIA WHERE id_categoria = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, categoria.getIdCategoria());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Sucesso: Categoria deletada com sucesso!");
            } else {
                System.out.println("Aviso: Nenhuma Categoria encontrada com o ID informado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar Categoria: " + e.getMessage());
        }
    }
    
}