package com.leenadam.app.Barramento;

public class DadosBarramento {

    private String tipoBarramento; //Barragem ou Dique

    private String nomeBarramento;
    private String dataConclusaoBarramento;

    //Verificar como colocar as coordenadas geográficas com: grau, minuto, segundo e as direções norte, sul e oeste segundo o FSB!
    private double coordenadasGeograficasBarramento;
    private double latitudeBarramento; //grau, minuto e segundo - Norte e Sul
    private double longitudeBarramento; //grau, minuto e segundo - Oeste

    private double alturaMacicoBarramento;
    private double comprimentoBarramento;

    public String getTipoBarramento() {
        return tipoBarramento;
    }

    public void setTipoBarramento(String tipoBarramento) {
        this.tipoBarramento = tipoBarramento;
    }

    public String getNomeBarramento() {
        return nomeBarramento;
    }

    public void setNomeBarramento(String nomeBarramento) {
        this.nomeBarramento = nomeBarramento;
    }

    public String getDataConclusaoBarramento() {
        return dataConclusaoBarramento;
    }

    public void setDataConclusaoBarramento(String dataConclusaoBarramento) {
        this.dataConclusaoBarramento = dataConclusaoBarramento;
    }

    public double getCoordenadasGeograficasBarramento() {
        return coordenadasGeograficasBarramento;
    }

    public void setCoordenadasGeograficasBarramento(double coordenadasGeograficasBarramento) {
        this.coordenadasGeograficasBarramento = coordenadasGeograficasBarramento;
    }

    public double getLatitudeBarramento() {
        return latitudeBarramento;
    }

    public void setLatitudeBarramento(double latitudeBarramento) {
        this.latitudeBarramento = latitudeBarramento;
    }

    public double getLongitudeBarramento() {
        return longitudeBarramento;
    }

    public void setLongitudeBarramento(double longitudeBarramento) {
        this.longitudeBarramento = longitudeBarramento;
    }

    public double getAlturaMacicoBarramento() {
        return alturaMacicoBarramento;
    }

    public void setAlturaMacicoBarramento(double alturaMacicoBarramento) {
        this.alturaMacicoBarramento = alturaMacicoBarramento;
    }

    public double getComprimentoBarramento() {
        return comprimentoBarramento;
    }

    public void setComprimentoBarramento(double comprimentoBarramento) {
        this.comprimentoBarramento = comprimentoBarramento;
    }
}