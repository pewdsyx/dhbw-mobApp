package com.example.listemitrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> mData;
    EditText t_addToCart;
    EditText t_amount;

    String mName;
    int amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.t_addToCart = findViewById(R.id.toBuy);
        this.t_amount =  findViewById(R.id.amount);

        mData = new ArrayList<>();

        MyAdapter myAdapter = new MyAdapter(mData);
        RecyclerView myRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(myAdapter);

    }

    public void onClickAdd(View aView){
        this.mName = this.t_addToCart.getText().toString();
        //this.amount = Integer.parseInt(this.t_amount.getText().toString());

        // this.mData.add(new Product(this.amount, this.mName));
        // problem das die zahl nicht ausgelesen werden kann, deswegen immer 3
        this.mData.add(new Product(3, this.mName));


        /*this.mData.add(new Product(2, "Apfel"));
        this.mData.add(new Product(2, "Birne"));
        System.out.println(mData.size());*/


        /*if (mData.size() > 0) {
            for (int i = 0; i <= mData.size(); i++ ) {
                if (mData.get(i).mName == this.mName) {
                    // element exists in mData
                    mData.get(i).mAmount += amount;
                }
            }
        }*/
    }
}
