package com.ylabs.wojjujju.wojjujju.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylabs.wojjujju.wojjujju.R;

public class HomeRecommendItemViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView price;
    public ImageView img;

    public HomeRecommendItemViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.title);
        price = (TextView) v.findViewById(R.id.price);
        img = (ImageView) v.findViewById(R.id.img);


    }
}