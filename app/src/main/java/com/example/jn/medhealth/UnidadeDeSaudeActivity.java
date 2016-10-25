package com.example.jn.medhealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by MarcosInacio on 25/10/2016.
 */

public class UnidadeDeSaudeActivity extends AppCompatActivity
        implements UnidadeDeSaudeListFragment.AoClicarNaUnidadeDeSaude{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unidadedesaude);
    }

    public void clicouNaUnidadeDeSaude(UnidadeDeSaude unidadeDeSaude){
        if(isTablet()){
            UnidadeDeSaudeDetalheFragment fragment =
                    UnidadeDeSaudeDetalheFragment.novaInstancia(unidadeDeSaude);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.detalhe, fragment,
                    UnidadeDeSaudeDetalheFragment.TAG_DETALHE);
            ft.commit();
        }
                Intent it = new Intent(this, UnidadeDeSaudeDetalheActivity.class);
        it.putExtra(UnidadeDeSaudeDetalheActivity.EXTRA_UNIDADEDESAUDE, unidadeDeSaude);
        startActivity(it);
    }
    private boolean isTablet(){
        return findViewById(R.id.detalhe) != null;
    }
}
