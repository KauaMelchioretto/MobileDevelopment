package br.ifsc.edu.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.ifsc.edu.myapplication.Contollers.NotaController;
import br.ifsc.edu.myapplication.MainActivity;
import br.ifsc.edu.myapplication.Model.Nota;


import br.ifsc.edu.myapplication.R;

public class InformacaoNotas extends AppCompatActivity {
    Button buttonEditar;
    Button buttonExcluir;
    NotaController notaController;
    TextView textIdNota;
    EditText textTituloNota;
    EditText textTextoNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_notas);
        notaController = new NotaController(this);
        textIdNota = findViewById(R.id.viewIdNota);
        textTituloNota = findViewById(R.id.tituloNota);
        textTextoNota = findViewById(R.id.textoNota);
        final String idNota = getIntent().getStringExtra("idNota");

        buttonEditar = findViewById(R.id.buttonEditar);
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editarNota();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        buttonExcluir = findViewById(R.id.buttonExcluir);
        buttonExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notaController.excluirNota(Integer.parseInt(idNota));
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        getNotaById(Integer.parseInt(idNota));
    }
    public Nota getNotaById(Integer idNota) {
        Nota nota = notaController.getNotaById(idNota);
        textIdNota.setText(nota.getId().toString());
        textTituloNota.setText(nota.getTitulo());
        textTextoNota.setText(nota.getTexto());
        return  nota;
    }

    public void editarNota() {
        String idNota = textIdNota.getText().toString();
        String titulo = textTituloNota.getText().toString();
        String texto = textTextoNota.getText().toString();
        boolean edited = notaController.editarNota(new Nota(Integer.parseInt(idNota) ,titulo, texto));

        if(!edited)
            Toast.makeText(getApplicationContext(), "Erro ao editar nota!", Toast.LENGTH_LONG).show();
         else
            Toast.makeText(getApplicationContext(), "Editado com sucesso!", Toast.LENGTH_LONG).show();
    }
}


