package com.example.wouldyourather;

import java.util.Date;

public class Questions {
    private String WouldYouRather1,WouldYouRather2;
    private Date date;
    private String Kategory;
    private int WouldYouRather1_value, WouldYouRather2_value;

    public Questions() {
    }

    public int getWouldYouRather1_value() {
        return WouldYouRather1_value;
    }

    public void setWouldYouRather1_value(int wouldYouRather1_value) {
        WouldYouRather1_value = wouldYouRather1_value;
    }

    public int getWouldYouRather2_value() {
        return WouldYouRather2_value;
    }

    public void setWouldYouRather2_value(int wouldYouRather2_value) {
        WouldYouRather2_value = wouldYouRather2_value;
    }

    public String getKategory() {
        return Kategory;
    }

    public void setKategory(String kategory) {
        Kategory = kategory;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWouldYouRather1() {
        return WouldYouRather1;
    }

    public void setWouldYouRather1(String wouldYouRather1) {
        WouldYouRather1 = wouldYouRather1;
    }

    public String getWouldYouRather2() {
        return WouldYouRather2;
    }

    public void setWouldYouRather2(String wouldYouRather2) {
        WouldYouRather2 = wouldYouRather2;
    }
}
