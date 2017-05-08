package com.climbdev2016.ucsyfresherguide.model;



public class Data {
    private String organizerName, places;

    public Data() {
    }

    public Data(String places) {
        this.places = places;
    }

    public Data(String organizerName, String places) {
        this.organizerName = organizerName;
        this.places = places;
    }


    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }
}
