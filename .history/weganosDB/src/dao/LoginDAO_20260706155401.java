package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Login;

public class LoginDAO {
    
    public void salvar(Login login) {
        String sql = "INSERT INTO LOGIN (nome_usuario, senha_login) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login.getNome_login());
            stmt.setString(2, login.getSenha_login());

            stmt.executeUpdate();
            System.out.println("Sucesso: Cliente salvo no banco de dados!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar login: " + e.getMessage());
        }
    }

    public static ArrayList<Login> listarTodos() {
        String sql = "SELECT * FROM LOGIN";
        ArrayList<Login> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Login login = new Login();

                login.setId_login(rs.getInt("id_login"));
                login.setNome_login(rs.getString("nome_usuario"));
                login.setSenha_login(rs.getString("senha_login"));

                lista.add(login);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar login: " + e.getMessage());
        }

        return lista;
    }

    public void alterar(Login login) {
        String sql = "UPDATE LOGIN SET nome_usuario = ?, senha_login = ? WHERE id_login = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login.getNome_login());
            stmt.setString(2, login.getSenha_login());

            stmt.setInt(3, login.getId_login());

            stmt.executeUpdate();
            System.out.println("Login atualizado com sucesso no banco!");

        } catch (SQLException e) {
            System.err.println("Erro ao alterar login: " + e.getMessage());
        }
    }

    public boolean verificar(String nome, String senha) {
    String sql = "SELECT * FROM LOGIN WHERE nome = ? AND senha = SHA2(?, 26)";
    
    try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, nome);
        stmt.setString(2, senha);
        
        try (ResultSet rs = stmt.executeQuery()) {
            return rs.next(); 
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


    public void deletar(Login login) {

        String sql = "DELETE FROM LOGIN WHERE id_login = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, login.getId_login());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Sucesso: Login deletado com sucesso!");
            } else {
                System.out.println("Aviso: Nenhum login encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar login: " + e.getMessage());
        }
    }
}
