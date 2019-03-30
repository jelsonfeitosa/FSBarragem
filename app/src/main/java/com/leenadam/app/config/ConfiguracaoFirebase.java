package com.leenadam.app.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFirebase {

    private static FirebaseAuth autenticacao;//criando um atributo estático, ele sera o mesmo independente de quantas instancias se crie na classe!
    private static DatabaseReference firebase;


    //metodo que retorna a instancia do FirebaseDatabase
    public static DatabaseReference getFirebaseDatabase() {
        if (firebase == null) {
            firebase = FirebaseDatabase.getInstance().getReference();
        }
        return firebase;

    }

    //metodo que retorna a instancia do FirebaseAuth
    public static FirebaseAuth getFirebaseAutenticacao() {

        if (autenticacao == null) {
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;

    }

}