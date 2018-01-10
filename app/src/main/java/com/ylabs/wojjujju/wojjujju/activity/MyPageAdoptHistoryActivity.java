package com.ylabs.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.BaseHeaderListViewAdapter;
import com.ylabs.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class MyPageAdoptHistoryActivity extends AppCompatActivity{
    final int HEADER = 0;
    final int CONTENTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_adopt_history);

        initAdoptHistoryItem();
    }


    void initAdoptHistoryItem(){

        ArrayList<Item> dataList = new ArrayList<>();

        Item item = new Item();
        item.setTitle("입양");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("귀여운 시바견 하쿠");
            item.setDescription("시바견 / 1세 / 남 / 4.7kg");
            item.setDate("면담일시 12.29 (화) 15:00~18:00 ");
            item.setImg(null);
            item.setType(CONTENTS);

            dataList.add(item);
        }

        item = new Item();
        item.setTitle("분양");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("귀여운 시바견 하쿠");
            item.setDescription("무슨 무슨 룸인지 옵션내용이 들어갑니다.");
            item.setPrice("320,000원 ");
            item.setDate("수령 일시 12.29 (화) 15:00~18:00 ");
            item.setImg(null);
            item.setType(CONTENTS);
            dataList.add(item);
        }




        ListView dataListView = (ListView) findViewById(R.id.data_list);

        dataListView.setAdapter(new BaseHeaderListViewAdapter(dataList, MyPageAdoptHistoryActivity.this, R.layout.items_adopt_history));




    }

}
