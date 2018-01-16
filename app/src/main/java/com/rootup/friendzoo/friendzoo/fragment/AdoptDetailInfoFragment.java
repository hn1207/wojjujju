package com.rootup.friendzoo.friendzoo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseUltraPagerAdapter;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;

public class AdoptDetailInfoFragment extends Fragment  {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_adopt_detail_info, container, false);

        initViewPager(view);
        return view;
    }


    void initViewPager(View v){

        ArrayList<String> dataList = new ArrayList<>();
        dataList.add("http://13.125.46.183/woojjujju/viewpager_adopt.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_adopt2.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_adopt3.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_adopt4.jpg");
        dataList.add("http://13.125.46.183/woojjujju/viewpager_adopt5.jpg");

        UltraViewPager ultraViewPager = (UltraViewPager)v.findViewById(R.id.ultra_viewpager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
//initialize UltraPagerAdapter，and add child view to UltraViewPager
        PagerAdapter adapter = new BaseUltraPagerAdapter(false, dataList, getActivity().getApplicationContext());
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


}

