package com.climbdev2016.ucsyfresherguide.model;

/**
 * Created by zwe on 11/21/16.
 */

public class CommunityModel {
    String title;
    int images;


    public CommunityModel(){

    }

    public CommunityModel(String title , int images){
        this.title = title;
        this.images = images;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
