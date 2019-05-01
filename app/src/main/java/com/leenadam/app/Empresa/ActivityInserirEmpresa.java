package com.leenadam.app.Empresa;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Transaction;
import com.leenadam.app.Barramento.ActivityInserirBarramento;
import com.leenadam.app.Declaracoes.ActivityDeclaracoes;
import com.leenadam.app.Expedito.ClassificacaoExpeditaActivity;
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.Relatorio.TelaRelatorioActivity;
import com.leenadam.app.activity.MainActivity;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.R;
import com.leenadam.app.TesteBancoActivity;
import com.leenadam.app.Usina.ActivityInserirUsina;
import com.leenadam.app.activity.PrincipalActivity;
import com.leenadam.app.config.ConfiguracaoFirebase;
import com.leenadam.app.helper.Base64Custom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityInserirEmpresa extends AppCompatActivity {

    private FirebaseFirestore mFirestore;

    private static final String TAG = "ActivityInserirEmpresa";

    private TextInputEditText TextInputEditText_denominacao;
    private TextInputEditText TextInputEditText_idagente;

    private TextInputEditText TextInputEditText_enderecocorrep;
    private TextInputEditText TextInputEditText_municipiocorrep;
    private TextInputEditText TextInputEditText_ufcorrep;
    private TextInputEditText TextInputEditText_cepcorrep;

    private TextInputEditText TextInputEditText_nomerepresentante;
    private TextInputEditText TextInputEditText_emailrepresentante;
    private TextInputEditText TextInputEditText_telefonerepresentante;

    private TextInputEditText TextInputEditText_nomeresptecnico;
    private TextInputEditText TextInputEditText_emailresptecnico;
    private TextInputEditText TextInputEditText_telefoneresptecnico;

    private Button btnCancelarEmpresa;

    /*private FloatingActionButton fab;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_empresa);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//adiciona o botão "up navigation"


        // Página de configuração do Banco de dados - Conexão
        mFirestore = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        mFirestore.setFirestoreSettings(settings);


        TextInputEditText_denominacao = findViewById(R.id.TextInputEditText_denominacao);
        TextInputEditText_idagente = findViewById(R.id.TextInputEditText_idagente);

        TextInputEditText_enderecocorrep = findViewById(R.id.TextInputEditText_enderecocorrep);
        TextInputEditText_municipiocorrep = findViewById(R.id.TextInputEditText_municipiocorrep);
        TextInputEditText_ufcorrep = findViewById(R.id.TextInputEditText_ufcorrep);
        TextInputEditText_cepcorrep = findViewById(R.id.TextInputEditText_cepcorrep);

        TextInputEditText_nomerepresentante = findViewById(R.id.TextInputEditText_nomerepresentante);
        TextInputEditText_emailrepresentante = findViewById(R.id.TextInputEditText_emailrepresentante);
        TextInputEditText_telefonerepresentante = findViewById(R.id.TextInputEditText_telefonerepresentante);

        TextInputEditText_nomeresptecnico = findViewById(R.id.TextInputEditText_nomeresptecnico);
        TextInputEditText_emailresptecnico = findViewById(R.id.TextInputEditText_emailresptecnico);
        TextInputEditText_telefoneresptecnico = findViewById(R.id.TextInputEditText_telefoneresptecnico);

        btnCancelarEmpresa = findViewById(R.id.btnCancelarEmpresa);


        //Cria condicional com aviso para campos que ficarem sem o devido preenchimento
        View rootView = findViewById(android.R.id.content);

        final List<TextInputLayout> textInputLayouts = Utils.findViewsWithType(
                rootView, TextInputLayout.class);

        Button button = findViewById(R.id.btnEmpresa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**/
                //bloco de codigos comentados temporariamente para fins de testes
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
                    startActivity(new Intent(getApplicationContext(), ActivityInserirUsina.class));
                    //finish();

                    Toast.makeText(getApplicationContext(), "Empresa cadastrada com sucesso.", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Verifique o(s) campo(s) vazio(s)", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                }

                //startActivity(new Intent(getApplicationContext(), ActivityInserirUsina.class));//linha de codigo comentada porque ativei a validação de dados logo acima
                //Toast.makeText(getApplicationContext(), "Empresa cadastrada com sucesso.", Toast.LENGTH_SHORT).show();

            }
        });


        btnCancelarEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aviso ao usuário
                String resultadoAlertDialog = "Você está prestes a perder os dados inseridos nesta tela.";
                AlertDialog.Builder dialog = new AlertDialog.Builder(ActivityInserirEmpresa.this);

                dialog.setTitle("Cancelar Cadastro?");
                dialog.setMessage(resultadoAlertDialog);
                //dialog.setIcon(R.drawable.calc_fsbarragem);
                dialog.setCancelable(true);

                dialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(ActivityInserirEmpresa.this, PrincipalActivity.class));
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


    /*---------------------------------Botão cancelar classificação expedita----------------------------------*/


    //Método para enviar dados para o Firebase Cloud Firestore
    private void enviarDados() {

        final Map<String, Object> dados = new HashMap<>();

        dados.put("nomeEmpresa", TextInputEditText_denominacao.getText().toString());
        dados.put("idAneelAgente", TextInputEditText_idagente.getText().toString()); //passível de alteração no tipo de dado

        dados.put("enderecoEmpresa", TextInputEditText_enderecocorrep.getText().toString());
        dados.put("municipio", TextInputEditText_municipiocorrep.getText().toString());
        dados.put("estado", TextInputEditText_ufcorrep.getText().toString());
        dados.put("codPostal", TextInputEditText_cepcorrep.getText().toString()); //passível de alteração no tipo de dado

        dados.put("nomeRepresentante", TextInputEditText_nomerepresentante.getText().toString());
        dados.put("emailRepresentante", TextInputEditText_emailrepresentante.getText().toString());
        dados.put("telefoneRepresentante", TextInputEditText_telefonerepresentante.getText().toString()); //passível de alteração no tipo de dado

        dados.put("reponsavelTecnico", TextInputEditText_nomeresptecnico.getText().toString());
        dados.put("emailReponsavelTecnico", TextInputEditText_emailresptecnico.getText().toString());
        dados.put("telefoneResponsavelTecnico", TextInputEditText_telefoneresptecnico.getText().toString()); //passível de alteração no tipo de dado

        dados.put("dataCriacao", FieldValue.serverTimestamp());

        // Cria um documento de referência, dentro de uma coleção, para cada dado enviado.
        final DocumentReference document = mFirestore
                .collection("Empresas")
                .document();

        mFirestore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                transaction.set(document, dados);
                return null;
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "Transaction success!");
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Transaction failure.", e);
            }
        });

    }

//Este menu é temporário. A finalidade, no momento, é para facilitar o trabalho de desenvolvimento ao conferir os resultados durante a emulação do app no aparelho. Futuramente, é possível manter o menu, porém, com outros itens/finalidades que ainda não foram pensados...

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
            //startActivity(new Intent(this, ActivityInserirEmpresa.class));
            //finish();
            return true;
        }

        if (id == R.id.menu_inserirusina) {
            startActivity(new Intent(this, ActivityInserirUsina.class));
            finish();
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
            //finish();
            return true;
        }

        if (id == R.id.action_relatorio) {
            //startActivity(new Intent(this, TelaRelatorioActivity.class));
            //finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}