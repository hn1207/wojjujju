package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class MyPageCouponHistoryActivity extends AppCompatActivity{ ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_coupon);

        initCouponItem();
    }


    void initCouponItem(){

        ArrayList<Item> dataList = new ArrayList<>();


        for(int i=0; i<20; i++){
            Item item = new Item();
            item.setTitle("우쭈쭈 첫가입");
            item.setDescription("쇼핑/미용/데이트 사용가능");
            item.setDate("2017.09.24 ~ 12.24");
            item.setLabel("사용가능");

            dataList.add(item);
        }





        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.data_list);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MyPageCouponHistoryActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {
            recyclerView.setAdapter(new BaseRecyclerAdapter(dataList, MyPageCouponHistoryActivity.this, R.layout.items_mypage_coupon));
        }
        recyclerView.setLayoutManager(layoutManager);




    }

}
