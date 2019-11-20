package com.trilochan.hotelbook_t_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    //variable declaration for spinner
    private Spinner Sspinlocation;
    private Spinner Sspinroomtype;

    //variable declaration for Date picker
    private TextView CCheckin;
    private TextView CCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner
        Sspinlocation =findViewById(R.id.spinlocation);
        Sspinroomtype =findViewById(R.id.spinroomtype);

        String location [] = {"Pokhara","Ghandruk","Gorkha"};
        ArrayAdapter adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, location

        );
        Sspinlocation.setAdapter(adapter);

        String roomtype [] = {"Gold (Rs:1000)", "Diamond (Rs:2000)","Platinum (Rs:3000)"};
        ArrayAdapter adapter2 = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, roomtype);
        Sspinroomtype.setAdapter(adapter2);


        //date picker
        CCheckin = findViewById(R.id.checkin);
        CCheckout = findViewById(R.id.checkout);

       CCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadDatePicker1();
            }
        }

        );

        CCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadDatePicker2();
            }
        }

        );

    }
    private void LoadDatePicker1(){

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, this, year, month,day);
        datePickerDialog.show();

    }

    private void LoadDatePicker2(){

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, this, year, month,day);
        datePickerDialog.show();

    }

    //AFTER THE SELECTION OF DATE FROM DATE PICKER
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String date = "Month/day/Year: "+month+"/ "+dayOfMonth+"/ "+year ;
        CCheckin.setText(date);
        CCheckout.setText(date);

    }

}
