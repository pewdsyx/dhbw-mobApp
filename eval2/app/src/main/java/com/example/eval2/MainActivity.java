package com.example.eval2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor whatEverFuckHeWants;

    // data:
    ArrayList<Double> refList;
    ArrayList<Double> testList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sensor shit
        this.sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        this.whatEverFuckHeWants = this.sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);


    }

    // button handler:
    public void onClickStart(View aView) {

        long endTime = System.currentTimeMillis() + 2000; // 2 sec
        while (System.currentTimeMillis() < endTime) {
            // do something for 2 secs:
        }
        // aktivate sensor:
        // this.sensorManager.registerListener(this, this.whatEverFuckHeWants, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // data from sensor

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // dont need that method.
    }
}
