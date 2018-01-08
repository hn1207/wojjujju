package com.ylabs.wojjujju.wojjujju.entity;

public class SelectedItem {


    String title;
//    String contents;
    String date;

    String price;

    public String getTitle() {
        return title;
    }

//    public String getContents() {
//        return contents;
//    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    public SelectedItem(String title, String date, String price) {
        this.title = title;
//        this.contents = contents;
        this.date = date;
        this.price = price;
    }
}
