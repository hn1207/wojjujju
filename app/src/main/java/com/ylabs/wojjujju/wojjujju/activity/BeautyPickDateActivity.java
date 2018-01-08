package com.ylabs.wojjujju.wojjujju.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.tmall.ultraviewpager.UltraViewPager;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.BeautyDetailPagerAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.BeautyTabViewAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.SelectedItemAdapter;
import com.ylabs.wojjujju.wojjujju.custom.SwipeViewPager;
import com.ylabs.wojjujju.wojjujju.entity.SelectedItem;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyDetailInfoFragment;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyQnAFragment;
import com.ylabs.wojjujju.wojjujju.fragment.BeautyReviewFragment;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class BeautyPickDateActivity extends AppCompatActivity implements DatePickerListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_pick_date);


        // find the picker
        HorizontalPicker picker = (HorizontalPicker) findViewById(R.id.datePicker);

        // initialize it and attach a listener
        picker.setListener(this)
                .setDays(20)
                .setOffset(10)
                .setDateSelectedColor(getResources().getColor(R.color.mint))
                .setDateSelectedTextColor(Color.WHITE)
                .setMonthAndYearTextColor(Color.WHITE)
                .setTodayButtonTextColor(getResources().getColor(R.color.white))
                .setTodayDateTextColor(getResources().getColor(R.color.white))
                .setTodayDateBackgroundColor(getResources().getColor(R.color.mint))
                .setUnselectedDayTextColor(Color.WHITE)
                .setDayOfWeekTextColor(Color.WHITE)
                .setUnselectedDayTextColor(getResources().getColor(R.color.warm_grey))
                .showTodayButton(false)
                .init();

        // or on the View directly after init was completed
        picker.setBackgroundColor(Color.WHITE);
        picker.setDate(new DateTime().plusDays(4));
    }

    @Override
    public void onDateSelected(@NonNull final DateTime dateSelected) {
        // log it for demo
        Log.i("HorizontalPicker", "Selected date is " + dateSelected.toString());
    }

}
