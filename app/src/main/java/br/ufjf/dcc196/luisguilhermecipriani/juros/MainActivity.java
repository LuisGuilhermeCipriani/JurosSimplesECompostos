package br.ufjf.dcc196.luisguilhermecipriani.juros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextValorPresente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextValorPresente = findViewById(R.id.editTextValorPresente);
    }

    public void simplesClick(View view){
        try{
            Double valorPresente = Double.parseDouble(editTextValorPresente.getText().toString());
            Intent simplesIntent = new Intent(getApplicationContext(), SimplesActivity.class);
            simplesIntent.putExtra("valorPresente", valorPresente);
            startActivity(simplesIntent);
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
            startActivity(compostosIntent);
        } catch (NumberFormatException ex){
            editTextValorPresente.selectAll();
            editTextValorPresente.requestFocus();
        }
    }
}