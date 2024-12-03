package com.ifsc.tabelanutricional.FileReader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DbFileReader {
    public int insertFromFile(Context context, SQLiteDatabase db) throws IOException {
        int result = 0;
        InputStream stream = context.getAssets().open("taco_converted_sqlite.sql");
        //this.getAssets().open("taco_converted_sqlite.sql");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
        StringBuilder comando = new StringBuilder();
        String linha;
        while((linha = buffer.readLine()) != null) {
            comando.append(linha);
            if(linha.contains(";")){
                db.execSQL(comando.toString());
                comando.setLength(0);
            }
        }
        buffer.close();

        return result;
    }
}
