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

public class BeautyDefaultItemAdapter extends RecyclerView.Adapter<BaseItemViewHolder> {
    private ArrayList<Item> dataList;
    private Context con;


    public BeautyDefaultItemAdapter(ArrayList<Item> dataList, Context con) {
        this.dataList = dataList;
        this.con=con;
    }
    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_beauty_default_item, parent, false);
        BaseItemViewHolder holder = new BaseItemViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final BaseItemViewHolder holder, int position) {

        holder.title.setText(dataList.get(position).getTitle());
//        holder.price.setText(dataList.get(position).getPrice());

        holder.address.setText(dataList.get(position).getAddress());
        holder.grade.setRating(dataList.get(position).getGrade());
        holder.commentCnt.setText(String.valueOf(dataList.get(position).getCommentCnt()));
        holder.description.setText(dataList.get(position).getDescription());
        holder.label.setText(dataList.get(position).getLabel());
        String heartcolor = "#eb5036";
        if(dataList.get(position).getLike() == 1)
        {
            holder.like.setImageResource(R.drawable.heart_on);
        }
        else
        {
            holder.like.setImageResource(R.drawable.heart_off);
        }

        Glide.with(con)
                .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(dataList.get(position).getImg())
                .into(holder.img);



    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}