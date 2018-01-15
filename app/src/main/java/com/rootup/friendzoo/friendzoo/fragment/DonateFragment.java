package com.rootup.friendzoo.friendzoo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.activity.AlarmActivity;
import com.rootup.friendzoo.friendzoo.activity.BaseDrawerActivity;
import com.rootup.friendzoo.friendzoo.activity.SearchActivity;
import com.rootup.friendzoo.friendzoo.adapter.TabViewAdapter;
import com.rootup.friendzoo.friendzoo.custom.SwipeViewPager;

public class DonateFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_donate, container, false);
        setHasOptionsMenu(true);
        initTabView(view);
        return view;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_donate, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_alarm:
                startActivity(new Intent(getContext(), AlarmActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }





    void initTabView(View v) {
        DonateInfoFragment donateInfoFragment = new DonateInfoFragment();
        DonateHistoryFragment donateHistoryFragment = new DonateHistoryFragment();
        DonateReviewFragment donateReviewFragment = new DonateReviewFragment();


        ViewPager viewPager = (ViewPager) v.findViewById(R.id.donate_tab_viewpager);
        TabViewAdapter adapter = new TabViewAdapter(getChildFragmentManager());

        adapter.addFragment(donateInfoFragment, "기부정보");
        adapter.addFragment(donateHistoryFragment, "기부내역");
        adapter.addFragment(donateReviewFragment, "기부후기");


        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.donate_tab_layout);
//        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_primary)));

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_primary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.warm_grey), getResources().getColor(R.color.color_primary));

        tabLayout.setupWithViewPager(viewPager);


    }


}

