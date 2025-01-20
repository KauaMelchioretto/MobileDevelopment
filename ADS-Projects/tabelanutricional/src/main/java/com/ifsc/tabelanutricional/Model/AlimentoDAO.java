package com.ifsc.tabelanutricional.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.UFormat;

import java.util.ArrayList;

public class AlimentoDAO {
    private Context context;
    private SQLiteDatabase dataBase;

    public AlimentoDAO(Context context) {
        this.context = context;
        dataBase = context.openOrCreateDatabase("tabela_nutricional", Context.MODE_PRIVATE, null);
    }

    public ArrayList<Alimento> getListaAlimentos() throws Exception {
        try {
            Cursor cursor = dataBase.rawQuery("SELECT codigo, nome_alimento, cod_preparo, forma_preparo FROM alimentos_lip_acucares_100g", null);
            cursor.moveToFirst();

            ArrayList<Alimento> alimentos = preencheLista(cursor);

            return alimentos;
        } catch (Error e) {
            throw new Exception("Erro no método getListaAlimentos(), Erro: " + e.getMessage());
        }
    }

        public ArrayList<Alimento> buscaAlimentos(String infoBusca) throws Exception{
            try {
                String buscaLike = "%" + infoBusca + "%";
                Cursor cursor = dataBase.rawQuery("SELECT codigo, nome_alimento, cod_preparo, forma_preparo FROM alimentos_lip_acucares_100g WHERE codigo LIKE ? OR nome_alimento LIKE ?",
                        new String[]{buscaLike, buscaLike});
                cursor.moveToFirst();

                ArrayList<Alimento> alimentos = preencheLista(cursor);

                return alimentos;
            } catch (Error e) {
                throw new Exception("Erro no método bsucaAlimentos(), Erro: " + e.getMessage());
            }
        }

    public ArrayList<Alimento> preencheLista(Cursor cursor) {
        ArrayList<Alimento> alimentos = new ArrayList<>();

        if(cursor == null)
            return null;

        while(!cursor.isAfterLast()) {
            Integer codigo = cursor.getInt(cursor.getColumnIndex("codigo"));
            Integer codPreparo = cursor.getInt(cursor.getColumnIndex("cod_preparo"));
            String nomeAlimento = cursor.getString(cursor.getColumnIndex("nome_alimento"));
            String formaPreparo = cursor.getString(cursor.getColumnIndex("forma_preparo"));

            Alimento alimento = new Alimento(codigo, codPreparo, nomeAlimento, formaPreparo);
            alimentos.add(alimento);
            cursor.moveToNext();
        }

        return alimentos;
    }

    public Alimento getAlimento(Integer id, Integer codPreparo) throws Exception {
        try {
            Cursor cursor = dataBase.rawQuery("SELECT * FROM alimentos_lip_acucares_100g WHERE codigo = ? AND cod_preparo = ?", new String[]{Integer.toString(id), Integer.toString(codPreparo)});
            cursor.moveToFirst();
            Integer codigo = cursor.getInt(cursor.getColumnIndex("codigo"));
            Integer codigoPreparo = cursor.getInt(cursor.getColumnIndex("cod_preparo"));
            String formaPreparo = cursor.getString(cursor.getColumnIndex("forma_preparo"));
            String nome = cursor.getString(cursor.getColumnIndex("nome_alimento"));
            Double colesterol = cursor.getDouble(cursor.getColumnIndex("colesterol_mg"));
            Double acidoGraxosSaturados = cursor.getDouble(cursor.getColumnIndex("axidosgraxos_saturados_g"));
            Double acidoGraxosMonosaturados = cursor.getDouble(cursor.getColumnIndex("axidosgraxos_monosaturados_g"));
            Double acidoGraxosPolisaturados = cursor.getDouble(cursor.getColumnIndex("axidosgraxos_polisaturados_g"));
            Double acidoGraxosLinoleicos = cursor.getDouble(cursor.getColumnIndex("axidograxos-linoleicos_g"));
            Double acidoGraxosLinoleinos = cursor.getDouble(cursor.getColumnIndex("Axidograxos-linoleinos_g"));
            Double acidoGraxosTransTotais = cursor.getDouble(cursor.getColumnIndex("axidograxo-trans_totais_g"));
            Double acucaresTotais = cursor.getDouble(cursor.getColumnIndex("acucares_totais_g"));
            Double acucaresAdicionados = cursor.getDouble(cursor.getColumnIndex("acucares_adicao_g"));
            String categoria = cursor.getString(cursor.getColumnIndex("categoria"));

            Alimento alimento = new Alimento(codigo, codigoPreparo, formaPreparo,
                    nome,
                    colesterol,
                    acidoGraxosSaturados,
                    acidoGraxosMonosaturados,
                    acidoGraxosPolisaturados,
                    acidoGraxosLinoleicos,
                    acidoGraxosLinoleinos,
                    acidoGraxosTransTotais,
                    acucaresTotais,
                    acucaresAdicionados,
                    categoria
            );

            return  alimento;
        } catch (Error e) {
            throw new Exception("Erro no método getAlimento(), Erro: " + e.getMessage());
        }
    }
}
