package com.example.lenovo.gold;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo on 7/18/2016.
 */
public class DataHelper {
    private  MyDBHandler dbHandler;
    private static boolean flag=false;
    public DataHelper(Context context){
        dbHandler=new MyDBHandler(context,null,null,1);
    }

    public  boolean isFlag() {
        return flag;
    }

    public  void setFlag(boolean flag) {
        DataHelper.flag = flag;
    }

    public MyDBHandler getDbHandler() {
        return dbHandler;
    }
}
