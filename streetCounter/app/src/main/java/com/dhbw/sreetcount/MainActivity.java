package com.dhbw.sreetcount;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String mSelectedVehicle = null;
    private int car;
    private int ped;
    private int bike;
    private int motor;
    private int bus;
    private int truck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSelect(View aView) {
        int id = aView.getId();

        switch (id) {
            case R.id.car:
                this.setmSelectedVehicle(findViewById(id).toString());
                break;
            case R.id.pedestrians:
                this.setmSelectedVehicle(findViewById(id).toString());
                break;
            case R.id.bicycles:
                this.setmSelectedVehicle(findViewById(id).toString());
                break;
            case R.id.motorcycles:
                this.setmSelectedVehicle(findViewById(id).toString());
                break;
            case R.id.busses:
                this.setmSelectedVehicle(findViewById(id).toString());
                break;
            case R.id.trucks:
                this.setmSelectedVehicle(findViewById(id).toString());
                break;
        }
    }

    public void onClickAdd(View aView){
        switch (findViewById(aView.getId()).toString()) {
            case "oneUp":
                if (mSelectedVehicle == "car") {
                    car+=1;
                } else if (mSelectedVehicle == "pedestrians") {
                    ped+=1;
                } else if (mSelectedVehicle == "bicycles") {
                    bike+=1;
                }else if (mSelectedVehicle == "motorcycles") {
                    motor+=1;
                }else if (mSelectedVehicle == "busses") {
                    bus+=1;
                }else if (mSelectedVehicle == "trucks") {
                    truck+=1;
                }
                break;
            case "fiveUp":
                if (mSelectedVehicle == "car") {
                    car+=5;
                } else if (mSelectedVehicle == "pedestrians") {
                    ped+=5;
                } else if (mSelectedVehicle == "bicycles") {
                    bike+=5;
                }else if (mSelectedVehicle == "motorcycles") {
                    motor+=5;
                }else if (mSelectedVehicle == "busses") {
                    bus+=5;
                }else if (mSelectedVehicle == "trucks") {
                    truck+=5;
                }
                break;
        }
    }

    public void onClickReset(View aView) {

    }

    private void setmSelectedVehicle(String aString){
        this.mSelectedVehicle = aString;
    }
}
