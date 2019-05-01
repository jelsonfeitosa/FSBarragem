package com.leenadam.app.MatrizClassificacao;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.isapanah.awesomespinner.AwesomeSpinner;
import com.leenadam.app.Barramento.ActivityInserirBarramento;
import com.leenadam.app.Declaracoes.ActivityDeclaracoes;
import com.leenadam.app.Empresa.ActivityInserirEmpresa;
import com.leenadam.app.Expedito.ClassificacaoExpeditaActivity;
import com.leenadam.app.Expedito.ResultadoExpedito;
import com.leenadam.app.Expedito.TelaResultadoActivity;
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.Relatorio.ResultadoRelatorio;
import com.leenadam.app.Relatorio.TelaRelatorioActivity;
import com.leenadam.app.RelatorioPrevia.ResultadoPreviaRelatorio;
import com.leenadam.app.RelatorioPrevia.TelaPreviaRelatorioActivity;
import com.leenadam.app.activity.MainActivity;
import com.leenadam.app.R;
import com.leenadam.app.Usina.ActivityInserirUsina;
import com.leenadam.app.util.ModoValorDesc;

import java.util.ArrayList;
import java.util.List;

public class ActivityMatrizClassificacao extends AppCompatActivity {

    protected static final String TAG = "MatrizClassificao";
    private FirebaseFirestore mFirestore;

    private Button btnCancelarClassificacao;
    private Button btnClassificacao;

    private TextView textResultado;
    private TextView textResultadoAltura;
    private TextView textResultadoReservatorio;
    private TextView textResultadoPotencial;
    private TextView textResultadoEnquadramento;

    private TextInputEditText TextInputEditText_alturabarramento;
    private TextInputEditText TextInputEditText_capacidadeusina;

    private AwesomeSpinner AwesomeSpinnerAltura;
    private AwesomeSpinner AwesomeSpinnerComprimento;
    private AwesomeSpinner AwesomeSpinnerTipoBarragem;
    private AwesomeSpinner AwesomeSpinnerTipoFundacao;
    private AwesomeSpinner AwesomeSpinnerIdadeBarragem;
    private AwesomeSpinner AwesomeSpinnerVazaoProjeto;
    private AwesomeSpinner AwesomeSpinnerCasaForca;

    private AwesomeSpinner AwesomeSpinnerConfiabEstrutExtravasoras;
    private AwesomeSpinner AwesomeSpinnerConfiabEstrutAducao;
    private AwesomeSpinner AwesomeSpinnerPercolacao;
    private AwesomeSpinner AwesomeSpinnerDeformacoesRecalques;
    private AwesomeSpinner AwesomeSpinnerDeterioracaoTaludesParamentos;
    private AwesomeSpinner AwesomeSpinnerEclusa;

    private AwesomeSpinner AwesomeSpinnerExistenciaDocProjeto;
    private AwesomeSpinner AwesomeSpinnerEstrutOrganizacional;
    private AwesomeSpinner AwesomeSpinnerProcedimentosRoteiros;
    private AwesomeSpinner AwesomeSpinnerRegraOperacional;
    private AwesomeSpinner AwesomeSpinnerRelatoriosInspecao;

    private AwesomeSpinner AwesomeSpinnerVolumeReservatorio;
    private AwesomeSpinner AwesomeSpinnerPotencialPerdasVidas;
    private AwesomeSpinner AwesomeSpinnerImpactoAmbiental;
    private AwesomeSpinner AwesomeSpinnerImpactoSocioEconomico;

    private List<String> listaAltura = new ArrayList<String>();
    private List<String> listaComprimento = new ArrayList<String>();
    private List<String> listaTipoBarragem = new ArrayList<String>();
    private List<String> listaTipoFundacao = new ArrayList<String>();
    private List<String> listaIdadeBarragem = new ArrayList<String>();
    private List<String> listaVazaoProjeto = new ArrayList<String>();
    private List<String> listaCasaForca = new ArrayList<String>();

    private List<String> listaConfiabEstrutExtravasoras = new ArrayList<String>();
    private List<String> listaConfiabEstrutAducao = new ArrayList<String>();
    private List<String> listaPercolacao = new ArrayList<String>();
    private List<String> listaDeformacaoRecalque = new ArrayList<String>();
    private List<String> listaDeterioracaoTaludesParamentos = new ArrayList<String>();
    private List<String> listaEclusa = new ArrayList<String>();

    private List<String> listaExistenciaDocProjeto = new ArrayList<String>();
    private List<String> listaEstrutOrganizacional = new ArrayList<String>();
    private List<String> listaProcedimentosRoteiros = new ArrayList<String>();
    private List<String> listaRegraOperacional = new ArrayList<String>();
    private List<String> listaRelatoriosInspecao = new ArrayList<String>();

    private List<String> listaVolumeReservatorio = new ArrayList<String>();
    private List<String> listaPotenciaPerdasVidas = new ArrayList<String>();
    private List<String> listaImpactoAmbiental = new ArrayList<String>();
    private List<String> listaImpactoSocioEconomico = new ArrayList<String>();
    //refatorar nome de recordA para pesoA...para todos os outros tbm
    String recordA = "";
    String recordB = "";
    String recordC = "";
    String recordD = "";
    String recordE = "";
    String recordF = "";
    String recordG = "";

