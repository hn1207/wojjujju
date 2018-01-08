package com.ylabs.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;

import com.tmall.ultraviewpager.UltraViewPager;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.BeautyDetailPagerAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.BeautyTabViewAdapter;
import com.ylabs.wojjujju.wojjujju.custom.SwipeViewPager;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyDetailInfoFragment;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyQnAFragment;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyReviewFragment;

public class BeautyDetailActivity extends AppCompatActivity{


    BeautyDetailInfoFragment beautyDetailInfoFragment;
    BeautyQnAFragment beautyQnAFragment;
    BeautyReviewFragment beautyReviewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_detail);

        initViewPager();
        initTabView();


    }

    void initTabView(){
        beautyDetailInfoFragment = new BeautyDetailInfoFragment();
        beautyQnAFragment = new BeautyQnAFragment();
        beautyReviewFragment = new BeautyReviewFragment();


        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.beauty_detail_tab_viewpager);
        BeautyTabViewAdapter adapter = new BeautyTabViewAdapter(getSupportFragmentManager());
        adapter.addFragment(beautyDetailInfoFragment, "상세정보");
        adapter.addFragment(beautyQnAFragment, "Q&A");
        adapter.addFragment(beautyReviewFragment, "후기");


        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.beauty_detail_tab_layout);
//        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_primary)));

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_primary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.warm_grey), getResources().getColor(R.color.color_primary));

        tabLayout.setupWithViewPager(viewPager);




    }

    void initViewPager(){

        UltraViewPager ultraViewPager = (UltraViewPager)findViewById(R.id.beauty_viewpager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
//initialize UltraPagerAdapter，and add child view to UltraViewPager
        PagerAdapter adapter = new BeautyDetailPagerAdapter(false);
        ultraViewPager.setAdapter(adapter);


        ultraViewPager.initIndicator();

        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(getResources().getColor(R.color.white))
                .setNormalColor(getResources().getColor(R.color.transparent_white))
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));

        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        ultraViewPager.getIndicator().setMargin(0,0,0,20);

        ultraViewPager.getIndicator().build();


        ultraViewPager.setInfiniteLoop(true);

//        ultraViewPager.setAutoScroll(2000);

    }



}
