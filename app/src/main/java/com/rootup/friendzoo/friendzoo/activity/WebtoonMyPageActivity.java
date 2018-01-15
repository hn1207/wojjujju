package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.TabViewAdapter;
import com.rootup.friendzoo.friendzoo.custom.SwipeViewPager;
import com.rootup.friendzoo.friendzoo.fragment.MyPageCompletedReviewHistoryFragment;
import com.rootup.friendzoo.friendzoo.fragment.MyPageUnCompletedReviewHistoryFragment;
import com.rootup.friendzoo.friendzoo.fragment.WebtoonMyPageCurrentFragment;
import com.rootup.friendzoo.friendzoo.fragment.WebtoonMyPageLikeFragment;

public class WebtoonMyPageActivity extends AppCompatActivity{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webtoon_mypage);

        initTabView();


    }

    void initTabView(){
        WebtoonMyPageLikeFragment webtoonMyPageLikeFragment = new WebtoonMyPageLikeFragment();
        WebtoonMyPageCurrentFragment webtoonMyPageCurrentFragment = new WebtoonMyPageCurrentFragment();


        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.view_pager);
        TabViewAdapter adapter = new TabViewAdapter(getSupportFragmentManager());
        adapter.addFragment(webtoonMyPageLikeFragment, "좋아요한 웹툰");
        adapter.addFragment(webtoonMyPageCurrentFragment, "최근 본 웹툰");



        viewPager.setPagingEnabled(true);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_primary)));

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_primary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.warm_grey), getResources().getColor(R.color.color_primary));

        tabLayout.setupWithViewPager(viewPager);




    }

}
