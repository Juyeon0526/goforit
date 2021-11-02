package com.cookandroid.gif.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Rec {

    public String prod_id;
    public String purpose_category;
    public String max_price;

    public Rec() {
        // Default constructor required for calls to DataSnapshot.getValue(Comment.class)
    }

    public Rec(String prod_id, String purpose_category, String max_price) {
        this.prod_id = prod_id;
        this.purpose_category = purpose_category;
        this.max_price = max_price;
    }

}