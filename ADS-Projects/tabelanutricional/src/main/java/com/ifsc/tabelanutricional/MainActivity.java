package com.ifsc.tabelanutricional;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifsc.tabelanutricional.FileReader.DbFileReader;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}