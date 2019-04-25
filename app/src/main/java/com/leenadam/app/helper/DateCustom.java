package com.leenadam.app.helper;

import java.text.SimpleDateFormat;

public class DateCustom {

    public static String dataAtual (){

        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");//no link da aula existem mais formatos de letras que podem ser utilizados - "dd/MM/yyyy hh:mm:ss"
        String dataString = simpleDateFormat.format(data);
        return dataString;

    }

    public static String mesAnoDataEscolhida (String data){

        String retornoData[] = data.split("/");//o "split" quebra a string em partes conforme o simbolo separador!
        String dia = retornoData[0];
        String mes = retornoData[1];
        String ano = retornoData[2];

        String mesAno = mes + ano;
        return mesAno;

    }

}
