package com.example.lenovo.gold;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class Calculate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.d_picker);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        final TextView t4=(TextView)findViewById(R.id.cal_ddate);
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t4.setText(Integer.toString(datePicker.getDayOfMonth()) + "-" + Integer.toString(datePicker.getMonth() + 1) + "-" + Integer.toString(datePicker.getYear()));
            }
        });
        final DatePicker datePicker2 = (DatePicker) findViewById(R.id.w_dpicker);
        Calendar calen = Calendar.getInstance();
        calen.setTimeInMillis(System.currentTimeMillis());
        final TextView t5=(TextView)findViewById(R.id.cal_wdate);
        datePicker2.init(calen.get(Calendar.YEAR), calen.get(Calendar.MONTH), calen.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker2, int year, int month, int dayOfMonth) {
                t5.setText(Integer.toString(datePicker2.getDayOfMonth())+"-"+Integer.toString(datePicker2.getMonth()+1)+"-"+Integer.toString(datePicker2.getYear()));
            }
        });
        Button button=(Button)findViewById(R.id.cal_calculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t1=(EditText)findViewById(R.id.cal_prin);
                EditText t2=(EditText)findViewById(R.id.cal_rate);
                int dd=datePicker.getDayOfMonth();
                int dm=datePicker.getMonth()+1;
                int dy=datePicker.getYear();
                int sd=datePicker2.getDayOfMonth();
                int sm=datePicker2.getMonth()+1;
                int sy=datePicker2.getYear();
                date date1=new date();
                date date2=new date();
                date1.setD(dd);
                date1.setM(dm);
                date1.setY(dy);
                date2.setD(sd);
                date2.setM(sm);
                date2.setY(sy);
                days d=new days();
                long diff=d.getDifference(date1, date2);
                double principle=Double.parseDouble(t1.getText().toString());
                double rate=Double.parseDouble(t2.getText().toString());
                Compute com=new Compute((int)diff,rate,principle);
                com.findamount();
                double amount=com.getAmount();
                TextView t3=(TextView)findViewById(R.id.cal_amount);
                t3.setText(Double.toString(amount));
            }
        });
    }
    @Override
    public void onBackPressed(){
        finish();
        Intent i = new Intent(getApplicationContext(), UserInterface.class);
        startActivity(i);
    }
}
