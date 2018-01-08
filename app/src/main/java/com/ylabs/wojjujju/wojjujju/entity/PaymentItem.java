package com.ylabs.wojjujju.wojjujju.entity;

import android.widget.ImageView;
import android.widget.TextView;

public class PaymentItem extends Item {


    String date;
    String contents;

    public String getDate() {
        return date;
    }

    public String getContents() {
        return contents;
    }

    public PaymentItem(String img, String title, String price, String date, String contents) {
        super(img, title, price);
        this.date = date;
        this.contents = contents;
    }




}