    String recordH = "";
    String recordI = "";
    String recordJ = "";
    String recordK = "";
    String recordL = "";
    String recordM = "";

    String recordN = "";
    String recordO = "";
    String recordP = "";
    String recordQ = "";
    String recordR = "";

    String recordS = "";
    String recordT = "";
    String recordU = "";
    String recordV = "";

    private ResultadoPreviaRelatorio resultadoPreviaRelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_matriz_classificacao);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d(TAG, "Matriz iniciada");

        // Access a Cloud Firestore instance from your Activity

        FirebaseFirestore.setLoggingEnabled(true);
        // Página de configuração do Banco de dados - Conexão
        mFirestore = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        mFirestore.setFirestoreSettings(settings);

        TextInputEditText_alturabarramento = findViewById(R.id.TextInputEditText_alturabarramento);
        TextInputEditText_capacidadeusina = findViewById(R.id.TextInputEditText_capacidadeusina);

        AwesomeSpinnerAltura = findViewById(R.id.AwesomeSpinnerAltura);
        AwesomeSpinnerComprimento = findViewById(R.id.AwesomeSpinnerComprimento);
        AwesomeSpinnerTipoBarragem = findViewById(R.id.AwesomeSpinnerTipoBarragem);
        AwesomeSpinnerTipoFundacao = findViewById(R.id.AwesomeSpinnerTipoFundacao);
        AwesomeSpinnerIdadeBarragem = findViewById(R.id.AwesomeSpinnerIdadeBarragem);
        AwesomeSpinnerVazaoProjeto = findViewById(R.id.AwesomeSpinnerVazaoProjeto);
        AwesomeSpinnerCasaForca = findViewById(R.id.AwesomeSpinnerCasaForca);

        AwesomeSpinnerConfiabEstrutExtravasoras = findViewById(R.id.AwesomeSpinnerConfiabEstrutExtravasoras);
        AwesomeSpinnerConfiabEstrutAducao = findViewById(R.id.AwesomeSpinnerConfiabEstrutAducao);
        AwesomeSpinnerPercolacao = findViewById(R.id.AwesomeSpinnerPercolacao);
        AwesomeSpinnerDeformacoesRecalques = findViewById(R.id.AwesomeSpinnerDeformacoesRecalques);
        AwesomeSpinnerDeterioracaoTaludesParamentos = findViewById(R.id.AwesomeSpinnerDeterioracaoTaludesParamentos);
        AwesomeSpinnerEclusa = findViewById(R.id.AwesomeSpinnerEclusa);

        AwesomeSpinnerExistenciaDocProjeto = findViewById(R.id.AwesomeSpinnerExistenciaDocProjeto);
        AwesomeSpinnerEstrutOrganizacional = findViewById(R.id.AwesomeSpinnerEstrutOrganizacional);
        AwesomeSpinnerProcedimentosRoteiros = findViewById(R.id.AwesomeSpinnerProcedimentosRoteiros);
        AwesomeSpinnerRegraOperacional = findViewById(R.id.AwesomeSpinnerRegraOperacional);
        AwesomeSpinnerRelatoriosInspecao = findViewById(R.id.AwesomeSpinnerRelatoriosInspecao);

        AwesomeSpinnerVolumeReservatorio = findViewById(R.id.AwesomeSpinnerVolumeReservatorio);
        AwesomeSpinnerPotencialPerdasVidas = findViewById(R.id.AwesomeSpinnerPotencialPerdasVidas);
        AwesomeSpinnerImpactoAmbiental = findViewById(R.id.AwesomeSpinnerImpactoAmbiental);
        AwesomeSpinnerImpactoSocioEconomico = findViewById(R.id.AwesomeSpinnerImpactoSocioEconomico);

        btnCancelarClassificacao = findViewById(R.id.buttonEnviar);//alterar o nome do botao apos testes xml - avisar sobre a perda de dados
        btnClassificacao = findViewById(R.id.btnClassificacao);//alterar o nome do botao apos testes xml - avisar sobre a perda de dados

        //textResultado = findViewById(R.id.textResultado);
        //textResultadoAltura = findViewById(R.id.textResultadoAltura);
        //textResultadoReservatorio = findViewById(R.id.textResultadoReservatorio);
        //textResultadoPotencial = findViewById(R.id.textResultadoPotencial);
        //textResultadoEnquadramento = findViewById(R.id.textResultadoEnquadramento);


        //Modify styles of spinner - remover após testes
        //AwesomeSpinnerAltura.setHintTextColor(Color.GRAY);//If you need to change the Spinner Hint Text color
        //AwesomeSpinnerAltura.setSelectedItemHintColor(Color.BLACK);//If you need to change the Selected Item Hint color
        //AwesomeSpinnerAltura.setDownArrowTintColor(Color.GRAY);//If you need to change the Down Arrow hint color


        CarregarDadosMatriz("1_Caracteristicas_Tecnicas_CT", "a_Altura", listaAltura, AwesomeSpinnerAltura);
        CarregarDadosMatriz("1_Caracteristicas_Tecnicas_CT", "b_Comprimento", listaComprimento, AwesomeSpinnerComprimento);
        CarregarDadosMatriz("1_Caracteristicas_Tecnicas_CT", "c_Tipo_de_Barragem", listaTipoBarragem, AwesomeSpinnerTipoBarragem);
        CarregarDadosMatriz("1_Caracteristicas_Tecnicas_CT", "d_Tipo_de_Fundacao", listaTipoFundacao, AwesomeSpinnerTipoFundacao);
        CarregarDadosMatriz("1_Caracteristicas_Tecnicas_CT", "e_Idade_Da_Barragem", listaIdadeBarragem, AwesomeSpinnerIdadeBarragem);
        CarregarDadosMatriz("1_Caracteristicas_Tecnicas_CT", "f_Vazao_de_Projeto", listaVazaoProjeto, AwesomeSpinnerVazaoProjeto);
        CarregarDadosMatriz("1_Caracteristicas_Tecnicas_CT", "g_Casa_de_Forca", listaCasaForca, AwesomeSpinnerCasaForca);

        CarregarDadosMatriz("2_Estado_de_Conservação_EC", "h_Confiab_Estrut_Extravasoras", listaConfiabEstrutExtravasoras, AwesomeSpinnerConfiabEstrutExtravasoras);
        CarregarDadosMatriz("2_Estado_de_Conservação_EC", "i_Confiab_Estrut_Aducao", listaConfiabEstrutAducao, AwesomeSpinnerConfiabEstrutAducao);
        CarregarDadosMatriz("2_Estado_de_Conservação_EC", "j_Percolacao", listaPercolacao, AwesomeSpinnerPercolacao);
        CarregarDadosMatriz("2_Estado_de_Conservação_EC", "k_Deformacoes_e_Recalques", listaDeformacaoRecalque, AwesomeSpinnerDeformacoesRecalques);
        CarregarDadosMatriz("2_Estado_de_Conservação_EC", "l_Deterioracao_Taludes_Paramentos", listaDeterioracaoTaludesParamentos, AwesomeSpinnerDeterioracaoTaludesParamentos);
        CarregarDadosMatriz("2_Estado_de_Conservação_EC", "m_Eclusa", listaEclusa, AwesomeSpinnerEclusa);

        CarregarDadosMatriz("3_Plano_de_seguranca_da_Barragem_PS", "n_Existencia_Doc_Projeto", listaExistenciaDocProjeto, AwesomeSpinnerExistenciaDocProjeto);
        CarregarDadosMatriz("3_Plano_de_seguranca_da_Barragem_PS", "o_Estrut_Organizacional", listaEstrutOrganizacional, AwesomeSpinnerEstrutOrganizacional);
        CarregarDadosMatriz("3_Plano_de_seguranca_da_Barragem_PS", "p_Procedimentos_Roteiros", listaProcedimentosRoteiros, AwesomeSpinnerProcedimentosRoteiros);
        CarregarDadosMatriz("3_Plano_de_seguranca_da_Barragem_PS", "q_Regra_Operacional", listaRegraOperacional, AwesomeSpinnerRegraOperacional);
        CarregarDadosMatriz("3_Plano_de_seguranca_da_Barragem_PS", "r_Relatorios_de_Inspecao", listaRelatoriosInspecao, AwesomeSpinnerRelatoriosInspecao);

        CarregarDadosMatriz("4_Dano_Potencial_Associado_DPA", "a_Volume_Total_Reservatorio", listaVolumeReservatorio, AwesomeSpinnerVolumeReservatorio);
        CarregarDadosMatriz("4_Dano_Potencial_Associado_DPA", "b_Potencial_Perdas_Vidas", listaPotenciaPerdasVidas, AwesomeSpinnerPotencialPerdasVidas);
        CarregarDadosMatriz("4_Dano_Potencial_Associado_DPA", "c_Impacto_Ambiental", listaImpactoAmbiental, AwesomeSpinnerImpactoAmbiental);
        CarregarDadosMatriz("4_Dano_Potencial_Associado_DPA", "d_Impacto_Socio_Economico", listaImpactoSocioEconomico, AwesomeSpinnerImpactoSocioEconomico);


        //Matriz Características Técnicas - CT
        AwesomeSpinnerAltura.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordA = "0";

                        break;

                    case 1:

                        recordA = "1";

                        break;

                    case 2:

                        recordA = "2";

                        break;

                    case 3:

                        recordA = "3";

                        break;

                }

            }
        });

        AwesomeSpinnerComprimento.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordB = "2";

                        break;

                    case 1:

                        recordB = "3";

                        break;

                }

            }
        });

        AwesomeSpinnerTipoBarragem.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordC = "1";

                        break;

                    case 1:

                        recordC = "2";

                        break;

                    case 2:

                        recordC = "3";

                        break;


                }
            }
        });

        AwesomeSpinnerTipoFundacao.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordD = "1";

                        break;

                    case 1:

                        recordD = "2";

                        break;

                    case 2:

                        recordD = "3";

                        break;

                    case 3:

                        recordD = "4";

                        break;

                    case 4:

                        recordD = "5";

                        break;

                }

            }
        });

        AwesomeSpinnerIdadeBarragem.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordE = "1";

                        break;

                    case 1:

                        recordE = "2";

                        break;

                    case 2:

                        recordE = "3";

                        break;

                    case 3:

                        recordE = "4";

                        break;

                }

            }
        });

        AwesomeSpinnerVazaoProjeto.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordF = "3";

                        break;

                    case 1:

                        recordF = "5";

                        break;

                    case 2:

                        recordF = "8";

                        break;

                    case 3:

                        recordF = "10";

                        break;

                }

            }
        });

        AwesomeSpinnerCasaForca.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordG = "0";

                        break;

                    case 1:

                        recordG = "2";

                        break;

                    case 2:

                        recordG = "5";

                        break;

                }

            }
        });


        //Matriz Estado de Conservação - EC
        AwesomeSpinnerConfiabEstrutExtravasoras.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordH = "0";

                        break;

                    case 1:

                        recordH = "4";

                        break;

                    case 2:

                        recordH = "7";

                        break;

                    case 3:

                        recordH = "10";

                        break;

                }

            }
        });

        AwesomeSpinnerConfiabEstrutAducao.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordI = "0";

                        break;

                    case 1:

                        recordI = "4";

                        break;

                    case 2:

                        recordI = "6";

                        break;

                }

            }
        });

        AwesomeSpinnerPercolacao.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordJ = "0";

                        break;

                    case 1:

                        recordJ = "3";

                        break;

                    case 2:

                        recordJ = "5";

                        break;

                    case 3:

                        recordJ = "8";

                        break;

                }

            }
        });

        AwesomeSpinnerDeformacoesRecalques.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordK = "0";

                        break;

                    case 1:

                        recordK = "1";

                        break;

                    case 2:

                        recordK = "5";

                        break;

                    case 3:

                        recordK = "8";

                        break;

                }

            }
        });

        AwesomeSpinnerDeterioracaoTaludesParamentos.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordL = "0";

                        break;

                    case 1:

                        recordL = "1";

                        break;

                    case 2:

                        recordL = "5";

                        break;

                    case 3:

                        recordL = "7";

                        break;

                }

            }
        });

        AwesomeSpinnerEclusa.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordM = "0";

                        break;

                    case 1:

                        recordM = "1";

                        break;

                    case 2:

                        recordM = "2";

                        break;

                    case 3:

                        recordM = "4";

                        break;

                }

            }
        });


        //Matriz Plano de Segurança da Barragem - PS
        AwesomeSpinnerExistenciaDocProjeto.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordN = "0";

                        break;

                    case 1:

                        recordN = "2";

                        break;

                    case 2:

                        recordN = "4";

                        break;

                    case 3:

                        recordN = "6";

                        break;

                    case 4:

                        recordN = "8";

                        break;

                }

            }
        });

        AwesomeSpinnerEstrutOrganizacional.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordO = "0";

                        break;

                    case 1:

                        recordO = "4";

                        break;

                    case 2:

                        recordO = "8";

                        break;

                }

            }
        });

        AwesomeSpinnerProcedimentosRoteiros.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordP = "0";

                        break;

                    case 1:

                        recordP = "3";

                        break;

                    case 2:

                        recordP = "5";

                        break;

                    case 3:

                        recordP = "6";

                        break;

                }

            }
        });

        AwesomeSpinnerRegraOperacional.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordQ = "0";

                        break;

                    case 1:

                        recordQ = "6";

                        break;

                }

            }
        });

        AwesomeSpinnerRelatoriosInspecao.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordR = "0";

                        break;

                    case 1:

                        recordR = "3";

                        break;

                    case 2:

                        recordR = "5";

                        break;

                }

            }
        });


        //Matriz Dano Potencial Associado - DPA
        AwesomeSpinnerVolumeReservatorio.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                //ModoValorDesc classe = new ModoValorDesc(); //Falhou

                switch (position) {

                    case 0:

                        recordS = "1";

                        //classe.getValor(); //Falhou

                        break;

                    case 1:

                        recordS = "2";

                        break;

                    case 2:

                        recordS = "3";

                        break;

                    case 3:

                        recordS = "5";

                        break;

                }

            }
        });

        AwesomeSpinnerPotencialPerdasVidas.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordT = "0";

                        break;

                    case 1:

                        recordT = "4";

                        break;

                    case 2:

                        recordT = "8";

                        break;

                    case 3:

                        recordT = "12";

                        break;

                }

            }
        });

        AwesomeSpinnerImpactoAmbiental.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordU = "3";

                        break;

                    case 1:

                        recordU = "5";

                        break;


                }
            }
        });

        AwesomeSpinnerImpactoSocioEconomico.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {

                switch (position) {

                    case 0:

                        recordV = "0";


                        break;

                    case 1:

                        recordV = "4";

                        break;

                    case 2:

                        recordV = "8";

                        break;

                }

            }
        });

        /*---------------------------------Processamento dos dados para classificação do barramento----------------------------------*/
        btnClassificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //VALIDAÇÕES AWESOME SPINNERS
                if (AwesomeSpinnerAltura.isSelected()) {

                    /*
                    Double compararAlturaMacico;
                    compararAlturaMacico = Double.parseDouble(TextInputEditText_alturabarramento.getText().toString());

                    Log.i("faixa", "Peso altura: " + recordA + "|" + "Altura inserida: " + compararAlturaMacico);

                    if ((recordA == "0") && (compararAlturaMacico <= 15)) {
                        Log.i("faixa", "rodou o item 1");

                    } else if ((recordA == "1") && ((compararAlturaMacico > 15) && (compararAlturaMacico < 30))) {
                        Log.i("faixa", "rodou o item 2");

                    } else if ((recordA == "2") && ((compararAlturaMacico >= 30) && (compararAlturaMacico <= 60))) {
                        Log.i("faixa", "rodou o item 3");

                    } else if ((recordA == "3") && ((compararAlturaMacico > 60))) {
                        Log.i("faixa", "rodou o item 4");

                    } else {
                        Log.i("faixa", "rodou erro altura");
                        //dadosAlturaCondizentes = "contraditorio";
                        Toast toast = Toast.makeText(getApplicationContext(), "Altura contraditória", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 500);//modificar posição um pouco mais para baixo...as unidades são pixels e considera-se uma pratica desaconselhável utilizar números negativos, assim como modificar posição e tamanho utilizando pixels mas sim dp!
                        toast.show();
                    }
                    */

                    //Caracteristicas Tecnicas CT
                    if (AwesomeSpinnerComprimento.isSelected()) {

                        if (AwesomeSpinnerTipoBarragem.isSelected()) {

                            if (AwesomeSpinnerTipoFundacao.isSelected()) {

                                if (AwesomeSpinnerIdadeBarragem.isSelected()) {

                                    if (AwesomeSpinnerVazaoProjeto.isSelected()) {

                                        if (AwesomeSpinnerCasaForca.isSelected()) {

                                            //Estado de conservacao EC
                                            if (AwesomeSpinnerConfiabEstrutExtravasoras.isSelected()) {

                                                if (AwesomeSpinnerConfiabEstrutAducao.isSelected()) {

                                                    if (AwesomeSpinnerPercolacao.isSelected()) {

                                                        if (AwesomeSpinnerDeformacoesRecalques.isSelected()) {

                                                            if (AwesomeSpinnerDeterioracaoTaludesParamentos.isSelected()) {

                                                                if (AwesomeSpinnerEclusa.isSelected()) {

                                                                    //Plano de seguranca de barragem PS
                                                                    if (AwesomeSpinnerExistenciaDocProjeto.isSelected()) {

                                                                        if (AwesomeSpinnerEstrutOrganizacional.isSelected()) {

                                                                            if (AwesomeSpinnerProcedimentosRoteiros.isSelected()) {

                                                                                if (AwesomeSpinnerRegraOperacional.isSelected()) {

                                                                                    if (AwesomeSpinnerRelatoriosInspecao.isSelected()) {

                                                                                        //Dano potencial associado
                                                                                        if (AwesomeSpinnerVolumeReservatorio.isSelected()) {

                                                                                            /*
                                                                                            Double compararVolumeReservatorio;
                                                                                            compararVolumeReservatorio = Double.parseDouble(TextInputEditText_capacidadeusina.getText().toString());

                                                                                            Log.i("faixa", "Peso volume: " + recordS + "|" + "Volume inserido: " + compararVolumeReservatorio);

                                                                                            if ((recordS == "1") && (compararVolumeReservatorio <= 5000000)) {
                                                                                                Log.i("faixa", "rodou o item 1");

                                                                                            } else if ((recordS == "2") && ((compararVolumeReservatorio > 5000000) && (compararVolumeReservatorio < 75000000))) {
                                                                                                Log.i("faixa", "rodou o item 2");

                                                                                            } else if ((recordS == "3") && ((compararVolumeReservatorio >= 75000000) && (compararVolumeReservatorio <= 200000000))) {
                                                                                                Log.i("faixa", "rodou o item 3");

                                                                                            } else if ((recordS == "5") && ((compararVolumeReservatorio > 200000000))) {
                                                                                                Log.i("faixa", "rodou o item 4");

                                                                                            } else {
                                                                                                Log.i("faixa", "rodou erro volume");
                                                                                                //dadosVolumeCondizentes = "contraditorio";
                                                                                                Toast.makeText(getApplicationContext(), "Volume contraditório", Toast.LENGTH_SHORT).show();
                                                                                            }
                                                                                            */


                                                                                            if (AwesomeSpinnerPotencialPerdasVidas.isSelected()) {

                                                                                                if (AwesomeSpinnerImpactoAmbiental.isSelected()) {

                                                                                                    if ((AwesomeSpinnerImpactoSocioEconomico.isSelected())) {

                                                                                                        /*INICIO COD CALCULO*/

                                                                                                        //Matriz CT
                                                                                                        int valorA = Integer.parseInt(recordA);
                                                                                                        int valorB = Integer.parseInt(recordB);
                                                                                                        int valorC = Integer.parseInt(recordC);
                                                                                                        int valorD = Integer.parseInt(recordD);
                                                                                                        int valorE = Integer.parseInt(recordE);
                                                                                                        int valorF = Integer.parseInt(recordF);
                                                                                                        int valorG = Integer.parseInt(recordG);

                                                                                                        int somatorioCt = (valorA + valorB + valorC + valorD + valorE + valorF + valorG);

                                                                                                        //textResultado.setText(String.valueOf("O resultado é: " + somatorioCt ));

                                                                                                        Log.i("CT ", String.valueOf(somatorioCt));

                                                                                                        //Matriz EC
                                                                                                        int valorH = Integer.parseInt(recordH);//*
                                                                                                        int valorI = Integer.parseInt(recordI);
                                                                                                        int valorJ = Integer.parseInt(recordJ);//*
                                                                                                        int valorK = Integer.parseInt(recordK);//*
                                                                                                        int valorL = Integer.parseInt(recordL);
                                                                                                        int valorM = Integer.parseInt(recordM);

                                                                                                        int somatorioEc = (valorH + valorI + valorJ + valorK + valorL + valorM);

                                                                                                        //textResultado.setText(String.valueOf("O resultado é: " + somatorioEc ));

                                                                                                        Log.i("EC ", String.valueOf(somatorioEc));

                                                                                                        //Matriz PS
                                                                                                        int valorN = Integer.parseInt(recordN);
                                                                                                        int valorO = Integer.parseInt(recordO);
                                                                                                        int valorP = Integer.parseInt(recordP);
                                                                                                        int valorQ = Integer.parseInt(recordQ);
                                                                                                        int valorR = Integer.parseInt(recordR);

                                                                                                        int somatorioPs = (valorN + valorO + valorP + valorQ + valorR);

                                                                                                        //textResultado.setText(String.valueOf("O resultado é: " + somatorioPs ));

                                                                                                        Log.i("PS ", String.valueOf(somatorioPs));

                                                                                                        //Resultado Somatorio CRI
                                                                                                        int somatorioCri = (somatorioCt + somatorioEc + somatorioPs);

                                                                                                        String criResult = "";

                                                                                                        if (valorH >= 8) {
                                                                                                            criResult = "Alto";
                                                                                                        } else if (valorJ >= 8) {
                                                                                                            criResult = "Alto";
                                                                                                        } else if (valorK >= 8) {
                                                                                                            criResult = "Alto";
                                                                                                        } else if (somatorioCri <= 35) {
                                                                                                            criResult = "Baixo";
                                                                                                        } else if (somatorioCri < 62) {
                                                                                                            criResult = "Médio";
                                                                                                        } else {
                                                                                                            criResult = "Alto";
                                                                                                        }

                                                                                                        //textResultado.setText(String.valueOf("O resultado é: " + somatorioCri + "; Classificação: " + criResult));

                                                                                                        Log.i("CRI ", String.valueOf(somatorioCri) + " | Classificação: " + criResult);

                                                                                                        //Matriz DPA
                                                                                                        int valorS = Integer.parseInt(recordS);
                                                                                                        int valorT = Integer.parseInt(recordT);
                                                                                                        int valorU = Integer.parseInt(recordU);
                                                                                                        int valorV = Integer.parseInt(recordV);

                                                                                                        int somatorioDpa = (valorS + valorT + valorU + valorV);

                                                                                                        String dpaResult = "";

                                                                                                        if (somatorioDpa <= 10) {
                                                                                                            dpaResult = "Baixo";
                                                                                                        } else if (somatorioDpa > 10 && somatorioDpa < 16) {
                                                                                                            dpaResult = "Médio";
                                                                                                        } else {
                                                                                                            dpaResult = "Alto";
                                                                                                        }

                                                                                                        //textResultado.setText(String.valueOf("O resultado é: " + somatorioDpa + "; Classificação: " + dpaResult));

                                                                                                        Log.i("DPA ", "O resultado é: " + somatorioDpa + " | Classificação: " + dpaResult);


                                                                                                        //Enquadramento Resolução nº 696 de 2015

                                                                                                        String enquadramentoAltura = "";
                                                                                                        /*...em desenvolvimento*/
                                                                                                        //Atenção: O barramento possui xx,xx m. Escolha a faixa de altura adequada!
                                                                                                        Double alturaMacico = 14.3;//esse valor deve vir do barramento cadastrado "Altura do maciço (m)"

                                                                                                        if (alturaMacico >= 15) {
                                                                                                            enquadramentoAltura = "Sim";
                                                                                                        } else {
                                                                                                            enquadramentoAltura = "Não";
                                                                                                        }

                                                                                                        //textResultadoAltura.setText(String.valueOf(enquadramentoAltura + " | (Altura: " + alturaMacico + " m)"));


                                                                                                        String enquadramentoReservatorio = "";
                                                                                                        /*...em desenvolvimento*/
                                                                                                        Double volumeReservatorio = 3000000.00;//esse valor deve vir da usina cadastrada "Capacidade total do reservatório (m³)"

                                                                                                        if (volumeReservatorio >= 3000000) {
                                                                                                            enquadramentoReservatorio = "Sim";
                                                                                                        } else {
                                                                                                            enquadramentoReservatorio = "Não";
                                                                                                        }

                                                                                                        //textResultadoReservatorio.setText(String.valueOf(enquadramentoReservatorio + " | (Volume: " + volumeReservatorio + " m³)"));


                                                                                                        String enquadramentoPotencial = "";

                                                                                                        if ((dpaResult == "Médio") || (dpaResult == "Alto")) {
                                                                                                            enquadramentoPotencial = "Sim";
                                                                                                        } else {
                                                                                                            enquadramentoPotencial = "Não";
                                                                                                        }

                                                                                                        //textResultadoPotencial.setText(String.valueOf(enquadramentoPotencial + " | (DPA: " + dpaResult + ")"));


                                                                                                        String enquadramentoResultado = "";

                                                                                                        String sim = "Positivo. O barramento enquadra na Resolução nº 696/2015.";
                                                                                                        String nao = "Negativo. O barramento não enquadra na Resolução nº 696/2015.";

                                                                                                        if (enquadramentoAltura == "Sim" || enquadramentoReservatorio == "Sim") {
                                                                                                            enquadramentoResultado = sim;
                                                                                                        } else {
                                                                                                            enquadramentoResultado = (enquadramentoPotencial == "Sim") ? sim : nao;
                                                                                                        }

                                                                                                        //textResultadoEnquadramento.setText(String.valueOf(enquadramentoResultado));


                                                                                                        //Resultado da Classificação
                                                                                                        String resultadoClassificacao = "";

                                                                                                        if (criResult == "Alto" && dpaResult == "Alto") {
                                                                                                            resultadoClassificacao = "A";
                                                                                                        } else if ((criResult == "Médio" && dpaResult == "Alto") || (criResult == "Baixo" && dpaResult == "Alto")) {
                                                                                                            resultadoClassificacao = "B";
                                                                                                        } else if ((criResult == "Alto" && dpaResult == "Médio") || (criResult == "Alto" && dpaResult == "Baixo")) {
                                                                                                            resultadoClassificacao = "B";
                                                                                                        } else if ((criResult == "Médio" && dpaResult == "Médio") || (criResult == "Baixo" && dpaResult == "Médio")) {
                                                                                                            resultadoClassificacao = "C";
                                                                                                        } else if ((criResult == "Médio" && dpaResult == "Baixo") || (criResult == "Baixo" && dpaResult == "Baixo")) {
                                                                                                            resultadoClassificacao = "C";
                                                                                                        }

                                                                                                        /*
                                                                                                        textResultado.setText(String.valueOf("Barramento Classe: "
                                                                                                                + resultadoClassificacao + " \n Categoria de Risco: " + criResult + " \n Dano Potencial Associado: " + dpaResult
                                                                                                                + "\n\n CT: " + somatorioCt + " | EC: " + somatorioEc + " | PS: " + somatorioPs + " | DPA: " + somatorioDpa));//Resultado
                                                                                                        */


                                                                                                        Log.i("Resultado ", "Classe: " + resultadoClassificacao + " | CRI: " + criResult + " | DPA: " + dpaResult
                                                                                                                + "\n CT: " + somatorioCt + " | EC: " + somatorioEc + " | PS: " + somatorioPs + " | DPA: " + somatorioDpa);


                                                                                                        //Intent


                                                                                                        resultadoPreviaRelatorio = new ResultadoPreviaRelatorio();

                                                                                                        //resultadoPreviaRelatorio.setAlturaMacico(Double.parseDouble(TextInputEditText_alturabarramento.getText().toString()));
                                                                                                        //resultadoPreviaRelatorio.setVolumeReservatorio(Double.parseDouble(TextInputEditText_capacidadeusina.getText().toString()));

                                                                                                        resultadoPreviaRelatorio.setCriResult(criResult);
                                                                                                        resultadoPreviaRelatorio.setDpaResult(dpaResult);

                                                                                                        resultadoPreviaRelatorio.setEnquadramentoAltura(enquadramentoAltura);
                                                                                                        resultadoPreviaRelatorio.setEnquadramentoReservatorio(enquadramentoReservatorio);
                                                                                                        resultadoPreviaRelatorio.setEnquadramentoPotencial(enquadramentoPotencial);
                                                                                                        resultadoPreviaRelatorio.setEnquadramentoResultado(enquadramentoResultado);
                                                                                                        resultadoPreviaRelatorio.setResultadoClassificacao("Barramento Classe: " + resultadoClassificacao + " \n Categoria de Risco: " + criResult + " \n Dano Potencial Associado: " + dpaResult
                                                                                                                + "\n\n CT: " + somatorioCt + " | EC: " + somatorioEc + " | PS: " + somatorioPs + " | DPA: " + somatorioDpa);

                                                                                                        /**/
                                                                                                        //resultadoExpedito.setAwesomeSpinnerConfiabEstrutAducao(AwesomeSpinnerConfiabEstrutAducao.getSelectedItem());

                                                                                                        Intent intent = new Intent(ActivityMatrizClassificacao.this, TelaPreviaRelatorioActivity.class);
                                                                                                        intent.putExtra("classificacao", resultadoPreviaRelatorio);
                                                                                                        startActivity(intent);
                                                                                                        /**/

                                                                                                        /*FIM COD CALCULO*/

                                                                                                    } else {
                                                                                                        Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                                                                    }

                                                                                                } else {
                                                                                                    Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                                                                }

                                                                                            } else {
                                                                                                Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                                                            }

                                                                                        } else {
                                                                                            Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                                                        }

                                                                                    } else {
                                                                                        Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                                                    }

                                                                                } else {
                                                                                    Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                                                }

                                                                            } else {
                                                                                Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                                            }

                                                                        } else {
                                                                            Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                                        }

                                                                    } else {
                                                                        Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                                    }

                                                                } else {
                                                                    Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                                }

                                                            } else {
                                                                Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                            }

                                                        } else {
                                                            Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                        }

                                                    } else {
                                                        Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                    }

                                                } else {
                                                    Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                                }

                                            } else {
                                                Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                            }

                                        } else {
                                            Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                        }

                                    } else {
                                        Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                    }

                                } else {
                                    Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                                }

                            } else {
                                Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                            }

                        } else {
                            Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                        }

                    } else {
                        Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                    }

                } else {
                    Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("ok", null).show();
                }

            }
        });


        btnCancelarClassificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aviso ao usuário
                String resultadoAlertDialog = "Você está prestes a perder os dados inseridos nesta tela.";//alterar menssagem
                AlertDialog.Builder dialog = new AlertDialog.Builder(ActivityMatrizClassificacao.this);

                dialog.setTitle("Cancelar Classificação?");
                dialog.setMessage(resultadoAlertDialog);
                //dialog.setIcon(R.drawable.calc_fsbarragem);
                dialog.setCancelable(true);

                dialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();//finaliza a atual activity. Isso é importante pois evita consumo de recursos desnecessariamente!

                        Toast.makeText(getApplicationContext(), "Classificação cancelada", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Prossiga a classificação", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.create();
                dialog.show();
            }
        });
