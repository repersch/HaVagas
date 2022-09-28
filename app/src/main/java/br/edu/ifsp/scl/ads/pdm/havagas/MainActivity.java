package br.edu.ifsp.scl.ads.pdm.havagas;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.time.LocalDate;

import br.edu.ifsp.scl.ads.pdm.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding amb;
    private Cadastro cadastro;
    private String NOME;
    private String EMAIL;
    private String TELEFONE;
    private String CELULAR;
    private String DATA_NASCIMENTO;
    private String FORMACAO;
    private String ANO_CONCLUSAO;
    private String INTITUICAO;
    private String TITULO_MONOGRAFIA;
    private String ORIENTADOR;
    private String VAGAS_DE_INTERESSE;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());

        amb.limparBt.setOnClickListener(this::limpar);

        amb.salvarBt.setOnClickListener(this::salvar);
        amb.cadastrarCelularSw.setOnClickListener(view -> {
            if (amb.cadastrarCelularSw.isChecked()) {
                amb.celularEt.setVisibility(View.VISIBLE);
            } else {
                amb.celularEt.setVisibility(View.GONE);
            }
        });


        if (savedInstanceState != null) {
            amb.nomeEt.setText(savedInstanceState.getString(NOME));
            amb.emailEt.setText(savedInstanceState.getString(EMAIL));
            amb.telefoneEt.setText(savedInstanceState.getString(TELEFONE));
            amb.celularEt.setText(savedInstanceState.getString(CELULAR));
            amb.dataNascimentoEt.setText(savedInstanceState.getString(DATA_NASCIMENTO));
            amb.anoConclusaoEt.setText(savedInstanceState.getString(ANO_CONCLUSAO));
            amb.instituicaoEt.setText(savedInstanceState.getString(INTITUICAO));
            amb.tituloMonografiaEt.setText(savedInstanceState.getString(TITULO_MONOGRAFIA));
            amb.orientadorEt.setText(savedInstanceState.getString(ORIENTADOR));
            amb.vagasDeInteresseEt.setText(savedInstanceState.getString(VAGAS_DE_INTERESSE));

        }

        amb.formacaoSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao == 1 || posicao == 2) {
                    amb.anoConclusaoEt.setVisibility(View.VISIBLE);
                    amb.instituicaoEt.setVisibility(View.GONE);
                    amb.tituloMonografiaEt.setVisibility(View.GONE);
                    amb.orientadorEt.setVisibility(View.GONE);
                } else if (posicao == 3 || posicao == 4) {
                    amb.anoConclusaoEt.setVisibility(View.VISIBLE);
                    amb.instituicaoEt.setVisibility(View.VISIBLE);
                    amb.tituloMonografiaEt.setVisibility(View.GONE);
                    amb.orientadorEt.setVisibility(View.GONE);
                } else if (posicao == 5 || posicao == 6) {
                    amb.anoConclusaoEt.setVisibility(View.VISIBLE);
                    amb.instituicaoEt.setVisibility(View.VISIBLE);
                    amb.tituloMonografiaEt.setVisibility(View.VISIBLE);
                    amb.orientadorEt.setVisibility(View.VISIBLE);
                } else {
                    amb.anoConclusaoEt.setVisibility(View.GONE);
                    amb.instituicaoEt.setVisibility(View.GONE);
                    amb.tituloMonografiaEt.setVisibility(View.GONE);
                    amb.orientadorEt.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(NOME, amb.nomeEt.getText().toString());
        outState.putString(EMAIL, amb.emailEt.getText().toString());
        outState.putString(TELEFONE, amb.telefoneEt.getText().toString());
        outState.putString(CELULAR, amb.celularEt.getText().toString());
        outState.putString(DATA_NASCIMENTO, amb.dataNascimentoEt.getText().toString());
        outState.putString(FORMACAO, amb.dataNascimentoEt.getText().toString());
        //outState.putInt(ANO_CONCLUSAO, Integer.parseInt(amb.anoConclusaoEt.getText().toString()));
        outState.putString(INTITUICAO, amb.instituicaoEt.getText().toString());
        outState.putString(TITULO_MONOGRAFIA, amb.tituloMonografiaEt.getText().toString());
        outState.putString(ORIENTADOR, amb.orientadorEt.getText().toString());
        outState.putString(VAGAS_DE_INTERESSE, amb.vagasDeInteresseEt.getText().toString());
    }

    private void limpar(View view) {
        amb.nomeEt.setText("");
        amb.emailEt.setText("");
        amb.receberEmailCb.setChecked(false);
        amb.residencialRb.setChecked(true);
        amb.telefoneEt.setText("");
        amb.celularEt.setText("");
        amb.femininoRb.setChecked(true);
        amb.dataNascimentoEt.setText("");
        amb.formacaoSp.setSelection(0);
        amb.instituicaoEt.setText("");
        amb.anoConclusaoEt.setText("");
        amb.orientadorEt.setText("");
        amb.tituloMonografiaEt.setText("");
        amb.vagasDeInteresseEt.setText("");
        amb.cadastrarCelularSw.setChecked(false);
        amb.celularEt.setVisibility(View.GONE);
    }

    private void salvar(View view) {
        cadastro = new Cadastro();
        cadastro.setNome(amb.nomeEt.getText().toString());
        cadastro.setEmail(amb.emailEt.getText().toString());
        cadastro.setReceberEmail(amb.receberEmailCb.isChecked());
        cadastro.setTipoTelefone(amb.residencialRb.isChecked() ? "Residencial" : "Comercial");
        cadastro.setTelefone(amb.telefoneEt.getText().toString());
        cadastro.setCelular(amb.cadastrarCelularSw.isChecked() ? amb.celularEt.getText().toString() : null);
        cadastro.setSexo(amb.femininoRb.isChecked() ? "Feminino" : "Masculino");
        cadastro.setDataNascimento(amb.dataNascimentoEt.getText().toString());
        cadastro.setFormacao(amb.formacaoSp.getSelectedItem().toString());
        String formacao = amb.formacaoSp.getSelectedItem().toString();
        cadastro.setAnoConclusao(Integer.valueOf(amb.anoConclusaoEt.getText().toString()));
        if (!formacao.equals("Fundamental") || !formacao.equals("Médio")) {
            cadastro.setInstituicao(amb.instituicaoEt.getText().toString());
        }

        if (formacao.equals("Mestrado") || formacao.equals("Doutorado")) {
            cadastro.setTituloMonografia(amb.tituloMonografiaEt.getText().toString());
            cadastro.setOrientador(amb.orientadorEt.getText().toString());
        }
        cadastro.setVagasDeInteresse(amb.vagasDeInteresseEt.getText().toString());

        Toast toast = Toast.makeText(getApplicationContext(), cadastro.toString(), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        limpar(view);
        toast.show();

        System.out.println(cadastro);
    }
}