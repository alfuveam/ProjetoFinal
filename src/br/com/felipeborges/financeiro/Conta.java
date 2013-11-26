package br.com.felipeborges.financeiro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Conta {

    private String nomeBanco;
    private String nConta;
    private String nAgencia;
    private String nDigito;
    

    public Conta() {
    }



    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getnConta() {
        return nConta;
    }

    public void setnConta(String nConta) {
        this.nConta = nConta;
    }

    public String getnAgencia() {
        return nAgencia;
    }

    public void setnAgencia(String nAgencia) {
        this.nAgencia = nAgencia;
    }

    public String getnDigito() {
        return nDigito;
    }

    public void setnDigito(String nDigito) {
        this.nDigito = nDigito;
    }

  
}