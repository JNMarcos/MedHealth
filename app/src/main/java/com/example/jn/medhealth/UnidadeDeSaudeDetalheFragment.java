package com.example.jn.medhealth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MarcosInacio on 25/10/2016.
 */

public class UnidadeDeSaudeDetalheFragment extends Fragment {
    public static final String TAG_DETALHE = "tagDetalhe";
    private static final String EXTRA_UNIDADEDESAUDE = "unidadeDeSaude";

    TextView nTextNome;

    UnidadeDeSaude mUnidadeDeSaude;
    public static UnidadeDeSaudeDetalheFragment novaInstancia(UnidadeDeSaude unidadeDeSaude){
        Bundle parametros = new Bundle();
        parametros.putSerializable(EXTRA_UNIDADEDESAUDE, unidadeDeSaude);
        UnidadeDeSaudeDetalheFragment fragment = new UnidadeDeSaudeDetalheFragment();
        fragment.setArguments(parametros);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View layout = inflater.inflate(R.layout.fragment_unidadedesaude_detalhe, container, false);
        nTextNome = (TextView)layout.findViewById(R.id.txtNome);
        if(mUnidadeDeSaude != null){
            nTextNome.setText(mUnidadeDeSaude.nome);
        }
        return layout;
    }

}





