package com.rootup.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseHeaderListViewAdapter;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.custom.RecyclerItemClickListener;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class MyPageBookHistoryActivity extends AppCompatActivity{
    final int HEADER = 0;
    final int CONTENTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_book_history);

        initBookHistoryItem();
    }


    void initBookHistoryItem(){

        ArrayList<Item> dataList = new ArrayList<>();

        Item item = new Item();
        item.setTitle("미용");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("[댕댕이 미용]");
            item.setDescription("무슨무슨 컷 (+10,000원 발톱정리) ");
            item.setPrice("12,000원");
            item.setDate("예약일시 12.29 (화) 16:00");
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
            item.setDescription("무슨 무슨 룸인지 옵션내용이 들어갑니다.");
            item.setPrice("12,000원");
            item.setDate("입실 12.29 (화) ~ 퇴실 12.31 (목) ");
            item.setImg(null);
            item.setType(CONTENTS);
            dataList.add(item);
        }




        ListView dataListView = (ListView) findViewById(R.id.data_list);

        dataListView.setAdapter(new BaseHeaderListViewAdapter(dataList, MyPageBookHistoryActivity.this, R.layout.items_book_history));




    }

}
