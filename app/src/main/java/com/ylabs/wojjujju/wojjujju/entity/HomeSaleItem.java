package com.ylabs.wojjujju.wojjujju.entity;

public class HomeSaleItem extends Item {

    String saledPrice;
    String percent;

    public HomeSaleItem(String img, String title, String price, String saledPrice, String percent) {
        super(img, title, price);
        this.saledPrice=saledPrice;
        this.percent=percent;
    }

    public String getSaledPrice() {
        return saledPrice;
    }

    public void setSaledPrice(String saledPrice) {
        this.saledPrice = saledPrice;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}
