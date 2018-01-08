package com.ylabs.wojjujju.wojjujju.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylabs.wojjujju.wojjujju.R;

public class HomeSaleItemViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView originPrice;
    public TextView saledPrice;
    public TextView percent;
    public ImageView img;

    public HomeSaleItemViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.title);
        originPrice = (TextView) v.findViewById(R.id.originPrice);
        saledPrice = (TextView) v.findViewById(R.id.saledPrice);
        percent = (TextView) v.findViewById(R.id.percent);
        img = (ImageView) v.findViewById(R.id.sales_img);


    }
}