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
    int index_paging = 0;

    public void init(Context mContext){
        this.mContext = mContext;
        api = new ApiManager(this.mContext);

    }

    private MutableLiveData<ArrayList<FreeAppEntry>> freeApps;
    private MutableLiveData<ArrayList<FreeAppEntry>> recommendApps;
    private MutableLiveData<String> searchKeyword;
    private MutableLiveData<ArrayList<FreeAppEntry>> searchResultApps;

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

    public ArrayList<FreeAppEntry> getNextTenApps() {
        index_paging += 10;
        return new ArrayList<>(freeApps.getValue().subList(index_paging,index_paging+10));
    }

    public MutableLiveData<String> getSearchKeyword() {
        if (searchKeyword == null){
            searchKeyword = new MutableLiveData<>();
        }
        return searchKeyword;
    }

    public void setSearchKeyword(String keyword) {
        getSearchKeyword().setValue(keyword);
        searchingApps();
    }

    public LiveData<ArrayList<FreeAppEntry>> getSearchResultApps() {
        if (searchResultApps == null) {
            searchResultApps = new MutableLiveData<>();
        }
        return searchResultApps;
    }

    private void searchingApps() {
        ArrayList<FreeAppEntry> searchResultList = new ArrayList<>();
        for (FreeAppEntry v : freeApps.getValue()) {
            if (v.getTextForSearch().contains(searchKeyword.getValue())) {
                searchResultList.add(v);
            }
        }
        searchResultApps.postValue(searchResultList);
    }
}
