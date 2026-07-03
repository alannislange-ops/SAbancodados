package model;
import java.time.LocalDate;
class Pedido {
    private int idPedido;
    private LocalDate dataPedido;
    private int fkClienteIdCliente;
    private int fkTransportadoraIdTransportadora;
}