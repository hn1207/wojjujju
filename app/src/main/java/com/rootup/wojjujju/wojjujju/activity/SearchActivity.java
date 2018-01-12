package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseGridAdapter;
import com.rootup.wojjujju.wojjujju.adapter.TabViewAdapter;
import com.rootup.wojjujju.wojjujju.custom.SwipeViewPager;
import com.rootup.wojjujju.wojjujju.entity.Item;
import com.rootup.wojjujju.wojjujju.fragment.BaseQnAFragment;
import com.rootup.wojjujju.wojjujju.fragment.BaseReviewFragment;
import com.rootup.wojjujju.wojjujju.fragment.BeautyDetailInfoFragment;
import com.rootup.wojjujju.wojjujju.fragment.SearchAllFragment;
import com.rootup.wojjujju.wojjujju.fragment.SearchBeautyFragment;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        initTabView();




    }


    void initTabView(){
        SearchAllFragment searchAllFragment = new SearchAllFragment();
        SearchBeautyFragment searchFragment = new SearchBeautyFragment();
        SearchBeautyFragment searchFragment2 = new SearchBeautyFragment();
        SearchBeautyFragment searchFragment3 = new SearchBeautyFragment();
        SearchBeautyFragment searchFragment4 = new SearchBeautyFragment();
        SearchBeautyFragment searchFragment5 = new SearchBeautyFragment();
        SearchBeautyFragment searchFragment6 = new SearchBeautyFragment();
        SearchBeautyFragment searchFragment7 = new SearchBeautyFragment();



        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.tab_viewpager);
        TabViewAdapter adapter = new TabViewAdapter(getSupportFragmentManager());
        adapter.addFragment(searchAllFragment, "전체");
        adapter.addFragment(searchFragment, "미용");
        adapter.addFragment(searchFragment2, "쇼핑");
        adapter.addFragment(searchFragment3, "데이트");
        adapter.addFragment(searchFragment4, "교육");
        adapter.addFragment(searchFragment5, "입양");
        adapter.addFragment(searchFragment6, "분양");
        adapter.addFragment(searchFragment7, "병원");



        viewPager.setPagingEnabled(true);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_primary)));

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_primary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.warm_grey), getResources().getColor(R.color.color_primary));

        tabLayout.setupWithViewPager(viewPager);





    }


}
