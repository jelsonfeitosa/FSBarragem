package com.leenadam.app.Usuario;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.leenadam.app.R;

//Futuramente, testar se dá pra inserir a splash screen antes dos sliders! Senão, remove isso!

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarLogin();
            }
        }, 2000);
    }

    //Caso consiga implementar o splash screen antes dos sliders, refatorar o nome deste metodo para "mostrarSliders", por exemplo
    private void mostrarLogin() {
        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
