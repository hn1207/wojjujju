package com.rootup.friendzoo.friendzoo.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.rootup.friendzoo.friendzoo.R;

public class BaseItemViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView price;
    public ImageView img;


    public TextView address;
    public RatingBar grade;
    public TextView commentCnt;
    public TextView description;
    public TextView label;
    public ImageView like;



    public TextView saledPrice;
    public TextView percent;

    public TextView date;

    public TextView contents;


    public LinearLayout qnaBackground;


    public TextView userName;


    public TextView cnt;





    public BaseItemViewHolder(View v) {
        super(v);

        try{title = (TextView) v.findViewById(R.id.title);} catch(Exception ignored){}
        try{img = (ImageView) v.findViewById(R.id.img);}catch(Exception ignored){}
        try{price = (TextView) v.findViewById(R.id.price);}catch (Exception ignored){}
        try{address = (TextView) v.findViewById(R.id.address);}catch (Exception ignored){}
        try{grade = (RatingBar) v.findViewById(R.id.grade);}catch (Exception ignored){}
        try{commentCnt = (TextView) v.findViewById(R.id.comment_cnt);}catch (Exception ignored){}
        try{description = (TextView) v.findViewById(R.id.description);}catch (Exception ignored){}
        try{label = (TextView) v.findViewById(R.id.label);}catch (Exception ignored){}
        try{like = (ImageView) v.findViewById(R.id.like);}catch (Exception ignored){}
        try{saledPrice = (TextView) v.findViewById(R.id.saledPrice);}catch (Exception ignored){}
        try{percent = (TextView) v.findViewById(R.id.percent);}catch (Exception ignored){}
        try{date = (TextView) v.findViewById(R.id.date);}catch (Exception ignored){}
        try{contents = (TextView) v.findViewById(R.id.contents);}catch (Exception ignored){}
        try{qnaBackground = (LinearLayout) v.findViewById(R.id.qna_bg);}catch (Exception ignored){}
        try{userName = (TextView) v.findViewById(R.id.user_name);}catch (Exception ignored){}
        try{cnt = (TextView) v.findViewById(R.id.cnt);}catch (Exception ignored){}



    }
}