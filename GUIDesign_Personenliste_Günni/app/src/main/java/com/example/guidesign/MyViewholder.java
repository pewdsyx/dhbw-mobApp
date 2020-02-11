package com.example.guidesign;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;



public class MyViewholder extends RecyclerView.ViewHolder  {

    TextView titleTV;
    TextView detailTV;
    TextView interesseTV;
    CardView mCardview;
    ImageView imageView;
    MyAdapter myAdapter;

    public MyViewholder(@NonNull View itemView,MyAdapter aMyAdapter) {
        super(itemView);
        myAdapter=aMyAdapter;
        titleTV=itemView.findViewById(R.id.titelTV);
        detailTV=itemView.findViewById(R.id.detailTV);
        interesseTV=itemView.findViewById(R.id.interesseTV);
        imageView=itemView.findViewById(R.id.imageview);

        mCardview=itemView.findViewById(R.id.cardview);
        mCardview.setCardElevation(5);
        mCardview.setRadius(20);
        //itemView.setOnClickListener(this);

    }

    //@Override
    public void onClick(View v) {
        mCardview.setElevation(20);

    }

    public void setElevation(float aHeightPx)
    {
        mCardview.setElevation(aHeightPx);
    }
}
