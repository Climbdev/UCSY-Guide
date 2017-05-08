package com.climbdev2016.ucsyfresherguide.model;

/**
 * Created by Myo Lwin Oo on 11/23/2016.
 */

public class Schedule {

    String data;
    int icon;

    public Schedule() {
    }

    public Schedule(String data, int icon) {
        this.data = data;
        this.icon = icon;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
