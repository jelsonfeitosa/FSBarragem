package com.leenadam.app.InfoGeral;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
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
import com.leenadam.app.Empresa.Utils;
import com.leenadam.app.Relatorio.TelaRelatorioActivity;
import com.leenadam.app.activity.MainActivity;
import com.leenadam.app.MatrizClassificacao.ActivityMatrizClassificacao;
import com.leenadam.app.R;
import com.leenadam.app.TesteBancoActivity;
import com.leenadam.app.Usina.ActivityInserirUsina;

import java.util.List;

public class ActivityInfoGerais extends AppCompatActivity {

    private String psbElaborado = "";
    private String paeElaborado = "";
    private String paeProtocolado = "";
    private String isrRealizado = "";
    private String iseRealizada = "";
    private String nivelSegurancaBarragem = "";

    private TextInputEditText txtInputEditTxt_dataElaboracaoPsb;
    private TextInputEditText txtInputEditTxt_dataElaboracaoPae;
    private TextInputEditText txtInputEditTxt_dataProtocoloPae;
    private TextInputEditText txtInputEditTxt_dataRealizacaoIsr;
    private TextInputEditText txtInputEditTxt_dataRealizacaoIse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_geral);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtInputEditTxt_dataElaboracaoPsb = findViewById(R.id.TextInputEditText_dataconclusaopsb);
        txtInputEditTxt_dataElaboracaoPae = findViewById(R.id.TextInputEditText_dataconclusaopae);
        txtInputEditTxt_dataProtocoloPae = findViewById(R.id.TextInputEditText_dataprotocolopae);
        txtInputEditTxt_dataRealizacaoIsr = findViewById(R.id.TextInputEditText_dataconclusaoisr);
        txtInputEditTxt_dataRealizacaoIse = findViewById(R.id.TextInputEditText_dataconclusaoise);

        //Cria condicional com aviso para campos que ficarem sem o devido preenchimento
        View rootView = findViewById(android.R.id.content);

        final List<TextInputLayout> textInputLayouts = Utils.findViewsWithType(
                rootView, TextInputLayout.class);

        Button button = findViewById(R.id.btnInfoGeral);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean noErrors = true;
                for (TextInputLayout textInputLayout : textInputLayouts) {
                    String editTextString = textInputLayout.getEditText().getText().toString();
                    if (editTextString.isEmpty()) {
                        textInputLayout.setError(getResources().getString(R.string.error_string));
                        noErrors = false;
                    } else {
                        textInputLayout.setError(null);
                    }
                }

                if ((noErrors) && (psbElaborado != "") && (paeElaborado != "") && (paeProtocolado != "") && (isrRealizado != "") && (iseRealizada != "")) {
                    //enviarDados(); // Chama o método para enviar dados para o Firebase - comentado por enquanto, logo não irá guardar os dados no firestore
                    startActivity(new Intent(getApplicationContext(), ActivityMatrizClassificacao.class));

                    Toast.makeText(getApplicationContext(), "Informações Gerais preenchidas com sucesso.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Verifique o(s) campo(s) vazio(s)", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

            //Plano de Segurança da Barragem (PSB) elaborado?
            case R.id.radio_sim:
                if (checked) {
                    psbElaborado = "Sim";
                    Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_nao:
                if (checked) {
                    psbElaborado = "Não";
                    Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_naoseaplica:
                if (checked) {
                    psbElaborado = "Não se Aplica";
                    Toast.makeText(getApplicationContext(), "Não se Aplica.", Toast.LENGTH_SHORT).show();
                }
                break;

            //Plano de Ação de Emergência (PAE) elaborado?
            case R.id.radio_sim1:
                if (checked) {
                    paeElaborado = "Sim";
                    Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_nao1:
                if (checked) {
                    paeElaborado = "Não";
                    Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_naoseaplica1:
                if (checked) {
                    paeElaborado = "Não se Aplica";
                    Toast.makeText(getApplicationContext(), "Não se Aplica.", Toast.LENGTH_SHORT).show();
                }
                break;


            //Plano de Ação de Emergência (PAE) protocolado na Defesa Civil/Prefeitura?
            case R.id.radio_sim2:
                if (checked) {
                    paeProtocolado = "Sim";
                    Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_nao2:
                if (checked) {
                    paeProtocolado = "Não";
                    Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_naoseaplica2:
                if (checked) {
                    paeProtocolado = "Não se Aplica";
                    Toast.makeText(getApplicationContext(), "Não se Aplica.", Toast.LENGTH_SHORT).show();
                }
                break;


            //Inspeção de Segurança Regular (ISR) realizada?
            case R.id.radio_sim3:
                if (checked) {
                    isrRealizado = "Sim";
                    Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_nao3:
                if (checked) {
                    isrRealizado = "Não";
                    Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_naoseaplica3:
                if (checked) {
                    isrRealizado = "Não se Aplica";
                    Toast.makeText(getApplicationContext(), "Não se Aplica.", Toast.LENGTH_SHORT).show();
                }
                break;


            //Inspeção de Segurança Especial (ISE) realizada?
            case R.id.radio_sim4:
                if (checked) {
                    iseRealizada = "Sim";
                    Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_nao4:
                if (checked) {
                    iseRealizada = "Não";
                    Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_naoseaplica4:
                if (checked) {
                    iseRealizada = "Não se Aplica";
                    Toast.makeText(getApplicationContext(), "Não se Aplica.", Toast.LENGTH_SHORT).show();
                }
                break;


            //Nível de Segurança de Barragem
            case R.id.radio_normal:
                if (checked) {
                    nivelSegurancaBarragem = "Normal";
                    Toast.makeText(getApplicationContext(), "Normal", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_atencao:
                if (checked) {
                    nivelSegurancaBarragem = "Atenção";
                    Toast.makeText(getApplicationContext(), "Atenção", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radio_alerta:
                if (checked) {
                    nivelSegurancaBarragem = "Alerta";
                    Toast.makeText(getApplicationContext(), "Alerta", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.radio_emergencia:
                if (checked) {
                    nivelSegurancaBarragem = "Emergência";
                    Toast.makeText(getApplicationContext(), "Emergência", Toast.LENGTH_SHORT).show();
                }
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
            startActivity(new Intent(this, TelaRelatorioActivity.class));
            return true;
        }

        if (id == R.id.action_bd) {
            startActivity(new Intent(this, TesteBancoActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}