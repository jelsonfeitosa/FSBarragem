package com.leenadam.app.Barramento;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.leenadam.app.Declaracoes.ActivityDeclaracoes;
import com.leenadam.app.Empresa.ActivityInserirEmpresa;
import com.leenadam.app.Empresa.Utils;
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.Relatorio.TelaRelatorioActivity;
import com.leenadam.app.activity.MainActivity;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.R;
import com.leenadam.app.TesteBancoActivity;
import com.leenadam.app.Usina.ActivityInserirUsina;

import java.util.List;

public class ActivityInserirBarramento extends AppCompatActivity {

    private String tipoBarramento = "";

    private TextInputEditText TextInputEditText_nomebarramento;
    private TextInputEditText TextInputEditText_dataconclusaobarramento;

    private TextInputEditText TextInputEditText_latitudebarramento;
    private TextInputEditText TextInputEditText_longitudebarramento;

    private TextInputEditText TextInputEditText_alturamacicobarramento;
    private TextInputEditText TextInputEditText_comprimentobarramento;

    private Button btnCancelarBarramento;


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_barragem:
                if (checked) {
                    tipoBarramento = "Barragem";
                    Toast.makeText(getApplicationContext(), "Tipo: Barragem", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_dique:
                if (checked) {
                    tipoBarramento = "Dique";
                    Toast.makeText(getApplicationContext(), "Tipo: Dique", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_barramento);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextInputEditText_nomebarramento = findViewById(R.id.TextInputEditText_nomebarramento);
        TextInputEditText_dataconclusaobarramento = findViewById(R.id.TextInputEditText_dataconclusaobarramento);

        TextInputEditText_latitudebarramento = findViewById(R.id.TextInputEditText_latitudebarramento);
        TextInputEditText_longitudebarramento = findViewById(R.id.TextInputEditText_longitudebarramento);

        TextInputEditText_alturamacicobarramento = findViewById(R.id.TextInputEditText_alturamacicobarramento);
        TextInputEditText_comprimentobarramento = findViewById(R.id.TextInputEditText_comprimentobarramento);

        btnCancelarBarramento = findViewById(R.id.btnCancelarBarramento);

        //Cria condicional com aviso para campos que ficarem sem o devido preenchimento
        View rootView = findViewById(android.R.id.content);

        final List<TextInputLayout> textInputLayouts = Utils.findViewsWithType(
                rootView, TextInputLayout.class);

        Button button = findViewById(R.id.btnBarramento);

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

                if ((noErrors) && (tipoBarramento != "")) {
                    // Se a condição acima for atendida então os campos estarão validados!
                    //enviarDados(); // Chama o método para enviar dados para o Firebase - comentado por enquanto, logo não irá guardar os dados no firestore
                    startActivity(new Intent(getApplicationContext(), ActivityInfoGerais.class));

                    Toast.makeText(getApplicationContext(), "Barramento cadastrado com sucesso.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Verifique o tipo e barramento e o(s) campo(s) vazio(s)", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                }
            }
        });

        btnCancelarBarramento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aviso ao usuário
                String resultadoAlertDialog = "Você está prestes a perder os dados inseridos nesta tela.";
                AlertDialog.Builder dialog = new AlertDialog.Builder(ActivityInserirBarramento.this);

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
            //startActivity(new Intent(this, TelaRelatorioActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}