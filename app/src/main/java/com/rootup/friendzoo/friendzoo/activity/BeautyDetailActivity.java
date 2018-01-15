package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.github.ksoichiro.android.observablescrollview.CacheFragmentStatePagerAdapter;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.google.samples.apps.iosched.ui.widget.SlidingTabLayout;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.rootup.friendzoo.friendzoo.lib.BaseActivity;
import com.rootup.friendzoo.friendzoo.lib.ViewPagerTabScrollViewWithFabActivity;
import com.rootup.friendzoo.friendzoo.lib.ViewPagerTabScrollViewWithFabFragment;
import com.tmall.ultraviewpager.UltraViewPager;
import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.adapter.BaseUltraPagerAdapter;
import com.rootup.friendzoo.friendzoo.adapter.TabViewAdapter;
import com.rootup.friendzoo.friendzoo.custom.SwipeViewPager;
import com.rootup.friendzoo.friendzoo.entity.Item;
import com.rootup.friendzoo.friendzoo.fragment.BeautyDetailInfoFragment;
import com.rootup.friendzoo.friendzoo.fragment.BaseQnAFragment;
import com.rootup.friendzoo.friendzoo.fragment.BaseReviewFragment;

import java.util.ArrayList;

public class BeautyDetailActivity extends BaseActivity implements ObservableScrollViewCallbacks {



    private View mHeaderView;
    private View mToolbarView;
    private int mBaseTranslationY;
    private ViewPager mPager;
    private TabViewAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_detail);

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));



        initViewPager();
        initTabView();
//        initBeautySelectedItemList();



        mHeaderView = findViewById(R.id.header);
        ViewCompat.setElevation(mHeaderView, getResources().getDimension(R.dimen.toolbar_elevation));
        mToolbarView = findViewById(R.id.toolbar);
//        mToolbarView = findViewById(R.id.ultra_viewpager);
//        mPagerAdapter = newViewPagerAdapter();
//        mPager = (ViewPager) findViewById(R.id.pager);
//        mPager.setAdapter(mPagerAdapter);

        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.color_primary));
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(mPager);



        // When the page is selected, other fragments' scrollY should be adjusted
        // according to the toolbar status(shown/hidden)
        slidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
            }

            @Override
            public void onPageSelected(int i) {
                propagateToolbarState(toolbarIsShown());
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

        propagateToolbarState(toolbarIsShown());




    }



    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        if (dragging) {
            int toolbarHeight = mToolbarView.getHeight();
            float currentHeaderTranslationY = ViewHelper.getTranslationY(mHeaderView);
            if (firstScroll) {
                if (-toolbarHeight < currentHeaderTranslationY) {
                    mBaseTranslationY = scrollY;
                }
            }
            float headerTranslationY = ScrollUtils.getFloat(-(scrollY - mBaseTranslationY), -toolbarHeight, 0);
            ViewPropertyAnimator.animate(mHeaderView).cancel();
            ViewHelper.setTranslationY(mHeaderView, headerTranslationY);
        }
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        mBaseTranslationY = 0;

        Fragment fragment = getCurrentFragment();
        if (fragment == null) {
            return;
        }
        View view = fragment.getView();
        if (view == null) {
            return;
        }

        int toolbarHeight = mToolbarView.getHeight();
        final ObservableScrollView scrollView = (ObservableScrollView) view.findViewById(R.id.scroll);
        if (scrollView == null) {
            return;
        }
        int scrollY = scrollView.getCurrentScrollY();
        if (scrollState == ScrollState.DOWN) {
            showToolbar();
        } else if (scrollState == ScrollState.UP) {
//            if (toolbarHeight <= scrollY) {
                hideToolbar();
//            } else {
//                showToolbar();
//            }
//        } else {
            // Even if onScrollChanged occurs without scrollY changing, toolbar should be adjusted
            if (toolbarIsShown() || toolbarIsHidden()) {
                // Toolbar is completely moved, so just keep its state
                // and propagate it to other pages
                propagateToolbarState(toolbarIsShown());
            } else {
                // Toolbar is moving but doesn't know which to move:
                // you can change this to hideToolbar()
//                showToolbar();
            }
        }
    }

    private Fragment getCurrentFragment() {
        return mPagerAdapter.getItem(mPager.getCurrentItem());
    }

    private void propagateToolbarState(boolean isShown) {
        int toolbarHeight = mToolbarView.getHeight();

        // Set scrollY for the fragments that are not created yet
        mPagerAdapter.setScrollY(isShown ? 0 : toolbarHeight);

        // Set scrollY for the active fragments
        for (int i = 0; i < mPagerAdapter.getCount(); i++) {
            // Skip current item
            if (i == mPager.getCurrentItem()) {
                continue;
            }

            // Skip destroyed or not created item
            Fragment f = mPagerAdapter.getItem(i);
            if (f == null) {
                continue;
            }

            View view = f.getView();
            if (view == null) {
                continue;
            }
            ObservableScrollView scrollView = (ObservableScrollView) view.findViewById(R.id.scroll);
            if (isShown) {
                // Scroll up
                if (0 < scrollView.getCurrentScrollY()) {
                    scrollView.scrollTo(0, 0);
                }
            } else {
                // Scroll down (to hide padding)
                if (scrollView.getCurrentScrollY() < toolbarHeight) {
                    scrollView.scrollTo(0, toolbarHeight);
                }
            }
        }
    }


    private boolean toolbarIsShown() {
        return ViewHelper.getTranslationY(mHeaderView) == 0;
    }
    private boolean toolbarIsHidden() {
        return ViewHelper.getTranslationY(mHeaderView) == -mToolbarView.getHeight();
    }

    private void showToolbar() {
        float headerTranslationY = ViewHelper.getTranslationY(mHeaderView);
        if (headerTranslationY != 0) {
            ViewPropertyAnimator.animate(mHeaderView).cancel();
            ViewPropertyAnimator.animate(mHeaderView).translationY(0).setDuration(200).start();
        }
        propagateToolbarState(true);
    }

    private void hideToolbar() {
        float headerTranslationY = ViewHelper.getTranslationY(mHeaderView);
        int toolbarHeight = mToolbarView.getHeight();
        if (headerTranslationY != -toolbarHeight) {
            ViewPropertyAnimator.animate(mHeaderView).cancel();
            ViewPropertyAnimator.animate(mHeaderView).translationY(-toolbarHeight).setDuration(200).start();
        }
        propagateToolbarState(false);
    }


    void initTabView(){
        BeautyDetailInfoFragment beautyDetailInfoFragment = new BeautyDetailInfoFragment();
        BaseQnAFragment baseQnAFragment = new BaseQnAFragment();
        BaseReviewFragment baseReviewFragment = new BaseReviewFragment();


        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.tab_viewpager);
        TabViewAdapter adapter = new TabViewAdapter(getSupportFragmentManager());

        mPager = viewPager;
        mPagerAdapter = adapter;

        adapter.addFragment(beautyDetailInfoFragment, "상세정보");
        adapter.addFragment(baseQnAFragment, "Q&A");
        adapter.addFragment(baseReviewFragment, "후기");


        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(adapter);

