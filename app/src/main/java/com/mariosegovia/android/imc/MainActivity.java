package com.mariosegovia.android.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mariosegovia.android.imc.R;

public class MainActivity extends AppCompatActivity {
    //ed600 ADATA DURABLE
    private EditText mCampoPeso;
    private EditText mCampoestatura;
    private Button mBotonCalcular;
    private Button  mBotonLimpiar;
    private TextView mImcTextView;
    private TextView mNutricionalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCampoPeso = findViewById(R.id.campo_peso);
        mCampoestatura = findViewById(R.id.campo_estatura);
        mBotonCalcular = findViewById(R.id.boton_calcular);
        mImcTextView = findViewById(R.id.imc_text_view);
        mNutricionalTextView= findViewById(R.id.nutricional_text_view);

        mBotonCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String s = mCampoPeso.getText().toString();
                double peso = Double.parseDouble(s);
                String s1 = mCampoestatura.getText().toString();
                double estatura = Double.parseDouble(s1);
                double imc = peso / Math.pow(estatura,2);
                mImcTextView.setText(Double.toString(imc));

                if(imc <18.5){
                    mNutricionalTextView.setText("Ud tiene peso bajo");
                }
                if(imc >= 18.5 || imc < 24.99){
                    mNutricionalTextView.setText("Ud tiene peso normal");
                }if(imc >= 25.0 || imc < 29.99){
                    mNutricionalTextView.setText("Ud tiene Sobrepeso");
                }if(imc >= 30.0 || imc < 39.99){
                    mNutricionalTextView.setText("Ud tiene obesidad");
                }if(imc > 39.99){
                    mNutricionalTextView.setText("Ud tiene obesidad extrema");
                }
            }
        });
        mBotonLimpiar = findViewById(R.id.boton_limpiar);
        mBotonLimpiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mCampoPeso.setText(" ");
                mCampoestatura.setText(" ");
                mImcTextView.setText(" ");
                mNutricionalTextView.setText("  ");
            }
        });
    }
}
