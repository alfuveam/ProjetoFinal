package br.com.felipeborges.financeiro;

import br.com.felipeborges.pessoa.Cliente;
import br.com.felipeborges.pessoa.Fornecedor;
import br.com.felipeborges.pessoa.Funcionario;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compra {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Cheque cheque;
   
    @ManyToOne
    private ContaCorrente contaCorrente;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Fornecedor fornecedor;
    @ManyToOne
    private Funcionario funcionario;

    public Compra() {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Compra{" + "cheque=" + cheque + ", contaCorrente=" + contaCorrente + ", cliente=" + cliente + ", fornecedor=" + fornecedor + ", funcionario=" + funcionario + '}';
    }
}
