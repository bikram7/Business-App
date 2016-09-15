package com.example.lenovo.gold;
public class Customer {
    private String name;
    private String Address;
    private String Principle;
    private String Amount;
    private String Gold;
    private String Weight;
    private int ddate;
    private int dmonth;
    private int dyear;
    private int smonth;
    private int syear;
    private int sdate;
    private int Status;

    public Customer(){

    }

    public String getGold() {
        return Gold;
    }

    public void setGold(String gold) {
        Gold = gold;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public Customer(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPrinciple() {
        return Principle;
    }

    public void setPrinciple(String principle) {
        Principle = principle;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public int isStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getDdate() {
        return ddate;
    }

    public void setDdate(int d) {
        this.ddate = d;
    }

    public int getSdate() {
        return sdate;
    }

    public void setSdate(int d) {
        this.sdate =d;
    }

    public int getStatus() {
        return Status;
    }

    public int getSyear() {
        return syear;
    }

    public void setSyear(int syear) {
        this.syear = syear;
    }

    public int getSmonth() {
        return smonth;
    }

    public void setSmonth(int smonth) {
        this.smonth = smonth;
    }

    public int getDyear() {
        return dyear;
    }

    public void setDyear(int dyear) {
        this.dyear = dyear;
    }

    public int getDmonth() {
        return dmonth;
    }

    public void setDmonth(int dmonth) {
        this.dmonth = dmonth;
    }
}
