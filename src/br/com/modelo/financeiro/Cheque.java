package br.com.modelo.financeiro;

import java.util.Date;

public class Cheque {
    private String nome;
    private Date dataAberturaConta;
    private String numeroCheque;

    public Cheque(String nome, Date dataAberturaConta, String numeroCheque) {
        this.nome = nome;
        this.dataAberturaConta = dataAberturaConta;
        this.numeroCheque = numeroCheque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAberturaConta() {
        return dataAberturaConta;
    }

    public void setDataAberturaConta(Date dataAberturaConta) {
        this.dataAberturaConta = dataAberturaConta;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    @Override
    public String toString() {
        return "Cheque{" + "nome=" + nome + ", dataAberturaConta=" + dataAberturaConta + ", numeroCheque=" + numeroCheque + '}';
    }
    
    
}
