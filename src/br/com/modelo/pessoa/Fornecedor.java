
package br.com.modelo.pessoa;

import java.util.Date;


public class Fornecedor extends Pessoa{
    private String cnpj;
    private int id;

    public Fornecedor(String nome, Date dataNasci, String rg, String cpf, String endereco, String telefone, String celular, int id) {
        super(nome, dataNasci, rg, cpf, endereco, telefone, celular, id);
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
