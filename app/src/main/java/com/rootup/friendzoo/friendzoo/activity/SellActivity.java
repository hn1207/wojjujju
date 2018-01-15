package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.TabViewAdapter;
import com.rootup.friendzoo.friendzoo.custom.SwipeViewPager;
import com.rootup.friendzoo.friendzoo.fragment.SellAllFragment;

public class SellActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        initToolbar("분양");

        initTabView();
//        initBeautySelectedItemList();


    }



    void initTabView() {
        SellAllFragment sellAllFragment = new SellAllFragment();
        SellAllFragment sellAllFragment2 = new SellAllFragment();
        SellAllFragment sellAllFragment3 = new SellAllFragment();


        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.tab_viewpager);
        TabViewAdapter adapter = new TabViewAdapter(getSupportFragmentManager());
        adapter.addFragment(sellAllFragment, "전체");
        adapter.addFragment(sellAllFragment2, "강아지");
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
