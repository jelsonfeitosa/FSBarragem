package com.leenadam.app.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.leenadam.app.Empresa.ActivityInserirEmpresa;
import com.leenadam.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment implements View.OnClickListener {

    String descricao = "De acordo com o Art. 5º da Lei nº 12.334, de 20 de setembro de 2010, tem-se que:\n" +
            "\n" +
            "Art. 5º A fiscalização da segurança de barragens caberá, sem prejuízo das ações fiscalizatórias dos órgãos ambientais integrantes do Sistema Nacional do Meio Ambiente (Sisnama):\n" +
            "\n" +
            "I - à entidade que outorgou o direito de uso dos recursos hídricos, observado o domínio do corpo hídrico, quando o objeto for de acumulação de água, exceto para fins de aproveitamento hidrelétrico; (ANA)\n" +
            "\n" +
            "II - à entidade que concedeu ou autorizou o uso do potencial hidráulico, quando se tratar de uso preponderante para fins de geração hidrelétrica; (ANEEL)\n" +
            "\n" +
            "III - à entidade outorgante de direitos minerários para fins de disposição final ou temporária de rejeitos; (ANM)\n" +
            "\n" +
            "IV - à entidade que forneceu a licença ambiental de instalação e operação para fins de disposição de resíduos industriais. (IBAMA)";

    //Atributos
    private ImageButton buttonAna, buttonAneel, buttonAnm, buttonIbama, buttonInfo;
    private TextView textViewInfo;


    public PrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // criar objeto
        View view = inflater.inflate(R.layout.fragment_principal, container, false);

        //acessar todos o s componentes
        buttonAna = view.findViewById(R.id.buttonAna);
        buttonAneel = view.findViewById(R.id.buttonAneel);
        buttonAnm = view.findViewById(R.id.buttonAnm);
        buttonIbama = view.findViewById(R.id.buttonIbama);
        buttonInfo = view.findViewById(R.id.buttonInfo);

        textViewInfo = view.findViewById(R.id.textViewInfo);

        //aplicar eventos de clique - no momento será configurado apenas para a aneel
        buttonAna.setOnClickListener(this);
        buttonAneel.setOnClickListener(this);
        buttonAnm.setOnClickListener(this);
        buttonIbama.setOnClickListener(this);
        buttonInfo.setOnClickListener(this);

        textViewInfo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i("Elemento clicado", "Item: " + v.getId()); //para verificar o funcionamento

        //utilizando o switch para fazer a verificação
        switch (v.getId()) {
            case R.id.buttonAna:
                abrirOps("titulo", "mensagem");
                break;

            case R.id.buttonAneel:
                Intent intent = new Intent(getActivity(), ActivityInserirEmpresa.class);
                startActivity(intent);
                break;

            case R.id.buttonAnm:
                abrirOps("titulo", "mensagem");
                break;

            case R.id.buttonIbama:
                abrirOps("titulo", "mensagem");
                break;

            case R.id.buttonInfo:
                abrirInfo("titulo", "mensagem");
                break;
        }

    }

    public void abrirInfo(String titulo, String mensagem) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());

        dialog.setCancelable(true);
        dialog.setTitle("O que diz a Lei?");
        dialog.setMessage(descricao);

        dialog.setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Prossiga", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.create();
        dialog.show();
    }

    public void abrirOps(String titulo, String mensagem) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());

        dialog.setCancelable(true);
        dialog.setTitle("Ops...!");
        dialog.setMessage("Este formulário ainda não foi desenvolvido.");

        dialog.setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "O formulário da Aneel está disponível.", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.create();
        dialog.show();
    }

}
