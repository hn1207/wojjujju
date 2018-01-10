package com.ylabs.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.ylabs.wojjujju.wojjujju.custom.RecyclerItemClickListener;
import com.ylabs.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class MyPagePurchaseHistoryActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_purchase_history);

        initPurchaseHistoryItem();
    }


    void initPurchaseHistoryItem(){

        ArrayList<Item> dataList = new ArrayList<>();
        for(int i=0; i<20; i++){
            Item item = new Item();
            item.setTitle("푹신푹신 허그미 쿠션");
            item.setDescription("특대사이즈 100cm red");
            item.setPrice("12,200원 (2개)");
            item.setDate("06/23\n도착예정");
            item.setLabel("배송 조회");
            item.setImg(null);

            dataList.add(item);
        }


        RecyclerView dataListView = (RecyclerView) findViewById(R.id.data_list);
        dataListView.setHasFixedSize(true);

        dataListView.addOnItemTouchListener(new RecyclerItemClickListener(MyPagePurchaseHistoryActivity.this, dataListView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                startActivity(new Intent(MyPagePurchaseHistoryActivity.this, BeautyDetailServiceGuideItemActivity.class));
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        LinearLayoutManager layoutManager = new LinearLayoutManager(MyPagePurchaseHistoryActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {
            dataListView.setAdapter(new BaseRecyclerAdapter(dataList, MyPagePurchaseHistoryActivity.this, R.layout.items_purchase_history));
        }
        dataListView.setLayoutManager(layoutManager);

    }

}
