package br.ufjf.dcc196.luisguilhermecipriani.juros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SimplesActivity extends AppCompatActivity {
    TextView textViewValorPresente;
    Float valorPresente;
    EditText editTextTaxa;
    EditText editTextPeriodos;
    TextView textViewValorFuturo;
    Button buttonCalcular;
    Button buttonRetornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simples);
        textViewValorPresente = findViewById(R.id.textViewValorPresente);
        textViewValorFuturo = findViewById(R.id.textViewValorFuturo);
        Bundle extras = getIntent().getExtras();
        valorPresente = extras.getFloat("valorPresente");
        textViewValorPresente.setText(valorPresente.toString());
        editTextTaxa = findViewById(R.id.editTextTaxa);
        editTextTaxa.setText("0.1");
        editTextPeriodos = findViewById(R.id.editTextPeriodos);
        editTextPeriodos.setText("10");

    }

    public void calcularClick(View view){
        Float taxa = Float.parseFloat(editTextTaxa.getText().toString());
        Integer periodos = Integer.parseInt(editTextPeriodos.getText().toString());
        Float valorFuturo = valorPresente*(1 + taxa*periodos);
        textViewValorFuturo.setText(valorFuturo.toString());
    }

    public void retornarClick(View view){
        finish();
    }
}