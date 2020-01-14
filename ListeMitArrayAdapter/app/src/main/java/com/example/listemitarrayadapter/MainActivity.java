package com.example.listemitarrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.net.IpSecManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Runnable, AdapterView.OnItemClickListener {

    ArrayList<String> mData;
    ArrayAdapter<String> mAdapter;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mData = new ArrayList<>();

        mData.add("bla");
        mData.add("bla");
        mData.add("bla");
        mData.add("bla");

        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, mData);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);
        mHandler = new Handler();
        mHandler.postDelayed(this,1000);
    }

    @Override
    public void run() {
        mData.add("Test");
        mAdapter.notifyDataSetChanged();
        mHandler.postDelayed(this,1000);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println("geklickt auf " + mData.get(position));
    }
}
