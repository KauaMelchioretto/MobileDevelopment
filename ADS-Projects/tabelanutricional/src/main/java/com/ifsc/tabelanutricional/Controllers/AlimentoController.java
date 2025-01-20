package com.ifsc.tabelanutricional.Controllers;

import android.content.Context;

import com.ifsc.tabelanutricional.Model.Alimento;
import com.ifsc.tabelanutricional.Model.AlimentoDAO;

import java.util.ArrayList;

public class AlimentoController {
    private AlimentoDAO alimentoDAO;

    public AlimentoController(Context context) {
        this.alimentoDAO = new AlimentoDAO(context);
    }

    public ArrayList<Alimento> getAlimentos() throws Exception {
        return this.alimentoDAO.getListaAlimentos();
    }

    public Alimento getAlimentoPorId(Integer id, Integer codigoPreparo) throws Exception {
        return this.alimentoDAO.getAlimento(id, codigoPreparo);
    }

    public ArrayList<Alimento> buscaAlimentos(String infoBusca) throws Exception {
        return this.alimentoDAO.buscaAlimentos(infoBusca);
    }
}
