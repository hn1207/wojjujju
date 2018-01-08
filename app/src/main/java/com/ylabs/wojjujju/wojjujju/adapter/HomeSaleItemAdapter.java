package com.ylabs.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.entity.HomeHotItem;
import com.ylabs.wojjujju.wojjujju.entity.HomeSaleItem;
import com.ylabs.wojjujju.wojjujju.viewholder.HomeSaleItemViewHolder;

import java.util.ArrayList;

public class HomeSaleItemAdapter extends RecyclerView.Adapter<HomeSaleItemViewHolder> {
    private ArrayList<HomeSaleItem> dataList;
    private Context con;

    public HomeSaleItemAdapter(ArrayList<HomeSaleItem> dataList, Context con) {
        this.dataList = dataList;
        this.con=con;
    }
    @Override
    public HomeSaleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_sales_item, parent, false);
        HomeSaleItemViewHolder holder = new HomeSaleItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeSaleItemViewHolder holder, int position) {

        holder.title.setText(dataList.get(position).getTitle());
        holder.originPrice.setText(dataList.get(position).getPrice());
        holder.originPrice.setPaintFlags(holder.originPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.percent.setText(dataList.get(position).getPercent());
        holder.saledPrice.setText(dataList.get(position).getSaledPrice());

        Glide.with(con)
                .load(dataList.get(position).getImg())
                .into(holder.img);


    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}