package com.ylabs.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.entity.BeautyItem;
import com.ylabs.wojjujju.wojjujju.entity.HomeHotItem;
import com.ylabs.wojjujju.wojjujju.viewholder.BeautyDefaultItemViewHolder;
import com.ylabs.wojjujju.wojjujju.viewholder.HomeHotItemViewHolder;

import java.util.ArrayList;

public class BeautyDefaultItemAdapter extends RecyclerView.Adapter<BeautyDefaultItemViewHolder> {
    private ArrayList<BeautyItem> dataList;
    private Context con;

    public BeautyDefaultItemAdapter(ArrayList<BeautyItem> dataList, Context con) {
        this.dataList = dataList;
        this.con=con;
    }
    @Override
    public BeautyDefaultItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_beauty_default_item, parent, false);
        BeautyDefaultItemViewHolder holder = new BeautyDefaultItemViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final BeautyDefaultItemViewHolder holder, int position) {

        holder.title.setText(dataList.get(position).getTitle());
//        holder.price.setText(dataList.get(position).getPrice());

        holder.address.setText(dataList.get(position).getAddress());
        holder.grade.setRating(dataList.get(position).getGrade());
        holder.commentCnt.setText(String.valueOf(dataList.get(position).getCommentCnt()));
        holder.description.setText(dataList.get(position).getDescription());
        holder.label.setText(dataList.get(position).getLabel());
        holder.like.setText(String.valueOf(dataList.get(position).getLike()));

        Glide.with(con)
                .load(dataList.get(position).getImg())
                .into(holder.img);


    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}