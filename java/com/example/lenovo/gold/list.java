package com.example.lenovo.gold;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class list extends AppCompatActivity {
    private String[] s;
    public oject obj=new oject();
    private ListViewAdapter adapter;
    DataHelper helper=new DataHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        s=new String[helper.getDbHandler().numberOfRows()];
        if(helper.getDbHandler().numberOfRows()!=0) {
            s = helper.getDbHandler().makelist();
            sortstring(s);
            adapter= new ListViewAdapter(this,s,helper);
             ListView list=(ListView)findViewById(R.id.list);
            list.setDivider(new ColorDrawable(Color.parseColor("#FC040102")));
            list.setDividerHeight(2);
            list.setAdapter(adapter);
            list.setOnItemClickListener(

                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            String str=String.valueOf(parent.getItemAtPosition(position));
                            obj.setStr(str);
                            Intent i = new Intent(getApplicationContext(), UserDetails.class);
                            startActivity(i);

                        }
                    }
            );
        }
    }
    public void sortstring(String names[]){
        String temp;
        for (int i = 0; i < helper.getDbHandler().numberOfRows(); i++)
        {
            for (int j = i + 1; j < helper.getDbHandler().numberOfRows(); j++)
            {
                if (names[i].compareTo(names[j])>0)
                {
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
    }
    @Override
    public void onBackPressed(){
        finish();
        Intent i = new Intent(getApplicationContext(), UserInterface.class);
        startActivity(i);
    }
}
