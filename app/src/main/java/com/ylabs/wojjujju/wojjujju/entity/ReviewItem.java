package com.ylabs.wojjujju.wojjujju.entity;

public class ReviewItem {


    String userName;
    String contents;
    String date;
    float grade;
    String img;


    public ReviewItem(String userName, String contents, String date, float grade, String img) {
        this.userName = userName;
        this.contents = contents;
        this.date = date;
        this.grade = grade;
        this.img = img;
    }

    public String getUserName() {
        return userName;
    }

    public String getContents() {
        return contents;
    }

    public String getDate() {
        return date;
    }

    public float getGrade() {
        return grade;
    }

    public String getImg() {
        return img;
    }
}
