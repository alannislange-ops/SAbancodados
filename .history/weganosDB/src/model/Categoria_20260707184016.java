package model;
public class Categoria {
    public int idCategoria;
    public String nomeCategoria;
    public String descCategoria;

    public Categoria() {

    }

    public Categoria(int idCategoria, String nomeCategoria, String descCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.descCategoria = descCategoria;
    }
    public void mostrarCategoria(){
        System.out.println("=======================================");
        System.out.println("ID: "+idCategoria + "\nNome: "+nomeCategoria+ "\nDescrição: "+descCategoria);
        System.out.println("=======================================");
    }

    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    public String getNomeCategoria() {
        return nomeCategoria;
    }
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    public String getDescCategoria() {
        return descCategoria;
    }
    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }
}