package com.leo.mvvm_test.recycler_view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leo.mvvm_test.R;
import com.leo.mvvm_test.dao.FreeAppEntry;

import java.util.ArrayList;

public class FreeAppListRecyclerViewAdapter extends RecyclerView.Adapter<FreeAppListRecyclerViewAdapter.MyViewHolder>{
    private ArrayList<FreeAppEntry> mDataset;

    final private static int CELL_TYPE_ODD = 1;
    final private static int CELL_TYPE_EVEN = 0;

    // Constructor
    public FreeAppListRecyclerViewAdapter(ArrayList<FreeAppEntry> dataset) {
        mDataset = dataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_free_app, parent, false);
        MyViewHolder vh = new MyViewHolder(view);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FreeAppEntry appInfo = mDataset.get(position);
        String index = Integer.toString(position+1);
        holder.txtPosition.setText(index);
        holder.txtTitle.setText(appInfo.name.label);
        holder.txtType.setText(appInfo.category.attributes.label);
        holder.txtRating.setText("70");
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2 == 1) {
            return CELL_TYPE_ODD;
        } else {
            return CELL_TYPE_EVEN;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView txtPosition;
        public TextView txtTitle;
        public TextView txtType;
        public TextView txtRating;
        public MyViewHolder(View mView) {
            super(mView);
            this.mView = mView;
            this.txtPosition = mView.findViewById(R.id.txtPosition);
            this.txtTitle = mView.findViewById(R.id.txtTitle);
            this.txtType = mView.findViewById(R.id.txtType);
            this.txtRating = mView.findViewById(R.id.txtRating);
        }
    }



}
