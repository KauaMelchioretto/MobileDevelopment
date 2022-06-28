package br.ifsc.edu.myapplication.Model;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class NotaDAO {
    private Context context;
    private SQLiteDatabase dataBase;

    public NotaDAO(Context context) {
        this.context = context;
        dataBase = context.openOrCreateDatabase("NotaDb", Context.MODE_PRIVATE, null);
        dataBase.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, texto VARCHAR NOT NULL);");
    }

    public Nota criarNota(Nota nota) {
        ContentValues cv = new ContentValues();
        cv.put("titulo", nota.getTitulo());
        cv.put("texto", nota.getTexto());

        nota.setId((int) dataBase.insert("notas", null, cv));
        Log.d("valores", "" + Integer.toString(nota.getId()));

        return nota;
    }

    public boolean editarNota(Nota nota) {
        ContentValues cv = new ContentValues();
        cv.put("titulo", nota.getTitulo());
        cv.put("texto", nota.getTexto());
        dataBase.update("notas", cv, "id = ?", new String[]{Integer.toString(nota.getId())});
        return  true;
    }

    public boolean excluirNota(Nota nota) {
        long var = dataBase.delete("notas", "id = ?", new String[]{Integer.toString(nota.getId())});

        if (var == 0)
            return false;

        return  true;
    }

    public ArrayList<Nota> getListaNotas() {
        Cursor cursor = dataBase.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<Nota> arrayListNotas = new ArrayList();
        while (!cursor.isAfterLast()) {
            Nota nota = new Nota(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            arrayListNotas.add(nota);
            cursor.moveToNext();
        }
        return arrayListNotas;
    }

    public Nota getNotaById(Integer idNota) {
        Cursor cursor = dataBase.rawQuery("SELECT * FROM notas WHERE id = ?", new String[]{Integer.toString(idNota)});
        cursor.moveToFirst();
        Nota nota = new Nota(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        return nota;
    }

    public boolean excluirNota(Integer idNota) {
        long var = dataBase.delete("notas", "id = ?", new String[]{Integer.toString(idNota)});

        if (var == 0)
            return false;

        Log.d("Nota", " excluída com sucesso!");
        return  true;
    }
}
