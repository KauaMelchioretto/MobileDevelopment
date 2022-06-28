package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SensorDetail extends AppCompatActivity implements  SensorEventListener{
    ListView sensorListValues;
    TextView sensorName;
    SensorManager mySensorManager;
    Sensor mySensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_detail);
        sensorListValues = findViewById(R.id.sensorValues);
        sensorName = findViewById(R.id.sensorName);
        String typeSensor = getIntent().getStringExtra("type");

        mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mySensor = mySensorManager.getDefaultSensor(Integer.parseInt(typeSensor));

        String sensorNameValue = mySensor.getName();
        sensorName.setText(sensorNameValue);
        mySensorManager.registerListener((SensorEventListener) this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();

        ArrayList<String> sensorValues = new ArrayList();
        for (int i = 0; i < event.values.length; i++) {
            sensorValues.add(Float.toString(event.values[i]));
        }

        sensorListValues.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sensorValues));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}