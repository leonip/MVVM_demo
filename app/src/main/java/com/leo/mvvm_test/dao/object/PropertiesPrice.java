package com.leo.mvvm_test.dao.object;

import com.google.gson.annotations.SerializedName;
import com.leo.mvvm_test.dao.object.AttributesPrice;

public class PropertiesPrice {
    @SerializedName("label")
    String label;
    @SerializedName("attributes")
    AttributesPrice attributes;
}
