package br.com.modelo.pessoa;

import java.util.Date;

public class Fornecedor extends Pessoa {

    private String cnpj;
    private int id;

    public Fornecedor() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "cnpj=" + cnpj + ", id=" + id + '}';
    }
}
