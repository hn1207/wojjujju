package com.ylabs.wojjujju.wojjujju.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ylabs.wojjujju.wojjujju.R;

public class ReviewItemViewHolder extends RecyclerView.ViewHolder {



    public TextView userName;
    public TextView contents;
    public TextView date;
    public RatingBar grade;
    public ImageView img;

    public ReviewItemViewHolder(View v) {
        super(v);
        userName = (TextView) v.findViewById(R.id.user_name);
        contents = (TextView) v.findViewById(R.id.contents);
        date = (TextView) v.findViewById(R.id.date);
        grade = (RatingBar) v.findViewById(R.id.grade);
        img = (ImageView) v.findViewById(R.id.img);




    }
}