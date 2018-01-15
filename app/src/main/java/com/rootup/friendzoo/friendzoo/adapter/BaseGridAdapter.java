package com.rootup.friendzoo.friendzoo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.entity.Item;
import com.rootup.friendzoo.friendzoo.viewholder.BaseItemViewHolder;

import java.util.ArrayList;

public class BaseGridAdapter extends BaseAdapter {
    ArrayList<Item> dataList;
    int layout;
    Context con;
    LayoutInflater inflater;

    public BaseGridAdapter(ArrayList<Item> dataList, Context con, int layout){
        this.dataList = dataList;
        this.con = con;
        this.layout = layout;
        inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Item getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        BaseItemViewHolder holder;

        Item item = dataList.get(position);

        if(convertView == null) {
            convertView = inflater.inflate(layout, viewGroup, false);
            holder = new BaseItemViewHolder(convertView);
            convertView.setTag(holder);
        }
        else{
            holder = (BaseItemViewHolder) convertView.getTag();
        }


        try{holder.title.setText(item.getTitle());}catch (Exception e){}
        try{Glide.with(con).load(item.getImg()).into(holder.img); }catch(Exception e){}
        try{holder.date.setText(item.getDate());}catch (Exception e){}
        try{holder.price.setText(item.getPrice());}catch (Exception e){}
        try{holder.contents.setText(item.getContents());}catch (Exception e){}
        try{holder.userName.setText(item.getUserName());}catch (Exception e){}
        try{holder.grade.setRating(item.getGrade());}catch (Exception e){}
        try{holder.percent.setText(dataList.get(position).getPercent());}catch (Exception e){}
        try{holder.label.setText(dataList.get(position).getLabel());}catch (Exception e){}


        return convertView;
    }
}