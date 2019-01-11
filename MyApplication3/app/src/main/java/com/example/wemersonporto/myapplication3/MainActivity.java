package com.example.wemersonporto.myapplication3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textViewResultado);

    }

    public void calcularPreco(View view){
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        if(this.validarCampos(precoAlcool,precoGasolina)){
            this.calcularMelhorPreco(precoAlcool,precoGasolina);
        } else {
//            textResultado.setText("Preencha os preços primeiro!");
            Toast.makeText(getApplicationContext(),"Preencha os preços primeiro!", Toast.LENGTH_LONG).show();
        }

    }

    public Boolean validarCampos(String pAlc, String pGas){
        if((pAlc == null || !pAlc.equalsIgnoreCase("")) && pGas == null || !pGas.equalsIgnoreCase("")){
            return true;
        }else{
            return  false;
        }
    }

    public void calcularMelhorPreco(String pAlc, String pGas){
        Double precoAlcool = Double.parseDouble(pAlc);
        Double precoGasolina = Double.parseDouble(pGas);
        if (precoAlcool / precoGasolina >= 0.7){
            textResultado.setText("Melhor utilizar Gasolina!");
        } else {
            textResultado.setText("Melhor utilizar Álcool!");
        }
    }
}
