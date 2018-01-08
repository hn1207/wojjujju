package com.ylabs.wojjujju.wojjujju.viewholder;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylabs.wojjujju.wojjujju.R;

public class HomeHotItemViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView price;
    public ImageView img;

    public HomeHotItemViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.title);
        price = (TextView) v.findViewById(R.id.price);
        img = (ImageView) v.findViewById(R.id.img);


    }
}