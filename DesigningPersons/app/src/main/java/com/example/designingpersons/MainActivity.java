package com.example.designingpersons;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        persons = new ArrayList<>();
        persons.add(new Person("Peter","Lustig", Person.geschlecht.MAENNLICH.toString(), Person.interesse.SERIEN.toString()));
        persons.add(new Person("Emma","Unlustig", Person.geschlecht.WEIBLICH.toString(), Person.interesse.SPORT.toString()));
        persons.add(new Person("Anna","Fröhlich", Person.geschlecht.WEIBLICH.toString(), Person.interesse.LESEN.toString()));
        persons.add(new Person("Peter","Unfröhlich", Person.geschlecht.MAENNLICH.toString(), Person.interesse.SERIEN.toString()));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                magicButtonClick();
            }
        });
    }

    public void magicButtonClick(){
        ArrayList<Person> currentPersons = new ArrayList<>();
        Random randomIndex = new Random();
        int randomInt = randomIndex.nextInt(persons.size());
        currentPersons.add(persons.get(randomInt));
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
}
