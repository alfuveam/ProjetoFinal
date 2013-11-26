package br.com.felipeborges.pessoa;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fornecedor extends Pessoa {
    
    @Id
    @GeneratedValue
    private int IdFornecedor;
    private String cnpj;
    private String ie;
    
    private String tipo;

    public int getIdFornecedor() {
        return IdFornecedor;
    }

    public void setIdFornecedor(int IdFornecedor) {
        this.IdFornecedor = IdFornecedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Fornecedor() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "cnpj=" + cnpj + ", ie=" + ie + ", tipo=" + tipo + '}';
    }
}