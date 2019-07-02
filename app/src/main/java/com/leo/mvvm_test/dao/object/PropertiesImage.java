package com.leo.mvvm_test.dao.object;

import com.google.gson.annotations.SerializedName;
import com.leo.mvvm_test.dao.object.AttributesHeight;

public class PropertiesImage {
    @SerializedName("name")
    public String label;
    @SerializedName("attributes")
    public AttributesHeight attributes;
}
