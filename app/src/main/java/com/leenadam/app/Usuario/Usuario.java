package com.leenadam.app.Usuario;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import com.leenadam.app.config.ConfiguracaoFirebase;

public class Usuario {

    private String idUsuario;
    private String nome;
    private String email;
    private String senha;

    //construtor
    public Usuario() {
    }

    //Método para salvar o usuário
    public void salvar() {
        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();//é preciso o metodo que retorne o objeto para o banco de dados
        firebase.child("usuarios")//esse nó precisa existir dentro do Realtime Database do Firebase! testar se é necessário acrescentar o ".push()"!
                .child(this.idUsuario)

                .setValue(this);
    }


    //getter and setter
    @Exclude //excui o dado na hora de salvar no firebase!
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude //excui o dado na hora de salvar no firebase!
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
