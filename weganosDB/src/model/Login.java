package model;

public class Login {
    private int id_login;
    private String nome_login, senha_login;

    public int getId_login() {
        return id_login;
    }
    public void setId_login(int id_login) {
        this.id_login = id_login;
    }
    public String getNome_login() {
        return nome_login;
    }
    public void setNome_login(String nome_login) {
        this.nome_login = nome_login;
    }
    public String getSenha_login() {
        return senha_login;
    }
    public void setSenha_login(String senha_login) {
        this.senha_login = senha_login;
    }
    public Login(int id_login, String nome_login, String senha_login) {
        this.id_login = id_login;
        this.nome_login = nome_login;
        this.senha_login = senha_login;
    }
    public Login() {
    }

    public void mostrarLogin(){
        System.out.println("=======================================");
        System.out.println("ID: "+id_login+"\nNome da conta: "+nome_login+"Senha: "+senha_login);
        System.out.println("=======================================");
    }
    
}
