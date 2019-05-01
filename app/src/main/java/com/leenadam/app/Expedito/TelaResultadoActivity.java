package com.leenadam.app.Expedito;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.leenadam.app.R;
import com.leenadam.app.activity.PrincipalActivity;

public class TelaResultadoActivity extends AppCompatActivity {

    private TextView txtAltura, txtVolume, txtResultadoAltura, txtResultadoReservatorio, txtResultadoPotencial, txtResultEnquadramentoExpedito, txtResultadoExpedito;

    private Button btnMais;
    private Button btnFechar;

    private ResultadoExpedito resultadoExpedito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_resultado);

        btnMais = findViewById(R.id.btnMais);
        btnFechar = findViewById(R.id.btnFechar);

        preencherDados();

        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compartilharResultado("titulo", "mensagem");

            }
        });

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                abrirTelaPrincipal();
                //finish();

            }
        });

    }

    private void preencherDados() {

        txtAltura = findViewById(R.id.txtAltura);
        txtVolume = findViewById(R.id.txtVolume);
        txtResultadoAltura = findViewById(R.id.txtResultadoAltura);
        txtResultadoReservatorio = findViewById(R.id.txtResultadoReservatorio);
        txtResultadoPotencial = findViewById(R.id.txtResultadoPotencial);
        txtResultEnquadramentoExpedito = findViewById(R.id.txtResultEnquadramentoExpedito);
        txtResultadoExpedito = findViewById(R.id.txtResultadoExpedito);

        resultadoExpedito = new ResultadoExpedito();
        Bundle b1 = getIntent().getExtras();
        resultadoExpedito = (ResultadoExpedito) b1.getSerializable("resultado");

        txtAltura.setText(Double.toString(resultadoExpedito.getAlturaMacico()));
        txtVolume.setText(Double.toString(resultadoExpedito.getVolumeReservatorio()));

        txtResultadoAltura.setText(resultadoExpedito.getEnquadramentoAltura());
        txtResultadoReservatorio.setText(resultadoExpedito.getEnquadramentoReservatorio());
        txtResultadoPotencial.setText(resultadoExpedito.getEnquadramentoPotencial());
        txtResultEnquadramentoExpedito.setText(resultadoExpedito.getEnquadramentoResultado());
        txtResultadoExpedito.setText(resultadoExpedito.getResultadoClassificacao());

        //txtResultado.setText(resultadoExpedito.getAwesomeSpinnerConfiabEstrutAducao());

    }


    public void compartilharResultado(String titulo, String mensagem) {

        String resultadoAlertDialog = "Compartilhar este resultado expedito?";

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Resultado Expedito");
        dialog.setMessage(resultadoAlertDialog);
        dialog.setIcon(R.drawable.calc_fsbarragem);
        dialog.setCancelable(true);

        dialog.setPositiveButton("Compartilhar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Este recurso ainda não está disponível.", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.create();
        dialog.show();

    }

    public void abrirTelaPrincipal() {
        startActivity(new Intent(this, PrincipalActivity.class));
    }

}
