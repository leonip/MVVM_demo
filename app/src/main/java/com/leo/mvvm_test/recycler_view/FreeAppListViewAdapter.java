package com.leo.mvvm_test.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.leo.mvvm_test.R;
import com.leo.mvvm_test.dao.FreeAppEntry;
import com.leo.mvvm_test.dao.object.PropertiesImage;
import com.leo.mvvm_test.util.image.CircleTransform;
import com.leo.mvvm_test.util.image.RoundedCornersTransformation;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;

import info.androidhive.fontawesome.FontTextView;

public class FreeAppListViewAdapter extends ArrayAdapter<FreeAppEntry> {
    private ArrayList<FreeAppEntry> mDataset;

    // Constructor
    public FreeAppListViewAdapter(Context context, ArrayList<FreeAppEntry> dataset) {
        super(context, 0, dataset);
        this.mDataset = dataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.cell_free_app, parent, false);
            viewHolder.txtPosition = convertView.findViewById(R.id.txtPosition);
            viewHolder.txtTitle = convertView.findViewById(R.id.txtTitle);
            viewHolder.txtType = convertView.findViewById(R.id.txtType);
            viewHolder.txtStars = convertView.findViewById(R.id.txtStars);
            viewHolder.txtRating = convertView.findViewById(R.id.txtRating);
            viewHolder.imgIcon = convertView.findViewById(R.id.imgIcon);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        FreeAppEntry appInfo = mDataset.get(position);
        String index = Integer.toString(position+1);
        viewHolder.txtPosition.setText(index);
        viewHolder.txtTitle.setText(appInfo.name.label);
        viewHolder.txtType.setText(appInfo.category.attributes.label);
        String starsStr = parent.getResources().getString(R.string.fa_star_solid)+" "
                + parent.getResources().getString(R.string.fa_star_solid)+" "
                + parent.getResources().getString(R.string.fa_star_solid)+" "
                + parent.getResources().getString(R.string.fa_star_solid)+" "
                + parent.getResources().getString(R.string.fa_star_solid)+" ";

        viewHolder.txtStars.setText(starsStr);
        viewHolder.txtRating.setText("(70)");

        PropertiesImage img = appInfo.image.get(0);
        int length = Integer.parseInt(img.attributes.height);
        Transformation transformType = position%2 == 1 ?
                new CircleTransform() :
                new RoundedCornersTransformation(10, 0);
        Picasso.get()
                .load(img.label)
                .transform(transformType)
                .resize(length,length).into(viewHolder.imgIcon);

        return convertView;
    }

    private static class ViewHolder{
        public TextView txtPosition;
        public TextView txtTitle;
        public TextView txtType;
        public TextView txtRating;
        public ImageView imgIcon;
        public FontTextView txtStars;
    }
}
