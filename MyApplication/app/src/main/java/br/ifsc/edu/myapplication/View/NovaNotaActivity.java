package br.ifsc.edu.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.ifsc.edu.myapplication.Contollers.NotaController;
import br.ifsc.edu.myapplication.Model.Nota;
import br.ifsc.edu.myapplication.R;

public class NovaNotaActivity extends AppCompatActivity {
    NotaController notaController;
    EditText editTextTitulo, editTextTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_nota);
        notaController = new NotaController(getApplicationContext());
        editTextTitulo = findViewById(R.id.editTitulo);
        editTextTxt = findViewById(R.id.editTexto);
    }

    public void novaNota(View view) {
        String titulo = editTextTitulo.getText().toString();
        String texto = editTextTxt.getText().toString();
        Nota nota = notaController.cadastrarNota(new Nota(titulo, texto));

        if((nota.getId() != null &&
                !editTextTitulo.getText().toString().isEmpty() &&
                !editTextTxt.getText().toString().isEmpty())) {
            Toast.makeText(getApplicationContext(),
                    "Nota Cadastrada! - " + Integer.toString(nota.getId()),
                    Toast.LENGTH_LONG).show();
                    editTextTitulo.setText("");
                    editTextTxt.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Erro ao cadastrar nota!", Toast.LENGTH_LONG).show();
        }
    }
}
