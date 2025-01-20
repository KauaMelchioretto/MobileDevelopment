package com.ifsc.tabelanutricional.Model;

import android.widget.TextView;

public class Alimento {
    public Integer codigo;
    private Integer codigoPreparo;
    private String formaPreparo;
    public String nome;
    private double colesterol;
    private double acidoGraxosSaturados;
    private double acidoGraxosMonosaturados;
    private double acidoGraxosPolisaturados;
    private double acidoGraxosLinoleicos;
    private double acidoGraxosLinoeinos;
    private double acidoGraxosTransTotais;
    private double acucaresTotais;
    private double acucaresAdicionados;
    private String categoria;

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getColesterol() {
        return colesterol;
    }

    public double getAcidoGraxosSaturados() {
        return acidoGraxosSaturados;
    }

    public double getAcidoGraxosMonosaturados() {
        return acidoGraxosMonosaturados;
    }

    public double getAcidoGraxosPolisaturados() {
        return acidoGraxosPolisaturados;
    }

    public double getAcidoGraxosLinoleicos() {
        return acidoGraxosLinoleicos;
    }

    public double getAcidoGraxosLinoeinos() {
        return acidoGraxosLinoeinos;
    }

    public double getAcidoGraxosTransTotais() {
        return acidoGraxosTransTotais;
    }

    public double getAcucaresTotais() {
        return acucaresTotais;
    }

    public String getFormaPreparo() {
        return formaPreparo;
    }

    public double getAcucaresAdicionados() {
        return acucaresAdicionados;
    }

    public Integer getCodigoPreparo() {
        return codigoPreparo;
    }

    public String getCategoria() {
        return categoria;
    }

    public Alimento(Integer codigo, Integer codigoPreparo, String nome, String formaPreparo) {
        this.codigo = codigo;
        this.codigoPreparo = codigoPreparo;
        this.nome = nome;
        this.formaPreparo = formaPreparo;
    }

    public Alimento(Integer codigo, Integer codigoPreparo, String formaPreparo, String nome, double colesterol, double acidoGraxosSaturados, double acidoGraxosMonosaturados, double acidoGraxosPolisaturados, double acidoGraxosLinoleicos, double acidoGraxosLinoeinos, double acidoGraxosTransTotais, double acucaresTotais, double acucaresAdicionados, String categoria) {
        this.codigo = codigo;
        this.codigoPreparo = codigoPreparo;
        this.formaPreparo = formaPreparo;
        this.nome = nome;
        this.colesterol = colesterol;
        this.acidoGraxosSaturados = acidoGraxosSaturados;
        this.acidoGraxosMonosaturados = acidoGraxosMonosaturados;
        this.acidoGraxosPolisaturados = acidoGraxosPolisaturados;
        this.acidoGraxosLinoleicos = acidoGraxosLinoleicos;
        this.acidoGraxosLinoeinos = acidoGraxosLinoeinos;
        this.acidoGraxosTransTotais = acidoGraxosTransTotais;
        this.acucaresTotais = acucaresTotais;
        this.acucaresAdicionados = acucaresAdicionados;
        this.categoria = categoria;
    }
}
