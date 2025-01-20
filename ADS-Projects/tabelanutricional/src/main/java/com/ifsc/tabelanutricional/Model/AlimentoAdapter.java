package com.ifsc.tabelanutricional.Model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ifsc.tabelanutricional.R;
import com.ifsc.tabelanutricional.View.InfoAlimento;

import org.w3c.dom.Text;

import java.util.List;

public class AlimentoAdapter extends ArrayAdapter<Alimento> {
    Context myContext;
    List<Alimento> myListAlimentos;

    public AlimentoAdapter(Context context, List<Alimento> alimentos) {
        super(context, 0, alimentos);
        this.myContext = context;
        this.myListAlimentos = alimentos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Alimento alimento = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.alimento, parent, false);
        }

        TextView tvCodigo = convertView.findViewById(R.id.codigo);
        TextView tvNome = convertView.findViewById(R.id.nome);
        TextView tvFormaPreparo = convertView.findViewById(R.id.forma_preparo);

        if(alimento != null) {
            tvCodigo.setText(Integer.toString(alimento.codigo));
            tvNome.setText(alimento.getNome());
            tvFormaPreparo.setText(alimento.getFormaPreparo());
        }

        return convertView;
    }
}
