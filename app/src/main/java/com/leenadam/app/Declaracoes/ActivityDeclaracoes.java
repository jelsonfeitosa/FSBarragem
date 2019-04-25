package com.leenadam.app.Declaracoes;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.leenadam.app.Barramento.ActivityInserirBarramento;
import com.leenadam.app.Empresa.ActivityInserirEmpresa;
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.activity.MainActivity;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.R;
import com.leenadam.app.TesteBancoActivity;
import com.leenadam.app.Usina.ActivityInserirUsina;
import com.leenadam.app.helper.DateCustom;

import java.io.File;
import java.util.List;

public class ActivityDeclaracoes extends AppCompatActivity {

    private TextInputEditText campoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declaracoes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        campoData = findViewById(R.id.TextInputEditText_datadeclaracao);

        campoData.setText(DateCustom.dataAtual());

    }


    public void abrirPDF() {

        String titulo = getResources().getString(R.string.choosee_title);

        //Intent pdf = new Intent(Intent.ACTION_SEND);
        Intent pdf = new Intent(Intent.ACTION_VIEW);
        pdf.addCategory(Intent.CATEGORY_OPENABLE);
        pdf.setType("application/pdf");
        pdf.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(Intent.createChooser(pdf, titulo)); // Permite ao usuário escolher o aplicativo que deseja utilizar

    }

    String dir="/Attendancesystem";
    public void displaypdf() {

        File file = null;
        file = new File(Environment.getExternalStorageDirectory()+dir+ "/sample.pdf");

        Toast.makeText(getApplicationContext(), file.toString() , Toast.LENGTH_LONG).show();

        if(file.exists()) {
            Intent target = new Intent(Intent.ACTION_VIEW);
            target.setDataAndType(Uri.fromFile(file), "application/pdf");
            target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

            Intent intent = Intent.createChooser(target, "Open File");
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                // Instruct the user to install a PDF reader here, or something
            }
        }
        else
            Toast.makeText(getApplicationContext(), "File path is incorrect." , Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_inicio) {
            startActivity(new Intent(this, MainActivity.class));
            return true;

        }

        if (id == R.id.menu_inserirempresa) {
            startActivity(new Intent(this, ActivityInserirEmpresa.class));
            return true;

        }

        if (id == R.id.menu_inserirusina) {
            startActivity(new Intent(this, ActivityInserirUsina.class));
            return true;
        }

        if (id == R.id.menu_inserirbarramento) {
            startActivity(new Intent(this, ActivityInserirBarramento.class));
            return true;
        }

        if (id == R.id.menu_infogerais) {
            startActivity(new Intent(this, ActivityInfoGerais.class));
            return true;
        }

        if (id == R.id.menu_matrizclassificacao) {
            startActivity(new Intent(this, ActivityMatrizClassificacao.class));
            return true;
        }

        if (id == R.id.menu_declaracoes) {
            startActivity(new Intent(this, ActivityDeclaracoes.class));
            return true;
        }

        if (id == R.id.action_configuracoes) {

            return true;
        }

        if (id == R.id.action_relatorio) {
            //abrirPDF();
            //displaypdf();
            return true;
        }

        if (id == R.id.action_bd) {
            startActivity(new Intent(this, TesteBancoActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}