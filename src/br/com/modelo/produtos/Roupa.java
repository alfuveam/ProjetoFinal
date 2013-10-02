
package br.com.modelo.produtos;

public class Roupa{
    private double tamanhoNum;
    private String tamanhoLetra;
    private String modeloRoupa;
    private String tipoModelo; //Moda Homen,Feminina,Infantil
    private int quant;
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
}
