package com.ylabs.wojjujju.wojjujju.activity;

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

import com.tmall.ultraviewpager.UltraViewPager;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.BeautyDetailPagerAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.BeautyTabViewAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.QnaItemAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.SelectedItemAdapter;
import com.ylabs.wojjujju.wojjujju.custom.SwipeViewPager;
import com.ylabs.wojjujju.wojjujju.entity.QnaItem;
import com.ylabs.wojjujju.wojjujju.entity.SelectedItem;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyDetailInfoFragment;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyQnAFragment;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyReviewFragment;

import java.util.ArrayList;

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
        initBeautySelectedItemList();

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


    void initBeautySelectedItemList(){

        ArrayList<SelectedItem> beautySelectedItemArrayList = new ArrayList<SelectedItem>();

        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//
//


        RecyclerView beautySelectedItemListView = (RecyclerView) findViewById(R.id.select_goods_list);
        beautySelectedItemListView.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyDetailActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (beautySelectedItemArrayList.size() > 0) {
            beautySelectedItemListView.setAdapter(new SelectedItemAdapter(beautySelectedItemArrayList, BeautyDetailActivity.this, R.layout.items_select_goods_item));
        }
        beautySelectedItemListView.setLayoutManager(layoutManager);


        final LinearLayout linearLayout = findViewById(R.id.selected_list);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (linearLayout.getVisibility()){
                    case View.GONE:
                        linearLayout.setVisibility(View.VISIBLE);
                        break;
                    case View.VISIBLE:
                        linearLayout.setVisibility(View.GONE);
                        break;

                }

            }
        });

        findViewById(R.id.payment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (linearLayout.getVisibility()){
                    case View.GONE:
                        linearLayout.setVisibility(View.VISIBLE);
                        break;
                    case View.VISIBLE:
                        linearLayout.setVisibility(View.GONE);
                        break;

                }

            }
        });
    }



}
