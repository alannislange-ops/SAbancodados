package model;
import java.time.LocalDate;
class Pedido {
    public int idPedido;
    public LocalDate dataPedido;
    public int fkClienteIdCliente;
    public int fkTransportadoraIdTransportadora;
}