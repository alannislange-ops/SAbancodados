package model;


import java.time.LocalDate;


public class Pedido {
    public int idPedido;
    public LocalDate dataPedido;
    public int fkClienteIdCliente;
    public int fkTransportadoraIdTransportadora;


    public int getIdPedido() {
        return idPedido;
    }


    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }


    public LocalDate getDataPedido() {
        return dataPedido;
    }


    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }


    public int getFkClienteIdCliente() {
        return fkClienteIdCliente;
    }


    public void setFkClienteIdCliente(int fkClienteIdCliente) {
        this.fkClienteIdCliente = fkClienteIdCliente;
    }


    public int getFkTransportadoraIdTransportadora() {
        return fkTransportadoraIdTransportadora;
    }


    public void setFkTransportadoraIdTransportadora(int fkTransportadoraIdTransportadora) {
        this.fkTransportadoraIdTransportadora = fkTransportadoraIdTransportadora;
    }


    public void setIdPedido(String string) {
       
    }


    public void setDataPedido(String string) {
       
    }


    public void setFkClienteIdCliente(String string) {
       
    }


    public void setFkTransportadoraIdTransportadora(String string) {
       
    }


}

