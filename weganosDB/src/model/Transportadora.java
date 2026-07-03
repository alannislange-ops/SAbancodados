package model;

import java.time.LocalTime;
import java.math.BigDecimal;
public class Transportadora {

    public int idTransportadora;
    public String nomeTransportadora;
    public LocalTime horarioAberturaTranspo;
    public LocalTime horarioFechamentoTran;
    public String cnpjTransportadora;
    public BigDecimal contratacaoMensalTran;

    public Transportadora(){
        
    }
    public void mostrarTransportadora(){
        System.out.println("=======================================");
        System.out.println("ID: "+idTransportadora + "\nNome: "+nomeTransportadora+ "\nHorario abertura: "+horarioAberturaTranspo+"\nHorario fechamento: "+horarioFechamentoTran+"\nCNPJ: "+cnpjTransportadora+"\nValor pago mensal: "+contratacaoMensalTran);
        System.out.println("=======================================");
    }
    public int getIdTransportadora() {
        return idTransportadora;
    }
    public void setIdTransportadora(int idTransportadora) {
        this.idTransportadora = idTransportadora;
    }
    public String getNomeTransportadora() {
        return nomeTransportadora;
    }
    public void setNomeTransportadora(String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }
    public LocalTime getHorarioAberturaTranspo() {
        return horarioAberturaTranspo;
    }
    public void setHorarioAberturaTranspo(LocalTime horarioAberturaTranspo) {
        this.horarioAberturaTranspo = horarioAberturaTranspo;
    }
    public LocalTime getHorarioFechamentoTran() {
        return horarioFechamentoTran;
    }
    public void setHorarioFechamentoTran(LocalTime horarioFechamentoTran) {
        this.horarioFechamentoTran = horarioFechamentoTran;
    }
    public String getCnpjTransportadora() {
        return cnpjTransportadora;
    }
    public void setCnpjTransportadora(String cnpjTransportadora) {
        this.cnpjTransportadora = cnpjTransportadora;
    }
    public BigDecimal getContratacaoMensalTran() {
        return contratacaoMensalTran;
    }
    public void setContratacaoMensalTran(BigDecimal contratacaoMensalTran) {
        this.contratacaoMensalTran = contratacaoMensalTran;
    }
    
    public Transportadora(int idTransportadora, String nomeTransportadora, LocalTime horarioAberturaTranspo,
            LocalTime horarioFechamentoTran, String cnpjTransportadora, BigDecimal contratacaoMensalTran) {
        this.idTransportadora = idTransportadora;
        this.nomeTransportadora = nomeTransportadora;
        this.horarioAberturaTranspo = horarioAberturaTranspo;
        this.horarioFechamentoTran = horarioFechamentoTran;
        this.cnpjTransportadora = cnpjTransportadora;
        this.contratacaoMensalTran = contratacaoMensalTran;
    }
    
}