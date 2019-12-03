package com.dhbw.berraschungsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener, Runnable {

    private TextView textView;
    private SensorManager sensorManager;
    private Sensor lightSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = findViewById(R.id.surprise);
        this.textView.setText("");

        // getting my SensorManager
        this.sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        this.lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }


    public void onClickStart(View aView) {
        Handler handler = new Handler();
        handler.postDelayed(this, 5000);
    }

    //SensorEventListner methods:
    @Override
    public void onSensorChanged(SensorEvent event) {
        this.textView.setText("Surprise!");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    // ---------------------------------------------------------------

    //Runnable:
    @Override
    public void run() {
        this.sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
