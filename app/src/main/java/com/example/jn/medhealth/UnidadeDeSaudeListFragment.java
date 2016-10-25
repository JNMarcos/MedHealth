package com.example.jn.medhealth;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MarcosInacio on 25/10/2016.
 */

public class UnidadeDeSaudeListFragment extends ListFragment {
    List<UnidadeDeSaude> mUnidadesDeSaude;
    ArrayAdapter<UnidadeDeSaude> mAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mUnidadesDeSaude = carregarUnidadesDeSaude();
        mAdapter = new ArrayAdapter<UnidadeDeSaude>(
                getActivity(),
                android.R.layout.simple_list_item_1,mUnidadesDeSaude);
        setListAdapter(mAdapter);
    }

    private List<UnidadeDeSaude> carregarUnidadesDeSaude(){
        List<UnidadeDeSaude> unidadesDeSaude = new ArrayList<UnidadeDeSaude>();
        unidadesDeSaude.add(new UnidadeDeSaude("Centros de Especialidades Odontológicas"));
        unidadesDeSaude.add(new UnidadeDeSaude("Farmacias da Familia"));
        unidadesDeSaude.add(new UnidadeDeSaude("Hospitais"));
        unidadesDeSaude.add(new UnidadeDeSaude("Policlinica"));
        unidadesDeSaude.add(new UnidadeDeSaude("Serviço de Apoio Diagnostico e Terapêutico"));
        unidadesDeSaude.add(new UnidadeDeSaude("Saúde Mental"));
        unidadesDeSaude.add(new UnidadeDeSaude("Serviço de Pronto Atendimento"));
        unidadesDeSaude.add(new UnidadeDeSaude("Unidades Básicas de Saúde"));
        unidadesDeSaude.add(new UnidadeDeSaude("Unidades Saúde da Familia"));
        unidadesDeSaude.add(new UnidadeDeSaude("Unidades Especializadas"));
        unidadesDeSaude.add(new UnidadeDeSaude("Farmacias Populares"));
        unidadesDeSaude.add(new UnidadeDeSaude("Maternidades"));
        return unidadesDeSaude;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        Activity activity = getActivity();
        if(activity instanceof AoClicarNaUnidadeDeSaude){
            UnidadeDeSaude unidadeDeSaude = (UnidadeDeSaude) l.getItemAtPosition(position);
            AoClicarNaUnidadeDeSaude listener = (AoClicarNaUnidadeDeSaude) activity;
            listener.clicouNaUnidadeDeSaude(unidadeDeSaude);
        }
    }
    public interface AoClicarNaUnidadeDeSaude{
        void clicouNaUnidadeDeSaude(UnidadeDeSaude unidadeDeSaude);
    }

}