/*
        //Temporário - apenas para efeito de testes
        Button button = findViewById(R.id.btnClassificacao);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), ActivityDeclaracoes.class));

                Toast.makeText(getApplicationContext(), "Matriz de Classificação preenchida com sucesso.", Toast.LENGTH_SHORT).show();

            }
        });*/

    }

    /*----------------------------------------Carregamento de dados armazenados no firebase-------------------------------------------*/
    private void CarregarDadosMatriz(String tipoMatriz, String conjuntoItens, final List<String> listaDados,
                                     final AwesomeSpinner spinner) {

        mFirestore.collection("Matriz_de_Classificacao")
                .document(tipoMatriz)
                .collection(conjuntoItens)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //Log.d(TAG, document.getId() + " => " + document.getData()); // Lê no formato JSON {desc=descrição,valor=valor}

                                ModoValorDesc modoValorDesc = document.toObject(ModoValorDesc.class); // Separa as tags de valores específicos de desc e valor
                                Log.d(TAG, modoValorDesc.getDesc() + " | " + modoValorDesc.getValor());

                                listaDados.add(modoValorDesc.getDesc());
                                //listaDados.add(String.valueOf(modoValorDesc.getValor()));

                            }

                            ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(getApplicationContext(),
                                    android.R.layout.simple_spinner_item, listaDados);
                            spinner.setAdapter(categoriesAdapter);
                            /*spinner.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
                                @Override
                                public void onItemSelected(int position, String itemAtPosition) {
                                    //TODO YOUR ACTIONS

                                    Toast.makeText(getApplicationContext(), "Position: " + position + " | Item: "
                                                    + itemAtPosition + " | isSelected:" + spinner.isSelected(),
                                            Toast.LENGTH_LONG).show();
                                }
                            });*/

                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }

                    }
                });
    }

    /*-----------------------------------------------------------Menu-----------------------------------------------------------------*/
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
            finish();
            return true;
        }

        if (id == R.id.menu_inserirempresa) {
            startActivity(new Intent(this, ActivityInserirEmpresa.class));
            finish();
            return true;
        }

        if (id == R.id.menu_inserirusina) {
            startActivity(new Intent(this, ActivityInserirUsina.class));
            finish();
            return true;
        }

        if (id == R.id.menu_inserirbarramento) {
            startActivity(new Intent(this, ActivityInserirBarramento.class));
            finish();
            return true;
        }

        if (id == R.id.menu_infogerais) {
            startActivity(new Intent(this, ActivityInfoGerais.class));
            finish();
            return true;
        }

        if (id == R.id.menu_matrizclassificacao) {
            //startActivity(new Intent(this, ActivityMatrizClassificacao.class));
            //finish();
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
            //startActivity(new Intent(this, TelaRelatorioActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}