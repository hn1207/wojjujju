package com.rootup.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseHeaderListViewAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class MyPageCurrentHistoryActivity extends AppCompatActivity{
    final int HEADER = 0;
    final int CONTENTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_current_history);

        initCurrentHistoryItem();
    }


    void initCurrentHistoryItem(){

        ArrayList<Item> dataList = new ArrayList<>();

        Item item = new Item();
        item.setTitle("쇼핑");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("푹신푹신 허그미 쿠션 ");
            item.setPrice("12,000원");
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
            item.setDescription("");
            item.setGrade(3.5f);
            item.setCommentCnt(785);
            item.setAddress("서울시 서초구 서초동");
            item.setImg(null);
            item.setType(CONTENTS);
            dataList.add(item);
        }

        item = new Item();
        item.setTitle("데이트");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("상품의 제목이 들어갑니다. 길면밑으로\n내려갑니다.");
            item.setDescription("");
//            item.setPrice("12,000원");
            item.setGrade(3.5f);
            item.setCommentCnt(785);
            item.setDate("2017.12.29. 16:00 취소 ");
            item.setAddress("서울시 서초구 서초동");
            item.setImg(null);
            item.setType(CONTENTS);
            dataList.add(item);
        }




        ListView dataListView = (ListView) findViewById(R.id.data_list);

        dataListView.setAdapter(new BaseHeaderListViewAdapter(dataList, MyPageCurrentHistoryActivity.this, R.layout.items_mypage_current_history));




    }

}
