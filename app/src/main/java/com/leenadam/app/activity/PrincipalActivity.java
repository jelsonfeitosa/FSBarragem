package com.leenadam.app.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

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
import com.leenadam.app.fragments.FormularioFragment;
import com.leenadam.app.fragments.PrincipalFragment;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth autenticacao;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        frameLayout = findViewById(R.id.frameContainer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Esse é aquele símbolo do drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Isso faz com que, por padrão, sempre carregue o fragment da empresa, caso contrario não apareceria nada... poderia ser outra!
        PrincipalFragment principalFragment = new PrincipalFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer, principalFragment);
        fragmentTransaction.commit();

    }

    // Esse método faz com que, ao clicar no botão voltar, fechemos o navigation drawer
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_principal) {

            PrincipalFragment principalFragment = new PrincipalFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, principalFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_configuracoes) {

        } else if (id == R.id.nav_creditos) {
            startActivity(new Intent(this, CreditosActivity.class));

        } else if (id == R.id.nav_contato) {
            enviarEmail();

        } else if (id == R.id.nav_sobre) {
            startActivity(new Intent(this, SobreActivity.class));

        } else if (id == R.id.nav_formularios) {

            FormularioFragment formularioFragment = new FormularioFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, formularioFragment);
            fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START); // Isso faz com que após selecionar o item, seja fechado o menu drawer
        return true;
    }

    public void enviarEmail() {

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"fsbarragem@gmail.com"}); //aqui temos um array onde é possível configurar vários email's, neste caso utilizou-se apenas 01 email!
        email.putExtra(Intent.EXTRA_SUBJECT, "Aplicativo FSBarragem"); // para o título da mensagem
        email.putExtra(Intent.EXTRA_TEXT, "Digite sua mensagem aqui"); // a mensagem do email

        //configurar apps para e-mail
        email.setType("message/rfc822"); // esse código permite ao app abrir apenas aplicativos de email existentes no device
        //email.setType("application/pdf");
        //email.setType("image/png");

        startActivity(Intent.createChooser(email, "Escolha o aplicativo de e-mail:")); // Permite ao usuário escolher o aplicativo que deseja utilizar

    }


    //métodos chamados pelo floating action menu
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

