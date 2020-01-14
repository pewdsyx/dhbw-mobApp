package com.example.eigeneliste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable {

    Handler mHandler;
    LayoutInflater mInflater;
    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler();
        mHandler.postDelayed(this, 1000);
        mInflater = LayoutInflater.from(getApplicationContext());
        mLinearLayout = findViewById(R.id.linearlayout);


    }


    @Override
    public void run() {
        System.out.println("run");
        View newView = mInflater.inflate(R.layout.onerowlayout,null);
        TextView textView = newView.findViewById(R.id.onerowlayout);
        textView.setText("meine neue Zeile");
        mLinearLayout.addView(newView);
        mHandler.postDelayed(this, 1000);
    }
}
