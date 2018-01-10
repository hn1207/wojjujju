package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.BeautyDetailPagerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.TabViewAdapter;
import com.rootup.wojjujju.wojjujju.custom.SwipeViewPager;
import com.rootup.wojjujju.wojjujju.entity.Item;
import com.rootup.wojjujju.wojjujju.fragment.BeautyDetailInfoFragment;
import com.rootup.wojjujju.wojjujju.fragment.BeautyQnAFragment;
import com.rootup.wojjujju.wojjujju.fragment.BeautyReviewFragment;
import com.rootup.wojjujju.wojjujju.fragment.MyPageCompletedReviewHistoryFragment;
import com.rootup.wojjujju.wojjujju.fragment.MyPageUnCompletedReviewHistoryFragment;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;

public class MyPageReviewHistoryActivity extends AppCompatActivity{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_review_history);

        initTabView();


    }

    void initTabView(){
        MyPageUnCompletedReviewHistoryFragment myPageUnCompletedReviewHistoryFragment = new MyPageUnCompletedReviewHistoryFragment();
        MyPageCompletedReviewHistoryFragment myPageUnCompletedReviewHistoryFragment1 = new MyPageCompletedReviewHistoryFragment();


        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.view_pager);
        TabViewAdapter adapter = new TabViewAdapter(getSupportFragmentManager());
        adapter.addFragment(myPageUnCompletedReviewHistoryFragment, "작성가능한 후기");
        adapter.addFragment(myPageUnCompletedReviewHistoryFragment1, "내가 쓴 후기");



        viewPager.setPagingEnabled(true);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_primary)));

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_primary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.warm_grey), getResources().getColor(R.color.color_primary));

        tabLayout.setupWithViewPager(viewPager);




    }

}
