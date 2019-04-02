package com.leenadam.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.leenadam.app.R;

import mehdi.sakout.aboutpage.AboutPage;

public class CreditosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String descricao = "FSBarragem\n" +
                "Versão 1.0 - Básica\n\n" +
                "Desenvolvido por: Jelson Feitosa Oliveira\n" +
                "\n" +
                "Utilizando a IDE Android Studio.\n" +
                "\n" +
                "Junho 2019\n" +
                "\n" +
                "Aviso: Nem o autor, nem a UFRR são responsáveis pelo uso ou mau uso do aplicativo e de seus resultados. Os acima mencionados não têm nenhum dever legal ou responsabilidade para com qualquer pessoa ou companhia pelos danos causados direta ou indiretamente resultantes do uso de alguma informação ou do uso do aplicativo aqui disponibilizado. O usuário é responsável por toda ou qualquer conclusão feita com o uso do aplicativo. Não existe nenhum compromisso de bom funcionamento ou qualquer garantia.";

        View sobre = new AboutPage(this)
                .setImage(R.drawable.creditos_app)
                .setDescription(descricao)
                .create();

        setContentView(sobre);

    }
}
