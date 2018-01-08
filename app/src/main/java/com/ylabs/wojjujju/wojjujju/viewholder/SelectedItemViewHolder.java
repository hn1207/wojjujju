package com.ylabs.wojjujju.wojjujju.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ylabs.wojjujju.wojjujju.R;

public class SelectedItemViewHolder extends RecyclerView.ViewHolder {



    public TextView title;
    public TextView date;
    public TextView price;
    public TextView contents;




    public SelectedItemViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.title);
        date = (TextView) v.findViewById(R.id.date);
        contents = (TextView) v.findViewById(R.id.contents);
        price = (TextView) v.findViewById(R.id.price);




    }
}