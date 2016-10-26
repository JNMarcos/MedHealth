package com.example.jn.medhealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SobreActivity extends AppCompatActivity {

    TextView versao;
    ImageView icone_app;
    TextView sobre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        versao = (TextView) findViewById(R.id.versao);
        sobre = (TextView) findViewById(R.id.sobre);
        icone_app = (ImageView) findViewById(R.id.icone_app);
    }
}