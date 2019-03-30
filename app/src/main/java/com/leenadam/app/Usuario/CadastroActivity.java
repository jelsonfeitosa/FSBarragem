package com.leenadam.app.Usuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.leenadam.app.R;
import com.leenadam.app.config.ConfiguracaoFirebase;
import com.leenadam.app.helper.Base64Custom;

public class CadastroActivity extends AppCompatActivity {

    //Atributos
    private EditText campoNome, campoEmail, campoSenha;
    private Button botaoCadastrar;
    private FirebaseAuth autenticacao;//para cadastrar o usuario no firebase
    private Usuario usuario;//é preciso criar a classe Usuario antes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //getSupportActionBar().setTitle("Cadastro");//altera o título da toolbar

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validações
                String textoNome = campoNome.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();
                //validar se os campos foram preenchidos --> Pode ser criado um método para este processo de validação
                if (!textoNome.isEmpty()) {

                    if (!textoEmail.isEmpty()) {

                        if (!textoSenha.isEmpty()) {
                            //Se todos os itens forem atendidos, Cadastrar o usuario - Criar e chamar o metodo cadastrarUsuario
                            usuario = new Usuario();
                            usuario.setNome(textoNome);
                            usuario.setEmail(textoEmail);
                            usuario.setSenha(textoSenha);
                            cadastrarUsuario();

                        } else {
                            Toast.makeText(CadastroActivity.this, "Preencha a senha", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(CadastroActivity.this, "Preencha o email", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(CadastroActivity.this, "Preencha o nome", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    //Método para cadastrar os usuários
    public void cadastrarUsuario() {

        //recuperar o objeto do firebase que permite a autenticação do usuario
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();//objeto que permite cadastrar o usuario
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()

        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //pra verificar se deu certo o cadastro
                if (task.isSuccessful()) {

                    String idUsuario = Base64Custom.codificarBase64(usuario.getEmail());
                    usuario.setIdUsuario(idUsuario);
                    usuario.salvar();
                    finish();
                    //Toast.makeText(CadastroActivity.this,"Sucesso ao cadastrar usuário!", Toast.LENGTH_SHORT).show();

                } else {
                    //tratando as excessões
                    String excecao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        excecao = "Digite uma senha mais forte!";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Por favor, digite um e-mail válido.";
                    } catch (FirebaseAuthUserCollisionException e) {
                        excecao = "Essa conta já foi cadastrada.";
                    } catch (Exception e) {
                        excecao = "Algo deu errado ao cadastrar o usuário:" + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(CadastroActivity.this,
                            excecao,//Sua senha possui mais de 6 digitos? Existem espaços após os textos 'nome' e 'email'?
                            Toast.LENGTH_LONG).show();
                }
            }
        });//cadastra o usuário - salvando o email e senha

    }

}
