package com.leenadam.app.Usuario;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.leenadam.app.R;

public class ProgressBarLogin extends Activity {
    /**/
/*
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        setContentView(R.layout.activity_login);
        // Barra de Progresso
        mProgress = (ProgressBar) findViewById(R.id.barraProgresso);
        Button b = (Button) findViewById(R.id.btLogin);
        b.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                new Thread(new Runnable(){
                    public void run(){
                        for (int i = 0; i<=100; i++){
                            final int progress = i;
                            // Atualiza a barra de progresso
                            runOnUiThread(new Runnable(){
                                public void run(){
                                    mProgress.setProgress(progress);
                                }
                            });
                            try{
                                Thread.sleep(1000);
                            } catch (InterruptedException e){}
                        }
                    }
                }).start();
            }

        });
    }
*/
}