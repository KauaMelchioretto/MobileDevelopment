package com.ifsc.tabelanutricional.View;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ifsc.tabelanutricional.Controllers.AlimentoController;
import com.ifsc.tabelanutricional.Model.Alimento;
import com.ifsc.tabelanutricional.R;

public class InfoAlimento extends AppCompatActivity {
    private TextView txtCodigo;
    private TextView txtNome;
    private TextView txtCodPreparo;
    private TextView txtFormaPreparo;
    private TextView txtColesterol;
    private TextView txtAcidoGraxosSaturados;
    private TextView txtAcidoGraxosMonosaturados;
    private TextView txtAcidoGraxosPolisaturados;
    private TextView txtAcidoGraxosLinoleicos;
    private TextView txtAcidoGraxosLinoeinos;
    private TextView txtAcidoGraxosTransTotais;
    private TextView txtAcucaresTotais;
    private TextView txtAcucaresAdicionados;
    private TextView txtCategoria;
    AlimentoController alimentoController;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_alimento);
        final Integer codigoAlimento = Integer.valueOf(getIntent().getStringExtra("cod_alimento"));
        final Integer codigoPreparo = Integer.valueOf(getIntent().getStringExtra("cod_preparo"));
        alimentoController = new AlimentoController(this);

        txtCodigo = findViewById(R.id.codigo_alimento);
        txtNome = findViewById(R.id.nome_alimento);
        txtCodPreparo = findViewById(R.id.cod_preparo);
        txtFormaPreparo = findViewById(R.id.forma_preparo);
        txtColesterol = findViewById(R.id.colesterol_alimento);
        txtAcidoGraxosSaturados = findViewById(R.id.axidosgraxos_saturados_g);
        txtAcidoGraxosMonosaturados = findViewById(R.id.axidosgraxos_monosaturados_g);
        txtAcidoGraxosPolisaturados = findViewById(R.id.axidosgraxos_polisaturados_g);
        txtAcidoGraxosLinoleicos = findViewById(R.id.axidograxos_linoleicos_g);
        txtAcidoGraxosLinoeinos = findViewById(R.id.axidograxos_linoleinos_g);
        txtAcidoGraxosTransTotais = findViewById(R.id.axidograxo_trans_totais_g);
        txtAcucaresTotais = findViewById(R.id.acucares_totais_g);
        txtAcucaresAdicionados = findViewById(R.id.acucares_adicao_g);
        txtCategoria = findViewById(R.id.categoria_alimento);

        try {
            preencheInformacoes(codigoAlimento, codigoPreparo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void preencheInformacoes(Integer codigoAlimento, Integer codigoPreparo) throws Exception {
        Alimento alimento = alimentoController.getAlimentoPorId(codigoAlimento, codigoPreparo);

        txtCodigo.setText("Código: " + Integer.toString(alimento.getCodigo()));
        txtNome.setText("Nome: " + alimento.nome);
        txtCodPreparo.setText("Código preparo: " + Integer.toString(alimento.getCodigoPreparo()));
        txtFormaPreparo.setText("Forma de preparo: " + alimento.getFormaPreparo());
        txtColesterol.setText("Colesterol: " + Double.toString(alimento.getColesterol()));
        txtAcidoGraxosSaturados.setText("Ácido graxos saturados: " + Double.toString(alimento.getAcidoGraxosSaturados()));
        txtAcidoGraxosMonosaturados.setText("Ácido graxos monosaturados: " + Double.toString(alimento.getAcidoGraxosMonosaturados()));
        txtAcidoGraxosPolisaturados.setText("Ácido graxos polisaturados: " + Double.toString(alimento.getAcidoGraxosPolisaturados()));
        txtAcidoGraxosLinoleicos.setText("Ácido graxos linoleicos: " + Double.toString(alimento.getAcidoGraxosLinoleicos()));
        txtAcidoGraxosLinoeinos.setText("Ácido graxos linoleinos: " + Double.toString(alimento.getAcidoGraxosLinoeinos()));
        txtAcidoGraxosTransTotais.setText("Ácido graxos trans totais: " + Double.toString(alimento.getAcidoGraxosTransTotais()));
        txtAcucaresTotais.setText("Açúcares totais: " + Double.toString(alimento.getAcucaresTotais()));
        txtAcucaresAdicionados.setText("Açúcares adicionados: " + Double.toString(alimento.getAcucaresAdicionados()));
        txtCategoria.setText("Categoria: " + alimento.getCategoria());
    }
}
