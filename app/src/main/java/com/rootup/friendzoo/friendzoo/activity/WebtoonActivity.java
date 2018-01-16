package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseUltraPagerAdapter;
import com.rootup.friendzoo.friendzoo.adapter.TabViewAdapter;
import com.rootup.friendzoo.friendzoo.custom.SwipeViewPager;
import com.rootup.friendzoo.friendzoo.fragment.WebtoonFragment;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;


public class WebtoonActivity extends BaseDrawerActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webtoon);


        initToolbar("웹툰");
        initTabView();

        initViewPager();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = WebtoonActivity.this.getMenuInflater();
        inflater.inflate(R.menu.toolbar_webtoon, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                startActivity(new Intent(WebtoonActivity.this, WebtoonSearchActivity.class));

                return true;
            case R.id.action_mypage:
                startActivity(new Intent(WebtoonActivity.this, WebtoonMyPageActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    void initViewPager(){

        ArrayList<String> dataList = new ArrayList<>();
        dataList.add("http://13.125.46.183/woojjujju/viewpager_webtoon.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_webtoon2.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_webtoon3.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_webtoon4.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_webtoon5.jpg");

        UltraViewPager ultraViewPager = (UltraViewPager)findViewById(R.id.ultra_viewpager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
//initialize UltraPagerAdapter，and add child view to UltraViewPager
        PagerAdapter adapter = new BaseUltraPagerAdapter(false, dataList, WebtoonActivity.this);
        ultraViewPager.setAdapter(adapter);


        ultraViewPager.initIndicator();

        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(getResources().getColor(R.color.white))

                .setNormalColor(getResources().getColor(R.color.transparent_white))
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics()));


        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        ultraViewPager.getIndicator().setMargin(0,50,0,0);

        ultraViewPager.getIndicator().build();


        ultraViewPager.setInfiniteLoop(false);

        ultraViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                if(position==3) {
//                    findViewById(R.id.next).startAnimation(AnimationUtils.loadAnimation(ShopDetailActivity.this, android.R.anim.fade_in));
//
//                    findViewById(R.id.next).setVisibility(View.VISIBLE);
//
//                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        ultraViewPager.setAutoScroll(2000);

    }


    void initTabView(){
        WebtoonFragment webtoonFragment = new WebtoonFragment();
        WebtoonFragment webtoonFragment2 = new WebtoonFragment();
        WebtoonFragment webtoonFragment3 = new WebtoonFragment();
        WebtoonFragment webtoonFragment4 = new WebtoonFragment();
        WebtoonFragment webtoonFragment5 = new WebtoonFragment();
        WebtoonFragment webtoonFragment6 = new WebtoonFragment();
        WebtoonFragment webtoonFragment7 = new WebtoonFragment();
        WebtoonFragment webtoonFragment8 = new WebtoonFragment();
        WebtoonFragment webtoonFragment9 = new WebtoonFragment();




        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.tab_viewpager);
        TabViewAdapter adapter = new TabViewAdapter(getSupportFragmentManager());
        adapter.addFragment(webtoonFragment, "월");
        adapter.addFragment(webtoonFragment2, "화");
        adapter.addFragment(webtoonFragment3, "수");
        adapter.addFragment(webtoonFragment4, "목");
        adapter.addFragment(webtoonFragment5, "금");
        adapter.addFragment(webtoonFragment6, "토");
        adapter.addFragment(webtoonFragment7, "일");
        adapter.addFragment(webtoonFragment8, "완결");
        adapter.addFragment(webtoonFragment9, "전체");



        viewPager.setPagingEnabled(true);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_primary)));

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_primary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.warm_grey), getResources().getColor(R.color.color_primary));

        tabLayout.setupWithViewPager(viewPager);





    }

}
