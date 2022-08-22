package br.edu.ifsp.scl.ads.pdm.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import br.edu.ifsp.scl.ads.pdm.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding amb;
    private Cadastro adastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());

        amb.limparBt.setOnClickListener( view -> {
            amb.nomeEt.setText("");
            amb.emailEt.setText("");
            amb.receberEmailCb.setChecked(false);
            amb.telefoneEt.setText("");
            amb.celularEt.setText("");
            amb.femininoRb.setChecked(true);
            amb.dataNascimentoEt.setText("");
            amb.formacaoSp.setSelection(0);
            amb.vagasDeInteresseEt.setText("");
        });


        amb.formacaoSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao == 1 || posicao == 2) {
                    amb.fundamentalMedioLl.setVisibility(View.VISIBLE);
                } else if (posicao == 3 || posicao == 4) {
                    amb.graduacaoEspecializacaoLl.setVisibility(View.VISIBLE);
                } else if (posicao == 5 || posicao == 6) {
                    amb.mestradoDoutoradoLl.setVisibility(View.VISIBLE);
                } else {
                    amb.fundamentalMedioLl.setVisibility(View.GONE);
                    amb.graduacaoEspecializacaoLl.setVisibility(View.GONE);
                    amb.mestradoDoutoradoLl.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}