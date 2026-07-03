package dao;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;

public class PagamentosDAO {
public void salvar(Pagamento pagamento) {
        String sql = "INSERT INTO PAGAMENTO (forma_pagamento, status_pagamento, valor_pagamento, FK_PEDIDO_id_pedido) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pagamento.getFormaPagamento());
            stmt.setString(2, pagamento.getStatusPagamento());
            stmt.setBigDecimal(3, pagamento.getValorPagamento());
            stmt.setInt(4, pagamento.getFkPedidoIdPedido());

            stmt.executeUpdate();
            System.out.println("Sucesso: Pagamento salvo no banco de dados!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar pagamento: " + e.getMessage());
        }
    }

    public static ArrayList<Pagamento> listarTodos() {
        String sql = "SELECT * FROM PAGAMENTO";
        ArrayList<Pagamento> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pagamento pagamento = new Pagamento();

                pagamento.setIdPagamento(rs.getInt("id_pagamento"));
                pagamento.setFormaPagamento(rs.getString("forma_pagamento"));
                pagamento.setStatusPagamento(rs.getString("status_pagamento"));
                pagamento.setValorPagamento(rs.getBigDecimal("valor_pagamento"));
                pagamento.setFkPedidoIdPedido(rs.getInt("FK_PEDIDO_id_pedido")); // Nome exato da FK no banco

                lista.add(pagamento);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar pagamentos: " + e.getMessage());
        }

        return lista;
    }

    public void alterar(Pagamento pagamento) {
        String sql = "UPDATE PAGAMENTO SET forma_pagamento = ?, status_pagamento = ?, valor_pagamento = ?, FK_PEDIDO_id_pedido = ? WHERE id_pagamento = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pagamento.getFormaPagamento());
            stmt.setString(2, pagamento.getStatusPagamento());
            stmt.setBigDecimal(3, pagamento.getValorPagamento());
            stmt.setInt(4, pagamento.getFkPedidoIdPedido());

            stmt.setInt(5, pagamento.getIdPagamento());

            stmt.executeUpdate();
            System.out.println("Pagamento atualizado com sucesso no banco!");

        } catch (SQLException e) {
            System.err.println("Erro ao alterar pagamento: " + e.getMessage());
        }
    }

    public void deletar(Pagamento pagamento) {
        String sql = "DELETE FROM PAGAMENTO WHERE id_pagamento = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pagamento.getIdPagamento());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Sucesso: Pagamento deletado com sucesso!");
            } else {
                System.out.println("Aviso: Nenhum pagamento encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar pagamento: " + e.getMessage());
        }
    }
}