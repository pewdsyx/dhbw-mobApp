package com.example.eval4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<String> mData;
    ArrayAdapter<String> mAdapter;

    View mLayout;
    Button mButton;

    boolean mBlack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mLayout = findViewById(R.id.layout);
        this.mButton = findViewById(R.id.toggleButton);

        mData = new ArrayList<>();
        mData.add("Theme BlueSummer");
        mData.add("Theme HotTea");
        mData.add("Theme WoddenTea");
        mData.add("Theme ExpoltedCoal");
        mData.add("Theme WaterCoal");


        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mData);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);


    }


    public void onClickToggleButton(View aView) {
        Button btn = (Button) findViewById(aView.getId());
        if (this.mBlack) {
            // button font color = white
            btn.setTextColor(getResources().getColor(R.color.black));
            this.mBlack = false;
        } else {
            // button font color is black
            btn.setTextColor(getResources().getColor(R.color.white));
            this.mBlack = true;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println("geklickt auf " + mData.get(position));

        switch (mData.get(position)) {
            case "Theme BlueSummer":
                this.mLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.T1colorPrimary));
                this.mButton.setBackgroundColor(ContextCompat.getColor(this, R.color.T1colorAccent));
                break;
            case "Theme HotTea":
                this.mLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.T2colorPrimary));
                this.mButton.setBackgroundColor(ContextCompat.getColor(this, R.color.T2colorAccent));
                break;
            case "Theme WoddenTea":
                this.mLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.T3colorPrimary));
                this.mButton.setBackgroundColor(ContextCompat.getColor(this, R.color.T3colorAccent));
                break;
            case "Theme ExpoltedCoal":
                this.mLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.T4colorPrimary));
                this.mButton.setBackgroundColor(ContextCompat.getColor(this, R.color.T4colorAccent));
                break;
            case "Theme WaterCoal":
                this.mLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.T5colorPrimary));
                this.mButton.setBackgroundColor(ContextCompat.getColor(this, R.color.T5colorAccent));
                break;
        }
    }
}
