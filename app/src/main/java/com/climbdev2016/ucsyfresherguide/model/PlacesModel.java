package com.climbdev2016.ucsyfresherguide.model;

/**
 * Created by zwe on 11/28/16.
 */

public class PlacesModel {
    private int image;
    private String title;

    public PlacesModel(String title, int image){
        this.image = image;
        this.title = title;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
