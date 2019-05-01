package com.leenadam.app.RelatorioPrevia;

import java.io.Serializable;

public class ResultadoPreviaRelatorio implements Serializable {

    private Double alturaMacico;
    private Double volumeReservatorio;
    private String potencial;
    private String resultado;

    private int somatorioCt;
    private int somatorioEc;
    private int somatorioPs;
    private int somatorioCri;
    private String criResult;

    private int somatorioDpa;
    private String dpaResult;

    private String enquadramentoAltura;
    private String enquadramentoReservatorio;
    private String enquadramentoPotencial;
    private String enquadramentoResultado;
    private String resultadoClassificacao;


    private String AwesomeSpinnerConfiabEstrutAducao;


    public ResultadoPreviaRelatorio() {
    }


    //esse dado virá do barramento cadastrado!
    public Double getAlturaMacico() {
        return alturaMacico;
    }

    public void setAlturaMacico(Double alturaMacico) {
        this.alturaMacico = alturaMacico;
    }

    //esse dado virá da usina cadastrada!
    public Double getVolumeReservatorio() {
        return volumeReservatorio;
    }

    public void setVolumeReservatorio(Double volumeReservatorio) {
        this.volumeReservatorio = volumeReservatorio;
    }

    public String getPotencial() {
        return potencial;
    }

    public void setPotencial(String potencial) {
        this.potencial = potencial;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getSomatorioCt() {
        return somatorioCt;
    }

    public void setSomatorioCt(int somatorioCt) {
        this.somatorioCt = somatorioCt;
    }

    public int getSomatorioEc() {
        return somatorioEc;
    }

    public void setSomatorioEc(int somatorioEc) {
        this.somatorioEc = somatorioEc;
    }

    public int getSomatorioPs() {
        return somatorioPs;
    }

    public void setSomatorioPs(int somatorioPs) {
        this.somatorioPs = somatorioPs;
    }

    public int getSomatorioCri() {
        return somatorioCri;
    }

    public void setSomatorioCri(int somatorioCri) {
        this.somatorioCri = somatorioCri;
    }

    public String getCriResult() {
        return criResult;
    }

    public void setCriResult(String criResult) {
        this.criResult = criResult;
    }

    public int getSomatorioDpa() {
        return somatorioDpa;
    }

    public void setSomatorioDpa(int somatorioDpa) {
        this.somatorioDpa = somatorioDpa;
    }

    public String getDpaResult() {
        return dpaResult;
    }

    public void setDpaResult(String dpaResult) {
        this.dpaResult = dpaResult;
    }


    public String getEnquadramentoAltura() {
        return enquadramentoAltura;
    }

    public void setEnquadramentoAltura(String enquadramentoAltura) {
        this.enquadramentoAltura = enquadramentoAltura;
    }

    public String getEnquadramentoReservatorio() {
        return enquadramentoReservatorio;
    }

    public void setEnquadramentoReservatorio(String enquadramentoReservatorio) {
        this.enquadramentoReservatorio = enquadramentoReservatorio;
    }

    public String getEnquadramentoPotencial() {
        return enquadramentoPotencial;
    }

    public void setEnquadramentoPotencial(String enquadramentoPotencial) {
        this.enquadramentoPotencial = enquadramentoPotencial;
    }

    public String getEnquadramentoResultado() {
        return enquadramentoResultado;
    }

    public void setEnquadramentoResultado(String enquadramentoResultado) {
        this.enquadramentoResultado = enquadramentoResultado;
    }

    public String getResultadoClassificacao() {
        return resultadoClassificacao;
    }

    public void setResultadoClassificacao(String resultadoClassificacao) {
        this.resultadoClassificacao = resultadoClassificacao;
    }

    public String getAwesomeSpinnerConfiabEstrutAducao() {
        return AwesomeSpinnerConfiabEstrutAducao;
    }

    public void setAwesomeSpinnerConfiabEstrutAducao(String awesomeSpinnerConfiabEstrutAducao) {
        AwesomeSpinnerConfiabEstrutAducao = awesomeSpinnerConfiabEstrutAducao;
    }

    public String toString() {
        return
                "\nResultado: " + resultado;
    }

}
