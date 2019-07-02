package com.leo.mvvm_test.dao;

import com.google.gson.annotations.SerializedName;
import com.leo.mvvm_test.dao.object.PropertiesImage;
import com.leo.mvvm_test.dao.object.PropertiesLabel;
import com.leo.mvvm_test.dao.object.PropertiesLink;
import com.leo.mvvm_test.dao.object.PropertiesPrice;
import com.leo.mvvm_test.dao.object.PropertiesType;

import java.util.ArrayList;

public class FreeAppEntry {
    @SerializedName("im:name")
    PropertiesLabel label;
    @SerializedName("im:image")
    ArrayList<PropertiesImage> image;
    @SerializedName("summary")
    PropertiesLabel summary;
    @SerializedName("im:price")
    PropertiesPrice price;
    @SerializedName("im:contentType")
    PropertiesType type;
    @SerializedName("rights")
    PropertiesLabel rights;
    @SerializedName("title")
    PropertiesLabel title;
    @SerializedName("link")
    PropertiesLink link;
    // id
}

