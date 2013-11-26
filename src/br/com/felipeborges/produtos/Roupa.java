package br.com.felipeborges.produtos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Roupa {

    @Id
    @GeneratedValue
    private int idRoupa;
    private String nomeRoupa;
    private double valorUnitario;
    private int quant;
    private String tamanhoEUA; // Para inserir depois
    private String tamanhoLetra;
    private String modeloRoupa;
    private String tipoModelo; //Moda Homen,Feminina,Infantil
    private String descricaoRoupa;

    public String getNomeRoupa() {
        return nomeRoupa;
    }

    public void setNomeRoupa(String nomeRoupa) {
        this.nomeRoupa = nomeRoupa;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getDescricaoRoupa() {
        return descricaoRoupa;
    }

    public void setDescricaoRoupa(String descricaoRoupa) {
        this.descricaoRoupa = descricaoRoupa;
    }

    public int getIdRoupa() {
        return idRoupa;
    }

    public void setIdRoupa(int idRoupa) {
        this.idRoupa = idRoupa;
    }

    public Roupa() {
    }

    public int getidRoupa() {
        return idRoupa;
    }

    public void setidRoupa(int id) {
        this.idRoupa = id;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    private String nome;

    public String getTamanhoEUA() {
        return tamanhoEUA;
    }

    public void setTamanhoNum(String tamanhoEUA) {
        this.tamanhoEUA = tamanhoEUA;
    }

    public String getTamanhoLetra() {
        return tamanhoLetra;
    }

    public void setTamanhoLetra(String tamanhoLetra) {
        this.tamanhoLetra = tamanhoLetra;
    }

    public String getModeloRoupa() {
        return modeloRoupa;
    }

    public void setModeloRoupa(String modeloRoupa) {
        this.modeloRoupa = modeloRoupa;
    }

    public String getTipoModelo() {
        return tipoModelo;
    }

    public void setTipoModelo(String tipoModelo) {
        this.tipoModelo = tipoModelo;
    }

    @Override
    public String toString() {
        return "Roupa{" + "tamanho Roupa EUA=" + tamanhoEUA + ", tamanhoLetra=" + tamanhoLetra + ", modeloRoupa=" + modeloRoupa + ", tipoModelo=" + tipoModelo + ", quant=" + quant + ", id=" + idRoupa + ", nome=" + nome + '}';
    }
}
