package com.climbdev2016.ucsyfresherguide.model;

/**
 * Created by ZweMunHtun on 11/18/2016.
 */

public class Discipline {
    private String title, id;

    public Discipline(){

    }

    public Discipline(String id, String title){
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
