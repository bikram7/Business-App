package com.example.lenovo.gold;

/**
 * Created by lenovo on 7/18/2016.
 */
public class days {
    private static final int monthDays[]={31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31};
    public days(){

    }
    public int countleapYears(date d){
        int years=d.getD();
        if(d.getM()<=2){
            years--;
        }
        return years/4-years/100+years/400;
    }
    public long getDifference(date d1,date d2){
        long n1=d1.getY()*365+d1.getD();
        for(int i=0;i<d1.getM()-1;i++)
            n1+=monthDays[i];
        n1+=countleapYears(d1);
        long n2=d2.getY()*365+d2.getD();
        for(int i=0;i<d2.getM()-1;i++){
            n2+=monthDays[i];
        }
        n2+=countleapYears(d2);
        return n2-n1;
    }
}
