package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseHeaderListViewAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

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
            item.setTitle("푹신푹신 쿠션 ");
            item.setPrice("12,000원");
            item.setDescription("특대사이즈 100cm red");
            item.setDate("12,000원");
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
//            item.setDescription("");
            item.setGrade(3.5f);
            item.setDescription("무슨무슨 컷 (+10,000원 발톱정리)\n예약일시 12.29 (화) 16:00");
            item.setCommentCnt(785);
//            item.setAddress("서울시 서초구 서초동");
            item.setDate("12,000원");
//            item.setDate("서울시 서초구 서초동");
            item.setImg("http://13.125.46.183/woojjujju/beauty.jpeg");
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
            item.setDescription("옵션 내용이 들어갑니다.\n서울시 서초구 서초동");
            item.setPrice("12,000원");
            item.setGrade(3.5f);
            item.setCommentCnt(785);
            item.setDate("12,000원");
//            item.setAddress("서울시 서초구 서초동");
            item.setImg("http://13.125.46.183/woojjujju/cushion.jpg");
            item.setType(CONTENTS);
            dataList.add(item);
        }




        ListView dataListView = (ListView) findViewById(R.id.data_list);

        dataListView.setAdapter(new BaseHeaderListViewAdapter(dataList, MyPageCurrentHistoryActivity.this, R.layout.items_mypage_current_history));




    }

}
