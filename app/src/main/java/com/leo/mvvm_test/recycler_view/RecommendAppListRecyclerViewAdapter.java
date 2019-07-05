package com.leo.mvvm_test.recycler_view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leo.mvvm_test.R;
import com.leo.mvvm_test.dao.FreeAppEntry;
import com.leo.mvvm_test.dao.object.PropertiesImage;
import com.leo.mvvm_test.util.image.RoundedCornersTransformation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecommendAppListRecyclerViewAdapter extends RecyclerView.Adapter<RecommendAppListRecyclerViewAdapter.MyViewHolder>{
    private ArrayList<FreeAppEntry> mDataset;

    // Constructor
    public RecommendAppListRecyclerViewAdapter(ArrayList<FreeAppEntry> dataset) {
        this.mDataset = dataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_recommend_app, parent, false);
        MyViewHolder vh = new MyViewHolder(view);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FreeAppEntry appInfo = mDataset.get(position);
//        FreeAppEntry index = Integer.toString(position+1);
        holder.txtTitle.setText(appInfo.name.label);
        holder.txtType.setText(appInfo.category.attributes.label);

        PropertiesImage img = appInfo.image.get(0);
        int length = Integer.parseInt(img.attributes.height);
        Picasso.get()
                .load(img.label)
                .transform(new RoundedCornersTransformation(10, 0))
                .resize(length,length).into(holder.imgIcon);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView txtTitle;
        public TextView txtType;
        public ImageView imgIcon;
        public MyViewHolder(View mView) {
            super(mView);
            this.mView = mView;
            this.txtTitle = mView.findViewById(R.id.txtTitle);
            this.txtType = mView.findViewById(R.id.txtType);
            this.imgIcon = mView.findViewById(R.id.imgIcon);
        }
    }
}
