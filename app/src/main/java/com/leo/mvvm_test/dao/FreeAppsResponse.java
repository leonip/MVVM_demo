package com.leo.mvvm_test.dao;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FreeAppsResponse {

    @SerializedName("feed")
    public FreeAppsList ID;

    public ArrayList<FreeAppEntry> getFreeAppsList() {
        return ID.freeAppList;
    }





    public class FreeAppsList {
        @SerializedName("entry")
        public ArrayList<FreeAppEntry> freeAppList;
    }
}

