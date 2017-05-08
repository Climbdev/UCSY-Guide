package com.climbdev2016.ucsyfresherguide.model;

/**
 * Created by zwe on 11/29/16.
 */

public class DepartmentModel {
    private String title,image;

    public DepartmentModel(String title,String image){
        this.image = image;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
