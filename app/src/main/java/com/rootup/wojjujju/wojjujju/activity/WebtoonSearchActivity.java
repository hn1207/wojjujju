package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.custom.RecyclerItemClickListener;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;


public class WebtoonSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webtoon_search);

        initSpinner();
        initItemList();


    }

    void initSpinner(){
        // Spinner
        Spinner defaultSpinner = (Spinner)findViewById(R.id.default_filter);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.default_filter, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defaultSpinner.setAdapter(adapter);

        Spinner categorySpinner = (Spinner)findViewById(R.id.category_filter);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.webtoon_default_filter, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);




    }


    void initItemList() {

        ArrayList<Item> dataList = new ArrayList<Item>();

        for (int i = 0; i < 15; i++) {
            Item item = new Item();
            if(i%2==0){
                item.setImg("http://13.125.46.183/woojjujju/webtoon_second.png");
            }
            else{item.setImg("http://13.125.46.183/woojjujju/webtoon_first.png");}
            item.setTitle("내 어린 고양이와 늙은 개");
            item.setDescription(i + " 화");
            item.setLabel("new");
            dataList.add(item);
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.data_list);
        recyclerView.setHasFixedSize(true);

//
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(WebtoonSearchActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever
                        startActivity(new Intent(WebtoonSearchActivity.this, CommunityPostDetailActivity.class));

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                }));


        LinearLayoutManager layoutManager = new LinearLayoutManager(WebtoonSearchActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        if (dataList.size() > 0) {
            recyclerView.setAdapter(new BaseRecyclerAdapter(dataList, WebtoonSearchActivity.this, R.layout.items_webtoon_mypage));
        }
        recyclerView.setLayoutManager(layoutManager);

    }
}
