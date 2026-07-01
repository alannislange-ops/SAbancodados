package dao;

import model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;

public class ClienteDAO {

    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (nome_cliente, documento_cliente, email_cliente, telefone_cliente, cep_cliente, cidade_cliente, rua_cliente, ncasa_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCep());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getRua());
            stmt.setString(8, cliente.getNcasa());

            stmt.executeUpdate();
            System.out.println("Sucesso: Cliente salvo no banco de dados!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public static ArrayList<Cliente> listarTodos() {
        String sql = "SELECT * FROM CLIENTE";
        ArrayList<Cliente> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();

                System.out.print((rs.getInt("id_cliente")));
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setCpf(rs.getString("documento_cliente"));
                cliente.setEmail(rs.getString("email_cliente"));
                cliente.setTelefone(rs.getString("telefone_cliente"));
                cliente.setCep(rs.getString("cep_cliente"));
                cliente.setCidade(rs.getString("cidade_cliente"));
                cliente.setRua(rs.getString("rua_cliente"));
                cliente.setNcasa(rs.getString("ncasa_cliente"));

                lista.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }

        return lista;
    }

    public void alterar(Cliente cliente) {
        String sql = "UPDATE CLIENTE SET nome_cliente = ?, documento_cliente = ?, email_cliente = ?, "
                + "telefone_cliente = ?, cep_cliente = ?, cidade_cliente = ?, rua_cliente = ?, "
                + "ncasa_cliente = ? WHERE id_cliente = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCep());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getRua());
            stmt.setString(8, cliente.getNcasa());

            stmt.setInt(9, cliente.getId());

            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso no banco!");

        } catch (SQLException e) {
            System.err.println("Erro ao alterar cliente: " + e.getMessage());
        }
    }

    public void deletar(Cliente cliente) {

    }

    
}
