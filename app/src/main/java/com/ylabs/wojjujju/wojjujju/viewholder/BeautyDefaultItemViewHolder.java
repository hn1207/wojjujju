package com.ylabs.wojjujju.wojjujju.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ylabs.wojjujju.wojjujju.R;

public class BeautyDefaultItemViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView price;
    public ImageView img;


    public TextView address;
    public RatingBar grade;
    public TextView commentCnt;
    public TextView description;
    public TextView label;
    public ImageView like;

    public BeautyDefaultItemViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.title);
        price = (TextView) v.findViewById(R.id.price);
        img = (ImageView) v.findViewById(R.id.img);


        address = (TextView) v.findViewById(R.id.address);
        grade = (RatingBar) v.findViewById(R.id.grade);
        commentCnt = (TextView) v.findViewById(R.id.comment_cnt);
        description = (TextView) v.findViewById(R.id.description);
        label = (TextView) v.findViewById(R.id.label);
        like = (ImageView) v.findViewById(R.id.like);

    }
}