package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseGridAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;


public class MemoriesAlbumDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories_album_detail);


        initGridView();
        initSpinner();

        findViewById(R.id.profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MemoriesAlbumDetailActivity.this, MemoriesAlbumProfileActivity.class));

            }
        });
    }


    void initSpinner(){

        Spinner defaultSpinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(MemoriesAlbumDetailActivity.this, R.array.memories_album, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defaultSpinner.setAdapter(adapter);

    }
    void initGridView(){
        ArrayList<Item> dataList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/dog.jpg");
            dataList.add(item);
        }


        GridView gridView = findViewById(R.id.data_list);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                startActivity(new Intent(MemoriesAlbumDetailActivity.this, DonatePostActivity.class));
            }
        });

        gridView.setAdapter(new BaseGridAdapter(dataList, MemoriesAlbumDetailActivity.this, R.layout.items_memories_album_detail));

    }
}
