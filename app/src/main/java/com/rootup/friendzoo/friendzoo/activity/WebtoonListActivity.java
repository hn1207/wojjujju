package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.custom.RecyclerItemClickListener;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class WebtoonListActivity extends AppCompatActivity{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webtoon_list);

        initItemList();


    }


    void initItemList() {

        ArrayList<Item> dataList = new ArrayList<Item>();

        for (int i = 0; i < 50; i++) {
            Item item = new Item();
            item.setTitle("제목이 들어갑니다. 제목이 길면 밑으로 내려갑니다. ");
            item.setLike(16);
            item.setCommentCnt(3);
            item.setDate("2017.10.03");
            item.setImg("http://13.125.46.183/woojjujju/webtoon_second.png");
            dataList.add(item);
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.data_list);
        recyclerView.setHasFixedSize(true);

//
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(WebtoonListActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever
                        startActivity(new Intent(WebtoonListActivity.this, WebtoonDetailActivity.class));

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                }));


        LinearLayoutManager layoutManager = new LinearLayoutManager(WebtoonListActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        if (dataList.size() > 0) {
            recyclerView.setAdapter(new BaseRecyclerAdapter(dataList, WebtoonListActivity.this, R.layout.items_webtoon_list));
        }
        recyclerView.setLayoutManager(layoutManager);

    }


}
