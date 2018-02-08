package com.rootup.friendzoo.friendzoo.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rootup.common.networs.model.UserInfo;
import com.rootup.common.recycleviews.RecyclerArrayAdapter;
import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.viewholder.JoinViewHolder;
import com.sw926.imagefileselector.ImageFileSelector;

import java.util.ArrayList;

/**
 * Created by Tommy on 2018. 1. 24..
 */
public class JoinAdapter extends RecyclerArrayAdapter<UserInfo,JoinViewHolder> {

    private ArrayList<UserInfo> dataList;
    private Context context;
    private Activity activity;
    private JoinViewHolder holder;
    private AlertDialog.Builder builder;
    private ImageFileSelector mImageFileSelector;
    private ArrayList<String> Gender;


    public  JoinAdapter(ArrayList<UserInfo> item, Context con, Activity activity){
        this.dataList = item;
        this.context = con;
        this.activity = activity;
        Gender = new ArrayList<String>();

    }



    @Override
    public JoinViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_sigin_in_addinfo, viewGroup, false);
        holder = new JoinViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final JoinViewHolder holder, final int position) {

        Gender.add(position,"F");

        holder.rlMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tvMan.setBackgroundResource(R.drawable.round_red_solid_red);
                holder.tvMan.setTextColor(ContextCompat.getColor(context, R.color.white));
                holder.tvWoman.setBackgroundResource(R.drawable.round_red);
                holder.tvWoman.setTextColor(ContextCompat.getColor(context, R.color.color_primary));
                Gender.add(position,holder.tvMan.getText().toString());
            }
        });

        holder.rlWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tvWoman.setBackgroundResource(R.drawable.round_red_solid_red);
                holder.tvWoman.setTextColor(ContextCompat.getColor(context, R.color.white));
                holder.tvMan.setBackgroundResource(R.drawable.round_red);
                holder.tvMan.setTextColor(ContextCompat.getColor(context, R.color.color_primary));
                Gender.add(position, holder.tvWoman.getText().toString());

            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public ArrayList getGender(){
        return Gender;
    }


}
