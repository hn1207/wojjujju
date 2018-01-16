package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseHeaderListViewAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class MyPageLikeHistoryActivity extends AppCompatActivity{
    final int HEADER = 0;
    final int CONTENTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_like_history);

        initLikeHistoryItem();
    }


    void initLikeHistoryItem(){

        ArrayList<Item> dataList = new ArrayList<>();

        Item item = new Item();
        item.setTitle("쇼핑");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("푹신푹신 쿠션 ");
            item.setDescription("특대사이즈 100cm red");
//            item.setPrice("12,000원");
            item.setDate("12,200원");
//            item.setLabel("취소 완료");
            item.setImg("http://13.125.46.183/woojjujju/cushion2.png");
            item.setType(CONTENTS);

            dataList.add(item);
        }

        item = new Item();
        item.setTitle("미용");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("[댕댕이 미용]");
            item.setDescription("무슨무슨 컷 (+10,000원 발톱정리)\n예약일시 12.29 (화) 16:00");
//            item.setPrice("12,000원");
            item.setDate("12,000원");
//          item.setLabel("취소 완료");
            item.setImg("http://13.125.46.183/woojjujju/beauty.jpeg");
            item.setType(CONTENTS);
            dataList.add(item);
        }




        ListView dataListView = (ListView) findViewById(R.id.data_list);

        dataListView.setAdapter(new BaseHeaderListViewAdapter(dataList, MyPageLikeHistoryActivity.this, R.layout.items_mypage_like_history));




    }

}
