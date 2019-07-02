package com.leo.mvvm_test.dao.object;

import com.google.gson.annotations.SerializedName;
import com.leo.mvvm_test.dao.object.AttributesPrice;

public class PropertiesPrice {
    @SerializedName("name")
    public String label;
    @SerializedName("attributes")
    public AttributesPrice attributes;
}
