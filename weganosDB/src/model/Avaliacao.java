package model;
public class Avaliacao {
    private int idAvaliacao;
    private int notaAvaliacao;
    private String descAvaliacao; 
    private Produto fkProdutoIdProduto;


    public void mostrarAvaliacao(){
        System.out.println("=======================================");
        System.out.println("ID: "+idAvaliacao + "\nNota: "+notaAvaliacao+ "\nDescrição: "+descAvaliacao+"\nId do Produto: "+getFkProdutoIdProduto().getIdProduto());
        System.out.println("=======================================");
    }
    public Avaliacao() {
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(int notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public String getDescAvaliacao() {
        return descAvaliacao;
    }

    public void setDescAvaliacao(String descAvaliacao) {
        this.descAvaliacao = descAvaliacao;
    }

    public Produto getFkProdutoIdProduto() {
        return fkProdutoIdProduto;
    }

    public void setFkProdutoIdProduto(Produto fkProdutoIdProduto) {
        this.fkProdutoIdProduto = fkProdutoIdProduto;
    }

    public Avaliacao(int idAvaliacao, int notaAvaliacao, String descAvaliacao, Produto fkProdutoIdProduto) {
        this.idAvaliacao = idAvaliacao;
        this.notaAvaliacao = notaAvaliacao;
        this.descAvaliacao = descAvaliacao;
        this.fkProdutoIdProduto = fkProdutoIdProduto;
    }
}
