# Ref Implementation
```java
package com.example.distancemeter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;

    private TextView distanceLabel;
    private Button resetButton;

    // Timestamp in nanoseconds of the last measurement
    private long prevTimestamp;

    // Last acceleration measured by the sensor
    private double oldAccelX;
    private double oldAccelY;
    private double oldAccelZ;

    // Current velocity (derived from the acceleration)
    private double curVelX;
    private double curVelY;
    private double curVelZ;

    // Total distance
    private double distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load accelerometer sensor by utilizing the sensor manager provided by the system
        // We choose linear acceleration type, otherwise we would have to subtract the additional
        // acceleration due to gravity manually.
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        if ((accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)) != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }

        // Resolve views ahead of time
        distanceLabel = findViewById(R.id.distanceLabel);
        resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this::resetButton_clicked);
    }

    private void resetButton_clicked(View v) {
        prevTimestamp = 0;
        oldAccelX = 0;
        oldAccelY = 0;
        oldAccelZ = 0;
        curVelX = 0;
        curVelY = 0;
        curVelZ = 0;
        distance = 0;
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        double curAccelX = event.values[0];
        double curAccelY = event.values[1];
        double curAccelZ = event.values[2];
        Log.d("acceleration", String.format("curAccelX = %1$s m/s^2; curAccelY = %2$s m/s^2; curAccelZ = %3$s m/s^2", curAccelX, curAccelY, curAccelZ));

        // Calculate the acceleration duration t by subtracting the current timestamp from the previous
        // and scale it to the SI unit (seconds) -> dividing by 10^9. If this is the very first
        // measurement the duration is set to zero.
        double t = 0;
        if (prevTimestamp != 0) {
            t = (event.timestamp - prevTimestamp) / 1E9D;
        }
        Log.d("duration", String.format("duration = %1$s s", t));

        // Calculate the change in position since the last measurement
        double sX = oldAccelX * t * t / 2 + curVelX * t;
        double sY = oldAccelY * t * t / 2 + curVelY * t;
        double sZ = oldAccelZ * t * t / 2 + curVelZ * t;
        Log.d("distance", String.format("sX = %1$s m, sY = %2$s m, sZ = %3$s m", sX, sY, sZ));

        // Calculate new velocity (derivation of the function above)
        curVelX += oldAccelX * t;
        curVelY += oldAccelY * t;
        curVelZ += oldAccelZ * t;
        Log.d("velocity", String.format("curVelX = %1$s m/s, curVelY = %2$s m/s, curVelZ = %3$s m/s", curVelX, curVelY, curVelZ));

        distance += Math.sqrt(sX * sX + sY * sY + sZ * sZ);
        distanceLabel.setText(String.format("Distance: %1.2f m", distance));

        // new values -> old values
        prevTimestamp = event.timestamp;
        oldAccelX = curAccelX;
        oldAccelY = curAccelY;
        oldAccelZ = curAccelZ;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Currently we are not interested in any accuracy changes
    }
}


```