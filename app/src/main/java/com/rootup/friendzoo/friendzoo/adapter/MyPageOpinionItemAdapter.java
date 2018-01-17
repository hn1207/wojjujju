package com.rootup.friendzoo.friendzoo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class MyPageOpinionItemAdapter extends BaseAdapter {
    final int POST = 0;
    final int QUESTION = 1;
    final int ANSWER = 2;


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

    public MyPageOpinionItemAdapter(ArrayList<Item> dataList, Context con, int layout){
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
            case POST:
                convertView = inflater.inflate(R.layout.items_mypage_opinion_post_history, viewGroup, false);
                try{title = (TextView) convertView.findViewById(R.id.title);} catch(Exception ignored){ }
                try{img = (ImageView) convertView.findViewById(R.id.img);}catch(Exception ignored){}

                Spinner defaultSpinner = (Spinner)convertView.findViewById(R.id.spinner);
                ArrayAdapter adapter = ArrayAdapter.createFromResource(con, R.array.my_page_opinion_filter, R.layout.spinner);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                defaultSpinner.setAdapter(adapter);

                title.setText(dataList.get(position).getTitle());

                try{Glide.with(con).load(dataList.get(position).getImg()).into(img);}catch (Exception ignored){}



                break;
            case QUESTION:
                convertView = inflater.inflate(layout, viewGroup, false);
                try{title = (TextView) convertView.findViewById(R.id.title);} catch(Exception ignored){ }
                try{date = (TextView) convertView.findViewById(R.id.date);}catch (Exception ignored){}
                try{contents = (TextView) convertView.findViewById(R.id.contents);}catch (Exception ignored){}
                try{qnaBackground = (LinearLayout) convertView.findViewById(R.id.qna_bg);}catch (Exception ignored){}

                qnaBackground.setBackgroundColor(con.getResources().getColor(R.color.white));
                title.setText(dataList.get(position).getTitle());
                contents.setText(dataList.get(position).getContents());
                date.setText(dataList.get(position).getDate());


                break;
            case ANSWER:
                convertView = inflater.inflate(layout, viewGroup, false);
                try{title = (TextView) convertView.findViewById(R.id.title);} catch(Exception ignored){ }
                try{date = (TextView) convertView.findViewById(R.id.date);}catch (Exception ignored){}
                try{contents = (TextView) convertView.findViewById(R.id.contents);}catch (Exception ignored){}
                try{qnaBackground = (LinearLayout) convertView.findViewById(R.id.qna_bg);}catch (Exception ignored){}


                qnaBackground.setBackgroundColor(con.getResources().getColor(R.color.strong_white));
                qnaBackground.setPadding(100,16,16,16);
                title.setText(dataList.get(position).getTitle());
                contents.setText(dataList.get(position).getContents());
                date.setText(dataList.get(position).getDate());


                break;



        }








        return convertView;
    }
}