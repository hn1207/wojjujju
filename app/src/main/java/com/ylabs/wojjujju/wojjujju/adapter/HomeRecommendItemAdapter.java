package com.ylabs.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.entity.HomeRecommendItem;
import com.ylabs.wojjujju.wojjujju.entity.HomeSaleItem;
import com.ylabs.wojjujju.wojjujju.viewholder.HomeRecommendItemViewHolder;
import com.ylabs.wojjujju.wojjujju.viewholder.HomeSaleItemViewHolder;

import java.util.ArrayList;

public class HomeRecommendItemAdapter extends RecyclerView.Adapter<HomeRecommendItemViewHolder> {
    private ArrayList<HomeRecommendItem> dataList;
    private Context con;

    public HomeRecommendItemAdapter(ArrayList<HomeRecommendItem> dataList, Context con) {
        this.dataList = dataList;
        this.con=con;
    }
    @Override
    public HomeRecommendItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_recommend_item, parent, false);
        HomeRecommendItemViewHolder holder = new HomeRecommendItemViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(HomeRecommendItemViewHolder holder, int position) {

        holder.title.setText(dataList.get(position).getTitle());
        holder.price.setText(dataList.get(position).getPrice());

        Glide.with(con)
                .load(dataList.get(position).getImg())
                .into(holder.img);



    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}