package dao;


import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import conexao.Conexao;


public class CarrinhoContemDAO {


    public void salvar(CarrinhoContem carrinho) {
        String sql = "INSERT INTO CARRINHO_CONTEM (quantidade_produtos_co, valor_compra, FK_PEDIDO_id_pedido, FK_PRODUTO_id_produto) VALUES (?, ?, ?, ?)";


        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setInt(1, carrinho.getQuantidadeProdutosCo());
            stmt.setBigDecimal(2, carrinho.getValorCompra());
            stmt.setObject(3, carrinho.getFkPedidoIdPedido());
            stmt.setObject(4, carrinho.getFkProdutoIdProduto());


            stmt.executeUpdate();
            System.out.println("\"Sucesso: Carrinho salvo no banco de dados!\"");


        } catch (SQLException e) {
            System.err.println("Erro ao salvar o carrinho: " + e.getMessage());
        }
    }



    public static ArrayList<CarrinhoContem> listarTodos() {
        String sql = "SELECT * FROM CARRINHO_CONTEM";
        ArrayList<CarrinhoContem> lista = new ArrayList<>();


        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {


            while (rs.next()) {
                CarrinhoContem carrinho = new CarrinhoContem();


                carrinho.setQuantidadeProdutosCo("quantidade_produtos_co");
                carrinho.setValorCompra("valor_compra");
                carrinho.setFkPedidoIdPedido("FK_PEDIDO_id_pedido");
                carrinho.setFkProdutoIdProduto("FK_PRODUTO_id_produto");


                lista.add(carrinho);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar o carrinho" + e.getMessage());
        }


        return lista;
    }


    public void alterar(CarrinhoContem carrinho) {
        String sql = "UPDATE CARRINHO_CONTEM SET quantidade_produtos_co = ?, valor_compra = ?, FK_PEDIDO_id_pedido = ?, FK_PRODUTO_id_produto = ?";


        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, carrinho.getQuantidadeProdutosCo());
            stmt.setBigDecimal(2, carrinho.getValorCompra());
            stmt.setObject(3, carrinho.getFkPedidoIdPedido());
            stmt.setObject(4, carrinho.getFkProdutoIdProduto());


            stmt.executeUpdate();
            System.out.println("Carrinho atualizado com sucesso no banco!");
        } catch (SQLException e) {
            System.err.println("Erro ao alterar o carrinho: " + e.getMessage());
        }
    }


    public void deletar(CarrinhoContem carrinho) {
        String sql = "DELETE FROM CARRINHO_CONTEM WHERE FK_PEDIDO_id_pedido = ?";


        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, carrinho.getFkPedidoIdPedido());


            int linhasAfetadas = stmt.executeUpdate();


            if(linhasAfetadas > 0) {
                System.out.println("Suceso: Carrinho deletad com sucesso!");
            } else{
                System.out.println("Aviso: Nenhum carrinho encontrado com o pedido informado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deletar carrinho: " + e.getMessage());
        }
    }
}