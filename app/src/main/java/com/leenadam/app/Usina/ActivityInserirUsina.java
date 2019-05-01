package com.leenadam.app.Usina;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.leenadam.app.Barramento.ActivityInserirBarramento;
import com.leenadam.app.Declaracoes.ActivityDeclaracoes;
import com.leenadam.app.Empresa.ActivityInserirEmpresa;
import com.leenadam.app.Empresa.Utils;
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.Relatorio.TelaRelatorioActivity;
import com.leenadam.app.activity.MainActivity;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.R;
import com.leenadam.app.TesteBancoActivity;
import com.leenadam.app.activity.PrincipalActivity;

import java.util.List;

public class ActivityInserirUsina extends AppCompatActivity {

    private TextInputEditText TextInputEditText_nomeusina;
    private TextInputEditText TextInputEditText_idusina;
    private TextInputEditText TextInputEditText_potenciausina;

    private TextInputEditText TextInputEditText_nomeriousina;
    private TextInputEditText TextInputEditText_municipiousina;
    private TextInputEditText TextInputEditText_estadousina;

    private TextInputEditText TextInputEditText_capacidadetotalusina;
    private TextInputEditText TextInputEditText_dataprimeiroenchimentousina;
    private TextInputEditText TextInputEditText_numerobarramentosusina;

    private Button btnCancelarUsina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_usina);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextInputEditText_nomeusina = findViewById(R.id.TextInputEditText_nomeusina);
        TextInputEditText_idusina = findViewById(R.id.TextInputEditText_idusina);
        TextInputEditText_potenciausina = findViewById(R.id.TextInputEditText_potenciausina);

        TextInputEditText_nomeriousina = findViewById(R.id.TextInputEditText_nomeriousina);
        TextInputEditText_municipiousina = findViewById(R.id.TextInputEditText_municipiousina);
        TextInputEditText_estadousina = findViewById(R.id.TextInputEditText_estadousina);

        TextInputEditText_capacidadetotalusina = findViewById(R.id.TextInputEditText_capacidadetotalusina);
        TextInputEditText_dataprimeiroenchimentousina = findViewById(R.id.TextInputEditText_dataprimeiroenchimentousina);
        TextInputEditText_numerobarramentosusina = findViewById(R.id.TextInputEditText_numerobarramentosusina);

        btnCancelarUsina = findViewById(R.id.btnCancelarUsina);


        //Cria condicional com aviso para campos que ficarem sem o devido preenchimento
        View rootView = findViewById(android.R.id.content);

        final List<TextInputLayout> textInputLayouts = Utils.findViewsWithType(
                rootView, TextInputLayout.class);

        Button button = findViewById(R.id.btnUsina);
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

                if (noErrors) {
                    // All fields are valid!
                    //enviarDados(); // Chama o método para enviar dados para o Firebase - comentado por enquanto, logo não irá guardar os dados no firestore
                    startActivity(new Intent(getApplicationContext(), ActivityInserirBarramento.class));
                    //finish();
                    Toast.makeText(getApplicationContext(), "Usina cadastrada com sucesso.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Verifique o(s) campo(s) vazio(s)", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                }
            }
        });

        btnCancelarUsina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aviso ao usuário
                String resultadoAlertDialog = "Você está prestes a perder os dados inseridos nesta tela.";
                AlertDialog.Builder dialog = new AlertDialog.Builder(ActivityInserirUsina.this);

                dialog.setTitle("Cancelar Cadastro?");
                dialog.setMessage(resultadoAlertDialog);
                //dialog.setIcon(R.drawable.calc_fsbarragem);
                dialog.setCancelable(true);

                dialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();//finaliza a atual activity. Isso é importante pois evita consumo de recursos desnecessariamente!

                        Toast.makeText(getApplicationContext(), "Cadastro cancelado", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Prossiga o cadastro", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.create();
                dialog.show();
            }
        });
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
            finish();
            return true;
        }

        if (id == R.id.menu_inserirempresa) {
            startActivity(new Intent(this, ActivityInserirEmpresa.class));
            finish();
            return true;
        }

        if (id == R.id.menu_inserirusina) {
            //startActivity(new Intent(this, ActivityInserirUsina.class));
            return true;
        }

        if (id == R.id.menu_inserirbarramento) {
            startActivity(new Intent(this, ActivityInserirBarramento.class));
            finish();
            return true;
        }

        if (id == R.id.menu_infogerais) {
            startActivity(new Intent(this, ActivityInfoGerais.class));
            finish();
            return true;
        }

        if (id == R.id.menu_matrizclassificacao) {
            startActivity(new Intent(this, ActivityMatrizClassificacao.class));
            finish();
            return true;
        }

        if (id == R.id.menu_declaracoes) {
            startActivity(new Intent(this, ActivityDeclaracoes.class));
            finish();
            return true;
        }

        if (id == R.id.action_configuracoes) {
            return true;
        }

        if (id == R.id.action_relatorio) {
            //startActivity(new Intent(this, TelaRelatorioActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}