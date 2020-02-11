package com.example.guidesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewholder> implements View.OnClickListener {

    ArrayList<Item> mData;
    ArrayList<MyViewholder> mViewholders;
    Context mContext;


    public MyAdapter(ArrayList<Item> aData, Context aContext)
    {
        mData=aData;
        mViewholders=new ArrayList<>();
        mContext=aContext;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View newView=inflater.inflate(R.layout.onerowlayout,parent,false);
        newView.setOnClickListener(this);
        MyViewholder viewholder=new MyViewholder(newView,this);
        mViewholders.add(viewholder);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        Item item=mData.get(position);
        holder.titleTV.setText(item.mVorname);
        holder.detailTV.setText(item.mName);
        holder.interesseTV.setText(item.mInteresse.toString());
        switch (item.mGeschlecht)
        {
            case männlich:
                holder.imageView.setImageResource(R.drawable.ic_male_solid);
                break;
            case weiblich:
                holder.imageView.setImageResource(R.drawable.ic_female_solid);
                break;
            default:
                holder.imageView.setImageResource(R.drawable.ic_walking_solid);
        }

        switch (item.mInteresse){
            case Lesen:
                holder.mCardview.setBackgroundColor(ContextCompat.getColor(mContext,R.color.colorLesen));
                break;
            case Sport:
                holder.mCardview.setBackgroundResource(R.color.colorSerien);
                holder.mCardview.setBackgroundColor(ContextCompat.getColor(mContext,R.color.colorSport));
                break;

                default:
                    holder.mCardview.setBackgroundColor(ContextCompat.getColor(mContext,R.color.colorSerien));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    @Override
    public void onClick(View v) {
        for (MyViewholder holder:mViewholders)
        {
            holder.setElevation(0);
        }
        CardView cardView=v.findViewById(R.id.cardview);
        cardView.setElevation(15);
    }
}
