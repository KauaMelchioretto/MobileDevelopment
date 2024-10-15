package com.example.simplepaint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorListener;

public class MainActivity extends AppCompatActivity {
    SimplePaint simplePaint;
    ColorPickerView colorPickerView;
    Button squareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simplePaint = findViewById(R.id.simplePaint);
        colorPickerView = findViewById(R.id.colorPickerView);
        squareButton = findViewById(R.id.squareButton);

        colorPickerView.setColorListener(new ColorListener() {
            @Override
            public void onColorSelected(int color, boolean fromUser) {
                SimplePaint simplePaint = findViewById(R.id.simplePaint);
                simplePaint.myPaint.setColor(color);
            }
        });

        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simplePaint.setDrawingShape(Shapes.Square); // Alterna entre os modos
                squareButton.setText(simplePaint.drawingSquare ? "Desenhar Livre" : "Desenhar Quadrado");
            }
        });
    }
}