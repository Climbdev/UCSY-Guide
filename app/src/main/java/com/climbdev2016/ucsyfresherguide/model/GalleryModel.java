package com.climbdev2016.ucsyfresherguide.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zwe on 11/25/16.
 */

public class GalleryModel implements Parcelable {
    String name , url;

    public GalleryModel(){

    }


    protected GalleryModel(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<GalleryModel> CREATOR = new Creator<GalleryModel>() {
        @Override
        public GalleryModel createFromParcel(Parcel in) {
            return new GalleryModel(in);
        }

        @Override
        public GalleryModel[] newArray(int size) {
            return new GalleryModel[size];
        }
    };;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
    }
}
