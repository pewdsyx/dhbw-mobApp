package com.example.listemitrecyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView mTextView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = (TextView)itemView;
    }
}
