package com.example.lenovo.gold;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Exit ex=new Exit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), UserInterface.class);
                startActivity(i);
            }
        }, 3000);
        if(ex.isEx()==true){
            finish();
        }
    }
}
