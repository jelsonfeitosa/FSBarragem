package com.leenadam.app.Usina;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.leenadam.app.Barramento.ActivityInserirBarramento;
import com.leenadam.app.Declaracoes.ActivityDeclaracoes;
import com.leenadam.app.Empresa.ActivityInserirEmpresa;
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.activity.MainActivity;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.R;
import com.leenadam.app.TesteBancoActivity;

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

    private FloatingActionButton fab;


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
        /* comentei este bloco porque ele estava causando erro já que eu havia apagado o cód xml do fab na ActivityInserirUsina

        //trocar o "fab" pelo "button" para realizar a validação dos dados aqui, e em todas as outras telas

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextInputEditText_nomeusina.getText().toString().isEmpty()){

                    if (!TextInputEditText_idusina.getText().toString().isEmpty()){

                        if (!TextInputEditText_potenciausina.getText().toString().isEmpty()){

                            if (!TextInputEditText_nomeriousina.getText().toString().isEmpty()){

                                if (!TextInputEditText_municipiousina.getText().toString().isEmpty()){

                                    if (!TextInputEditText_estadousina.getText().toString().isEmpty()){

                                        if (!TextInputEditText_capacidadetotalusina.getText().toString().isEmpty()){

                                            if (!TextInputEditText_dataprimeiroenchimentousina.getText().toString().isEmpty()){

                                                if (!TextInputEditText_numerobarramentosusina.getText().toString().isEmpty()){



                                                }else{
                                                    TextInputEditText_numerobarramentosusina.setError("Campo Obrigatório");
                                                }

                                            }else{
                                                TextInputEditText_dataprimeiroenchimentousina.setError("Campo Obrigatório");
                                            }

                                        }else{
                                            TextInputEditText_capacidadetotalusina.setError("Campo Obrigatório");
                                        }

                                    }else{
                                        TextInputEditText_estadousina.setError("Campo Obrigatório");
                                    }

                                }else{
                                    TextInputEditText_municipiousina.setError("Campo Obrigatório");
                                }

                            }else{
                                TextInputEditText_nomeriousina.setError("Campo Obrigatório");
                            }

                        }else{
                            TextInputEditText_potenciausina.setError("Campo Obrigatório");
                        }

                    }else{
                        TextInputEditText_idusina.setError("Campo Obrigatório");
                    }

                }else{
                    TextInputEditText_nomeusina.setError("Campo Obrigatório");
                }

            }
        });
*/

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