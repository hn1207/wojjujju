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

public class BaseRecyclerAdapter extends RecyclerView.Adapter<BaseItemViewHolder> {
    private ArrayList<Item> dataList;
    private Context con;
    private int layout;

    public BaseRecyclerAdapter(ArrayList<Item> dataList, Context con, int layout) {
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

        try{holder.title.setText(dataList.get(position).getTitle());}catch (Exception e){}
        try{Glide.with(con).load(dataList.get(position).getImg()).into(holder.img); }catch(Exception e){}
        try{holder.date.setText(dataList.get(position).getDate());}catch (Exception e){}
        try{holder.price.setText(dataList.get(position).getPrice());}catch (Exception e){}
        try{holder.contents.setText(dataList.get(position).getContents());}catch (Exception e){}
        try{holder.userName.setText(dataList.get(position).getUserName());}catch (Exception e){}
        try{holder.percent.setText(dataList.get(position).getPercent());}catch (Exception e){}
        try{holder.grade.setRating(dataList.get(position).getGrade());}catch (Exception e){}


    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}