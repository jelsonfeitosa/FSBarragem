package com.leenadam.app.Usuario;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.leenadam.app.R;
import com.leenadam.app.activity.PrincipalActivity;
import com.leenadam.app.config.ConfiguracaoFirebase;

public class LoginActivity extends AppCompatActivity {

    private EditText campoEmail, campoSenha;
    private Button botaoEntrar;
    private FirebaseAuth autenticacao;//para cadastrar o usuario no firebase
    private Usuario usuario;//é preciso criar a classe Usuario antes de validar o login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoEntrar = findViewById(R.id.buttonEntrar);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validações
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                //validar se os campos foram preenchidos --> Pode ser criado um método para este processo de validação
                if (!textoEmail.isEmpty()) {

                    if (!textoSenha.isEmpty()) {
                        //Autenticação do usuário - é necessário um método para validar o login do usuário - Criar e chamar o metodo validarLogin
                        usuario = new Usuario();
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                        validarLogin();

                    } else {
                        Toast.makeText(LoginActivity.this, "Digite a senha", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "Preencha o email", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //Método para validar o login dos usuários
    public void validarLogin() {

        //recuperar o objeto do firebase que permite a autenticação do usuario
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();//objeto que permite cadastrar/autenticar o usuario
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()

        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //pra verificar se deu certo a autenticacao
                if (task.isSuccessful()) {

                    //caso o login seja bem sucedido, enviar usuário para a tela principal
                    //pode haver um toast avisando que o login foi executado com sucesso (opcional)
                    abrirTelaPrincipal();

                } else {
                    //tratando as excessões
                    String excecao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Usuário não está cadastrado.";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "E-mail e senha não correspondem a um usuário cadastrado.";
                    } catch (Exception e) {
                        excecao = "Erro ao cadastrar o usuário: " + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(LoginActivity.this,
                            excecao,
                            Toast.LENGTH_LONG).show();
                }
            }
        });//autentica o usuário - faz login e leva para a tela principal

    }

    //Método para abrir a tela principal
    public void abrirTelaPrincipal() {
        startActivity(new Intent(this, PrincipalActivity.class));
        finish();//fecha a activity de login
    }

}