package com.leenadam.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.leenadam.app.Barramento.ActivityInserirBarramento;
import com.leenadam.app.Declaracoes.ActivityDeclaracoes;
import com.leenadam.app.Empresa.ActivityInserirEmpresa;
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.Usina.ActivityInserirUsina;
import com.leenadam.app.R;
import com.leenadam.app.Usuario.CadastroActivity;
import com.leenadam.app.Usuario.LoginActivity;
import com.leenadam.app.activity.PrincipalActivity;
import com.leenadam.app.config.ConfiguracaoFirebase;

public class MainActivity extends IntroActivity {

    private FirebaseFirestore mFirestore;
    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        // Página de configuração do Banco de dados - Conexão
        FirebaseApp.initializeApp(this);

        mFirestore = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        mFirestore.setFirestoreSettings(settings);


        //configurando as setas do slider
        setButtonBackVisible(false);
        setButtonNextVisible(false);

        //Método utilizando o "Fragment slide"
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_1)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_2)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_3)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_cadastro)
                .canGoForward(false)//impede, ou não(true or false), que ao deslizar o ultimo slide, "saia do app"
                //.canGoBackward(true)//impede, ou não(true or false), que ao deslizar o ultimo slide, volte ao anterior
                .build());

    }


    @Override
    protected void onStart() {
        super.onStart();
        verificarUsuarioLogado();
    }

    //método para entrar "Já tenho uma conta"
    public void btEntrar(View view) {
        startActivity(new Intent(this, LoginActivity.class));

    }

    //método para o botão cadastrar
    public void btCadastrar(View view) {
        startActivity(new Intent(this, CadastroActivity.class));

    }

    //método que será chamado logo que os sliders forem carregados
    public void verificarUsuarioLogado() {
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        //autenticacao.signOut();

        if (autenticacao.getCurrentUser() != null) {
            abrirTelaPrincipal();
        }
    }

    //Método para abrir a tela principal
    public void abrirTelaPrincipal() {
        startActivity(new Intent(this, PrincipalActivity.class));
    }

}