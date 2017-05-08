package com.climbdev2016.ucsyfresherguide.model;

/**
 * Created by Myo Lwin Oo on 11/29/2016.
 */

public class Bus {
    private String id, data;

    public Bus(String id, String data) {
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
