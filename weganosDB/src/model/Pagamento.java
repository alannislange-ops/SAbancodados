package model;

import java.math.BigDecimal;

public class Pagamento {

    private int idPagamento;
    private String formaPagamento;
    private String statusPagamento;
    private BigDecimal valorPagamento;
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(int idPagamento, String formaPagamento, String statusPagamento, BigDecimal valorPagamento,
            Pedido pedido) {
        this.idPagamento = idPagamento;
        this.formaPagamento = formaPagamento;
        this.statusPagamento = statusPagamento;
        this.valorPagamento = valorPagamento;
        this.pedido = pedido;
    }

    public void mostrarPagamento() {
        System.out.println("=======================================");
        System.out.println("ID Pagamento: " + idPagamento
                + "\nForma: " + formaPagamento
                + "\nStatus: " + statusPagamento
                + "\nValor: " + valorPagamento
                + "\nID Pedido: " + (pedido != null ? pedido.getIdPedido() : "Não associado"));
        System.out.println("=======================================");
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
