package dao;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

import conexao.Conexao;

public class TransportadoraDAO {
    
    public void salvar(Transportadora transportadora) {
        String sql = "INSERT INTO TRANSPORTADORA (nome_transportadora, horario_abertura_tran, horario_fechamento_tran, cnpj_transportadora, contratacao_mensal_tran) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, transportadora.getNomeTransportadora());
            stmt.setObject(2, transportadora.getHorarioAberturaTranspo());
            stmt.setObject(3, transportadora.getHorarioFechamentoTran());
            stmt.setString(4, transportadora.getCnpjTransportadora());
            stmt.setBigDecimal(5, transportadora.getContratacaoMensalTran());

            stmt.setInt(6, transportadora.getIdTransportadora());

            stmt.executeUpdate();
            System.out.println("Sucesso: Transportadora salva no banco de dados!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar Transportadora: " + e.getMessage());
        }
    }

    public static ArrayList<Transportadora> listarTodos() {
        String sql = "SELECT * FROM TRANSPORTADORA";
        ArrayList<Transportadora> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Transportadora transportadora = new Transportadora();

                transportadora.setIdTransportadora(rs.getInt("id_transportadora"));
                transportadora.setNomeTransportadora(rs.getString("nome_transportadora"));
                transportadora.setHorarioAberturaTranspo(rs.getObject("horario_abertura_tran", LocalTime.class));
                transportadora.setHorarioFechamentoTran(rs.getObject("horario_fechamento_tran", LocalTime.class));
                transportadora.setCnpjTransportadora(rs.getString("cnpj_transportadora"));
                transportadora.setContratacaoMensalTran(rs.getBigDecimal("contratacao_mensal_tran"));
                

                lista.add(transportadora);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Transportadora: " + e.getMessage());
        }

        return lista;
    }

    public void alterar(Transportadora transportadora) {
        String sql = "UPDATE TRANSPORTADORA SET nomeTransportadora = ?, horario_abertura_tran = ?, horario_fechamento_tran = ?, cnpj_transportadora = ?, contratacao_mensal_tran = ? WHERE id_transportadora = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, transportadora.getNomeTransportadora());
            stmt.setObject(2, transportadora.getHorarioAberturaTranspo());
            stmt.setObject(3, transportadora.getHorarioFechamentoTran());
            stmt.setString(4, transportadora.getCnpjTransportadora());
            stmt.setBigDecimal(5, transportadora.getContratacaoMensalTran());

            stmt.setInt(6, transportadora.getIdTransportadora());

            stmt.executeUpdate();
            System.out.println("Transportadora atualizada com sucesso no banco!");

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Transportadora: " + e.getMessage());
        }
    }

    public void deletar(Transportadora transportadora) {

        String sql = "DELETE FROM TRANSPORTADORA WHERE id_transportadora = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, transportadora.getIdTransportadora());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Sucesso: Transportadora deletada com sucesso!");
            } else {
                System.out.println("Aviso: Nenhuma Transportadora encontrada com o ID informado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar Transportadora: " + e.getMessage());
        }
    }
}
