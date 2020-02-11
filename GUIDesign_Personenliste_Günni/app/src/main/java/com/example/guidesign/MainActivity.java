package com.example.guidesign;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> mData;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Shuffle the list", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                fillData();
            }
        });

        mData=new ArrayList<>();

        myAdapter=new MyAdapter(mData,getApplicationContext());
        RecyclerView recView=findViewById(R.id.recyclerview);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(myAdapter);
        fillData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void fillData()
    {
        mData.clear();

        mData.add(createItem("Müller","Hanni"));
        mData.add(createItem("Joe","Otto"));
        mData.add(createItem("Andrea","Heinz"));
        myAdapter.notifyDataSetChanged();

    }

    public Item createItem(String aName,String aVorname)
    {
        double r=Math.random();
        Item.Geschlecht aGeschlecht=Item.Geschlecht.männlich;
        if (r>0.3)aGeschlecht=Item.Geschlecht.weiblich;
        if (r>0.7)aGeschlecht=Item.Geschlecht.binär;

        double r2=Math.random();
        Item.Interesse aInteresse=Item.Interesse.Lesen;
        if (r>0.3)aInteresse= Item.Interesse.Sport;
        if (r>0.7)aInteresse= Item.Interesse.Serien;
        return new Item(aName,aVorname,aInteresse,aGeschlecht);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
