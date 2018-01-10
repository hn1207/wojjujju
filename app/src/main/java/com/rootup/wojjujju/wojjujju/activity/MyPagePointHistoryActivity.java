package com.rootup.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class MyPagePointHistoryActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_point_history);

        initLikeHistoryItem();
    }


    void initLikeHistoryItem(){

        ArrayList<Item> dataList = new ArrayList<>();



        for(int i=0; i<20; i++){
            Item item = new Item();
            item.setTitle("맛있고 건강한 강아지사료 1 kg ");
            item.setPrice("200원 적립");
            item.setDate("적립일 : 2017.09.24");

            dataList.add(item);
        }



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.data_list);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(),
                LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(getApplicationContext().getResources().getDrawable(R.drawable.divider));

        recyclerView.addItemDecoration(dividerItemDecoration);



        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MyPagePointHistoryActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {
            recyclerView.setAdapter(new BaseRecyclerAdapter(dataList, MyPagePointHistoryActivity.this, R.layout.items_mypage_point_item));
        }
        recyclerView.setLayoutManager(layoutManager);


    }

}
