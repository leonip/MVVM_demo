package com.leo.mvvm_test.dao;

import com.google.gson.annotations.SerializedName;
import com.leo.mvvm_test.dao.object.PropertiesCategory;
import com.leo.mvvm_test.dao.object.PropertiesImage;
import com.leo.mvvm_test.dao.object.PropertiesLabel;
import com.leo.mvvm_test.dao.object.PropertiesLink;
import com.leo.mvvm_test.dao.object.PropertiesPrice;
import com.leo.mvvm_test.dao.object.PropertiesType;

import java.util.ArrayList;

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
    @SerializedName("category")
    public PropertiesCategory category;

}

