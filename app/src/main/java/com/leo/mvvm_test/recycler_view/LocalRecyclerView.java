package com.leo.mvvm_test.recycler_view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class LocalRecyclerView extends RecyclerView {
    Context mContext;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public LocalRecyclerView(Context mContext){
        super(mContext);
        this.mContext = mContext;

        mRecyclerView = new RecyclerView(mContext);
        mRecyclerView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    public void setAdapter(RecyclerView.Adapter mAdapter){
        this.mAdapter = mAdapter;
        mRecyclerView.setAdapter(mAdapter);
    }

    public View getView(){
        return mRecyclerView;
    }

}