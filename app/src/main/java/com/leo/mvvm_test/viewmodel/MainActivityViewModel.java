package com.leo.mvvm_test.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.leo.mvvm_test.dao.FreeAppEntry;
import com.leo.mvvm_test.network.ApiManager;

import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel {
    Context mContext;
    ApiManager api;

    public void init(Context mContext){
        this.mContext = mContext;
        api = new ApiManager(this.mContext);

    }

    private MutableLiveData<ArrayList<FreeAppEntry>> users;
    public LiveData<ArrayList<FreeAppEntry>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            loadFreeAppsList();
        }
        return users;
    }

    public void loadFreeAppsList() {
        api.getTopFreeApplication((res) -> {
            users.setValue(res.getFreeAppsList());
        });

    }
}
