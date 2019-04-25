package com.leenadam.app.Barramento;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.leenadam.app.Declaracoes.ActivityDeclaracoes;
import com.leenadam.app.Empresa.ActivityInserirEmpresa;
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.activity.MainActivity;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.R;
import com.leenadam.app.TesteBancoActivity;
import com.leenadam.app.Usina.ActivityInserirUsina;

public class ActivityInserirBarramento extends AppCompatActivity {

    //private TextInputEditText TextInputEditText_tipobarramento;

    private TextInputEditText TextInputEditText_nomebarramento;
    private TextInputEditText TextInputEditText_dataconclusaobarramento;

    private TextInputEditText TextInputEditText_latitudebarramento;
    private TextInputEditText TextInputEditText_longitudebarramento;

    private TextInputEditText TextInputEditText_alturamacicobarramento;
    private TextInputEditText TextInputEditText_comprimentobarramento;

    private FloatingActionButton fab;


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_barragem:
                Toast.makeText(getApplicationContext(), "Tipo: Barragem", Toast.LENGTH_SHORT).show();

                break;
            case R.id.radio_dique:
                Toast.makeText(getApplicationContext(), "Tipo: Dique", Toast.LENGTH_SHORT).show();

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


        //TextInputEditText_tipobarramento = findViewById(R.id.TextInputEditText_tipobarramento);//este campo foi removido

        TextInputEditText_nomebarramento = findViewById(R.id.TextInputEditText_nomebarramento);
        TextInputEditText_dataconclusaobarramento = findViewById(R.id.TextInputEditText_dataconclusaobarramento);

        TextInputEditText_latitudebarramento = findViewById(R.id.TextInputEditText_latitudebarramento);
        TextInputEditText_longitudebarramento = findViewById(R.id.TextInputEditText_longitudebarramento);

        TextInputEditText_alturamacicobarramento = findViewById(R.id.TextInputEditText_alturamacicobarramento);
        TextInputEditText_comprimentobarramento = findViewById(R.id.TextInputEditText_comprimentobarramento);
/* comentei este bloco porque ele estava causando erro
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //precisa remover o primeiro item caso ainda utilize este bloco de códigos!
                if (!TextInputEditText_tipobarramento.getText().toString().isEmpty()){

                    if (!TextInputEditText_nomebarramento.getText().toString().isEmpty()){

                        if (!TextInputEditText_dataconclusaobarramento.getText().toString().isEmpty()){

                            if (!TextInputEditText_latitudebarramento.getText().toString().isEmpty()){

                                if (!TextInputEditText_longitudebarramento.getText().toString().isEmpty()){

                                    if (!TextInputEditText_alturamacicobarramento.getText().toString().isEmpty()){

                                        if (!TextInputEditText_comprimentobarramento.getText().toString().isEmpty()){



                                        }else{
                                            TextInputEditText_comprimentobarramento.setError("Campo Obrigatório");
                                        }

                                    }else{
                                        TextInputEditText_alturamacicobarramento.setError("Campo Obrigatório");
                                    }

                                }else{
                                    TextInputEditText_longitudebarramento.setError("Campo Obrigatório");
                                }

                            }else{
                                TextInputEditText_latitudebarramento.setError("Campo Obrigatório");
                            }

                        }else{
                            TextInputEditText_dataconclusaobarramento.setError("Campo Obrigatório");
                        }

                    }else{
                        TextInputEditText_nomebarramento.setError("Campo Obrigatório");
                    }

                }else{
                    TextInputEditText_tipobarramento.setError("Campo Obrigatório");//precisa remover o primeiro item caso ainda utilize este bloco de códigos!
                }



            }
        });
*/
        Button button = findViewById(R.id.btnBarramento);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), ActivityInfoGerais.class));

                Toast.makeText(getApplicationContext(), "Barramento cadastrado com sucesso.", Toast.LENGTH_SHORT).show();

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
        if (id == android.R.id.home) {
            finish();//encerra a activity
            return true;

        }

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