package model;
public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String cep;
    private String cidade;
    private String rua;
    private String ncasa;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, String email, String telefone, String cep, String cidade, String rua, String ncasa) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
        this.rua = rua;
        this.ncasa = ncasa;
    }
    public void mostrarCliente(){
        System.out.println("=======================================");
        System.out.println("ID: "+id + "\nNome: "+nome+ "\nCpf: "+cpf+"\nEmail: "+email+"\nTelefone: "+telefone+"\nCEP: "+cep+"\nCidade: "+cidade+"\nRua: "+rua+"\nNúmero da casa: "+ncasa);
        System.out.println("=======================================");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNcasa() {
        return ncasa;
    }

    public void setNcasa(String ncasa) {
        this.ncasa = ncasa;
    }
}