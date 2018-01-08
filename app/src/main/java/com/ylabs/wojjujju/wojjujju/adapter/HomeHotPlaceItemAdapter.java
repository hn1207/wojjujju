package com.ylabs.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.entity.HomeHotItem;
import com.ylabs.wojjujju.wojjujju.entity.HomeHotPlaceItem;
import com.ylabs.wojjujju.wojjujju.viewholder.HomeHotItemViewHolder;
import com.ylabs.wojjujju.wojjujju.viewholder.HomeHotPlaceItemViewHolder;

import java.util.ArrayList;

public class HomeHotPlaceItemAdapter extends RecyclerView.Adapter<HomeHotPlaceItemViewHolder> {
    private ArrayList<HomeHotPlaceItem> dataList;
    private Context con;

    public HomeHotPlaceItemAdapter(ArrayList<HomeHotPlaceItem> dataList, Context con) {
        this.dataList = dataList;
        this.con=con;
    }
    @Override
    public HomeHotPlaceItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_hot_place_item, parent, false);
        HomeHotPlaceItemViewHolder holder = new HomeHotPlaceItemViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final HomeHotPlaceItemViewHolder holder, int position) {

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