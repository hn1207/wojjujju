package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.adapter.BaseUltraPagerAdapter;
import com.rootup.friendzoo.friendzoo.adapter.TabViewAdapter;
import com.rootup.friendzoo.friendzoo.custom.SwipeViewPager;
import com.rootup.friendzoo.friendzoo.entity.Item;
import com.rootup.friendzoo.friendzoo.fragment.BaseQnAFragment;
import com.rootup.friendzoo.friendzoo.fragment.BaseReviewFragment;
import com.rootup.friendzoo.friendzoo.fragment.WalkDetailInfoFragment;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;

public class WalkDetailActivityByCash extends AppCompatActivity {

    BaseQnAFragment baseQnAFragment;
    BaseReviewFragment baseReviewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_detail_by_cash);

        initViewPager();
        initTabView();
        initSelectedItemList();


    }

    void initTabView() {
        WalkDetailInfoFragment walkDetailInfoFragment = new WalkDetailInfoFragment();
        baseQnAFragment = new BaseQnAFragment();
        baseReviewFragment = new BaseReviewFragment();


        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.tab_viewpager);
        TabViewAdapter adapter = new TabViewAdapter(getSupportFragmentManager());
        adapter.addFragment(walkDetailInfoFragment, "상세정보");
        adapter.addFragment(baseQnAFragment, "Q&A");
        adapter.addFragment(baseReviewFragment, "후기");


        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_primary)));

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_primary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.warm_grey), getResources().getColor(R.color.color_primary));

        tabLayout.setupWithViewPager(viewPager);


    }

    void initViewPager(){

        ArrayList<String> dataList = new ArrayList<>();
        dataList.add("http://13.125.46.183/woojjujju/viewpager_date.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_date2.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_date3.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_date4.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_date5.jpg");

        UltraViewPager ultraViewPager = (UltraViewPager)findViewById(R.id.ultra_viewpager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
//initialize UltraPagerAdapter，and add child view to UltraViewPager
        PagerAdapter adapter = new BaseUltraPagerAdapter(false, dataList, WalkDetailActivityByCash.this);
        ultraViewPager.setAdapter(adapter);


        ultraViewPager.initIndicator();

        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(getResources().getColor(R.color.white))

                .setNormalColor(getResources().getColor(R.color.transparent_white))
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics()));

        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        ultraViewPager.getIndicator().setMargin(0,0,0,20);
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


    void initSelectedItemList() {

        ArrayList<Item> dataList = new ArrayList<Item>();

        for (int i = 0; i < 2; i++) {
            Item item = new Item();
            item.setTitle("[디럭스 스위트 룸 1 상품이름이 길면 밑으로 내려갑니다. 내려갑니다.");
            item.setDate("입실 12.29 (화) ~ 퇴실 12.31 (목)");
            item.setPrice("9,900원");
            dataList.add(item);
        }



        RecyclerView beautySelectedItemListView = (RecyclerView) findViewById(R.id.select_goods_list);
        beautySelectedItemListView.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(WalkDetailActivityByCash.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {
            beautySelectedItemListView.setAdapter(new BaseRecyclerAdapter(dataList, WalkDetailActivityByCash.this, R.layout.items_base_select_goods_item));
        }
        beautySelectedItemListView.setLayoutManager(layoutManager);



        final ImageView selectArrow = findViewById(R.id.select_arrow);
        final LinearLayout linearLayout = findViewById(R.id.selected_list);
        linearLayout.setVisibility(View.GONE);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (linearLayout.getVisibility()){
                    case View.GONE:
                        linearLayout.setVisibility(View.VISIBLE);
                        selectArrow.setVisibility(View.VISIBLE);
                        break;
                    case View.VISIBLE:
                        linearLayout.setVisibility(View.GONE);
                        selectArrow.setVisibility(View.GONE);
                        break;

                }

            }
        });

        findViewById(R.id.contact_us).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (linearLayout.getVisibility()) {
                    case View.GONE:
                        linearLayout.setVisibility(View.VISIBLE);
                        selectArrow.setVisibility(View.VISIBLE);

                        break;
                    case View.VISIBLE:
                        linearLayout.setVisibility(View.GONE);
                        selectArrow.setVisibility(View.GONE);

                        break;

                }

            }
        });

        findViewById(R.id.payment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(WalkDetailActivityByCash.this, WalkPaymentActivity.class));
            }
        });

        findViewById(R.id.date_pick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WalkDetailActivityByCash.this, WalkPickDateActivity.class));

            }
        });



    }
}
