package com.leenadam.app.MatrizClassificacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
import com.leenadam.app.InfoGeral.ActivityInfoGerais;
import com.leenadam.app.MainActivity;
import com.leenadam.app.R;
import com.leenadam.app.TesteBancoActivity;
import com.leenadam.app.Usina.ActivityInserirUsina;
import com.leenadam.app.util.DadoMatrizClassif;
import com.leenadam.app.util.ModoValorDesc;

import java.util.ArrayList;
import java.util.List;

import me.srodrigo.androidhintspinner.HintAdapter;
import me.srodrigo.androidhintspinner.HintSpinner;

public class ActivityMatrizClassificacao extends AppCompatActivity {

    protected static final String TAG = "MatrizClassificao";
    private FirebaseFirestore mFirestore;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriz_classificacao);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d(TAG, "Matriz iniciada");

        // Access a Cloud Firestore instance from your Activity

        FirebaseFirestore.setLoggingEnabled(true);

        mFirestore = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        mFirestore.setFirestoreSettings(settings);

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


    }

    private void CarregarDadosMatriz(String tipoMatriz, String conjuntoItens, final List<String> listaDados,
                                     final AwesomeSpinner spinner){

        mFirestore.collection("Matriz_de_Classificacao")
                .document(tipoMatriz)
                .collection(conjuntoItens)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //Log.d(TAG, document.getId() + " => " + document.getData()); // Le no formato JSON {desc=valor,valor=valor}

                                ModoValorDesc modoValorDesc = document.toObject(ModoValorDesc.class); // Separa as tags de valores espeificos de desc e valor
                                Log.d(TAG, modoValorDesc.getDesc() + " | " + modoValorDesc.getValor());

                                listaDados.add(modoValorDesc.getDesc());
                            }

                            ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(getApplicationContext(),
                                    android.R.layout.simple_spinner_item, listaDados);
                            spinner.setAdapter(categoriesAdapter);
                            spinner.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
                                @Override
                                public void onItemSelected(int position, String itemAtPosition) {
                                    //TODO YOUR ACTIONS
                                    Toast.makeText(getApplicationContext(), "Position: " + position + " | Item: "
                                                    + itemAtPosition + " | isSelected:" + spinner.isSelected(),
                                            Toast.LENGTH_LONG).show();
                                }
                            });

                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }

                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

}
