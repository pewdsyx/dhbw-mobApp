package com.example.eval2;

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
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener, Runnable {

    SensorManager sensorManager;
    Sensor whatEverFuckHeWants;

    // data:
    ArrayList<Double> refList;
    ArrayList<Double> testList;
    boolean success = false;
    boolean timeUp = false;
    String nextMoveText = "";
    long timestamp;

    // GUI data
    int data_time = 10; // in seconds
    int data_threshold;
    int data_successfullMoves;
    int data_leftMoves = 4;

    // GUI Elements:
    TextView nextMove;
    TextView leftMoves;
    TextView time;
    TextView successfullMoves;
    EditText threshold;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sensor shit
        this.sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        this.whatEverFuckHeWants = this.sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        // getting all GUI elements:
        this.nextMove = findViewById(R.id.bewegungseinheitView);
        this.leftMoves = findViewById(R.id.verbleibendeBewegung);
        this.time = findViewById(R.id.restzeit);
        this.successfullMoves = findViewById(R.id.erfolgreicheBewegung);
        this.threshold = findViewById(R.id.schwellwert);

        // set GUI initial:
        this.threshold.setText(String.valueOf(this.data_threshold));
        this.time.setText("Restzeit: " + String.valueOf(this.data_time).concat(" s"));

    }

    // button handler:
    public void onClickStart(View aView) {
        this.btn = (Button) findViewById(aView.getId());
        btn.setText("Messung läuft");

        /*long startTime = System.currentTimeMillis();
        long endTime = startTime + 1000;

        while (startTime < endTime) {
            if (success) {
                return;
            }
            // 10 sec time to do something
            this.sensorManager.registerListener(this, this.whatEverFuckHeWants, SensorManager.SENSOR_DELAY_NORMAL);
            this.time.setText("Restzeit: " + String.valueOf((endTime-startTime)/1000.0).concat(" s"));
        }*/


        this.sensorManager.registerListener(this, this.whatEverFuckHeWants, SensorManager.SENSOR_DELAY_NORMAL);

        new Handler().postDelayed(this, 10000); // let it run for 10 s
        this.time.setText("10 s");

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (this.timestamp == -1L) {
            this.timestamp = event.timestamp;
        }

        // data from sensor
        double x = event.values[0];
        double z = event.values[2];

        //movement calc:
        
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // dont need that method.
    }

    @Override
    public void run() {
        this.sensorManager.unregisterListener(this, this.whatEverFuckHeWants);
        this.timestamp = -1L;
        this.btn.setText("Bewegungseinheit start");
        this.time.setText("0 s");
    }
}
