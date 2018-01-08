package com.ylabs.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.entity.QnaItem;
import com.ylabs.wojjujju.wojjujju.entity.ReviewItem;
import com.ylabs.wojjujju.wojjujju.viewholder.QnaItemViewHolder;
import com.ylabs.wojjujju.wojjujju.viewholder.ReviewItemViewHolder;

import java.util.ArrayList;

public class ReviewItemAdapter extends RecyclerView.Adapter<ReviewItemViewHolder> {
    private ArrayList<ReviewItem> dataList;
    private Context con;
    private int layout;

    final int QUESTION = 0;
    final int ANSWER = 1;

    public ReviewItemAdapter(ArrayList<ReviewItem> dataList, Context con, int layout) {
        this.dataList = dataList;
        this.con=con;
        this.layout= layout;
    }
    @Override
    public ReviewItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        ReviewItemViewHolder holder = new ReviewItemViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final ReviewItemViewHolder holder, int position) {




        holder.userName.setText(dataList.get(position).getUserName());
        holder.contents.setText(dataList.get(position).getContents());
        holder.date.setText(dataList.get(position).getDate());

        holder.grade.setRating(dataList.get(position).getGrade());




        Glide.with(con)
                .load(dataList.get(position).getImg())
                .into(holder.img);



    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}