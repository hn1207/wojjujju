package com.ylabs.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ylabs.wojjujju.wojjujju.entity.ReviewItem;
import com.ylabs.wojjujju.wojjujju.entity.SelectedItem;
import com.ylabs.wojjujju.wojjujju.viewholder.ReviewItemViewHolder;
import com.ylabs.wojjujju.wojjujju.viewholder.SelectedItemViewHolder;

import java.util.ArrayList;

public class SelectedItemAdapter extends RecyclerView.Adapter<SelectedItemViewHolder> {
    private ArrayList<SelectedItem> dataList;
    private Context con;
    private int layout;

    final int QUESTION = 0;
    final int ANSWER = 1;

    public SelectedItemAdapter(ArrayList<SelectedItem> dataList, Context con, int layout) {
        this.dataList = dataList;
        this.con=con;
        this.layout= layout;
    }
    @Override
    public SelectedItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        SelectedItemViewHolder holder = new SelectedItemViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final SelectedItemViewHolder holder, int position) {




        holder.title.setText(dataList.get(position).getTitle());
        holder.date.setText(dataList.get(position).getDate());
        holder.price.setText(dataList.get(position).getPrice());
//        holder.contents.setText(dataList.get(position).getContents());




    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}