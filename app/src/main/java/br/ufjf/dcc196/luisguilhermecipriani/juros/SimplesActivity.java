package br.ufjf.dcc196.luisguilhermecipriani.juros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class SimplesActivity extends AppCompatActivity {
    TextView textViewValorPresente;
    Double valorPresente;
    EditText editTextTaxa;
    EditText editTextPeriodos;
    TextView textViewValorFuturo;
    Button buttonCalcular;
    Button buttonRetornar;
    Double valorFuturo;
    Locale locale = new Locale("pt", "BR");
    Double taxaJuros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simples);
        textViewValorPresente = findViewById(R.id.textViewValorPresente);
        textViewValorFuturo = findViewById(R.id.textViewValorFuturo);
        Bundle extras = getIntent().getExtras();
        valorPresente = extras.getDouble("valorPresente");
        textViewValorPresente.setText(valorPresente.toString());
        taxaJuros = extras.getDouble("taxaJuros");
        editTextTaxa = findViewById(R.id.editTextTaxa);
        editTextTaxa.setText(Double.toString(taxaJuros));
        editTextPeriodos = findViewById(R.id.editTextPeriodos);
        editTextPeriodos.setText("10");
    }

    public void calcularClick(View view){
        taxaJuros = Double.parseDouble(editTextTaxa.getText().toString());
        Integer periodos = Integer.parseInt(editTextPeriodos.getText().toString());
        valorFuturo = valorPresente*(1 + taxaJuros *periodos);
        textViewValorFuturo.setText(NumberFormat.getCurrencyInstance(locale).format(valorFuturo));
    }

    public void retornarClick(View view){
        Intent resultado = new Intent();
        resultado.putExtra("valorFuturo", valorFuturo);
        resultado.putExtra("taxaJurosSimples", taxaJuros);
        setResult(RESULT_OK, resultado);
        finish();
    }
}