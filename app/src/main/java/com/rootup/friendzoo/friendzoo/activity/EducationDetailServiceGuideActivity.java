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

public class EducationDetailServiceGuideActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_detail_service_guide);

        initServiceGuideItem();
    }


    void initServiceGuideItem(){

        ArrayList<Item> dataList = new ArrayList<>();
        for(int i=0; i<20; i++){
            Item item = new Item();
            item.setTitle("행동교정치료 365");
            item.setPrice("50,000원 / 2h");
            item.setImg("http://13.125.46.183/woojjujju/dog.jpg");
            dataList.add(item);
        }


        RecyclerView dataListView = (RecyclerView) findViewById(R.id.data_list);
        dataListView.setHasFixedSize(true);

        dataListView.addOnItemTouchListener(new RecyclerItemClickListener(EducationDetailServiceGuideActivity.this, dataListView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(EducationDetailServiceGuideActivity.this, EducationDetailServiceGuideItemActivity.class));
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        LinearLayoutManager layoutManager = new LinearLayoutManager(EducationDetailServiceGuideActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {
            dataListView.setAdapter(new BaseRecyclerAdapter(dataList, EducationDetailServiceGuideActivity.this, R.layout.items_base_service_guide));
        }
        dataListView.setLayoutManager(layoutManager);

    }

}
