package com.ylabs.wojjujju.wojjujju.entity;

public class QnaItem {


    String title;
    String contents;
    String date;
    int type;


    public QnaItem(String title, String contents, String date, int type) {
        this.title = title;
        this.contents = contents;
        this.date = date;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getDate() {
        return date;
    }

    public int getType() {
        return type;
    }
}
