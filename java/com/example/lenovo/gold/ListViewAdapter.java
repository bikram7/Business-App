package com.example.lenovo.gold;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by lenovo on 7/20/2016.
 */
public class ListViewAdapter extends ArrayAdapter<String>{
    Context context;
    String items[]=null;
    private DataHelper helper;
    public ListViewAdapter(Context context,String [] obj,DataHelper helper){
        super(context,R.layout.listviewitem,obj);
        this.context=context;
        this.items=obj;
        this.helper=helper;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        LayoutInflater infl=LayoutInflater.from(getContext());
        View row=infl.inflate(R.layout.listviewitem, parent, false);
        TextView tv=(TextView)row.findViewById(R.id.litem);
        TextView tv1=(TextView)row.findViewById(R.id.litem_address);
        tv1.setText(helper.getDbHandler().getaddress(helper.getDbHandler().getname(getItem(position).toString())));
        String str=getItem(position);
        tv.setText(str);
        if(helper.getDbHandler().getstatus(helper.getDbHandler().getid(getItem(position).toString()))==1){
            row.setBackgroundColor(Color.parseColor("#FFF5E12D"));
        }
        else
            row.setBackgroundColor(Color.parseColor("#e50c63"));
        return row;
    }
}
