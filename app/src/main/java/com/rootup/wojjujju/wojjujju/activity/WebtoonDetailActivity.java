package com.rootup.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;


public class WebtoonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webtoon_detail);


        initReviewList();

        


    }


    void initReviewList() {

        ArrayList<Item> dataList = new ArrayList<Item>();

        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/user.png");
            item.setContents("댓글 내용이 들어갑니다. 댓글 내용이 들어갑니다.댓글 내용이 들어갑니다.");
            item.setUserName("장지후");
            item.setDate("2017.10.03");
            dataList.add(item);
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.donate_post_review_list);
        recyclerView.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(WebtoonDetailActivity.this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        if (dataList.size() > 0) {
            recyclerView.setAdapter(new BaseRecyclerAdapter(dataList, WebtoonDetailActivity.this, R.layout.items_donate_post_review));
        }
        recyclerView.setLayoutManager(layoutManager);

    }

}
