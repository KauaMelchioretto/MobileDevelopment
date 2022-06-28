package com.example.androidactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textReciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textReciver = (TextView) findViewById(R.id.textReciver);
        String stringReturn = getIntent().getStringExtra("msg");
        textReciver.setText(stringReturn);
    }
}