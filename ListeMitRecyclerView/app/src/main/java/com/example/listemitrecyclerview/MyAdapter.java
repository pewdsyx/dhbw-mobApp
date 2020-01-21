package com.example.listemitrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<Product> mData;

    public MyAdapter(ArrayList<Product> aProduct){
        this.mData = aProduct;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View newView = inflater.inflate(R.layout.onerowlayout, parent,false);

        //MyViewHolder myViewHolder = new MyViewHolder(newView);

        return new MyViewHolder(newView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextView.setText(mData.get(position).mAmount + " " + mData.get(position).mName);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
