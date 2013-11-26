package br.com.felipeborges.financeiro;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cheque {

    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataAberturaConta;
    private String numeroCheque;
    @Id @GeneratedValue
    private int id;

    public Cheque() {
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
        return "Cheque{" + "nome=" + nome + ", dataAberturaConta=" + dataAberturaConta + ", numeroCheque=" + numeroCheque + ", id=" + id + '}';
    }
}
