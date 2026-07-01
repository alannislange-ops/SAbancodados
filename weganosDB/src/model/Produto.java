package model;
import java.math.BigDecimal;
class Produto {
    public int idProduto;
    public String nomeProduto;
    public BigDecimal precoProduto;
    public int qtdEstoqueProduto;
    public String descProduto;
    public BigDecimal valorCompraProduto;
    public BigDecimal valorVendaProduto;
    public int fkFornecedorIdFornecedor;
    public int fkCategoriaIdCategoria;

}
