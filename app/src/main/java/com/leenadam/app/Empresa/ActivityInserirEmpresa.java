package com.leenadam.app.Empresa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Transaction;
import com.leenadam.app.Barramento.ActivityInserirBarramento;
import com.leenadam.app.Declaracoes.ActivityDeclaracoes;
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.MainActivity;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.R;
import com.leenadam.app.TesteBancoActivity;
import com.leenadam.app.Usina.ActivityInserirUsina;

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

    /*private FloatingActionButton fab;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_empresa);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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

        /*

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!TextInputEditText_denominacao.getText().toString().isEmpty()){

                    if (!TextInputEditText_idagente.getText().toString().isEmpty()){

                        if (!TextInputEditText_enderecocorrep.getText().toString().isEmpty()){

                            if (!TextInputEditText_municipiocorrep.getText().toString().isEmpty()){

                                if (!TextInputEditText_ufcorrep.getText().toString().isEmpty()){

                                    if (!TextInputEditText_cepcorrep.getText().toString().isEmpty()){

                                        if (!TextInputEditText_nomerepresentante.getText().toString().isEmpty()){

                                            if (!TextInputEditText_emailrepresentante.getText().toString().isEmpty()){

                                                if (!TextInputEditText_telefonerepresentante.getText().toString().isEmpty()){

                                                    if (!TextInputEditText_nomeresptecnico.getText().toString().isEmpty()){

                                                        if (!TextInputEditText_emailresptecnico.getText().toString().isEmpty()){

                                                            if (!TextInputEditText_telefoneresptecnico.getText().toString().isEmpty()){

                                                                enviarDados();

                                                            }else{
                                                                TextInputEditText_telefoneresptecnico.setError("Campo Obrigatório");
                                                            }

                                                        }else{
                                                            TextInputEditText_emailresptecnico.setError("Campo Obrigatório");
                                                        }

                                                    }else{
                                                        TextInputEditText_nomeresptecnico.setError("Campo Obrigatório");
                                                    }

                                                }else{
                                                    TextInputEditText_telefonerepresentante.setError("Campo Obrigatório");
                                                }

                                            }else{
                                                TextInputEditText_emailrepresentante.setError("Campo Obrigatório");
                                            }

                                        }else{
                                            TextInputEditText_nomerepresentante.setError("Campo Obrigatório");
                                        }

                                    }else{
                                        TextInputEditText_cepcorrep.setError("Campo Obrigatório");
                                    }

                                }else{
                                    TextInputEditText_ufcorrep.setError("Campo Obrigatório");
                                }

                            }else{
                                TextInputEditText_municipiocorrep.setError("Campo Obrigatório");
                            }

                        }else{
                            TextInputEditText_enderecocorrep.setError("Campo Obrigatório");
                        }

                    }else{
                        TextInputEditText_idagente.setError("Campo Obrigatório");
                    }


                }else{
                    TextInputEditText_denominacao.setError("Campo Obrigatório");
                }

            }
        });

        */
        //Cria condicional com aviso para campos que ficarem sem o devido preenchimento
        View rootView = findViewById(android.R.id.content);

        final List<TextInputLayout> textInputLayouts = Utils.findViewsWithType(
                rootView, TextInputLayout.class);

        Button button = findViewById(R.id.button2);
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
                    enviarDados(); // Chama o método para enviar dados para o Firebase
                }
            }
        });
    }

//Método para enviar dados para o Firebase
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        if (id == R.id.action_bd) {
            startActivity(new Intent(this, TesteBancoActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
