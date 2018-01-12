package com.rootup.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.TabViewAdapter;
import com.rootup.wojjujju.wojjujju.custom.SwipeViewPager;
import com.rootup.wojjujju.wojjujju.fragment.MyPageCompletedReviewHistoryFragment;
import com.rootup.wojjujju.wojjujju.fragment.MyPageUnCompletedReviewHistoryFragment;
import com.rootup.wojjujju.wojjujju.fragment.WebtoonMyPageCurrentFragment;
import com.rootup.wojjujju.wojjujju.fragment.WebtoonMyPageLikeFragment;

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
