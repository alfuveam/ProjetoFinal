package br.com.felipeborges.financeiro;

import br.com.felipeborges.pessoa.Cliente;
import br.com.felipeborges.pessoa.Pessoa;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Venda {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Cheque cheque;
    @ManyToOne
    private ContaCorrente contaCorrente;
    @ManyToOne
    private Cliente cliente;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}