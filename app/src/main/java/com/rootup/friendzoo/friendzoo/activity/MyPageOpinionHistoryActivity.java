package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.MyPageOpinionItemAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class MyPageOpinionHistoryActivity extends AppCompatActivity{
    final int POST = 0;
    final int QUESTION = 1;
    final int ANSWER = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_opinion_history);

        initPurchaseHistoryItem();
    }


    void initPurchaseHistoryItem(){

        ArrayList<Item> dataList = new ArrayList<>();
        for(int i=0; i<9; i++){
            Item item = new Item();
            switch (i%3){
                case POST:
                    item.setTitle("푹신푹신 허그미  쿠션 제목이 길면 밑으로 내려갑니다. ");
                    item.setImg("http://13.125.46.183/woojjujju/cushion.jpg");
                    break;
                case QUESTION:
                    item.setTitle("Q 질문이 들어갑니다");
                    item.setContents("질문내용이 들어갑니다. 질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.");
                    break;
                case ANSWER:
                    item.setTitle("A 답변이 들어갑니다");
                    item.setContents("답변내용이 들어갑니다. 답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.");
                    break;
            }

            item.setDate("2017.09.23");
            item.setType(i%3);

            dataList.add(item);
        }


        ListView dataListView = (ListView) findViewById(R.id.data_list);


        if (dataList.size() > 0) {
            dataListView.setAdapter(new MyPageOpinionItemAdapter(dataList, MyPageOpinionHistoryActivity.this, R.layout.items_mypage_opinion_history));
        }


    }

}
