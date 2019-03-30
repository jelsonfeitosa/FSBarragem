package com.leenadam.app;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Transaction;

import java.util.HashMap;
import java.util.Map;

public class TesteBancoActivity extends AppCompatActivity {

    protected static final String TAG = "Teste Banco de Dados";

    private FirebaseFirestore mFirestore;

    private EditText EditTextDocumento;
    private Button buttonEnviarDadosDocumento;

    private EditText EditTextTextoDocumentos;
    private Button buttonEnviarDocumento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_banco);


        // Página de configuração do Banco de dados - Conexão
        mFirestore = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        mFirestore.setFirestoreSettings(settings);

        EditTextDocumento = findViewById(R.id.EditTextDocumento);
        buttonEnviarDadosDocumento = findViewById(R.id.buttonEnviarDadosDocumento);

        EditTextTextoDocumentos = findViewById(R.id.EditTextTextoDocumentos);
        buttonEnviarDocumento = findViewById(R.id.buttonEnviarDocumento);

        buttonEnviarDadosDocumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Se o texto não for igual a nulo - Envia os dados
                if (!EditTextDocumento.getText().toString().isEmpty()) {

                    final Map<String, Object> dadosMensagem = new HashMap<>();
                    dadosMensagem.put("texto", EditTextDocumento.getText().toString());
                    dadosMensagem.put("dataCriacao", FieldValue.serverTimestamp());

                    // Faz referência somente a um documento: DocumentoTeste
                    final DocumentReference document = mFirestore
                            .collection("DOCUMENTO_TEXTO_TESTE")
                            .document("DocumentoTeste");

                    mFirestore.runTransaction(new Transaction.Function<Void>() {
                        @Override
                        public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                            transaction.set(document, dadosMensagem);
                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG, "Transaction success!");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Transaction failure.", e);
                        }
                    });

                } else {
                    Toast.makeText(getApplicationContext(), "Nenhum texto inserido", Toast.LENGTH_SHORT).show();
                }

            }
        });


        buttonEnviarDocumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Se o texto não for igual a nulo - Envia os dados
                if (!EditTextTextoDocumentos.getText().toString().isEmpty()) {

                    final Map<String, Object> dadosMensagem = new HashMap<>();
                    dadosMensagem.put("texto", EditTextTextoDocumentos.getText().toString());
                    dadosMensagem.put("dataCriacao", FieldValue.serverTimestamp());

                    // Cria uma documento de refrÊncia para cada dado enviado.
                    final DocumentReference document = mFirestore
                            .collection("DOCUMENTO_TEXTO_TESTE")
                            .document();

                    mFirestore.runTransaction(new Transaction.Function<Void>() {
                        @Override
                        public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                            transaction.set(document, dadosMensagem);
                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG, "Transaction success!");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Transaction failure.", e);
                        }
                    });

                } else {
                    Toast.makeText(getApplicationContext(), "Nenhum documento de texto inserido", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}