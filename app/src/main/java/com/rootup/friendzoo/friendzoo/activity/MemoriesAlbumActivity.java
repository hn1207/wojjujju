package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseGridAdapter;
import com.rootup.friendzoo.friendzoo.adapter.MemoriesAlbumGridAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;


public class MemoriesAlbumActivity extends BaseDrawerActivity {

    final int CONTENTS = 0;
    final int ADD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories_album);

        initToolbar("추억앨범");
        initGridView();
    }



    void initGridView(){
        ArrayList<Item> dataList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/dog.jpg");
            item.setTitle("다롱이");
            item.setType(CONTENTS);
            dataList.add(item);
        }
        Item item = new Item();
        item.setType(ADD);
        dataList.add(item);




        GridView gridView = findViewById(R.id.data_list);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MemoriesAlbumActivity.this, MemoriesAlbumDetailActivity.class));
            }
        });

        gridView.setAdapter(new MemoriesAlbumGridAdapter(dataList, MemoriesAlbumActivity.this, R.layout.items_memories_album));

    }




}
