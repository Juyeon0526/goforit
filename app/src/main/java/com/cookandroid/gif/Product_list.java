package com.cookandroid.gif;


import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Product_list {
    public String prod_name;
    public String price;
    public String img_url;


    public Product_list() {
    }

    public Product_list(String prod_name, String price, String img_url) {
        this.prod_name = prod_name;
        this.price = price;
        this.img_url = img_url;
    }


    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getPrice() {
        return price;
    }

    public String getImgUrl() {
        return img_url;
    }
}
