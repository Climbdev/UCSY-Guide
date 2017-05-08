package com.climbdev2016.ucsyfresherguide.model;

/**
 * Created by zwe on 11/21/16.
 */

public class MainModel {
    private String titles;
    private int images;


    public MainModel(){

    }

    public MainModel(String titles, int images){
        this.titles = titles;
        this.images = images;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
