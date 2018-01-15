package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.custom.RecyclerItemClickListener;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class WalkDetailServiceGuideActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_detail_service_guide);

        initServiceGuideItem();
    }


    void initServiceGuideItem(){

        ArrayList<Item> dataList = new ArrayList<>();
        for(int i=0; i<20; i++){
            Item item = new Item();
            item.setTitle("디럭스 스위트 룸 1");
            item.setDescription("기준 2명 (최대 2명) 대형견 가능");
            item.setPrice("139,800원");
            item.setSaledPrice("40,000원");
            item.setImg("http://13.125.46.183/woojjujju/sweetroom.png");
            dataList.add(item);
        }


        RecyclerView dataListView = (RecyclerView) findViewById(R.id.data_list);
        dataListView.setHasFixedSize(true);

        dataListView.addOnItemTouchListener(new RecyclerItemClickListener(WalkDetailServiceGuideActivity.this, dataListView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(WalkDetailServiceGuideActivity.this, WalkDetailServiceGuideItemActivity.class));
            }

            @Override
            public void onLongItemClick(View view, int position) {


            }
        }));

        LinearLayoutManager layoutManager = new LinearLayoutManager(WalkDetailServiceGuideActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {
            dataListView.setAdapter(new BaseRecyclerAdapter(dataList, WalkDetailServiceGuideActivity.this, R.layout.items_walk_service_guide));
        }
        dataListView.setLayoutManager(layoutManager);

    }

}
