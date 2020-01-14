package com.example.listemitrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData = new ArrayList<>();

        mData.add("1");
        mData.add("1");
        mData.add("1");

        MyAdapter myAdapter = new MyAdapter(mData);
    }
}
