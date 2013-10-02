
package br.com.modelo.produtos;

import java.util.Date;

public class MateriaPrima {
    private String modelo;
    private int quantidade;
    private String cor;
    private double tamanho;
    private Date horaEntrada;
    private String nome;
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "MateriaPrima{" + "modelo=" + modelo + ", quantidade=" + quantidade + ", cor=" + cor + ", tamanho=" + tamanho + '}';
    }
}
