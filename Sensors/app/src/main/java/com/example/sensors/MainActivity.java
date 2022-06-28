package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager mySensorManager;
    ListView listView;
    List<Sensor> listSensors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        mySensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        listSensors = mySensorManager.getSensorList(Sensor.TYPE_ALL);
        ArrayList<String> listSensorsNames = new ArrayList<>();
        for (Sensor s : listSensors) {
            String sensorName = s.getName();
            listSensorsNames.add(sensorName);
        }
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listSensorsNames));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int type = listSensors.get(position).getType();

                Intent intent = new Intent(getApplicationContext(), SensorDetail.class);
                intent.putExtra("type", Integer.toString(type));
                startActivity(intent);
            }
        });
    }
}