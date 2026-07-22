package model;
import java.math.BigDecimal;
public class Produto {
    private int idProduto;
    private String nomeProduto;
    private BigDecimal precoProduto;
    private int qtdEstoqueProduto;
    private String descProduto;
    private BigDecimal valorCompraProduto;
    private BigDecimal valorVendaProduto;
    private Fornecedor fkFornecedorIdFornecedor;
    private Categoria fkCategoriaIdCategoria;


     public Produto() {
    }

    public void mostrarProduto(){
         System.out.println("=======================================");
        System.out.println("ID: "+idProduto + "\nNome: "+nomeProduto+ "\nPreço: "+precoProduto+"\nQuantidade Estoque: "+qtdEstoqueProduto+"\nDescrição: "+descProduto+"\nValor Compra: "+valorCompraProduto+"\nValor Venda: "+valorVendaProduto+"\nID Fornecedor: "+getFkFornecedorIdFornecedor().getIdFornecedor()+"\nID Categoria: "+getFkCategoriaIdCategoria().getIdCategoria());
        System.out.println("=======================================");
    }
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }
    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }
    public int getQtdEstoqueProduto() {
        return qtdEstoqueProduto;
    }
    public void setQtdEstoqueProduto(int qtdEstoqueProduto) {
        this.qtdEstoqueProduto = qtdEstoqueProduto;
    }
    public String getDescProduto() {
        return descProduto;
    }
    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }
    public BigDecimal getValorCompraProduto() {
        return valorCompraProduto;
    }
    public void setValorCompraProduto(BigDecimal valorCompraProduto) {
        this.valorCompraProduto = valorCompraProduto;
    }
    public BigDecimal getValorVendaProduto() {
        return valorVendaProduto;
    }
    public void setValorVendaProduto(BigDecimal valorVendaProduto) {
        this.valorVendaProduto = valorVendaProduto;
    }
    public Fornecedor getFkFornecedorIdFornecedor() {
        return fkFornecedorIdFornecedor;
    }
    public void setFkFornecedorIdFornecedor(Fornecedor fkFornecedorIdFornecedor) {
        this.fkFornecedorIdFornecedor = fkFornecedorIdFornecedor;
    }
    public Categoria getFkCategoriaIdCategoria() {
        return fkCategoriaIdCategoria;
    }
    public void setFkCategoriaIdCategoria(Categoria fkCategoriaIdCategoria) {
        this.fkCategoriaIdCategoria = fkCategoriaIdCategoria;
    }

    public Produto(int idProduto, String nomeProduto, BigDecimal precoProduto, int qtdEstoqueProduto,
            String descProduto, BigDecimal valorCompraProduto, BigDecimal valorVendaProduto,
            Fornecedor fkFornecedorIdFornecedor, Categoria fkCategoriaIdCategoria) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.qtdEstoqueProduto = qtdEstoqueProduto;
        this.descProduto = descProduto;
        this.valorCompraProduto = valorCompraProduto;
        this.valorVendaProduto = valorVendaProduto;
        this.fkFornecedorIdFornecedor = fkFornecedorIdFornecedor;
        this.fkCategoriaIdCategoria = fkCategoriaIdCategoria;
    }
}
