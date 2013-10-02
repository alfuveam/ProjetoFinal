package br.com.modelo.financeiro;

import br.com.modelo.pessoa.Pessoa;

public class Venda {

    private Cheque cheque;
    private ContaCorrente contaCorrente;
    private Pessoa pessoa;
    private int id;

    public Venda() {
    }

    public Cheque getCheque() {
        return cheque;
    }

    public void setCheque(Cheque cheque) {
        this.cheque = cheque;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Venda{" + "cheque=" + cheque + ", contaCorrente=" + contaCorrente + ", pessoa=" + pessoa + ", id=" + id + '}';
    }
}