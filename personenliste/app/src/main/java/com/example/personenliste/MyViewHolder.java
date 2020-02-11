package com.example.personenliste;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    LinearLayout mLinearLayout;
    public MyViewHolder(@NonNull View aLinearLayout) {
        super(aLinearLayout);
        mLinearLayout = (LinearLayout) aLinearLayout;
    }
}