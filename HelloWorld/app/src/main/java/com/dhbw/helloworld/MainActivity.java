package com.dhbw.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // own methods

    // click listner for our button:
    public void onButtonClick(View aView) {
        System.out.println("onButtonClick");
        TextView textView = findViewById(R.id.textToChange);
        textView.setText(Integer.toString(12));
    }
}
