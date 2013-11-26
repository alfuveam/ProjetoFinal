
package br.com.felipeborges.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Felipe
 */
@Entity
public class Cidade {
    @ManyToOne
    private Estado cduf;
    @Id
    private int cdcidade;
    private String dscidadenome;

    public Estado getCd_uf() {
        return cduf;
    }

    public void setCd_uf(Estado cduf) {
        this.cduf = cduf;
    }

    public int getCd_cidade() {
        return cdcidade;
    }

    public void setCd_cidade(int cdcidade) {
        this.cdcidade = cdcidade;
    }

    public String getDs_cidade_nome() {
        return dscidadenome;
    }

    public void setDs_cidade_nome(String dscidadenome) {
        this.dscidadenome = dscidadenome;
    }

    @Override
    public String toString() {
        return  dscidadenome;
    }
}