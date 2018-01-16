package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.TabViewAdapter;
import com.rootup.friendzoo.friendzoo.custom.SwipeViewPager;
import com.rootup.friendzoo.friendzoo.fragment.WalkAllFragment;

public class WalkActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);

        initToolbar("데이트");

        initTabView();
//        initItemList();
//        initBeautySelectedItemList();
//        RecyclerView recyclerView = findViewById(R.id.data_list);
//        recyclerView.setFocusable(false);

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
