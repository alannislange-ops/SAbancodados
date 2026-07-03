package model;

import java.math.BigDecimal;

public class Pagamento {

    public int idPagamento;
    public String formaPagamento;
    public String statusPagamento;
    public BigDecimal valorPagamento;
    public int fkPedidoIdPedido;

    public Pagamento() {
    }

    public void mostrarPagamento() {
        System.out.println("=======================================");
        System.out.println("ID Pagamento: " + idPagamento
                + "\nForma: " + formaPagamento
                + "\nStatus: " + statusPagamento
                + "\nValor: " + valorPagamento
                + "\nID Pedido: " + fkPedidoIdPedido);
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

    public int getFkPedidoIdPedido() {
        return fkPedidoIdPedido;
    }

    public void setFkPedidoIdPedido(int fkPedidoIdPedido) {
        this.fkPedidoIdPedido = fkPedidoIdPedido;
    }

    public Pagamento(int idPagamento, String formaPagamento, String statusPagamento, BigDecimal valorPagamento, int fkPedidoIdPedido) {
        this.idPagamento = idPagamento;
        this.formaPagamento = formaPagamento;
        this.statusPagamento = statusPagamento;
        this.valorPagamento = valorPagamento;
        this.fkPedidoIdPedido = fkPedidoIdPedido;
    }
}