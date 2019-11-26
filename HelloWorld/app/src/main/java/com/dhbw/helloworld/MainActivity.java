package com.dhbw.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        TextView wert1 = findViewById(R.id.wert1);
        TextView wert2 = findViewById(R.id.wert2);
        TextView operant = findViewById(R.id.wert3);

        TextView ergebnis = findViewById(R.id.ergebnis);
        double i = 0.0;
        System.out.println(operant.getText().toString());

        switch (operant.getText().toString()) {
            case "+":
                i = Double.parseDouble(wert1.getText().toString()) + Double.parseDouble(wert2.getText().toString());
                ergebnis.setText(Double.toString(i));
                break;
            case "-":
                i = Double.parseDouble(wert1.getText().toString()) - Double.parseDouble(wert2.getText().toString());
                ergebnis.setText(Double.toString(i));
                System.out.println(i);
                break;
            case "*":
                i = Double.parseDouble(wert1.getText().toString()) * Double.parseDouble(wert2.getText().toString());
                ergebnis.setText(Double.toString(i));
                break;
            case "/":
                i = Double.parseDouble(wert1.getText().toString()) / Double.parseDouble(wert2.getText().toString());
                ergebnis.setText(Double.toString(i));
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
