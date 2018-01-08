package com.ylabs.wojjujju.wojjujju.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ylabs.wojjujju.wojjujju.R;

public class DateTimePickerViewHolder extends RecyclerView.ViewHolder {

    public TextView dateTime;



    public DateTimePickerViewHolder(View v) {
        super(v);
        dateTime = (TextView) v.findViewById(R.id.date_time);

    }
}