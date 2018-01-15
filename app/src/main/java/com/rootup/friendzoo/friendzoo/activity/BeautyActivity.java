package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseLikeDefaultItemAdapter;

import com.rootup.friendzoo.friendzoo.custom.RecyclerItemClickListener;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class BeautyActivity extends BaseDrawerActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty);


        initToolbar("미용");

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
                startActivity(new Intent(BeautyActivity.this, BasePlaceFilterActivity.class));
            }
        });


    }

    void initBeautyDefaultItemList(){

        ArrayList<Item> dataList = new ArrayList<Item>();

        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/beauty.jpeg");
            item.setTitle("댕댕이 미용");
            item.setPrice("0");
            item.setAddress("서울시 서초구 서초동");
            item.setGrade(4);
            item.setCommentCnt(785);
            item.setDescription("예약취소 연기 가능");
            item.setLabel("예약 특가");
            item.setLike(i % 2);
            dataList.add(item);
        }

//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 0));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
//        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));





        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.data_list);
        recyclerView.setHasFixedSize(true);


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(BeautyActivity.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        startActivity(new Intent(BeautyActivity.this, BeautyDetailActivity.class));
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                }));

        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {
            recyclerView.setAdapter(new BaseLikeDefaultItemAdapter(dataList, BeautyActivity.this, R.layout.items_base_default));
        }
        recyclerView.setLayoutManager(layoutManager);

    }


}
