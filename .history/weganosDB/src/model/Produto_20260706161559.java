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
    private int fkFornecedorIdFornecedor;
    private int fkCategoriaIdCategoria;

}
