package model;

public class Fornecedor {
    public int idFornecedor;
    public String nomeFornecedor;
    public String cnpjFornecedor;
    public String telefoneFornecedor;

    public Fornecedor() {

    }

    public void mostrarFornecedor() {
        System.out.println("=======================================");
        System.out.println("ID: " + idFornecedor + "\nNome: " + nomeFornecedor + "\nCNPJ: " + cnpjFornecedor
                + "\nTelefone: " + telefoneFornecedor);
        System.out.println("=======================================");
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public Fornecedor(int idFornecedor, String nomeFornecedor, String cnpjFornecedor, String telefoneFornecedor) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpjFornecedor = cnpjFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
    }
}
