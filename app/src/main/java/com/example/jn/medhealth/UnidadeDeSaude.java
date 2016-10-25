package com.example.jn.medhealth;

import java.io.Serializable;

/**
 * Created by MarcosInacio on 25/10/2016.
 */

public class UnidadeDeSaude implements Serializable {
    public String nome;

    public UnidadeDeSaude(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
