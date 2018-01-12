package com.rootup.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.TabViewAdapter;
import com.rootup.wojjujju.wojjujju.custom.SwipeViewPager;
import com.rootup.wojjujju.wojjujju.fragment.WalkAllFragment;

public class WalkActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);

        initToolbar("데이트");

        initTabView();
//        initItemList();
//        initBeautySelectedItemList();


    }


    void initTabView() {
        WalkAllFragment walkAllFragment = new WalkAllFragment();
        WalkAllFragment walkAllFragment2 = new WalkAllFragment();
        WalkAllFragment walkAllFragment3 = new WalkAllFragment();


        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.tab_viewpager);
        TabViewAdapter adapter = new TabViewAdapter(getSupportFragmentManager());
        adapter.addFragment(walkAllFragment, "전체");
        adapter.addFragment(walkAllFragment2, "강아지");
        adapter.addFragment(walkAllFragment3, "고양이");


        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_primary)));

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_primary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.warm_grey), getResources().getColor(R.color.color_primary));

        tabLayout.setupWithViewPager(viewPager);


    }


}
