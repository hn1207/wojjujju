package com.rootup.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.entity.Item;
import com.rootup.wojjujju.wojjujju.viewholder.BaseItemViewHolder;

import java.util.ArrayList;

public class BaseLikeDefaultItemAdapter extends RecyclerView.Adapter<BaseItemViewHolder> {
    private ArrayList<Item> dataList;
    private Context con;
    int layout;


    public BaseLikeDefaultItemAdapter(ArrayList<Item> dataList, Context con, int layout) {
        this.dataList = dataList;
        this.con=con;
        this.layout = layout;
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

        try{holder.title.setText(dataList.get(position).getTitle());}catch (Exception e){};
//        holder.price.setText(dataList.get(position).getPrice());

        try{holder.address.setText(dataList.get(position).getAddress());}catch (Exception e){};
        try{holder.grade.setRating(dataList.get(position).getGrade());}catch (Exception e){};
        try{holder.commentCnt.setText(String.valueOf(dataList.get(position).getCommentCnt()));}catch (Exception e){};
        try{holder.description.setText(dataList.get(position).getDescription());}catch (Exception e){}
        try{holder.label.setText(dataList.get(position).getLabel());}catch(Exception e){};
        String heartcolor = "#eb5036";
        try {
            if (dataList.get(position).getLike() == 1) {
                holder.like.setImageResource(R.drawable.heart_on);
            } else {
                holder.like.setImageResource(R.drawable.heart_off);
            }
        }catch (Exception e){};
        try{Glide.with(con).applyDefaultRequestOptions(RequestOptions.centerCropTransform()).load(dataList.get(position).getImg()).into(holder.img);}catch (Exception e){};



    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}