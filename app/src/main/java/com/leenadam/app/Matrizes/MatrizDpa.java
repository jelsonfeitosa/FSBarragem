package com.leenadam.app.Matrizes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.isapanah.awesomespinner.AwesomeSpinner;
import com.leenadam.app.R;

public class MatrizDpa extends AppCompatActivity {
/*
    private AwesomeSpinner AwesomeSpinnerVolumeReservatorio;
    private AwesomeSpinner AwesomeSpinnerPotencialPerdasVidas;
    private AwesomeSpinner AwesomeSpinnerImpactoAmbiental;
    private AwesomeSpinner AwesomeSpinnerImpactoSocioEconomico;

    private Button buttonEnviar;
    private TextView textResultado;


    String record1 = "";//define string variable for record1
    String record2 = "";
    String record3 = "";
    String record4 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriz_classificacao);

        textResultado = findViewById(R.id.textResultado);

        buttonEnviar = findViewById(R.id.buttonEnviar);

        //Set spinner method setOnItemSelectedListener
        AwesomeSpinnerVolumeReservatorio.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        record1 = "1";

                        break;

                    case 1:

                        record1 = "2";

                        break;

                    case 2:

                        record1 = "3";

                        break;

                    case 3:

                        record1 = "5";

                        break;

                }

            }
        });

        AwesomeSpinnerPotencialPerdasVidas.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        record2 = "0";

                        break;

                    case 1:

                        record2 = "4";

                        break;

                    case 2:

                        record2 = "8";

                        break;

                    case 3:

                        record2 = "12";

                        break;

                }

            }
        });

        AwesomeSpinnerImpactoAmbiental.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        record3 = "3";

                        break;

                    case 1:

                        record3 = "5";

                        break;


                }
            }
        });

        AwesomeSpinnerImpactoSocioEconomico.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        record4 = "0";

                        break;

                    case 1:

                        record4 = "4";

                        break;

                    case 2:

                        record4 = "8";

                        break;

                }

            }
        });




        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int valorS = Integer.parseInt(record1);
                int valorT = Integer.parseInt(record2);
                int valorU = Integer.parseInt(record3);
                int valorV = Integer.parseInt(record4);

                //Validação dos dados
                //Descobrir um método para validar os spinners



                //Faz o somatório dos campos da matriz DPA
                int dpa = (valorS + valorT + valorU + valorV);

                String dpaResult = "";
                //Faz a classificação da Matriz DPA
                if (dpa<=10){
                    dpaResult = "Baixo";
                }else if (dpa>10 && dpa<16){
                    dpaResult = "Médio";
                }else {
                    dpaResult = "Alto";
                }

                textResultado.setText(String.valueOf("O resultado é: " + dpa + "; Classificação: " + dpaResult));//Resultado

                Log.i("DPA ",  "O resultado é: " + dpa + " | Classificação: " + dpaResult);
            }
        });


    }
*/
}
