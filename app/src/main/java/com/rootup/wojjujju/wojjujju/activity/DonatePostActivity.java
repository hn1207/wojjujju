package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.tmall.ultraviewpager.UltraViewPager;
import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.BaseUltraPagerAdapter;
import com.rootup.wojjujju.wojjujju.custom.HorizontalProgressView;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class DonatePostActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_post);


        initViewPager();
        initDonatePostReviewList();
        initProgressBar();


        findViewById(R.id.donate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonatePostActivity.this, DonatePaymentActivity.class));
            }
        });

    }

    void initDonatePostReviewList() {

        ArrayList<Item> dataList = new ArrayList<Item>();

        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/user.png");
            item.setContents("댓글 내용이 들어갑니다. 댓글 내용이 들어갑니다.댓글 내용이 들어갑니다.");
            item.setUserName("장지후");
            item.setDate("2017.10.03");
            dataList.add(item);
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.donate_post_review_list);
        recyclerView.setHasFixedSize(true);

//
//        recyclerView.addOnItemTouchListener(
//                new RecyclerItemClickListener(DonatePostActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int position) {
//                        // do whatever
////                        startActivity(new Intent(DonatePostActivity.this, BeautyDetailActivity.class));
//                    }
//
//                    @Override
//                    public void onLongItemClick(View view, int position) {
//                        // do whatever
//                    }
//                }));


        LinearLayoutManager layoutManager = new LinearLayoutManager(DonatePostActivity.this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        if (dataList.size() > 0) {
            recyclerView.setAdapter(new BaseRecyclerAdapter(dataList, DonatePostActivity.this, R.layout.items_donate_post_review));
        }
        recyclerView.setLayoutManager(layoutManager);

    }

    void initProgressBar() {
        HorizontalProgressView progress = (HorizontalProgressView) findViewById(R.id.progress);
        progress.setProgressColor(getResources().getColor(R.color.color_primary));
        progress.setProgressBackgroundColor(getResources().getColor(R.color.warm_grey));
        progress.setMax(100);
        progress.setProgress(60);
        progress.animateView(0, 60);


    }


    void initViewPager() {

        UltraViewPager ultraViewPager = (UltraViewPager) findViewById(R.id.ultra_viewpager);
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
        ultraViewPager.getIndicator().setMargin(0, 0, 0, 20);

        ultraViewPager.getIndicator().build();


        ultraViewPager.setInfiniteLoop(true);

//        ultraViewPager.setAutoScroll(2000);

    }


    void initBeautySelectedItemList() {

        ArrayList<Item> beautySelectedItemArrayList = new ArrayList<Item>();

        for (int i = 0; i < 3; i++) {
            Item item = new Item();
            item.setImg("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ");
            item.setTitle("예약일시 12.29 (화) 16:00");
            item.setPrice("9,900원");
            beautySelectedItemArrayList.add(item);
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


        LinearLayoutManager layoutManager = new LinearLayoutManager(DonatePostActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (beautySelectedItemArrayList.size() > 0) {
            beautySelectedItemListView.setAdapter(new BaseRecyclerAdapter(beautySelectedItemArrayList, DonatePostActivity.this, R.layout.items_beauty_select_goods_item));
        }
        beautySelectedItemListView.setLayoutManager(layoutManager);


        final LinearLayout linearLayout = findViewById(R.id.selected_list);
        linearLayout.setVisibility(View.GONE);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (linearLayout.getVisibility()) {
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

                switch (linearLayout.getVisibility()) {
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

                startActivity(new Intent(DonatePostActivity.this, BeautyPaymentActivity.class));
            }
        });

        findViewById(R.id.date_pick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonatePostActivity.this, BasePickDateActivity.class));

            }
        });


    }


}
