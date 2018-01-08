package com.ylabs.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylabs.wojjujju.wojjujju.entity.SelectedItem;
import com.ylabs.wojjujju.wojjujju.viewholder.DateTimePickerViewHolder;
import com.ylabs.wojjujju.wojjujju.viewholder.SelectedItemViewHolder;

import java.util.ArrayList;

public class DateTimePickerAdapter extends RecyclerView.Adapter<DateTimePickerViewHolder> {
    private ArrayList<String> dataList;
    private Context con;
    private int layout;

    final int QUESTION = 0;
    final int ANSWER = 1;

    public DateTimePickerAdapter(ArrayList<String> dataList, Context con, int layout) {
        this.dataList = dataList;
        this.con=con;
        this.layout= layout;
    }
    @Override
    public DateTimePickerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        DateTimePickerViewHolder holder = new DateTimePickerViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final DateTimePickerViewHolder holder, int position) {




        holder.dateTime.setText(dataList.get(position));

//        holder.contents.setText(dataList.get(position).getContents());




    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}