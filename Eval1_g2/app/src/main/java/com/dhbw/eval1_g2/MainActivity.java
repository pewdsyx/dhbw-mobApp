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
        switch (btn.getId()){
            case R.id.fenster:
                btn.setText(mFenster);
                if (mFensterB == false) {
                    // fenster ist zu
                    btn.setText(mFenster);
                    mFensterB = true;
                }
                break;
            case R.id.heizung:
                // do something
                break;
            case R.id.licht:
                // do something
                break;
        }
    }
}
