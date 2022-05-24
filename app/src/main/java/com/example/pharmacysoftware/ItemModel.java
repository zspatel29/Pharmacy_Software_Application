package com.example.pharmacysoftware;

public class ItemModel {
    private String item_name;
    private int item_image;
    private int item_price;

    public ItemModel(String item_name, int item_image, int item_price) {
        this.item_name = item_name;
        this.item_image = item_image;
        this.item_price = item_price;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getItem_image() {
        return item_image;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }
}
