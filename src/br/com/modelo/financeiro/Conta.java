package br.com.modelo.financeiro;

public class Conta {

    private String nomeBanco;
    private String nConta;
    private String nAgencia;
    private String nDigito;
    private int id;

    public Conta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Conta{" + "nomeBanco=" + nomeBanco + ", nConta=" + nConta + ", nAgencia=" + nAgencia + ", nDigito=" + nDigito + ", id=" + id + '}';
    }
}