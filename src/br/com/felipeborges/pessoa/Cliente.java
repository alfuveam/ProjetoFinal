package br.com.felipeborges.pessoa;

import br.com.felipeborges.financeiro.ContaCorrente;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue
    private int cliente;
    @ManyToOne
    private ContaCorrente contaCorrente;

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente{" + "contaCorrente=" + contaCorrente + '}';
    }    
}