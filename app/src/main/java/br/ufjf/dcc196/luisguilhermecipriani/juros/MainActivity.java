package br.ufjf.dcc196.luisguilhermecipriani.juros;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_JUROS_SIMPLES = 1;
    public static final int REQUEST_JUROS_COMPOSTOS = 2;

    EditText editTextValorPresente;
    TextView textViewResultado;
    Locale locale = new Locale("pt", "BR");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextValorPresente = findViewById(R.id.editTextValorPresente);
        textViewResultado = findViewById(R.id.textViewResultado);
    }

    public void simplesClick(View view){
        try{
            Double valorPresente = Double.parseDouble(editTextValorPresente.getText().toString());
            Intent simplesIntent = new Intent(getApplicationContext(), SimplesActivity.class);
            simplesIntent.putExtra("valorPresente", valorPresente);
            startActivityForResult(simplesIntent, REQUEST_JUROS_SIMPLES);
        } catch (NumberFormatException ex){
            editTextValorPresente.selectAll();
            editTextValorPresente.requestFocus();
        }
    }

    public void compostosClick(View view){
        try{
            Double valorPresente = Double.parseDouble(editTextValorPresente.getText().toString());
            Intent compostosIntent = new Intent(getApplicationContext(), CompostosActivity.class);
            compostosIntent.putExtra("valorPresente", valorPresente);
            startActivityForResult(compostosIntent, REQUEST_JUROS_COMPOSTOS);
        } catch (NumberFormatException ex){
            editTextValorPresente.selectAll();
            editTextValorPresente.requestFocus();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Double valorFuturo = null;
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_JUROS_SIMPLES){
                valorFuturo = data.getExtras().getDouble("valorFuturo");
            }else if(requestCode == REQUEST_JUROS_COMPOSTOS){
                valorFuturo = data.getExtras().getDouble("valorFuturo");
            }
            textViewResultado.setText(NumberFormat.getCurrencyInstance(locale).format(valorFuturo));
        }
    }
}