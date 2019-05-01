package com.leenadam.app.Declaracoes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.leenadam.app.Barramento.ActivityInserirBarramento;
import com.leenadam.app.Empresa.ActivityInserirEmpresa;
import com.leenadam.app.Empresa.Utils;
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.activity.MainActivity;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.R;
import com.leenadam.app.Usina.ActivityInserirUsina;
import com.leenadam.app.activity.PrincipalActivity;
import com.leenadam.app.helper.DateCustom;

import java.util.List;


public class ActivityDeclaracoes extends AppCompatActivity {

    private String declaracaoArt = "";
    private String declaracaoRl = "";

    private TextInputEditText TextInputEditText_localdeclaracao;
    private TextInputEditText TextInputEditText_datadeclaracao;

    private TextInputEditText TextInputEditText_nomerepresentantedeclaracao;
    private TextInputEditText TextInputEditText_cpfrepresentantedeclaracao;
    private TextInputEditText TextInputEditText_cargorepresentantedeclaracao;

    private TextInputEditText TextInputEditText_nometecnicodeclaracao;
    private TextInputEditText TextInputEditText_createcnicodeclaracao;
    private TextInputEditText TextInputEditText_cpftecnicodeclaracao;
    private TextInputEditText TextInputEditText_cargotecnicodeclaracao;

    private TextInputEditText campoData;


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.cbResponsavelTecnico:
                if (checked){
                    declaracaoArt = "ok";
                }
                break;
            case R.id.cbRepresentanteLegal:
                if (checked){
                    declaracaoRl = "ok";
                }
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declaracoes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextInputEditText_localdeclaracao = findViewById(R.id.TextInputEditText_localdeclaracao);
        TextInputEditText_datadeclaracao = findViewById(R.id.TextInputEditText_datadeclaracao);

        TextInputEditText_nomerepresentantedeclaracao = findViewById(R.id.TextInputEditText_nomerepresentantedeclaracao);
        TextInputEditText_cpfrepresentantedeclaracao = findViewById(R.id.TextInputEditText_cpfrepresentantedeclaracao);
        TextInputEditText_cargorepresentantedeclaracao = findViewById(R.id.TextInputEditText_cargorepresentantedeclaracao);

        TextInputEditText_nometecnicodeclaracao = findViewById(R.id.TextInputEditText_nometecnicodeclaracao);
        TextInputEditText_createcnicodeclaracao = findViewById(R.id.TextInputEditText_createcnicodeclaracao);
        TextInputEditText_cpftecnicodeclaracao = findViewById(R.id.TextInputEditText_cpftecnicodeclaracao);
        TextInputEditText_cargotecnicodeclaracao = findViewById(R.id.TextInputEditText_cargotecnicodeclaracao);

        campoData = findViewById(R.id.TextInputEditText_datadeclaracao);
        campoData.setText(DateCustom.dataAtual());//configura a data atual automaticamente

        //Cria condicional com aviso para campos que ficarem sem o devido preenchimento
        View rootView = findViewById(android.R.id.content);

        final List<TextInputLayout> textInputLayouts = Utils.findViewsWithType(
                rootView, TextInputLayout.class);

        Button button = findViewById(R.id.aceitarDeclaracao);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean noErrors = true;
                for (TextInputLayout textInputLayout : textInputLayouts) {
                    String editTextString = textInputLayout.getEditText().getText().toString();
                    if (editTextString.isEmpty()) {
                        textInputLayout.setError(getResources().getString(R.string.error_string));
                        noErrors = false;
                    } else {
                        textInputLayout.setError(null);
                    }
                }

                if ((noErrors) && (declaracaoArt != "") && (declaracaoRl != "")) {
                    //enviarDados(); // Chama o método para enviar dados para o Firebase - comentado por enquanto, logo não irá guardar os dados no firestore
                    //startActivity(new Intent(getApplicationContext(), PrincipalActivity.class));//modificar

                    Toast.makeText(getApplicationContext(), "Declaração realizada com sucesso.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Verifique o(s) campo(s) vazio(s)", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                }
            }
        });

    }

/*
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

*/


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
            //startActivity(new Intent(this, ActivityDeclaracoes.class));
            return true;
        }

        if (id == R.id.action_configuracoes) {

            return true;
        }

        if (id == R.id.action_relatorio) {
            //startActivity(new Intent(this, TelaRelatorioActivity.class));
            //abrirPDF();
            //displaypdf();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}