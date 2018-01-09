package com.ylabs.wojjujju.wojjujju.adapter;

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
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.entity.Item;
import com.ylabs.wojjujju.wojjujju.viewholder.BaseItemViewHolder;

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

        // 캐시된 뷰가 없을 경우 새로 생성하고 뷰홀더를 생성한다
        if(convertView == null)
        {
            convertView = inflater.inflate(layout, viewGroup, false);

            holder = new BaseItemViewHolder(convertView);


            convertView.setTag(holder);
        }
        // 캐시된 뷰가 있을 경우 저장된 뷰홀더를 사용한다
        else
        {
            holder = (BaseItemViewHolder) convertView.getTag();
        }


        try{holder.title.setText(dataList.get(position).getTitle());}catch (Exception e){}
        try{Glide.with(con).load(dataList.get(position).getImg()).into(holder.img); }catch(Exception e){}
        try{holder.date.setText(dataList.get(position).getDate());}catch (Exception e){}
        try{holder.price.setText(dataList.get(position).getPrice());}catch (Exception e){}
        try{holder.contents.setText(dataList.get(position).getContents());}catch (Exception e){}
        try{holder.userName.setText(dataList.get(position).getUserName());}catch (Exception e){}
        try{holder.grade.setRating(dataList.get(position).getGrade());}catch (Exception e){}


        return convertView;
    }
}