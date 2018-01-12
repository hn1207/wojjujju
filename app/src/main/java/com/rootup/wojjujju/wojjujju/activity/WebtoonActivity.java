package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseUltraPagerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.FAQExpandableAdapter;
import com.rootup.wojjujju.wojjujju.adapter.TabViewAdapter;
import com.rootup.wojjujju.wojjujju.custom.SwipeViewPager;
import com.rootup.wojjujju.wojjujju.fragment.SearchAllFragment;
import com.rootup.wojjujju.wojjujju.fragment.SearchBeautyFragment;
import com.rootup.wojjujju.wojjujju.fragment.WebtoonFragment;
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

        UltraViewPager ultraViewPager = (UltraViewPager)findViewById(R.id.ultra_viewpager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
//initialize UltraPagerAdapter，and add child view to UltraViewPager
        PagerAdapter adapter = new BaseUltraPagerAdapter(false);
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
