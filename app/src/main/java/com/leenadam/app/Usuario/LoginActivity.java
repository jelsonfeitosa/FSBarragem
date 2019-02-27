package com.leenadam.app.Usuario;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.leenadam.app.MainActivity;
import com.leenadam.app.R; //importei essa classe porque ao criar a activity deu erro na classe R

public class LoginActivity extends AppCompatActivity {

    private void alert (String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    private Context getContext(){
        return this;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Layout desta activity

        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);

                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                if ("Jelson".equals(login)&&"123".equals(senha)||"".equals(login)&&"".equals(senha)||"ricardo".equals(login)&&"123".equals(senha)){
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    Bundle params = new Bundle();
                    params.putString("nome", "Olá");
                    intent.putExtras(params);
                    startActivity(intent);

                    alert("Bem-Vindo, login realizado com sucesso.");

                }else {
                    alert("Login e/ou senha incorretos.");
                }
            }
        });

        /*Bundle args = getIntent().getExtras();
        String nome = args.getString("nome");
        //Atualiza o texto do TextView com uma mensagem de bem-vindo
        TextView text = (TextView) findViewById(R.id.text);
        text.setText(nome + ", seja bem-vindo.");
        */
    }

}
