package com.leenadam.app.InfoGeral;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.leenadam.app.Barramento.ActivityInserirBarramento;
import com.leenadam.app.Declaracoes.ActivityDeclaracoes;
import com.leenadam.app.Empresa.ActivityInserirEmpresa;
import com.leenadam.app.activity.MainActivity;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.R;
import com.leenadam.app.TesteBancoActivity;
import com.leenadam.app.Usina.ActivityInserirUsina;

public class ActivityInfoGerais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_geral);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/* comentei este bloco porque ele estava causando erro
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/

        Button button = findViewById(R.id.btnInfoGeral);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), ActivityMatrizClassificacao.class));

                Toast.makeText(getApplicationContext(), "Informações Gerais preenchidas com sucesso.", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

            //Plano de Ação de Emergência (PAE) elaborado?
            case R.id.radio_sim:
                Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_nao:
                Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_naoseaplica:
                Toast.makeText(getApplicationContext(), "Não se Aplica.", Toast.LENGTH_SHORT).show();
                break;

            //Plano de Ação de Emergência (PAE) protocolado na Defesa Civil/Prefeitura?
            case R.id.radio_sim1:
                Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_nao1:
                Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_naoseaplica1:
                Toast.makeText(getApplicationContext(), "Não se Aplica.", Toast.LENGTH_SHORT).show();
                break;


            //Plano de Ação de Emergência (PAE) protocolado na Defesa Civil/Prefeitura?
            case R.id.radio_sim2:
                Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_nao2:
                Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_naoseaplica2:
                Toast.makeText(getApplicationContext(), "Não se Aplica.", Toast.LENGTH_SHORT).show();
                break;


            //Plano de Segurança Regular (PSR) realizada?
            case R.id.radio_sim3:
                Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_nao3:
                Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_naoseaplica3:
                Toast.makeText(getApplicationContext(), "Não se Aplica.", Toast.LENGTH_SHORT).show();
                break;


            //Inspeção de Segurança Especial (ISE) realizada?
            case R.id.radio_sim4:
                Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_nao4:
                Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_naoseaplica4:
                Toast.makeText(getApplicationContext(), "Não se Aplica.", Toast.LENGTH_SHORT).show();
                break;


            //Nível de Segurança de Barragem
            case R.id.radio_normal:
                Toast.makeText(getApplicationContext(), "Normal", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_atencao:
                Toast.makeText(getApplicationContext(), "Atenção", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_alerta:
                Toast.makeText(getApplicationContext(), "Alerta", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_emergencia:
                Toast.makeText(getApplicationContext(), "Emergência", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_inicio) {
            startActivity(new Intent(this, MainActivity.class));
            return true;

        }

        if (id == R.id.menu_inserirempresa) {
            startActivity(new Intent(this, ActivityInserirEmpresa.class));
            return true;

        }

        if (id == R.id.menu_inserirusina) {
            startActivity(new Intent(this, ActivityInserirUsina.class));
            return true;
        }

        if (id == R.id.menu_inserirbarramento) {
            startActivity(new Intent(this, ActivityInserirBarramento.class));
            return true;
        }

        if (id == R.id.menu_infogerais) {
            startActivity(new Intent(this, ActivityInfoGerais.class));
            return true;
        }

        if (id == R.id.menu_matrizclassificacao) {
            startActivity(new Intent(this, ActivityMatrizClassificacao.class));
            return true;
        }

        if (id == R.id.menu_declaracoes) {
            startActivity(new Intent(this, ActivityDeclaracoes.class));
            return true;
        }

        if (id == R.id.action_configuracoes) {
            return true;
        }

        if (id == R.id.action_relatorio) {
            return true;
        }

        if (id == R.id.action_bd) {
            startActivity(new Intent(this, TesteBancoActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}