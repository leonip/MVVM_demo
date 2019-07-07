package com.leo.mvvm_test;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.leo.mvvm_test.dao.FreeAppEntry;
import com.leo.mvvm_test.recycler_view.FreeAppListViewAdapter;
import com.leo.mvvm_test.recycler_view.RecommendAppListRecyclerViewAdapter;
import com.leo.mvvm_test.viewmodel.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityViewModel model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        model.init(this.getApplicationContext());

        // init UI
        ListView bodyList = findViewById(R.id.bodyList);
        ArrayList<FreeAppEntry> freeAppList = new ArrayList<>();
        FreeAppListViewAdapter freeAppAdapter = new FreeAppListViewAdapter(this,freeAppList);
        bodyList.setAdapter(freeAppAdapter);

        ProgressBar bodyProgress = findViewById(R.id.bodyProgress);

        View headerView = LayoutInflater.from(this).inflate(R.layout.view_recommend,null, false);
        RecyclerView rv = headerView.findViewById(R.id.recommendList);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FreeAppEntry> recommendAppList = new ArrayList<>();
        RecommendAppListRecyclerViewAdapter recommendAdapter = new RecommendAppListRecyclerViewAdapter(recommendAppList);
        rv.setAdapter(recommendAdapter);
        bodyList.addHeaderView(headerView);

        TextInputEditText searchInput = findViewById(R.id.searchInput);
        ListView searchResultListView = findViewById(R.id.searchResultList);
        ArrayList<FreeAppEntry> searchResultList = new ArrayList<>();
        FreeAppListViewAdapter searchResultAdapter = new FreeAppListViewAdapter(this,searchResultList);
        searchResultListView.setAdapter(searchResultAdapter);


        model.getFreeApps().observe(this, (res) -> {
            freeAppList.addAll(res.subList(0, 10));
            freeAppAdapter.notifyDataSetChanged();
        });


        model.getRecommendApps().observe(this, (res) -> {
            bodyProgress.setVisibility(res == null ? View.VISIBLE : View.INVISIBLE);
            recommendAppList.addAll(res);
            recommendAdapter.notifyItemRangeInserted(0,res.size());
        });

        bodyList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if (totalItemCount > 0 && totalItemCount < 100) {
                    int lastInScreen = firstVisibleItem + visibleItemCount;
                    if (lastInScreen == totalItemCount) {
                        if(model.getFreeApps().getValue() != null){
                            freeAppList.addAll(model.getNextTenApps());
                            freeAppAdapter.notifyDataSetChanged();

                        }
                    }
                }
            }
        });

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                model.setSearchKeyword(s.toString());
            }
        });

        model.getSearchKeyword().observe(this, (res) -> {
            bodyList.setVisibility(res.length() == 0 ? View.VISIBLE : View.INVISIBLE);
            searchResultListView.setVisibility(res.length() > 0 ? View.VISIBLE : View.INVISIBLE);
        });

        model.getSearchResultApps().observe(this, (res) -> {
            searchResultList.clear();
            searchResultList.addAll(res);
            searchResultAdapter.notifyDataSetChanged();
        });

    }
}
