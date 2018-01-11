package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.BeautyDefaultItemAdapter;
import com.rootup.wojjujju.wojjujju.adapter.ShopDefaultItemAdapter;
import com.rootup.wojjujju.wojjujju.adapter.TabViewAdapter;
import com.rootup.wojjujju.wojjujju.custom.RecyclerItemClickListener;
import com.rootup.wojjujju.wojjujju.custom.SwipeViewPager;
import com.rootup.wojjujju.wojjujju.entity.Item;
import com.rootup.wojjujju.wojjujju.fragment.ShopCatFragment;
import com.rootup.wojjujju.wojjujju.fragment.ShopDogFragment;

import java.util.ArrayList;

public class ShoppingSelectCategoryActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_select_category);



//        initTabView();
//        initBeautySelectedItemList();

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
                R.array.category_filter, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

    }

    void initItemList(){

        ArrayList<Item> dataList = new ArrayList<Item>();

        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/beauty.jpeg");
            item.setTitle("댕댕이 미용");
            item.setPrice("14,000원");
            item.setLabel("15%할인");
            item.setLike(i % 2);
            dataList.add(item);
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.data_list);
        recyclerView.setHasFixedSize(true);


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(ShoppingSelectCategoryActivity.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        startActivity(new Intent(ShoppingSelectCategoryActivity.this, ShopDetailActivity.class));
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                }));

        LinearLayoutManager layoutManager = new LinearLayoutManager(ShoppingSelectCategoryActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {
            recyclerView.setAdapter(new ShopDefaultItemAdapter(dataList, ShoppingSelectCategoryActivity.this));
        }
        recyclerView.setLayoutManager(layoutManager);

    }


}
