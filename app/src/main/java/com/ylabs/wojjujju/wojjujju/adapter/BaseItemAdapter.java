package com.ylabs.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.entity.Item;
import com.ylabs.wojjujju.wojjujju.viewholder.BaseItemViewHolder;

import java.util.ArrayList;

public class BaseItemAdapter extends RecyclerView.Adapter<BaseItemViewHolder> {
    private ArrayList<Item> dataList;
    private Context con;
    private int layout;

    public BaseItemAdapter(ArrayList<Item> dataList, Context con, int layout) {
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

        holder.title.setText(dataList.get(position).getTitle());
//        holder.price.setText(dataList.get(position).getPrice());

        Glide.with(con)
                .load(dataList.get(position).getImg())
                .into(holder.img);


    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}