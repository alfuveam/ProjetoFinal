package br.com.modelo.produtos;

public class Aviamentos {

    private int quantidade;
    private String modelo;
    private String nome;
    private int id;

    public Aviamentos() {
    }

    @Override
    public String toString() {
        return "Aviamentos{" + "quantidade=" + quantidade + ", modelo=" + modelo + ", nome=" + nome + ", id=" + id + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}