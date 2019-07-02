package com.leo.mvvm_test;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.leo.mvvm_test.recycler_view.FreeAppListRecyclerViewAdapter;
import com.leo.mvvm_test.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityViewModel model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        model.init(this.getApplicationContext());

        // init UI
        RecyclerView bodyList = findViewById(R.id.bodyList);
        bodyList.setLayoutManager(new LinearLayoutManager(this));

        model.getUsers().observe(this, (res) -> {
            bodyList.setAdapter(new FreeAppListRecyclerViewAdapter(res));
            bodyList.setHasFixedSize(true);
        });
    }
}
