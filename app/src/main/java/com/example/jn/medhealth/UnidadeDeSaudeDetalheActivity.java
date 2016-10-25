package com.example.jn.medhealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by MarcosInacio on 25/10/2016.
 */

public class UnidadeDeSaudeDetalheActivity extends AppCompatActivity {
    public static final String EXTRA_UNIDADEDESAUDE = "unidadeDeSaude";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unidadedesaude_detalhe);
        Intent intent = getIntent();
        UnidadeDeSaude unidadeDeSaude = (UnidadeDeSaude)
                intent.getSerializableExtra(EXTRA_UNIDADEDESAUDE);
        UnidadeDeSaudeDetalheFragment fragment =
                UnidadeDeSaudeDetalheFragment.novaInstancia(unidadeDeSaude);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.detalhe, fragment,
                UnidadeDeSaudeDetalheFragment.TAG_DETALHE);
        ft.commit();
    }

}
