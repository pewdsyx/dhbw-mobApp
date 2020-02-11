package com.example.personenliste;

import android.content.Context;
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
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ArrayList<Person> mData;
    String[] vornamen = new String[6];
    String[] nachnamen = new String[6];
    String[] hobbies = new String[3];
    int[] bilder = new int[3];
    MyAdapter myAdapter;

    private static Context mContext;

    public static Context getContext(){
        return mContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context mContext = this;

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Person wurde hinzugefügt", Snackbar.LENGTH_LONG)
                        .setAction("Action", this).show();
                mData.add(NeueZufaelligePersonErstellen());
                myAdapter.notifyDataSetChanged();
            }
        });
        arraysBefuellen();
        mData=new ArrayList<>();
        myAdapter = new MyAdapter(mData);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        mData.add(NeueZufaelligePersonErstellen());
        mData.add(NeueZufaelligePersonErstellen());
        mData.add(NeueZufaelligePersonErstellen());
    }

    private void arraysBefuellen(){
        vornamen[0] = "Tywin";
        vornamen[1] = "Dobby";
        vornamen[2] = "Jamie";
        vornamen[3] = "Daenerys";
        vornamen[4] = "Harry";
        vornamen[5] = "Severus";

        nachnamen[0] = "Stark";
        nachnamen[1] = "Potter";
        nachnamen[2] = "Lannister";
        nachnamen[3] = "Snape";
        nachnamen[4] = "Longbottom";
        nachnamen[5] = "Granger";

        hobbies[0] = "Lesen";
        hobbies[1] = "Serien";
        hobbies[2] = "Sport";

        bilder[0] = R.drawable.ic_female_solid;
        bilder[1] = R.drawable.ic_male_solid;
        bilder[2] = R.drawable.ic_walking_solid;
    }

    private Person NeueZufaelligePersonErstellen(){
        String zufaelligerVorname = vornamen[new Random().nextInt(6)];
        String zufaelligerNachname = nachnamen[new Random().nextInt(6)];
        String zufaelligesHobby = hobbies[new Random().nextInt(3)];
        int zufaelligesBild = bilder[new Random().nextInt(3)];

        Person newPerson = new Person(zufaelligerVorname,zufaelligerNachname,zufaelligesHobby,zufaelligesBild);
        return newPerson;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    public void erheben(View aView){

    }
}
