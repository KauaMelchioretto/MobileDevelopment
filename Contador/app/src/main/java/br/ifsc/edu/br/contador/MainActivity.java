package br.ifsc.edu.br.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumeroInicial, editTextNumeroFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        editTextNumeroInicial = findViewById(R.id.numeroInicial);
        editTextNumeroFinal = findViewById(R.id.numeroFinal);

        myButton.setOnClickListener(view -> {
            Random random = new Random();
            int numeroInicial =  Integer.parseInt(editTextNumeroInicial.getText().toString());
            int numeroFinal = Integer.parseInt(editTextNumeroFinal.getText().toString());

            textView.setText(Integer.toString(random.nextInt(numeroFinal - numeroInicial + 1) + numeroInicial));
        });
    }
}