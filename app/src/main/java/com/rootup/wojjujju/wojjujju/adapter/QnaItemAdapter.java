package com.rootup.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.entity.Item;
import com.rootup.wojjujju.wojjujju.viewholder.BaseItemViewHolder;

import java.util.ArrayList;

public class QnaItemAdapter extends RecyclerView.Adapter<BaseItemViewHolder> {
    private ArrayList<Item> dataList;
    private Context con;
    private int layout;

    final int QUESTION = 0;
    final int ANSWER = 1;

    public QnaItemAdapter(ArrayList<Item> dataList, Context con, int layout) {
        this.dataList = dataList;
        this.con=con;
        this.layout= layout;
    }
    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        BaseItemViewHolder holder = new BaseItemViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final BaseItemViewHolder holder, int position) {

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