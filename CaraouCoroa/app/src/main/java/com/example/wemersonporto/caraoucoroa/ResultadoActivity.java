package com.example.wemersonporto.caraoucoroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {

    private Button btnVoltar;
    private ImageView imgResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        btnVoltar = findViewById(R.id.buttonVoltar);
        imgResultado = findViewById(R.id.imageResultado);

        Bundle dados = getIntent().getExtras();
        int numero = dados.getInt("numero");

        if( numero == 0){
            imgResultado.setImageResource(R.drawable.moeda_cara);
        }else{
            imgResultado.setImageResource(R.drawable.moeda_coroa);
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             finish();
                                         }
                                     }
        );
    }

}
