package com.example.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonFragmentA, buttonFragmentB;
    FragmentA fragmentA;
    FragmentB fragmentB;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFragmentA = findViewById(R.id.buttonA);
        buttonFragmentB = findViewById(R.id.buttonB);
        textView = findViewById(R.id.textView3);

        buttonFragmentA.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, fragmentA);
            textView.setText("");
            transaction.commit();
        }
    });
        buttonFragmentB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, fragmentB);
            transaction.commit();
        }
    });
    fragmentA = new FragmentA();
    fragmentB = new FragmentB();
    }
}