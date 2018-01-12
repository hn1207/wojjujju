package com.rootup.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.rootup.wojjujju.wojjujju.entity.Item;
import com.rootup.wojjujju.wojjujju.viewholder.BaseItemViewHolder;

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

        try{if(dataList.get(position).getTitle()==null){holder.title.setVisibility(View.GONE);}else{ holder.title.setText(dataList.get(position).getTitle()); }}catch (Exception e){}
        try{if(dataList.get(position).getDate()==null){holder.date.setVisibility(View.GONE);}else{ holder.date.setText(dataList.get(position).getDate()); }}catch (Exception e){}
        try{if(dataList.get(position).getPrice()==null){holder.price.setVisibility(View.GONE);}else{ holder.price.setText(dataList.get(position).getPrice()); }}catch (Exception e){}
        try{if(dataList.get(position).getContents()==null){holder.contents.setVisibility(View.GONE);}else{ holder.contents.setText(dataList.get(position).getContents()); }}catch (Exception e){}
        try{if(dataList.get(position).getUserName()==null){holder.userName.setVisibility(View.GONE);}else{ holder.userName.setText(dataList.get(position).getUserName()); }}catch (Exception e){}
        try{if(dataList.get(position).getPercent()==null){holder.percent.setVisibility(View.GONE);}else{ holder.percent.setText(dataList.get(position).getPercent()); }}catch (Exception e){}
        try{if(dataList.get(position).getGrade()==-1){holder.grade.setVisibility(View.GONE);}else{ holder.grade.setRating(dataList.get(position).getGrade()); }}catch (Exception e){}
        try{if(dataList.get(position).getDescription()==null){holder.description.setVisibility(View.GONE);}else{ holder.description.setText(dataList.get(position).getDescription()); }}catch (Exception e){}
        try{if(dataList.get(position).getCnt()==-1){holder.cnt.setVisibility(View.GONE);}else{ holder.cnt.setText("("+dataList.get(position).getCnt()+"개)"); }}catch (Exception e){}

        try{Glide.with(con).load(dataList.get(position).getImg()).into(holder.img); }catch(Exception e){}



    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}