//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
////        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_primary)));
//
//        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_primary));
//        tabLayout.setTabTextColors(getResources().getColor(R.color.warm_grey), getResources().getColor(R.color.color_primary));
//
//        tabLayout.setupWithViewPager(viewPager);




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
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics()));

        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        ultraViewPager.getIndicator().setMargin(0,0,0,20);

        ultraViewPager.getIndicator().build();


        ultraViewPager.setInfiniteLoop(true);

//        ultraViewPager.setAutoScroll(2000);

    }
//
//
//    void initBeautySelectedItemList(){
//
//        ArrayList<Item> beautySelectedItemArrayList = new ArrayList<Item>();
//
//        for(int i=0; i<3; i++) {
//            Item item = new Item();
//            item.setImg("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ");
//            item.setTitle("예약일시 12.29 (화) 16:00");
//            item.setPrice("9,900원");
//            beautySelectedItemArrayList.add(item);
//        }
//
////        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
////        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
////        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
////        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
////        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
////
////
//
//
//        RecyclerView beautySelectedItemListView = (RecyclerView) findViewById(R.id.select_goods_list);
//        beautySelectedItemListView.setHasFixedSize(true);
//
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyDetailActivity.this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        if (beautySelectedItemArrayList.size() > 0) {
//            beautySelectedItemListView.setAdapter(new BaseRecyclerAdapter(beautySelectedItemArrayList, BeautyDetailActivity.this, R.layout.items_base_select_goods_item));
//        }
//        beautySelectedItemListView.setLayoutManager(layoutManager);
//
//
//        final LinearLayout linearLayout = findViewById(R.id.selected_list);
//        linearLayout.setVisibility(View.GONE);
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (linearLayout.getVisibility()){
//                    case View.GONE:
//                        linearLayout.setVisibility(View.VISIBLE);
//                        break;
//                    case View.VISIBLE:
//                        linearLayout.setVisibility(View.GONE);
//                        break;
//
//                }
//
//            }
//        });
//
//        findViewById(R.id.contact_us).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                switch (linearLayout.getVisibility()){
//                    case View.GONE:
//                        linearLayout.setVisibility(View.VISIBLE);
//                        break;
//                    case View.VISIBLE:
//                        linearLayout.setVisibility(View.GONE);
//                        break;
//
//                }
//
//            }
//        });
//
//        findViewById(R.id.payment).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startActivity(new Intent(BeautyDetailActivity.this, BeautyPaymentActivity.class));
//            }
//        });
//
//        findViewById(R.id.date_pick).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(BeautyDetailActivity.this, BasePickDateActivity.class));
//
//            }
//        });
//
//
//
//    }



}
