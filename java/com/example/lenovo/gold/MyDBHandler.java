package com.example.lenovo.gold;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="Customers.db";
    public static final String TABLE_PERSON="Persons";
    public static final String COLUMN_ID="_id";
    public static final String D_DATE="ddate";
    public static final String D_MONTH="dmonth";
    public static final String D_YEAR_="dyear";
    public static final String S_DATE="sdate";
    public static final String S_MONTH="smonth";
    public static final String S_YEAR="syear";
    public static final String NAME="name";
    public static final String ADDRESS="Address";
    public static final String PRINCIPLE="Principle";
    public static final String AMOUNT="Amount";
    public static final String STATUS="Status";
    public static final String GOLD="Gold";
    public static final String WEIGHT="Weight";

    public MyDBHandler(Context context,String name,SQLiteDatabase.CursorFactory factory,int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE Persons (_id INTEGER PRIMARY KEY AUTOINCREMENT,ddate INTEGER,dmonth INTEGER,dyear INTEGER,sdate INTEGER,smonth INTEGER,syear INTEGER,name TEXT,Address TEXT,Principle TEXT,Amount TEXT,Weight TEXT,Status INTEGER,Gold TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }

    //Add new customer
    public void addPersons(Customer customer){
        ContentValues values=new ContentValues();
        values.put(NAME,customer.getName());
        values.put(ADDRESS,customer.getAddress());
        values.put(PRINCIPLE,customer.getPrinciple());
        values.put(AMOUNT,customer.getAmount());
        values.put(D_DATE,customer.getDdate());
        values.put(D_MONTH,customer.getDmonth());
        values.put(D_YEAR_,customer.getDyear());
        values.put(S_DATE,customer.getSdate());
        values.put(S_MONTH,customer.getSmonth());
        values.put(S_YEAR,customer.getSdate());
        values.put(STATUS, customer.isStatus());
        values.put(GOLD,customer.getGold());
        values.put(WEIGHT,customer.getWeight());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_PERSON, null, values);
        db.close();
    }

    //Delete customer
    public void deletePersons(String name){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PERSON + " WHERE " + NAME + "=\"" + name + "\";");
        db.close();
    }

    //print database
    public int getddate(String name){
        int k=0;
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query, null);
        cursor.moveToFirst();
        if(cursor.moveToFirst()){
        k=cursor.getInt(cursor.getColumnIndex(D_DATE));
        }
        cursor.close();
        db.close();
        return k;
    }
    public int getdmonth(String name){
        int k=0;
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query,null);
        cursor.moveToFirst();
        if(cursor.moveToFirst()) {
            k = cursor.getInt(cursor.getColumnIndex(D_MONTH));
        }
        cursor.close();
        db.close();
        return k;
    }
    public int getdyear(String name){
        int k=0;
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            k=cursor.getInt(cursor.getColumnIndex(D_YEAR_));
        }
        cursor.close();
        db.close();
        return k;
    }
    public int getsdate(String name){
        int k=0;
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            k=cursor.getInt(cursor.getColumnIndex(S_DATE));
        }
        cursor.close();
        db.close();
        return k;
    }
    public int getsmonth(String name){
        int k=0;
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            k=cursor.getInt(cursor.getColumnIndex(S_MONTH));
        }
        cursor.close();
        db.close();
        return k;
    }
    public int getsyear(String name){
        int k=0;
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            k=cursor.getInt(cursor.getColumnIndex(S_YEAR));
        }
        cursor.close();
        db.close();
        return k;
    }
    public String getname(String name){
        String dbString="";
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            dbString=cursor.getString(cursor.getColumnIndex(NAME));
        }
        cursor.close();
        db.close();
        return dbString;
    }
    public String getaddress(String name){
        String dbString="";
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            dbString=cursor.getString(cursor.getColumnIndex(ADDRESS));
        }
        cursor.close();
        db.close();
        return dbString;
    }
    public String getPrinciple(String name){
        String p="";
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            p=cursor.getString(cursor.getColumnIndex(PRINCIPLE));
        }
        cursor.close();
        db.close();
        return p;
    }
    public String getamount(String name){
        String dbString="";
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            dbString=cursor.getString(cursor.getColumnIndex(AMOUNT));
        }
        cursor.close();
        db.close();
        return dbString;
    }
    public String getgold(String name){
        String dbString="";
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            dbString=cursor.getString(cursor.getColumnIndex(GOLD));
        }
        cursor.close();
        db.close();
        return dbString;
    }
    public String getweight(String name){
        String dbString="";
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            dbString=cursor.getString(cursor.getColumnIndex(WEIGHT));
        }
        cursor.close();
        db.close();
        return dbString;
    }
    public int getid(String name){
        int id=-1;
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ NAME + " =\"" + name + "\";";

        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
           id =cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
        }
        return id;
    }
    public int getstatus(int ids){
        int k=-1;
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON+" WHERE "+ COLUMN_ID + " =\"" + ids + "\";";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()) {
            k=cursor.getInt(cursor.getColumnIndex(STATUS));
        }
        cursor.close();
        db.close();
        return k;
    }
    public String[] makelist(){
        String str[]=new String[this.numberOfRows()];
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_PERSON;
        Cursor c=db.rawQuery(query,null);
        int i=0;
        c.moveToFirst();
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex(NAME))!=null){
                String s=c.getString(c.getColumnIndex(NAME));
                str[i]=s;
                i++;
            }
            c.moveToNext();
        }
        c.close();
        return str;
    }


    public boolean checkForTables(){

        SQLiteDatabase db = getWritableDatabase();
        String count = "SELECT count(*) FROM  "+TABLE_PERSON;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount>0)
            return true;
        else
            return false;
    }
    public int numberOfRows(){
        SQLiteDatabase db = getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_PERSON);
        return numRows;
    }
    public void updatesubdate(int d,int m,int y,int id){
        ContentValues cv=new ContentValues();
        cv.put(S_DATE,d);
        cv.put(S_MONTH,m);
        cv.put(S_YEAR,y);
        SQLiteDatabase db=this.getWritableDatabase();
        db.update(TABLE_PERSON,cv,"_id="+id,null);
        db.close();
    }
    public void updateamount(int id,Double amt){
        ContentValues cv=new ContentValues();
        cv.put(AMOUNT, Double.toString(amt));
        SQLiteDatabase db=this.getWritableDatabase();
        db.update(TABLE_PERSON,cv,"_id="+id,null);
        db.close();
    }
    public void updatestatus(int id,int n){
        ContentValues cv=new ContentValues();
        cv.put(STATUS,n);
        SQLiteDatabase db=this.getWritableDatabase();
        db.update(TABLE_PERSON,cv,"_id="+id,null);
        db.close();
    }
}
