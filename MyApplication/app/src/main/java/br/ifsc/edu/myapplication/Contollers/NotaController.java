package br.ifsc.edu.myapplication.Contollers;

import android.content.Context;

import java.util.ArrayList;

import br.ifsc.edu.myapplication.Model.Nota;
import br.ifsc.edu.myapplication.Model.NotaDAO;

public class NotaController {
    private NotaDAO notaDAO;

    public NotaController(Context context) {
        this.notaDAO = new NotaDAO(context);
    }

    public Nota cadastrarNota(Nota nota) {
        if(nota.getTexto().length() < 3 || ((nota.getTitulo().length() < 3))){
            return null;
        } else
            return this.notaDAO.criarNota(nota);
       }

       public ArrayList<Nota> getListaNotas() {
        return this.notaDAO.getListaNotas();
       }

       public ArrayList<String> getListaTituloNota() {
        ArrayList<String> arrayList = new ArrayList();
        for(Nota nota : this.getListaNotas()) {
            arrayList.add(nota.getTitulo());
        }
        return  arrayList;
       }

    public ArrayList<Integer> getIdNotas() {
        ArrayList<Integer> arrayIdNotas = new ArrayList();
        for(Nota nota : this.getListaNotas()) {
            arrayIdNotas.add(nota.getId());
        }
        return  arrayIdNotas;
    }

    public Nota getNotaById(Integer idNota) { return  this.notaDAO.getNotaById(idNota); }

    public boolean excluirNota(Integer idNota) { return  this.notaDAO.excluirNota(idNota); }

    public boolean editarNota(Nota nota) { return  this.notaDAO.editarNota(nota); }
}
