package model;


import java.time.LocalDate;


public class Pedido {
    public int idPedido;
    public LocalDate dataPedido;
    public Cliente fkClienteIdCliente;
    public Transportadora fkTransportadoraIdTransportadora;

    public void mostrarCarrinho(){
        System.out.println("=======================================");
        System.out.println("ID: " + idPedido + "DATA: " + dataPedido + "ID CLIENTE: " + fkClienteIdCliente + "ID TRANSPORTADORA: " + fkTransportadoraIdTransportadora);
        System.out.println("=======================================");
    }


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


    public Cliente getFkClienteIdCliente() {
        return fkClienteIdCliente;
    }


    public void setFkClienteIdCliente(Cliente fkClienteIdCliente) {
        this.fkClienteIdCliente = fkClienteIdCliente;
    }


    public Transportadora getFkTransportadoraIdTransportadora() {
        return fkTransportadoraIdTransportadora;
    }


    public void setFkTransportadoraIdTransportadora(Transportadora fkTransportadoraIdTransportadora) {
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

