package model;


import java.math.BigDecimal;
public class CarrinhoContem {
    public int quantidadeProdutosCo;
    public BigDecimal valorCompra;
    public Pedido fkPedidoIdPedido;
    public Produto fkProdutoIdProduto;


    public CarrinhoContem(){


    }


    public CarrinhoContem(int quantidadeProdutosCo, BigDecimal valorCompra, Pedido fkPedidoIdPedido,
            Produto fkProdutoIdProduto) {
        this.quantidadeProdutosCo = quantidadeProdutosCo;
        this.valorCompra = valorCompra;
        this.fkPedidoIdPedido = fkPedidoIdPedido;
        this.fkProdutoIdProduto = fkProdutoIdProduto;
    }


    public void mostrarCarrinho(){
        System.out.println("=======================================");
        System.out.println("Quantidade: "+quantidadeProdutosCo + "\nValor: "+valorCompra+ "\nPedido: "+fkPedidoIdPedido+"\nProduto: "+fkProdutoIdProduto);
        System.out.println("=======================================");
    }


    public int getQuantidadeProdutosCo() {
        return quantidadeProdutosCo;
    }
    public void setQuantidadeProdutosCo(int quantidadeProdutosCo) {
        this.quantidadeProdutosCo = quantidadeProdutosCo;
    }
    public BigDecimal getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }
    public Pedido getFkPedidoIdPedido() {
        return fkPedidoIdPedido;
    }
    public void setFkPedidoIdPedido(Pedido fkPedidoIdPedido) {
        this.fkPedidoIdPedido = fkPedidoIdPedido;
    }
    public Produto getFkProdutoIdProduto() {
        return fkProdutoIdProduto;
    }
    public void setFkProdutoIdProduto(Produto fkProdutoIdProduto) {
        this.fkProdutoIdProduto = fkProdutoIdProduto;
    }


    public void setQuantidadeProdutosCo(String string) {
       
    }


    public void setValorCompra(String string) {
       
    }


    public void setFkPedidoIdPedido(String string) {
       
    }


    public void setFkProdutoIdProduto(String string) {
       
    }
   
}

