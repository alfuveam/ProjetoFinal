package br.com.modelo.pessoa;

import br.com.modelo.financeiro.ContaCorrente;
import java.util.Date;

public class Cliente extends Pessoa {

    private ContaCorrente contaCorrente;
    private int id;

    public Cliente(String nome, Date dataNasci, String rg, String cpf, String endereco, String telefone, String celular, int id) {
        super(nome, dataNasci, rg, cpf, endereco, telefone, celular);
    }

    @Override
    public String toString() {
        return "Cliente{" + "contaCorrente=" + contaCorrente + ", id=" + id + '}';
    }
}
