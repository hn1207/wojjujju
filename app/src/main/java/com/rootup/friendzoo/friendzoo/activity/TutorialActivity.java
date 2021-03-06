package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.andexert.library.RippleView;
import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.TutorialUltraPagerAdapter;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;


public class TutorialActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);


        initViewPager();





        RippleView rippleView = findViewById(R.id.ripple_view);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(TutorialActivity.this, AcceptTermsActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);

            }
        });




        //Full Screen
        View decorView = getWindow().getDecorView();
        int uiOption = getWindow().getDecorView().getSystemUiVisibility();
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility( uiOption );


    }

    void initViewPager(){

        ArrayList<Integer> dataList = new ArrayList<>();
        dataList.add(R.drawable.tutorial1);
        dataList.add(R.drawable.tutorial2);
        dataList.add(R.drawable.tutorial3);
        dataList.add(R.drawable.tutorial4);



        UltraViewPager ultraViewPager = (UltraViewPager)findViewById(R.id.ultra_viewpager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
//initialize UltraPagerAdapter，and add child view to UltraViewPager
        PagerAdapter adapter = new TutorialUltraPagerAdapter(false, dataList, TutorialActivity.this);
        ultraViewPager.setAdapter(adapter);


        ultraViewPager.initIndicator();

        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(getResources().getColor(R.color.color_primary))
                .setNormalColor(getResources().getColor(R.color.soft_grey))
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, getResources().getDisplayMetrics()));

//        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
//        ultraViewPager.getIndicator().setMargin(0,50,0,0);
        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        ultraViewPager.getIndicator().setMargin(0,0,0,50);

        ultraViewPager.getIndicator().build();


        ultraViewPager.setInfiniteLoop(false);

        ultraViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==3) {
                    findViewById(R.id.next).startAnimation(AnimationUtils.loadAnimation(TutorialActivity.this, android.R.anim.fade_in));

                    findViewById(R.id.next).setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        ultraViewPager.setAutoScroll(2000);

    }


}
