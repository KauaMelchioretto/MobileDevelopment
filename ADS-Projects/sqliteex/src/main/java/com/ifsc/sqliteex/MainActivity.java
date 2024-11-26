package com.ifsc.sqliteex;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    EditText etTexto;
    Button btnSalvar;
    ListView lvNotas;
    ArrayList<String> notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("notinhas", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, texto VARCHAR)");
        btnSalvar = findViewById(R.id.save);
        etTexto = findViewById(R.id.texto);
        lvNotas = findViewById(R.id.listViewNotas);

        notas = getNotas(db);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                notas);

        lvNotas.setAdapter(adapter);

        btnSalvar.setOnClickListener(view -> {
            String nome = etTexto.getText().toString();

            ContentValues cv = new ContentValues();
            cv.put("texto", nome);
            if(db.insert("notas", null, cv) > 0) {
                Toast.makeText(getApplicationContext(), "Inserido o registro com a nota '" + nome + "'", Toast.LENGTH_LONG);
                Log.i("MyLog", "Inserido o registro com a nota '" + nome + "'");
            }

            adapter.add(nome);
            etTexto.setText(null);
        });
    }

    public ArrayList<String> getNotas(SQLiteDatabase db) {
        ArrayList<String> notas = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            String texto = cursor.getString(cursor.getColumnIndex("texto"));
            notas.add(texto);
            cursor.moveToNext();
        }

        return notas;
    }
}