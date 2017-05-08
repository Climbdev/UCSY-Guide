package com.climbdev2016.ucsyfresherguide.model;

/**
 * Created by Myo Lwin Oo on 11/24/2016.
 */

public class Book {
    String bookName, price;

    public Book(String bookName, String price) {
        this.bookName = bookName;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
