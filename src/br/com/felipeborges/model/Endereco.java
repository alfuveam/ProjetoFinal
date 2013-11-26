
package br.com.felipeborges.model;

import javax.persistence.Entity;

/**
 *
 * @author Felipe Borges Tomaz
 */

public class Endereco {
    private String rua;
    private String cep;
    private String cidade;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
