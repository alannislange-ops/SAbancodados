package model;
import java.math.BigDecimal;
class Produto {
    private int idProduto;
    private String nomeProduto;
    private BigDecimal precoProduto;
    private int qtdEstoqueProduto;
    private String descProduto;
    private BigDecimal valorCompraProduto;
    private BigDecimal valorVendaProduto;
    private int fkFornecedorIdFornecedor;
    private int fkCategoriaIdCategoria;
    public void mostrarProduto(){
        System.out.println("=======================================");
        System.out.println("ID: "+idProduto + "\nNome: "+nomeProduto);
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
    public int getFkFornecedorIdFornecedor() {
        return fkFornecedorIdFornecedor;
    }
    public void setFkFornecedorIdFornecedor(int fkFornecedorIdFornecedor) {
        this.fkFornecedorIdFornecedor = fkFornecedorIdFornecedor;
    }
    public int getFkCategoriaIdCategoria() {
        return fkCategoriaIdCategoria;
    }
    public void setFkCategoriaIdCategoria(int fkCategoriaIdCategoria) {
        this.fkCategoriaIdCategoria = fkCategoriaIdCategoria;
    }

}
