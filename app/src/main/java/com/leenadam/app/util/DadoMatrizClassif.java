package com.leenadam.app.util;


public class DadoMatrizClassif {

    private String desc;
    private int valor;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    /*bloco comentado*/
    public DadoMatrizClassif(String descricao, int valorClassif) {
        this.desc = descricao;
        this.valor = valorClassif;
    }

    @Override
    public String toString() {
        return "DadoMatrizClassifc{" +
                "name='" + desc + '\'' +
                ", lastName='" + desc + '\'' +
                '}';
    }


}
