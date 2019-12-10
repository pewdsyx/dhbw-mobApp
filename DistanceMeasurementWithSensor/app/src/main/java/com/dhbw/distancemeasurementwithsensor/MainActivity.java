package com.dhbw.distancemeasurementwithsensor;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor linearAccelarationSensor;
    TextView linearAccelarationTextView;
    TextView gesStreckeTextView;
    Boolean firstTimeMeasuring = true;
    long firstTimestamp;
    long secondTimestamp;
    double gesStrecke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        linearAccelarationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        Handler handler = new Handler();

        linearAccelarationTextView = findViewById(R.id.linearAccelarationTextView);
        gesStreckeTextView = findViewById(R.id.gesStreckeTextView);
    }

    // calculate travelled distance
    @Override
    public void onSensorChanged(SensorEvent event) {

        // in der ersten Messung wird nur der erste Timestamp gesetzt, mehr nicht
        if(firstTimeMeasuring){
            firstTimestamp = event.timestamp;
            firstTimeMeasuring = false;
            return;
        } else {
            secondTimestamp = event.timestamp;
            firstTimeMeasuring = true;
        }

        // read acceleration from sensor
        float sensorValueX = event.values[0];
        float sensorValueY = event.values[1];
        float sensorValueZ = event.values[2];

        // calculate acceleration in x and y direction
        double deltaAcceleration = Math.sqrt(Math.pow(sensorValueX, 2) + Math.pow(sensorValueY, 2));

        linearAccelarationTextView.setText("" + sensorValueX);

        // calculate timeDelta since last measuring
        double timeDelta = (secondTimestamp - firstTimestamp) / Math.pow(10, 9);

        // calculate velocity
        double velocity = (timeDelta * deltaAcceleration);

        //calculate travelled distance
        gesStrecke = (0.5 * sensorValueX * (timeDelta * timeDelta) + velocity * timeDelta + gesStrecke);

        gesStreckeTextView.setText("gesamte Strecke = " + gesStrecke);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void startMeasuring(View aView){
        sensorManager.registerListener(this, linearAccelarationSensor, SensorManager.SENSOR_DELAY_NORMAL);
        Button stopButton = findViewById(R.id.stopMeasuringButton);
        stopButton.setVisibility(View.VISIBLE);
    }

    public void stopMeasuring(View aView){
        sensorManager.unregisterListener(this, linearAccelarationSensor);
        aView.setVisibility(View.INVISIBLE);
    }
}


/*import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView distanceText;
    private SensorManager sensorManager;
    private Sensor accelerationSensor;

    private long oldTimestamp = 0;
    private long newTimestamp = 0;

    private double distance = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.distanceText = findViewById(R.id.distanceTV);

        this.sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        this.accelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
    }


    public void onClickStart(View aView) {
        // start measurement:
        this.sensorManager.registerListener(this, this.accelerationSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onClickStopAndReset(View aView) {
        this.sensorManager.unregisterListener(this, this.accelerationSensor);
        this.distanceText.setText("0.0");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // first run:
        if (this.oldTimestamp == 0) {
            this.oldTimestamp = event.timestamp;
        }

        // 2nd -> infinite run:
        if (event.timestamp != this.oldTimestamp) {
            this.newTimestamp = event.timestamp;
            long currentTime = (this.newTimestamp - this.oldTimestamp) / 1000; // in seconds
            // calculation

            double a = Math.sqrt(Math.pow(event.values[0], 2) + Math.pow(event.values[1], 2) + Math.pow(event.values[2], 2));
            double v = a * currentTime;

            double s = (a/2)* Math.pow(currentTime, 2) + v * currentTime;

            *//*System.out.println("a: " + a);
            System.out.println("v: " + v);
            System.out.println("s: " + s);*//*

            this.distance += s;

            // calc finshed
            this.oldTimestamp = this.newTimestamp;
        }

        // rewrite textView
        this.distanceText.setText(String.valueOf(this.distance));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
} */
