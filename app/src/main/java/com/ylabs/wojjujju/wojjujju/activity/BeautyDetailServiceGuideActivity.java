package com.ylabs.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.tmall.ultraviewpager.UltraViewPager;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.BaseItemAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.BeautyDetailPagerAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.BeautyTabViewAdapter;
import com.ylabs.wojjujju.wojjujju.custom.RecyclerItemClickListener;
import com.ylabs.wojjujju.wojjujju.custom.SwipeViewPager;
import com.ylabs.wojjujju.wojjujju.entity.Item;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyDetailInfoFragment;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyQnAFragment;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyReviewFragment;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class BeautyDetailServiceGuideActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_detail_service_guide);

        initServiceGuideItem();
    }


    void initServiceGuideItem(){

        ArrayList<Item> dataList = new ArrayList<>();
        for(int i=0; i<20; i++){
            Item item = new Item();
            item.setTitle("무슨무슨 컷");
            item.setPrice("50,000원");
            item.setImg(null);
            dataList.add(item);
        }


        RecyclerView dataListView = (RecyclerView) findViewById(R.id.beauty_service_guide_list);
        dataListView.setHasFixedSize(true);

        dataListView.addOnItemTouchListener(new RecyclerItemClickListener(BeautyDetailServiceGuideActivity.this, dataListView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(BeautyDetailServiceGuideActivity.this, BeautyDetailServiceGuideItemActivity.class));
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyDetailServiceGuideActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {
            dataListView.setAdapter(new BaseItemAdapter(dataList, BeautyDetailServiceGuideActivity.this, R.layout.items_beauty_service_guide_item));
        }
        dataListView.setLayoutManager(layoutManager);

    }

}
