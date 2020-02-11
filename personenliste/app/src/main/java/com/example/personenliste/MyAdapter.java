package com.example.personenliste;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    ArrayList<Person> mData;
    public static ArrayList<CardView> CardViews = new ArrayList<CardView>();

    public MyAdapter(ArrayList<Person> data){
        mData = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View neueView = inflater.inflate(R.layout.personfile,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(neueView);
        final CardView cardView = (CardView)neueView.findViewById(R.id.personCardView);
        CardViews.add(cardView);
        cardView.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                for(CardView currentCardView : CardViews){
                    currentCardView.setCardElevation(0);
                }
                CardView aktuelleCardView = (CardView) v;
                aktuelleCardView.setCardElevation(15);
            }
        });
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView vornameView = holder.mLinearLayout.findViewById(R.id.textViewVorname);
        TextView nachnameView = holder.mLinearLayout.findViewById(R.id.textViewNachname);
        TextView hobbyView = holder.mLinearLayout.findViewById(R.id.textViewHobby);
        ImageView imageView = holder.mLinearLayout.findViewById(R.id.personImageView);
        CardView cardView = holder.mLinearLayout.findViewById(R.id.personCardView);

        Person aktuellePerson = mData.get(position);
        String aktuellerVorname = aktuellePerson.mVorname;
        String aktuellerNachname = aktuellePerson.mNachname;
        String aktuellesHobby = aktuellePerson.mHobby;
        int aktuellesBild =  aktuellePerson.mBild;

        vornameView.setText(aktuellerVorname);
        nachnameView.setText(aktuellerNachname);
        hobbyView.setText(aktuellesHobby);
        imageView.setImageResource(aktuellesBild);


        switch (aktuellesHobby){
            case "Lesen":
                cardView.setBackgroundResource(R.color.colorLesen);
                break;
            case "Serien":
                cardView.setBackgroundResource(R.color.colorSerien);
                break;

            case "Sport":
                cardView.setBackgroundResource(R.color.colorSport);
                break;

        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}