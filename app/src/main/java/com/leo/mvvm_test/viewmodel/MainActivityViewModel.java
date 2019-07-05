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

    private MutableLiveData<ArrayList<FreeAppEntry>> freeApps;
    private MutableLiveData<ArrayList<FreeAppEntry>> recommendApps;
    public LiveData<ArrayList<FreeAppEntry>> getFreeApps() {
        if (freeApps == null) {
            freeApps = new MutableLiveData<>();
            loadFreeAppsList();
        }
        return freeApps;
    }

    public void loadFreeAppsList() {
        api.getTopFreeApplication((res) -> {
            freeApps.setValue(res.getFreeAppsList());
        });
    }

    public LiveData<ArrayList<FreeAppEntry>> getRecommendApps() {
        if (recommendApps == null) {
            recommendApps = new MutableLiveData<>();
            loadRecommendAppsList();
        }
        return recommendApps;
    }

    public void loadRecommendAppsList() {
        api.getRecommendApplication((res) -> {
            recommendApps.setValue(res.getFreeAppsList());
        });
    }
}
