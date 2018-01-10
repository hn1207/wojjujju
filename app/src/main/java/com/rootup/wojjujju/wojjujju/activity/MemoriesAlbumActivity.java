package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.GridView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseGridAdapter;
import com.rootup.wojjujju.wojjujju.adapter.FAQExpandableAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;


public class MemoriesAlbumActivity extends BaseDrawerActivity {

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
            item.setImg(null);
            item.setTitle("다롱이");
            item.setLabel("F");
            dataList.add(item);
        }


        GridView gridView = findViewById(R.id.data_list);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MemoriesAlbumActivity.this, MemoriesAlbumDetailActivity.class));
            }
        });

        gridView.setAdapter(new BaseGridAdapter(dataList, MemoriesAlbumActivity.this, R.layout.items_memories_album));

    }
}
