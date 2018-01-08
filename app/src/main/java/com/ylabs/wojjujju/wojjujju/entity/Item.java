package com.ylabs.wojjujju.wojjujju.entity;

public class Item {

    String img;
    String title;
    String price;

    public Item(String img, String title, String price){
        this.img =img;
        this.title = title;
        this.price=price;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }
}
