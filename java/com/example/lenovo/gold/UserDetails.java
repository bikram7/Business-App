package com.example.lenovo.gold;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.Calendar;

public class UserDetails extends AppCompatActivity {
    public  oject obj;
    private CheckedTextView ctv;


    DataHelper helper=new DataHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        obj=new oject();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        final String str=obj.getStr();
        int d1=helper.getDbHandler().getddate(str);
        TextView v1=(TextView)findViewById(R.id.c_name);
        v1.setText(helper.getDbHandler().getname(str));
        TextView v2=(TextView)findViewById(R.id.c_address);
        v2.setText(helper.getDbHandler().getaddress(str));
        TextView v3=(TextView)findViewById(R.id.c_ddate);
        int dd=helper.getDbHandler().getddate(str);
        int dm=helper.getDbHandler().getdmonth(str);
        int dy=helper.getDbHandler().getdyear(str);
        String sr=Integer.toString(dd)+"-"+Integer.toString(dm)+"-"+Integer.toString(dy);
        v3.setText(sr);
        TextView v5=(TextView)findViewById(R.id.c_amount);
        v5.setText(helper.getDbHandler().getamount(str));
        TextView v8=(TextView)findViewById(R.id.c_gold);
        TextView v6=(TextView)findViewById(R.id.c_weight);
        v8.setText(helper.getDbHandler().getgold(str));
        v6.setText(helper.getDbHandler().getweight(str));
        TextView v7=(TextView)findViewById(R.id.c_withdrawl);
        String ds="NotPaid";
        int sd=helper.getDbHandler().getsdate(str);
        int sm=helper.getDbHandler().getsmonth(str);
        int sy=helper.getDbHandler().getsyear(str);
        if(sd==0&&sm==0&&sy==0){
            v7.setText(ds);
        }
        else{
            ds=Integer.toString(sd)+"-"+Integer.toString(sm)+"-"+Integer.toString(sy);
            v7.setText(ds);
        }
        TextView pr=(TextView)findViewById(R.id.u_principle);
        pr.setText(helper.getDbHandler().getPrinciple(str));
        RadioButton rb1=(RadioButton)findViewById(R.id.C_paid);
        RadioButton rb2=(RadioButton)findViewById(R.id.c_notpaid);
        final int id=helper.getDbHandler().getid(str);
        if(helper.getDbHandler().getstatus(id)==1)
            rb1.setChecked(true);
        if(helper.getDbHandler().getstatus(id)==0)
            rb2.setChecked(true);
        Button b1=(Button)findViewById(R.id.c_calculate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date d1=new date();
                date d2=new date();
                DatePicker dpp=(DatePicker)findViewById(R.id.udp);
                int year = dpp.getYear();
                int month = dpp.getMonth()+1;
                System.out.println(month);
                int day = dpp.getDayOfMonth();
                helper.getDbHandler().updatesubdate(day,month,year,id);
                d1.setD(helper.getDbHandler().getddate(str));
                d1.setM(helper.getDbHandler().getdmonth(str));
                d1.setY(helper.getDbHandler().getdyear(str));
                d2.setD(day);
                d2.setM(month);
                d2.setY(year);
                days da=new days();
                long diff=da.getDifference(d1,d2);
                int d= (int) diff;
                double principle = Double.parseDouble(helper.getDbHandler().getPrinciple(str));

                EditText ra=(EditText)findViewById(R.id.c_rate);
                String sr=ra.getText().toString();

                if(TextUtils.isEmpty(sr))
                {
                    ra.setError("Cannot be left empty");
                    return;
                }
                Double rate=Double.parseDouble(sr);
                Compute com=new Compute(d,rate,principle);
                com.findamount();
                double amount=com.getAmount();
                TextView am=(TextView)findViewById(R.id.c_amount);
                am.setText(Double.toString(amount));
                helper.getDbHandler().updateamount(id, amount);
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup);
                int rid=grp.getCheckedRadioButtonId();
                RadioButton rbt=(RadioButton)findViewById(rid);
                String rstring=rbt.getText().toString();
                if(rstring.equals("Paid")){
                    helper.getDbHandler().updatestatus(id,1);
                }
                else if(rstring.equals("Not Paid")){
                    helper.getDbHandler().updatestatus(id,0);
                }
                else{

                }
                TextView tview=(TextView)findViewById(R.id.c_withdrawl);
                tview.setText(Integer.toString(day)+"-"+Integer.toString(month)+"-"+Integer.toString(year));
            }
        });
        Button b3=(Button)findViewById(R.id.c_done);
        Button b4=(Button)findViewById(R.id.c_delete);
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v){
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup);
                int rid=grp.getCheckedRadioButtonId();
                RadioButton rbt=(RadioButton)findViewById(rid);
                String rstring=rbt.getText().toString();
                if(rstring.equals("Paid")){
                    helper.getDbHandler().updatestatus(id,1);
                }
                else if(rstring.equals("Not Paid")){
                    helper.getDbHandler().updatestatus(id,0);
                }
                else{

                }
                Intent i = new Intent(getApplicationContext(), UserInterface.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v){
                AlertDialog.Builder alert=new AlertDialog.Builder(UserDetails.this);
                alert.setTitle("Confirm");
                alert.setMessage("Are you sure you want to delete this customer?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        helper.getDbHandler().deletePersons(str);
                        dialog.dismiss();
                        Intent i = new Intent(getApplicationContext(), UserInterface.class);
                        startActivity(i);
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
            }
        });
    }
    @Override
    public void onBackPressed(){
        finish();
        Intent i = new Intent(getApplicationContext(), list.class);
        startActivity(i);
    }
}
