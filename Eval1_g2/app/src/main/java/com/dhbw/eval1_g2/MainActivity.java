package com.dhbw.eval1_g2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String mFensterN = "Fenster ist zu";
    private String mHeizungN = "Heizung ist aus";
    private String mLichtN = "Licht ist aus";

    private String mFenster = "Fenster ist offen";
    private String mHeizung = "Heizung ist an";
    private String mLicht = "Licht ist an";

    private boolean mFensterB = false;
    private boolean mHeizungB = false;
    private boolean mLichtB = false;

    private int mOffnungsrate = 0; // 0-100

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAnAus(View aView){
        Button btn = (Button) findViewById(aView.getId());
        TextView view = findViewById(R.id.fehler);
        view.setText("keine Fehler");
        switch (btn.getId()){
            case R.id.fenster:
                if (mFensterB == false) {
                    if (mHeizungB == true) {
                        view.setText("Heizung ist an! Fenster geht nicht auf");
                        break;
                    } else {
                        // fenster ist zu
                        btn.setText(mFenster);
                        mFensterB = true;
                    }
                } else if (mFensterB == true) {
                    // fenster offen
                    btn.setText(mFensterN);
                    mFensterB = false;
                }
                break;
            case R.id.heizung:
                if (mHeizungB == false) {
                    if (mFensterB == true) {
                        view.setText("Fenster ist offen. Heizung geht nicht an");
                        break;
                    } else {
                        // fenster ist zu
                        btn.setText(mHeizung);
                        mHeizungB = true;
                    }
                } else if (mHeizungB == true){
                    // fenster offen
                    btn.setText(mHeizungN);
                    mHeizungB = false;
                }
                break;
            case R.id.licht:
                if (mLichtB == false) {
                    // fenster ist zu
                    btn.setText(mLicht);
                    mLichtB = true;
                } else if (mLichtB == true ){
                    // fenster offen
                    btn.setText(mLichtN);
                    mLichtB = false;
                }
                break;
        }
    }

    public void onClickAdd(View aView) {
        TextView view = findViewById(R.id.zustand);
        mOffnungsrate+=1;
        view.setText(Integer.toString(mOffnungsrate));
    }

    public void onClickDel(View aView) {
        TextView view = findViewById(R.id.zustand);
        mOffnungsrate-=1;
        view.setText(Integer.toString(mOffnungsrate));
    }
}
