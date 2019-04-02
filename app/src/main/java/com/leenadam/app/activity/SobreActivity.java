package com.leenadam.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.leenadam.app.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String descricao = "O aplicativo FSBarragem tem como objetivo estimular os órgãos fiscalizadores de barragens do Brasil e demais entidades relacionadas a Segurança de Barragens, a continuarem desenvolvendo novas tecnologias que aperfeiçoem a inspeção de barragens.\n\n" +
                "O grupo de pesquisa de Mecânica dos Solos do curso de Engenharia Civil da Universidade Federal de Roraima, já vinha tratando sobre o desenvolvimento desta ferramenta antes mesmo do rompimento da barragem no Córrego do Feijão, em Brumadinho.";

        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo_sobre)
                .setDescription(descricao)
                .addGroup("Fale conosco")
                .addEmail("fsbarragem@gmail.com", "Envie um e-mail")
                .addWebsite("http://ufrr.br/engcivil/", "Acesse nosso site")
                .addGroup("Acesse nossas redes sociais")
                .addFacebook("UFRRoficial", "Facebook")
                //.addTwitter("google", "Twitter")
                //.addYoutube("google", "Youtube")
                .addPlayStore("com.google.android.apps.plus", "Play Store")
                .addGitHub("jelsonfeitosa/FSBarragem", "Github")
                //.addInstagram("google", "Instagram")
                .create();

        setContentView(sobre);

    }
}
