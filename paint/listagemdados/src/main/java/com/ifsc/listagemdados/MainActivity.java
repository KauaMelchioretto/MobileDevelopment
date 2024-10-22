package com.ifsc.listagemdados;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> nomes;
    ListView listView;
    EditText editText;
    Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);
        addButton = findViewById(R.id.addButton);

        nomes = new ArrayList<>();
        String[] nomeOld = new String[] {"Kaua", "Lucas", "Gustavo", "Augusto", "Eduarda", "Helasio"};

        for(String s:nomeOld) {
            nomes.add(s);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,
                android.R.id.text1,
                nomes);

        listView.setAdapter(adapter);

        addButton.setOnClickListener(view -> {
            String newName = editText.getText().toString();
            nomes.add(newName);
            adapter.add(nomes);
        });
    }
}