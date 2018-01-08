package com.ylabs.wojjujju.wojjujju.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.fragment.CategoryFragment;
import com.ylabs.wojjujju.wojjujju.fragment.DonateFragment;
import com.ylabs.wojjujju.wojjujju.fragment.HomeFragment;
import com.ylabs.wojjujju.wojjujju.fragment.MyPageFragment;
import com.ylabs.wojjujju.wojjujju.fragment.ViewMoreFragment;
import com.ylabs.wojjujju.wojjujju.view.HomeViewPager;

import java.util.ArrayList;
import java.util.List;

import devlight.io.library.ntb.NavigationTabBar;

public class MainActivity extends BaseDrawerActivity {


    HomeFragment homeFragment;
    CategoryFragment categoryFragment;
    MyPageFragment myPageFragment;
    ViewMoreFragment viewMoreFragment;
    DonateFragment donateFragment;

    HomeViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar("우쭈쭈");

        initBottomBar();
    }

    void initBottomBar(){

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


        navigationTabBar.setViewPager(viewPager , 0);
        navigationTabBar.setBadgeTitleColor(Color.WHITE);
        navigationTabBar.setIsSwiped(false);
    }


    public class MyFragmentPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyFragmentPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title)
        {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragments.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return mFragmentTitles.get(position);
        }
    }
}
