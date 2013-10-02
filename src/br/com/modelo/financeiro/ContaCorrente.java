
package br.com.modelo.financeiro;

import java.util.Date;

public class ContaCorrente extends Conta{
        private String nome; //É para verificar no banco de dados os valores armazenados
        private String valor;
        private Date dataPagamento;
        private int id;

    public ContaCorrente(String nome, String valor, Date dataPagamento, int id, String nomeBanco, String nConta, String nAgencia, String nDigito) {
        super(id, nomeBanco, nConta, nAgencia, nDigito);
        this.nome = nome;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.id = id;
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

    @Override
    public String toString() {
        return "ContaCorrente{" + "nome=" + nome + ", valor=" + valor + ", dataPagamento=" + dataPagamento + ", id=" + id + '}';
    }
    }