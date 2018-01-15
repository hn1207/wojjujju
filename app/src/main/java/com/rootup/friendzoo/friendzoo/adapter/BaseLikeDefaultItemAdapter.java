package com.rootup.friendzoo.friendzoo.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.entity.Item;
import com.rootup.friendzoo.friendzoo.viewholder.BaseItemViewHolder;

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



        try{if(dataList.get(position).getTitle()==null){holder.title.setVisibility(View.GONE);}else{ holder.title.setText(dataList.get(position).getTitle()); }}catch (Exception e){}
        try{if(dataList.get(position).getDate()==null){holder.date.setVisibility(View.GONE);}else{ holder.date.setText(dataList.get(position).getDate()); }}catch (Exception e){}
        try{if(dataList.get(position).getPrice()==null){holder.price.setVisibility(View.GONE);}else{ holder.price.setText(dataList.get(position).getPrice());   holder.price.setPaintFlags(holder.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG); }}catch (Exception e){}
        try{if(dataList.get(position).getContents()==null){holder.contents.setVisibility(View.GONE);}else{ holder.contents.setText(dataList.get(position).getContents()); }}catch (Exception e){}
        try{if(dataList.get(position).getUserName()==null){holder.userName.setVisibility(View.GONE);}else{ holder.userName.setText(dataList.get(position).getUserName()); }}catch (Exception e){}
        try{if(dataList.get(position).getPercent()==null){holder.percent.setVisibility(View.GONE);}else{ holder.percent.setText(dataList.get(position).getPercent()); }}catch (Exception e){}
        try{if(dataList.get(position).getSaledPrice()==null){holder.saledPrice.setVisibility(View.GONE);}else{ holder.saledPrice.setText(dataList.get(position).getSaledPrice()); }}catch (Exception e){}
        try{if(dataList.get(position).getGrade()==-1){holder.grade.setVisibility(View.GONE);}else{ holder.grade.setRating(dataList.get(position).getGrade()); }}catch (Exception e){}


        try{if(dataList.get(position).getAddress()==null){holder.address.setVisibility(View.GONE);}else{ holder.address.setText(dataList.get(position).getAddress()); }}catch (Exception e){}
        try{if(dataList.get(position).getCommentCnt()==-1){holder.commentCnt.setVisibility(View.GONE);}else{ holder.commentCnt.setText("("+dataList.get(position).getCommentCnt() + ")"); }}catch (Exception e){}
        try{if(dataList.get(position).getDescription()==null){holder.description.setVisibility(View.GONE);}else{ holder.description.setText(dataList.get(position).getDescription()); }}catch (Exception e){}
        try{if(dataList.get(position).getLabel()==null){holder.label.setVisibility(View.GONE);}else{ holder.label.setText(dataList.get(position).getLabel()); }}catch (Exception e){}




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