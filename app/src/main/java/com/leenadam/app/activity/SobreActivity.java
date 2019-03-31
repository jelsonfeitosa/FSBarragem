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

        //setContentView(R.layout.activity_sobre); // Como não vamos utilizar esta activity, então ela está comentada
        // vamos utilizar a biblioteca do github que foi implementada, para montagem do layout
        String descricao = "O aplicativo FSBarragem tem como objetivo estimular os órgãos fiscalizadores de barragens do Brasil e demais entidades a desenvolverem novas tecnologias que facilitem a inspeção de barragens.\n\n" +
                "O grupo de pesquisa de Mecânica dos Solos do curso de Engenharia Civil da Universidade Federal de Roraima já vinha tratando sobre o desenvolvimento desta ferramenta antes mesmo do rompimento da Barragem no Córrego do Feijão, em Brumadinho.";

        // toda essa linha foi criada mas poderia pegar do github ctrl+c ctrl+v e adaptar!
        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo_ufrr) //configura a imagem que fica no topo da activity
                .setDescription( descricao ) //permite um campo para a descrição da activity, criou-se a variável string "descrição" para chamá-la aqui!
                .addGroup("Fale conosco") // configura um grupo chamado: "Fale Conosco"
                .addEmail("fsbarragem@gmail.com", "Envie um e-mail") // permite a opção de enviar email já configurada por padrão!
                .addWebsite("http://ufrr.br/engcivil/", "Acesse nosso site") // permite colocar o site da empresa. No caso, como é uma empresa fictícia, colocou-se o site da google.
                .addGroup("Acesse nossas redes sociais") // configura um novo grupo
                .addFacebook("UFRRoficial", "Facebook" )
                //.addTwitter("google", "Twitter")
                //.addYoutube("google", "Youtube")
                //.addPlayStore("com.google.android.apps.plus", "Play Store")
                .addGitHub("jelsonfeitosa/FSBarragem", "Github")
                //.addInstagram("google", "Instagram")
                .create();

        setContentView( sobre );

    }
}
