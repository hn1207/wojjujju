package com.ylabs.wojjujju.wojjujju.entity;

public class BeautyItem extends Item {

    String address;
    float grade;
    int commentCnt;
    String description;
    String label;
    int like;

//    public BeautyItem(String img, String title, String price) {
//        super(img, title, price);
//    }

    public BeautyItem(String img, String title, String price, String address, float grade, int commentCnt, String description, String label, int like) {
        super(img, title, price);
        this.address = address;
        this.grade = grade;
        this.commentCnt = commentCnt;
        this.description = description;
        this.label = label;
        this.like = like;
    }

    public String getAddress() {
        return address;
    }

    public float getGrade() {
        return grade;
    }

    public int getCommentCnt() {
        return commentCnt;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public int getLike() {
        return like;
    }
}
