package com.leenadam.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.leenadam.app.Barramento.ActivityInserirBarramento;
import com.leenadam.app.Declaracoes.ActivityDeclaracoes;
import com.leenadam.app.Empresa.ActivityInserirEmpresa;
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.R;
import com.leenadam.app.TesteBancoActivity;
import com.leenadam.app.Usina.ActivityInserirUsina;
import com.leenadam.app.config.ConfiguracaoFirebase;

public class PrincipalActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void adicionarEmpresa(View view) {
        startActivity(new Intent(this, ActivityInserirEmpresa.class));
    }

    public void adicionarUsina(View view) {
        startActivity(new Intent(this, ActivityInserirUsina.class));
    }

    public void adicionarBarramento(View view) {
        startActivity(new Intent(this, ActivityInserirBarramento.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    //Menu
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

        if (id == R.id.menuSair) {
            autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
            autenticacao.signOut();
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

