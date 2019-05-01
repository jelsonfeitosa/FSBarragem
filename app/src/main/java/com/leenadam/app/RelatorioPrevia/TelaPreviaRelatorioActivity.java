package com.leenadam.app.RelatorioPrevia;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.leenadam.app.Declaracoes.ActivityDeclaracoes;
import com.leenadam.app.Expedito.ResultadoExpedito;
import com.leenadam.app.R;
import com.leenadam.app.activity.PrincipalActivity;

public class TelaPreviaRelatorioActivity extends AppCompatActivity {

    private TextView txtAlturaPrevia, txtVolumePrevia, txtResultadoAlturaPrevia, txtResultadoReservatorioPrevia, txtResultadoPotencialPrevia, txtResultEnquadramentoPrevia, txtResultadoPrevia;

    private Button btnMaisTelaPrevia;

    private ResultadoPreviaRelatorio resultadoPreviaRelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previa_relatorio);

        btnMaisTelaPrevia = findViewById(R.id.btnMaisTelaPrevia);//renomear

        preencherDados();

        btnMaisTelaPrevia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(TelaPreviaRelatorioActivity.this, "Aeeeee,CLICOU!!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    //modificar este metodo
    private void preencherDados() {

        txtAlturaPrevia = findViewById(R.id.txtAlturaPrevia);
        txtVolumePrevia = findViewById(R.id.txtVolumePrevia);
        txtResultadoAlturaPrevia = findViewById(R.id.txtResultadoAlturaPrevia);
        txtResultadoReservatorioPrevia = findViewById(R.id.txtResultadoReservatorioPrevia);
        txtResultadoPotencialPrevia = findViewById(R.id.txtResultadoPotencialPrevia);
        txtResultEnquadramentoPrevia = findViewById(R.id.txtResultEnquadramentoPrevia);
        txtResultadoPrevia = findViewById(R.id.txtResultadoPrevia);

        resultadoPreviaRelatorio = new ResultadoPreviaRelatorio();
        Bundle b1 = getIntent().getExtras();
        resultadoPreviaRelatorio = (ResultadoPreviaRelatorio) b1.getSerializable("classificacao");

        //txtAltura.setText(Double.toString(resultadoPreviaRelatorio.getAlturaMacico()));
        //txtVolume.setText(Double.toString(resultadoPreviaRelatorio.getVolumeReservatorio()));

        //txtResultadoAlturaPrevia.setText(resultadoPreviaRelatorio.getEnquadramentoAltura());
        //txtResultadoReservatorioPrevia.setText(resultadoPreviaRelatorio.getEnquadramentoReservatorio());

        txtResultadoPotencialPrevia.setText(resultadoPreviaRelatorio.getEnquadramentoPotencial());
        txtResultEnquadramentoPrevia.setText(resultadoPreviaRelatorio.getEnquadramentoResultado());
        txtResultadoPrevia.setText(resultadoPreviaRelatorio.getResultadoClassificacao());

    }
/*
    //apagar ou modificar este metodo
    public void compartilharResultado(String titulo, String mensagem) {

        String resultadoAlertDialog = "Compartilhar este resultado prévio?";

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Resultado prévio");
        dialog.setMessage(resultadoAlertDialog);
        //dialog.setIcon(R.drawable.calc_fsbarragem);//modificar
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
*/
}
