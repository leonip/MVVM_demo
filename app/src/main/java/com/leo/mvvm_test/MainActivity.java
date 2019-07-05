package com.leo.mvvm_test;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.leo.mvvm_test.dao.FreeAppEntry;
import com.leo.mvvm_test.recycler_view.FreeAppListViewAdapter;
import com.leo.mvvm_test.recycler_view.RecommendAppListRecyclerViewAdapter;
import com.leo.mvvm_test.recycler_view.LocalRecyclerView;
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

        LocalRecyclerView rv = new LocalRecyclerView(this);
        ArrayList<FreeAppEntry> recommendAppList = new ArrayList<>();
        RecommendAppListRecyclerViewAdapter recommendAdapter = new RecommendAppListRecyclerViewAdapter(recommendAppList);
        rv.setAdapter(recommendAdapter);
        bodyList.addHeaderView(rv.getView());


        model.getFreeApps().observe(this, (res) -> {
            freeAppList.addAll(res);
            freeAppAdapter.notifyDataSetChanged();
        });


        model.getRecommendApps().observe(this, (res) -> {
            recommendAppList.addAll(res);
            recommendAdapter.notifyItemRangeInserted(0,res.size());
        });

    }
}
