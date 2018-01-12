package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.TabViewAdapter;
import com.rootup.wojjujju.wojjujju.custom.SwipeViewPager;
import com.rootup.wojjujju.wojjujju.entity.Item;
import com.rootup.wojjujju.wojjujju.fragment.SellAllFragment;
import com.rootup.wojjujju.wojjujju.fragment.ShopCatFragment;
import com.rootup.wojjujju.wojjujju.fragment.ShopDogFragment;

import java.util.ArrayList;

public class SellActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        initToolbar("분양");

        initTabView();
//        initBeautySelectedItemList();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = SellActivity.this.getMenuInflater();
        inflater.inflate(R.menu.toolbar_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        switch (id) {
            case R.id.action_search:
//                startActivity(new Intent(CommunityActivity.this, CommunityPostSearchActivity.class));
//                Toast.makeText(getApplicationContext(), R.string.search, Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    void initTabView() {
        SellAllFragment sellAllFragment = new SellAllFragment();
        SellAllFragment sellAllFragment2 = new SellAllFragment();
        SellAllFragment sellAllFragment3 = new SellAllFragment();


        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.tab_viewpager);
        TabViewAdapter adapter = new TabViewAdapter(getSupportFragmentManager());
        adapter.addFragment(sellAllFragment, "전체");
        adapter.addFragment(sellAllFragment2, "강이지");
        adapter.addFragment(sellAllFragment3, "고양이");


        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_primary)));

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_primary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.warm_grey), getResources().getColor(R.color.color_primary));

        tabLayout.setupWithViewPager(viewPager);


    }


}
