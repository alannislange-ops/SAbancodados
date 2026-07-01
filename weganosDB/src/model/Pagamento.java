package model;
import java.math.BigDecimal;
class Pagamento {
    public int idPagamento;
    public String formaPagamento;
    public String statusPagamento;
    public BigDecimal valorPagamento;
    public int fkPedidoIdPedido;
}