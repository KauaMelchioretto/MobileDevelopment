package com.ifsc.tabelanutricional;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifsc.tabelanutricional.Controllers.AlimentoController;
import com.ifsc.tabelanutricional.FileReader.DbFileReader;
import com.ifsc.tabelanutricional.Model.Alimento;
import com.ifsc.tabelanutricional.Model.AlimentoAdapter;
import com.ifsc.tabelanutricional.View.InfoAlimento;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    ListView listView;
    Button btnBuscar;
    EditText etBuscar;
    ArrayList<Alimento> alimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        criaBanco();

        btnBuscar = findViewById(R.id.buscar);
        etBuscar = findViewById(R.id.infoBusca);
        listView = findViewById(R.id.listView);
        AlimentoController alimentoController = new AlimentoController(this);
        try {
            alimentos = alimentoController.getAlimentos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        btnBuscar.setOnClickListener(v -> {
            String infoBusca = etBuscar.getText().toString();
            try {
                alimentos = alimentoController.buscaAlimentos(infoBusca);
                carregaListagemAlimentos();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void criaBanco() {
        db = openOrCreateDatabase("tabela_nutricional", MODE_PRIVATE, null);

        try {
            DbFileReader dbFileReader = new DbFileReader();
            int result = dbFileReader.insertFromFile(this, db);
            Toast.makeText(this, "Linhas carregadas: " + result, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        carregaListagemAlimentos();

        listView.setOnItemClickListener((adapterView, view, index, l) -> {
            Integer codigo = alimentos.get(index).codigo;
            Integer codigoPreparo = alimentos.get(index).getCodigoPreparo();
            Intent intent = new Intent(getApplicationContext(), InfoAlimento.class);
            intent.putExtra("cod_alimento", Integer.toString(codigo));
            intent.putExtra("cod_preparo", Integer.toString(codigoPreparo));
            startActivity(intent);
        });
    }

    private void carregaListagemAlimentos() {
        AlimentoAdapter adapter = new AlimentoAdapter(this, alimentos);
        listView.setAdapter(adapter);
    }
}