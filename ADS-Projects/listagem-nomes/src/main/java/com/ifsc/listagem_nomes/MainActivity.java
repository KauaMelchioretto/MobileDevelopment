package com.ifsc.listagem_nomes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> nomes;
    EditText editText;
    Button addButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        addButton = findViewById(R.id.addButton);
        listView = findViewById(R.id.listView);
        nomes = new ArrayList<String>();

        nomes.add("Kauã");
        nomes.add("Lucas");
        nomes.add("Gustavo");
        nomes.add("Rodrigo");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes);

        listView.setAdapter(adapter);

        addButton.setOnClickListener(view -> {
            adapter.add(editText.getText().toString());
        });
    }
}