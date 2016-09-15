package com.example.lenovo.gold;

/**
 * Created by lenovo on 7/23/2016.
 */
public class Compute {
    private int days;
    private double rate;
    private double time;
    private double principle;
    private double amount;
    public Compute(int d,double r,double p){
        days=d;
        rate=r;
        principle=p;
    }
    public void findamount(){
        int left=days%30;
        int m=days/30;
        if(left<=10){
            time=(double)m;
        }
        else if(left>10&&left<=20){
            time=(double)m+0.5;
        }
        else{
            time=(double)m+1.0;
        }
        double interest=(principle*time*rate)/100;
        amount=principle+interest;
    }
    public double getAmount(){
        return this.amount;
    }
}
