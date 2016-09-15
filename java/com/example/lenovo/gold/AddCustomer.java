package com.example.lenovo.gold;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class AddCustomer extends AppCompatActivity {
    final DataHelper helper=new DataHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        Button button=(Button)findViewById(R.id.u_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t1 = (EditText) findViewById(R.id.u_name);
                String s1=t1.getText().toString();
                if(TextUtils.isEmpty(s1)){
                    t1.setError("Cannot be left empty!");
                }
                EditText t2 = (EditText) findViewById(R.id.u_address);
                String s2=t2.getText().toString();
                if(TextUtils.isEmpty(s2)){
                    t2.setError("Cannot be left empty!");
                }
                EditText et=(EditText)findViewById(R.id.c_principle);
                String s3=et.getText().toString();
                if(TextUtils.isEmpty(s3)){
                    et.setError("Cannot be left empty");
                }
                EditText e4=(EditText)findViewById(R.id.c_gold);
                EditText e5=(EditText)findViewById(R.id.c_weight);
                DatePicker dp = (DatePicker) findViewById(R.id.udpp);
                Integer dobYear = dp.getYear();
                Integer dobMonth = dp.getMonth()+1;
                Integer dobDate = dp.getDayOfMonth();

                Customer customer = new Customer();
                customer.setName(t1.getText().toString());
                customer.setAddress(t2.getText().toString());
                customer.setPrinciple(et.getText().toString());
                customer.setGold(e4.getText().toString());
                customer.setWeight(e5.getText().toString());
                customer.setAmount("Amount not paid");
                customer.setDdate(dobDate);
                customer.setDmonth(dobMonth);
                customer.setDyear(dobYear);
                customer.setSdate(0);
                customer.setSmonth(0);
                customer.setSyear(0);
                customer.setStatus(0);
                helper.getDbHandler().addPersons(customer);
                helper.setFlag(true);
                Intent i = new Intent(getApplicationContext(), UserInterface.class);
                startActivity(i);
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
