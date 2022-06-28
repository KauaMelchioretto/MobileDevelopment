package br.ifsc.edu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import br.ifsc.edu.myapplication.Contollers.NotaController;
import br.ifsc.edu.myapplication.View.InformacaoNotas;
import br.ifsc.edu.myapplication.View.NovaNotaActivity;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    ListView listView;
    NotaController notaController;
    Button newNoteButton;
    ArrayList<Integer> arrayIdNota = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newNoteButton = findViewById(R.id.newNote);
        newNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NovaNotaActivity.class);
                startActivity(intent);
            }
        });
        listView = findViewById(R.id.listView);
        notaController = new NotaController(this);
        arrayIdNota = notaController.getIdNotas();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Integer idNota = arrayIdNota.get(i);
                Intent intent = new Intent(getApplicationContext(), InformacaoNotas.class);
               intent.putExtra("idNota", Integer.toString(idNota));
                startActivity(intent);
                finish();
            }
        });
    }

    public void carregaListagemNotas() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                notaController.getListaTituloNota());

        listView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        carregaListagemNotas();
    }
}
