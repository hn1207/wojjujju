package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.graphics.Paint;
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
import android.widget.TextView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.adapter.BaseUltraPagerAdapter;
import com.rootup.friendzoo.friendzoo.adapter.TabViewAdapter;
import com.rootup.friendzoo.friendzoo.custom.SwipeViewPager;
import com.rootup.friendzoo.friendzoo.entity.Item;
import com.rootup.friendzoo.friendzoo.fragment.BaseQnAFragment;
import com.rootup.friendzoo.friendzoo.fragment.BaseReviewFragment;
import com.rootup.friendzoo.friendzoo.fragment.ShopDetailInfoFragment;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;

public class ShopDetailActivity extends AppCompatActivity{


    ShopDetailInfoFragment shopDetailInfoFragment;
    BaseQnAFragment baseQnAFragment;
    BaseReviewFragment baseReviewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        initViewPager();
        initTabView();
        initSelectedItemList();

        TextView price = findViewById(R.id.price);

        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


    }

    void initTabView(){
        shopDetailInfoFragment = new ShopDetailInfoFragment();
        baseQnAFragment = new BaseQnAFragment();
        baseReviewFragment = new BaseReviewFragment();


        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.tab_viewpager);
        TabViewAdapter adapter = new TabViewAdapter(getSupportFragmentManager());
        adapter.addFragment(shopDetailInfoFragment, "상세정보");
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


    void initSelectedItemList(){

        ArrayList<Item> dataList = new ArrayList<Item>();

        for(int i=0; i<3; i++) {
            Item item = new Item();
            item.setTitle("캣만두 라이프 500g (+2,000원)길면 밑으로 내려갑니다");
            item.setPrice("9,900원");
            dataList.add(item);
        }

//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//
//


        RecyclerView beautySelectedItemListView = (RecyclerView) findViewById(R.id.select_goods_list);
        beautySelectedItemListView.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(ShopDetailActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {
            beautySelectedItemListView.setAdapter(new BaseRecyclerAdapter(dataList, ShopDetailActivity.this, R.layout.items_shop_select_goods_item));
        }
        beautySelectedItemListView.setLayoutManager(layoutManager);


        final LinearLayout linearLayout = findViewById(R.id.selected_list);
        linearLayout.setVisibility(View.GONE);
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

        findViewById(R.id.contact_us).setOnClickListener(new View.OnClickListener() {
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

                startActivity(new Intent(ShopDetailActivity.this, ShopPaymentActivity.class));
            }
        });

        findViewById(R.id.date_pick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopDetailActivity.this, BasePickDateActivity.class));

            }
        });



    }



}
