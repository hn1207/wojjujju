package com.ylabs.wojjujju.wojjujju.viewholder;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylabs.wojjujju.wojjujju.R;

public class PaymentItemViewHolder extends RecyclerView.ViewHolder {



    public ImageView img;
    public TextView title;
    public TextView date;
    public TextView price;
    public TextView contents;







    public PaymentItemViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.title);
        date = (TextView) v.findViewById(R.id.date);
        contents = (TextView) v.findViewById(R.id.contents);
        price = (TextView) v.findViewById(R.id.price);
        img = (ImageView) v.findViewById(R.id.img);




    }
}