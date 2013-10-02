package br.com.modelo.produtos;

public class Roupa {

    private double tamanhoNum;
    private String tamanhoLetra;
    private String modeloRoupa;
    private String tipoModelo; //Moda Homen,Feminina,Infantil
    private int quant;
    private int id;

    public Roupa() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getTamanhoNum() {
        return tamanhoNum;
    }

    public void setTamanhoNum(double tamanhoNum) {
        this.tamanhoNum = tamanhoNum;
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
        return "Roupa{" + "tamanhoNum=" + tamanhoNum + ", tamanhoLetra=" + tamanhoLetra + ", modeloRoupa=" + modeloRoupa + ", tipoModelo=" + tipoModelo + ", quant=" + quant + ", id=" + id + ", nome=" + nome + '}';
    }
}
