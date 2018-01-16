package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseGridAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class AdoptActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt);

        initToolbar("입양");
        initGridView();
        initSpinner();

    }




    void initSpinner() {

        Spinner defaultSpinner = (Spinner) findViewById(R.id.adopt_default_filter);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(AdoptActivity.this, R.array.adopt_default_filter, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defaultSpinner.setAdapter(adapter);

        TextView placeSpinner = (TextView)findViewById(R.id.place_filter);
        placeSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdoptActivity.this, BasePlaceFilterActivity.class));
            }
        });

    }

    void initGridView() {
        ArrayList<Item> dataList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/dog.jpg");
            item.setTitle("애교가 많고 귀여운 포리");
            item.setContents("포메라니안");
            item.setAddress("서울시 역삼동");
            item.setUserName("우쭈쭈보호소");
            dataList.add(item);
        }


        GridView gridView = findViewById(R.id.data_list);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(AdoptActivity.this, AdoptDetailActivity.class));
            }
        });

        gridView.setAdapter(new BaseGridAdapter(dataList, AdoptActivity.this, R.layout.items_adopt_item));

    }


}
