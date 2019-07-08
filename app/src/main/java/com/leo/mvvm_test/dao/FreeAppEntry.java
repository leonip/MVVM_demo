package com.leo.mvvm_test.dao;

import com.google.gson.annotations.SerializedName;
import com.leo.mvvm_test.dao.object.PropertiesCategory;
import com.leo.mvvm_test.dao.object.PropertiesImage;
import com.leo.mvvm_test.dao.object.PropertiesLabel;
import com.leo.mvvm_test.dao.object.PropertiesLink;
import com.leo.mvvm_test.dao.object.PropertiesPrice;
import com.leo.mvvm_test.dao.object.PropertiesType;

import java.util.ArrayList;
import java.util.Random;

public class FreeAppEntry {
    @SerializedName("im:name")
    public PropertiesLabel name;
    @SerializedName("im:image")
    public ArrayList<PropertiesImage> image;
    @SerializedName("summary")
    public PropertiesLabel summary;
    @SerializedName("im:price")
    public PropertiesPrice price;
    @SerializedName("im:contentType")
    public PropertiesType type;
    @SerializedName("rights")
    public PropertiesLabel rights;
    @SerializedName("title")
    public PropertiesLabel title;
    @SerializedName("link")
    public PropertiesLink link;
    // id
    @SerializedName("im:artist")
    public PropertiesLabel artist;
    @SerializedName("category")
    public PropertiesCategory category;

    public String getTextForSearch() {
        return name.label+
                category.attributes.term+
                category.attributes.label+
                artist.label+
                summary.label;
    }

    private int ratingCount;
    private int ratingStar;

    public int getRatingCount() {
        if(ratingCount == 0){
            Random rand = new Random();
            ratingCount = rand.nextInt(100)+10;
        }
        return ratingCount;
    }


    public int getRatingStar() {
        if(ratingStar == 0){
            Random rand = new Random();
            ratingStar = rand.nextInt(5)+1;
        }
        return ratingStar;
    }


}

