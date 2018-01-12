package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseLikeDefaultItemAdapter;
import com.rootup.wojjujju.wojjujju.custom.RecyclerItemClickListener;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class EducationActivity extends BaseDrawerActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);


        initToolbar("교육");

        initSpinner();
        initBeautyDefaultItemList();



    }

    void initSpinner(){
        // Spinner
        Spinner defaultSpinner = (Spinner)findViewById(R.id.default_filter);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.default_filter, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defaultSpinner.setAdapter(adapter);

        TextView placeSpinner = (TextView)findViewById(R.id.place_filter);
        placeSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EducationActivity.this, BasePlaceFilterActivity.class));
            }
        });


    }

    void initBeautyDefaultItemList(){

        ArrayList<Item> dataList = new ArrayList<Item>();

        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/education.png");
            item.setTitle("[보듬]김지용 강사");
//            item.setPrice("0");
//            item.setAddress("서울시 서초구 서초동");
            item.setGrade(4);
            item.setCommentCnt(785);
            item.setDescription("오프라인 워크숍 수강권 증정 ");
            item.setLabel("예약 특가");
            item.setLike(i % 2);
            dataList.add(item);
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.data_list);
        recyclerView.setHasFixedSize(true);


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(EducationActivity.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        startActivity(new Intent(EducationActivity.this, EducationDetailActivity.class));
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                }));

        LinearLayoutManager layoutManager = new LinearLayoutManager(EducationActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {
            recyclerView.setAdapter(new BaseLikeDefaultItemAdapter(dataList, EducationActivity.this, R.layout.items_base_default));
        }
        recyclerView.setLayoutManager(layoutManager);

    }


}
