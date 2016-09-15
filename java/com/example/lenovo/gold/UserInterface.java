package com.example.lenovo.gold;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class UserInterface extends AppCompatActivity {
    final DataHelper helper=new DataHelper(this);
    Exit ex=new Exit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);
        Button b1=(Button)findViewById(R.id.b_add);
        Button b2=(Button)findViewById(R.id.b_view);
        Button b3=(Button)findViewById(R.id.b_cal);
        if(helper.isFlag()){
            TextView text=(TextView)findViewById(R.id.b_text);
            text.setText("New Customer Added");
            helper.setFlag(false);
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddCustomer.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!helper.getDbHandler().checkForTables())
                {
                    TextView tv=(TextView)findViewById(R.id.b_text);
                    tv.setText("No Customers Yet");
                }
                else
                {
                    Intent i = new Intent(getApplicationContext(), list.class);
                    startActivity(i);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), Calculate.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (ex.isEx()==true) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            ex.setEx(true);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ex.setEx(false);
                }
            }, 3 * 1000);

        }

    }
}
