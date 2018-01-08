package com.ylabs.wojjujju.wojjujju.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ylabs.wojjujju.wojjujju.R;

public class QnaItemViewHolder extends RecyclerView.ViewHolder {



    public TextView title;
    public TextView contents;
    public TextView date;
    public LinearLayout qnaBackground;

    public QnaItemViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.title);
        contents = (TextView) v.findViewById(R.id.contents);
        date = (TextView) v.findViewById(R.id.date);
        qnaBackground = (LinearLayout) v.findViewById(R.id.qna_bg);



    }
}