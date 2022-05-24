package com.example.pharmacysoftware;


public class ChildItem {

    // Declaration of the variable
    private String ChildItemTitle;
    private String ChildItemPrice;
    private int ChildItemImage;

    // Constructor of the class
    // to initialize the variable*
    public ChildItem(String ChildItemTitle, String ChildItemPrice, int ChildItemImage)
    {
        this.ChildItemTitle = ChildItemTitle;
        this.ChildItemPrice = ChildItemPrice;
        this.ChildItemImage = ChildItemImage;
    }

    // Getter and Setter method
    // for the parameter
    public String getChildItemTitle()
    {
        return ChildItemTitle;
    }

    public void setChildItemTitle(
            String childItemTitle)
    {
        ChildItemTitle = childItemTitle;
    }

    public String getChildItemPrice() {
        return ChildItemPrice;
    }

    public int getChildItemImage() {
        return ChildItemImage;
    }

    public void setChildItemPrice(String childItemPrice) {
        ChildItemPrice = childItemPrice;
    }

    public void setChildItemImage(int childItemImage) {
        ChildItemImage = childItemImage;
    }
}
