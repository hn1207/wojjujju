package com.rootup.wojjujju.wojjujju.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class SearchHeaderListViewAdapter extends BaseAdapter {
    final int HEADER = 0;
    final int CONTENTS = 1;


    ArrayList<Item> dataList;
    int layout;
    Context con;
    LayoutInflater inflater;

    public TextView title;
    public TextView price;
    public ImageView img;
    public TextView address;
    public RatingBar grade;
    public TextView commentCnt;
    public TextView description;
    public TextView label;
    public ImageView like;
    public TextView saledPrice;
    public TextView percent;
    public TextView date;
    public TextView contents;
    public LinearLayout qnaBackground;
    public TextView userName;

    public SearchHeaderListViewAdapter(ArrayList<Item> dataList, Context con, int layout){
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



        Item item = dataList.get(position);



        switch (item.getType()){

            case HEADER:
                    convertView = inflater.inflate(R.layout.items_header, viewGroup, false);

                    title = convertView.findViewById(R.id.title);


                    try{title.setText(item.getTitle());}catch (Exception e){}

                break;

            case CONTENTS:
                convertView = inflater.inflate(layout, viewGroup, false);


                try{title = (TextView) convertView.findViewById(R.id.title);} catch(Exception ignored){ }
                try{img = (ImageView) convertView.findViewById(R.id.img);}catch(Exception ignored){}
                try{price = (TextView) convertView.findViewById(R.id.price);}catch (Exception ignored){}
                try{address = (TextView) convertView.findViewById(R.id.address);}catch (Exception ignored){}
                try{grade = (RatingBar) convertView.findViewById(R.id.grade);}catch (Exception ignored){}
                try{commentCnt = (TextView) convertView.findViewById(R.id.comment_cnt);}catch (Exception ignored){}
                try{description = (TextView) convertView.findViewById(R.id.description);}catch (Exception ignored){}
                try{label = (TextView) convertView.findViewById(R.id.label);}catch (Exception ignored){}
                try{like = (ImageView) convertView.findViewById(R.id.like);}catch (Exception ignored){}
                try{saledPrice = (TextView) convertView.findViewById(R.id.saledPrice);}catch (Exception ignored){}
                try{percent = (TextView) convertView.findViewById(R.id.percent);}catch (Exception ignored){}
                try{date = (TextView) convertView.findViewById(R.id.date);}catch (Exception ignored){}
                try{contents = (TextView) convertView.findViewById(R.id.contents);}catch (Exception ignored){}
                try{qnaBackground = (LinearLayout) convertView.findViewById(R.id.qna_bg);}catch (Exception ignored){}
                try{userName = (TextView) convertView.findViewById(R.id.user_name);}catch (Exception ignored){}


                try{if(item.getTitle()==null){title.setVisibility(View.GONE);}else{ title.setText(item.getTitle()); }}catch (Exception e){}
                try{if(item.getDate()==null){date.setVisibility(View.GONE);}else{ date.setText(item.getDate()); }}catch (Exception e){}
                try{if(item.getPrice()==null){price.setVisibility(View.GONE);}else{ price.setText(item.getPrice()); price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);}}catch (Exception e){}
                try{if(item.getContents()==null){contents.setVisibility(View.GONE);}else{ contents.setText(item.getContents()); }}catch (Exception e){}
                try{if(item.getUserName()==null){userName.setVisibility(View.GONE);}else{ userName.setText(item.getUserName()); }}catch (Exception e){}
                try{if(item.getGrade()==-1){grade.setVisibility(View.GONE);}else{ grade.setRating(item.getGrade()); }}catch (Exception e){}
                try{if(item.getPercent()==null){percent.setVisibility(View.GONE);}else{ percent.setText(item.getPercent()); }}catch (Exception e){}
                try{if(item.getDescription()==null){description.setVisibility(View.GONE);}else{ description.setText(item.getDescription()); }}catch (Exception e){}
                try{if(item.getLabel()==null){label.setVisibility(View.GONE);}else{ label.setText(item.getLabel()); }}catch (Exception e){}
                try{if(item.getSaledPrice()==null){saledPrice.setVisibility(View.GONE);}else{ saledPrice.setText(item.getSaledPrice()); }}catch (Exception e){}


                try{Glide.with(con).load(dataList.get(position).getImg()).into(img); }catch(Exception e){}


                try {
                    if (dataList.get(position).getLike() == 1) {
                        like.setImageResource(R.drawable.heart_on);
                    } else {
                        like.setImageResource(R.drawable.heart_off);
                    }
                }catch (Exception e){};
                try{Glide.with(con).applyDefaultRequestOptions(RequestOptions.centerCropTransform()).load(dataList.get(position).getImg()).into(img);}catch (Exception e){};



                break;
        }








        return convertView;
    }
}