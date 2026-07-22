package dao;


import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import conexao.Conexao;


public class PedidoDAO {


    public void salvar(Pedido pedido) {
        String sql = "INSERT INTO PEDIDO (id_pedido, data_pedido, FK_CLIENTE_id_cliente, FK_TRANSPORTADORA_id_transportadora) VALUES (?, ?, ?, ?)";


        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getIdPedido());
            stmt.setObject(2, pedido.getDataPedido());
            stmt.setObject(3, pedido.getFkClienteIdCliente());
            stmt.setObject(4, pedido.getFkTransportadoraIdTransportadora());


            stmt.executeUpdate();
            System.out.println("Sucesso: Pedido salvo no banco de dados!");


        } catch (SQLException e) {
            System.err.println("Erro ao salvar pedido");
        }
    }


    public static ArrayList<Pedido> listarTodos() {
        String sql = "SELECT * FROM PEDIDO";
        ArrayList<Pedido> lista = new ArrayList<>();


        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
           
            while(rs.next()){
                Pedido pedido = new Pedido();
               
                pedido.setIdPedido("id_pedido");
                pedido.setIdPedido("data_pedido");
                pedido.setIdPedido("FK_CLIENTE_id_cliente");
                pedido.setIdPedido("FK_TRANSPORTADORA_id_transportadora");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar pedido: " + e.getMessage());
        }
        return lista;
    }


    public void alterar(Pedido pedido) {
        String sql = "UPDATE PEDIDO SET data_pedido = ?, FK_CLIENTE_id_cliente = ?, FK_TRANSPORTADORA_id_transportadora = ? WHERE id_pedido = ?";


        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, pedido.getDataPedido());
            stmt.setObject(2, pedido.getFkClienteIdCliente());
            stmt.setObject(3, pedido.getFkTransportadoraIdTransportadora());


            stmt.setInt(4, pedido.getIdPedido());


            stmt.executeUpdate();
            System.out.println("Pedido atualizado com sucesso no banco!");


        } catch (SQLException e) {
            System.err.println("Erro ao alterar pedido: " + e.getMessage());
        }
    }


    public void deletar(Pedido pedido) {
        String sql = "DELETE FROM PEDIDO WHERE id_pedido = ?";


        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getIdPedido());


            int linhasAfetadas = stmt.executeUpdate();


            if (linhasAfetadas > 0) {
                System.out.println("Sucesso: Pedido deletado com sucesso!");
            } else {
                System.out.println("Aviso: Nenhum Pedido encontrado com o ID informado.");
            }
        } catch(SQLException e) {
            System.err.println("Erro ao deletar Pedido: " + e.getMessage());
        }
    }
}