package com.climbdev2016.ucsyfresherguide.model;

/**
 * Created by zwe on 12/1/16.
 */

public class GalleryContainerModel  {

    private String title,image;
    public GalleryContainerModel(String title,String image){
        this.image = image;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
