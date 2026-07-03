package dao;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;

public class FornecedorDAO {

    public void salvar(Fornecedor fornecedor) {
        String sql = "INSERT INTO FORNECEDOR (nome_fornecedor, cnpj_fornecedor, telefone_fornecedor) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getCnpjFornecedor());
            stmt.setString(3, fornecedor.getTelefoneFornecedor());

            stmt.executeUpdate();
            System.out.println("Sucesso: Fornecedor salvo no banco de dados!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar fornecedor: " + e.getMessage());
        }
    }

    public static ArrayList<Fornecedor> listarTodos() {
        String sql = "SELECT * FROM FORNECEDOR";
        ArrayList<Fornecedor> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("nome_fornecedor"));
                fornecedor.setCnpjFornecedor(rs.getString("cnpj_fornecedor"));
                fornecedor.setTelefoneFornecedor(rs.getString("telefone_fornecedor"));

                lista.add(fornecedor);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar fornecedores: " + e.getMessage());
        }

        return lista;
    }

    public void alterar(Fornecedor fornecedor) {
        String sql = "UPDATE FORNECEDOR SET nome_fornecedor = ?, cnpj_fornecedor = ?, telefone_fornecedor = ? WHERE id_fornecedor = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getCnpjFornecedor());
            stmt.setString(3, fornecedor.getTelefoneFornecedor());

            // O ID vai no WHERE usando o getter correspondente
            stmt.setInt(4, fornecedor.getIdFornecedor());

            stmt.executeUpdate();
            System.out.println("Fornecedor updated com sucesso no banco!");

        } catch (SQLException e) {
            System.err.println("Erro ao alterar fornecedor: " + e.getMessage());
        }
    }

    public void deletar(Fornecedor fornecedor) {
        String sql = "DELETE FROM FORNECEDOR WHERE id_fornecedor = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fornecedor.getIdFornecedor());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Sucesso: Fornecedor deletado com sucesso!");
            } else {
                System.out.println("Aviso: Nenhum fornecedor encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar fornecedor: " + e.getMessage());
        }
    }
}
