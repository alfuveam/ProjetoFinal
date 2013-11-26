package br.com.felipeborges.financeiro;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ContaCorrente extends Conta {
    @Id @GeneratedValue
    private int id;
    private String nome; //É para verificar no banco de dados os valores armazenados
    private String valor;
    @Temporal (TemporalType.DATE)
    private Date dataPagamento;


    public ContaCorrente() {
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}