package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class MyPageProfileActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_profile);

        findViewById(R.id.update_phone_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyPageProfileActivity.this, UpdatePhoneNoActivity.class));
            }
        });

        findViewById(R.id.update_nickname).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyPageProfileActivity.this, UpdateNickNameActivity.class));

            }
        });
        findViewById(R.id.update_summary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyPageProfileActivity.this, UpdateSummaryActivity.class));

            }
        });

        findViewById(R.id.update_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyPageProfileActivity.this, UpdatePasswordActivity.class));

            }
        });
        initMemoriesAlbumItemList();
    }

    void initMemoriesAlbumItemList(){

        ArrayList<Item> dateList = new ArrayList<Item>();

        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/dog.jpg");
            item.setTitle("다롱이");
            item.setLabel("F");
            dateList.add(item);
        }



        RecyclerView beautySelectedItemListView = (RecyclerView) findViewById(R.id.memories_album_list);
        beautySelectedItemListView.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(MyPageProfileActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (dateList.size() > 0) {
            beautySelectedItemListView.setAdapter(new BaseRecyclerAdapter(dateList, MyPageProfileActivity.this, R.layout.items_mypage_memories_album));
        }
        beautySelectedItemListView.setLayoutManager(layoutManager);




    }


}
