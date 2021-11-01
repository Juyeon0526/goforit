package com.cookandroid.gif;

public class Product_list {
    public String prod_name;
    public String price;
    public String img_url;


    public Product_list(){}

    public String getProd_name(){
        return prod_name;
    }

    public void setProd_name(String prod_name){
        this.prod_name=prod_name;
    }

    public String getPrice(){
        return price;
    }

    public String getImgUrl(){return img_url;}
}
