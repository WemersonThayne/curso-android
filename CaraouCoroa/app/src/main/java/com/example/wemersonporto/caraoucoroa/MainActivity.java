package com.example.wemersonporto.caraoucoroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJogar = findViewById(R.id.buttonJogar);
        this.jogar();
    }

    public void jogar(){
        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);
                int numero = new Random().nextInt(2);
                intent.putExtra("numero", numero);
                startActivity(intent);

            }
        });
    }
}
