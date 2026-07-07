package model;
<<<<<<< HEAD

public class Categoria {
    private int idCategoria;
    private String nomeCategoria;
    private String descCategoria;
=======
public class Categoria {
    public int idCategoria;
    public String nomeCategoria;
    public String descCategoria;
>>>>>>> 2ded2490361397ddc31a2e69165934fbde45ddf8

    public Categoria() {

    }

    public Categoria(int idCategoria, String nomeCategoria, String descCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.descCategoria = descCategoria;
    }
<<<<<<< HEAD

    public void mostrarCategoria() {
        System.out.println("=======================================");
        System.out.println("ID: " + idCategoria + "\nNome: " + nomeCategoria + "\nDescrição: " + descCategoria);
=======
    public void mostrarCategoria(){
        System.out.println("=======================================");
        System.out.println("ID: "+idCategoria + "\nNome: "+nomeCategoria+ "\nDescrição: "+descCategoria);
>>>>>>> 2ded2490361397ddc31a2e69165934fbde45ddf8
        System.out.println("=======================================");
    }

    public int getIdCategoria() {
        return idCategoria;
    }
<<<<<<< HEAD

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
=======
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
>>>>>>> 2ded2490361397ddc31a2e69165934fbde45ddf8
