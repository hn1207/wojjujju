package com.rootup.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.entity.Item;
import com.rootup.wojjujju.wojjujju.viewholder.BaseItemViewHolder;

import java.util.ArrayList;

public class HomeSaleItemAdapter extends RecyclerView.Adapter<BaseItemViewHolder> {
    private ArrayList<Item> dataList;
    private Context con;

    public HomeSaleItemAdapter(ArrayList<Item> dataList, Context con) {
        this.dataList = dataList;
        this.con=con;
    }
    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_sales_item, parent, false);
        BaseItemViewHolder holder = new BaseItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseItemViewHolder holder, int position) {

        holder.title.setText(dataList.get(position).getTitle());
        holder.price.setText(dataList.get(position).getPrice());
        holder.price.setPaintFlags(holder.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

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