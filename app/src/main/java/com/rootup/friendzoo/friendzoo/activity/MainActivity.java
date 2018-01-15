package com.rootup.friendzoo.friendzoo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.fragment.CategoryFragment;
import com.rootup.friendzoo.friendzoo.fragment.DonateFragment;
import com.rootup.friendzoo.friendzoo.fragment.HomeFragment;
import com.rootup.friendzoo.friendzoo.fragment.MyPageFragment;
import com.rootup.friendzoo.friendzoo.fragment.ViewMoreFragment;
import com.rootup.friendzoo.friendzoo.view.HomeViewPager;

import java.util.ArrayList;
import java.util.List;

import devlight.io.library.ntb.NavigationTabBar;

public class  MainActivity extends BaseDrawerActivity {


    final int HOME_FRAGMENT = 0;
    final int CATEGORY_FRAGMENT = 1;
    final int DONATE_FRAGMENT = 2;
    final int MYPAGE_FRAGMENT = 3;
    final int VIEWMORE_FRAGMENT = 4;

    HomeFragment homeFragment;
    CategoryFragment categoryFragment;
    MyPageFragment myPageFragment;
    ViewMoreFragment viewMoreFragment;
    DonateFragment donateFragment;

    HomeViewPager viewPager;

    int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar("프렌쥬");

        initBottomBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = BaseDrawerActivity.this.getMenuInflater();
//        inflater.inflate(R.menu.toolbar_main, menu);
        return false;
    }




    void initBottomBar() {

        homeFragment = new HomeFragment();
        categoryFragment = new CategoryFragment();
        donateFragment = new DonateFragment();
        myPageFragment = new MyPageFragment();
        viewMoreFragment = new ViewMoreFragment();


        viewPager = findViewById(R.id.view_pager);


        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(homeFragment, "1");
        adapter.addFragment(categoryFragment, "2");
        adapter.addFragment(donateFragment, "3");
        adapter.addFragment(myPageFragment, "4");
        adapter.addFragment(viewMoreFragment, "5");

        viewPager.setAdapter(adapter); // 처음으로 0번째 Fragment 를 보여줍니다.
//        pager.setCurrentItem(0);
        viewPager.setPagingEnabled(false);


        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.activity_main_home_icon),
                        Color.parseColor("#FFFFFF")
                ).title("홈")
                        .build()
        );
        //Active color 투명으로 한뒤 selectedIcon 을 Primary 로해서 바꿔주는 방법이 있다. 나중에 하자
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.activity_main_category_icon),
                        Color.parseColor("#FFFFFF")
                ).title("카테고리")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.activity_main_donate_icon),
                        Color.parseColor("#FFFFFF")
                ).title("기부")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.activity_main_mypage_icon),
                        Color.parseColor("#FFFFFF")
                ).title("마이페이지")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.activity_main_view_more_icon),
                        Color.parseColor("#FFFFFF")
                ).title("더보기")
                        .build()
        );


        navigationTabBar.setModels(models);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case HOME_FRAGMENT:
                        initToolbar("프렌쥬");
                        break;
                    case CATEGORY_FRAGMENT:
                        viewPager.setCurrentItem(currentPosition, true);

                        drawer.openDrawer(GravityCompat.START);
                        return;
//                        setTitle("카테고리");
//                        break;
                    case DONATE_FRAGMENT:
                        initToolbar("기부");
//                        getSupportActionBar().setTitle("기부");
                        break;
                    case MYPAGE_FRAGMENT:
                        initToolbar("마이페이지");
//                        getSupportActionBar().setTitle("마이페이지");
                        break;
                    case VIEWMORE_FRAGMENT:
                        initToolbar("더보기");
//                        getSupportActionBar().setTitle("더보기");
                        break;


                }
                currentPosition=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        navigationTabBar.setViewPager(viewPager, 0);
        navigationTabBar.setBadgeTitleColor(Color.WHITE);
        navigationTabBar.setIsSwiped(false);





    }


    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
