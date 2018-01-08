package com.ylabs.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.entity.QnaItem;
import com.ylabs.wojjujju.wojjujju.viewholder.QnaItemViewHolder;

import java.util.ArrayList;

public class QnaItemAdapter extends RecyclerView.Adapter<QnaItemViewHolder> {
    private ArrayList<QnaItem> dataList;
    private Context con;
    private int layout;

    final int QUESTION = 0;
    final int ANSWER = 1;

    public QnaItemAdapter(ArrayList<QnaItem> dataList, Context con, int layout) {
        this.dataList = dataList;
        this.con=con;
        this.layout= layout;
    }
    @Override
    public QnaItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        QnaItemViewHolder holder = new QnaItemViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final QnaItemViewHolder holder, int position) {

        switch (dataList.get(position).getType()){
            case QUESTION:
                holder.qnaBackground.setBackgroundColor(con.getResources().getColor(R.color.white));
                break;
            case ANSWER:
                holder.qnaBackground.setBackgroundColor(con.getResources().getColor(R.color.soft_grey));
                holder.qnaBackground.setPadding(100,16,16,16);
                break;
        }

        holder.title.setText(dataList.get(position).getTitle());
        holder.contents.setText(dataList.get(position).getContents());
        holder.date.setText(dataList.get(position).getDate());





    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}