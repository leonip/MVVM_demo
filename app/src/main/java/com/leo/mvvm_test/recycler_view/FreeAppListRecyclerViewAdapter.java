package com.leo.mvvm_test.recycler_view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.mvvm_test.R;
import com.leo.mvvm_test.dao.FreeAppEntry;

import java.util.ArrayList;

public class FreeAppListRecyclerViewAdapter extends RecyclerView.Adapter<FreeAppListRecyclerViewAdapter.MyViewHolder>{
    private ArrayList<FreeAppEntry> mDataset;

    // Constructor
    public FreeAppListRecyclerViewAdapter(ArrayList<FreeAppEntry> dataset) {
        mDataset = dataset;
    }

    public FreeAppListRecyclerViewAdapter() {

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_free_app, parent, false);
        MyViewHolder vh = new MyViewHolder(view);


//        MyViewHolder vh = new MyViewHolder(new FlexboxLayout_Example(parent.getContext()).addCell(viewType).getView());

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - replace the contents of the view with that element
    }

    @Override
    public int getItemViewType(int position) {
//        if(position == /* position of item that needs extra text view */) {
//            return VIEW_WITH_EXTRA_TEXT_VIEW;
//        } else {
//            return VIEW_ORDINARY;
//        }
        return position;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public MyViewHolder(View mView) {
            super(mView);
            this.mView = mView;
        }
    }
}
