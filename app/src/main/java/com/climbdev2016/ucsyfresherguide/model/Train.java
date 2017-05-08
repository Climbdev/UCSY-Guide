package com.climbdev2016.ucsyfresherguide.model;

/**
 * Created by Myo Lwin Oo on 11/29/2016.
 */

public class Train {
    private String buTar, from, to;

    public String getBuTar() {
        return buTar;
    }

    public void setBuTar(String buTar) {
        this.buTar = buTar;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Train(String buTar, String from, String to) {

        this.buTar = buTar;
        this.from = from;
        this.to = to;
    }
}
