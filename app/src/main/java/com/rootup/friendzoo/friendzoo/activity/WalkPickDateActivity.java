package com.rootup.friendzoo.friendzoo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class WalkPickDateActivity extends AppCompatActivity implements DatePickerListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_pick_date);

        initDatePicker(R.id.datePicker);
        initDatePicker(R.id.datePicker2);


        findViewById(R.id.complete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onDateSelected(@NonNull final DateTime dateSelected) {
        // log it for demo
        Log.i("HorizontalPicker", "Selected date is " + dateSelected.toString());
    }

    void initDatePicker(int id){

        // find the picker
        HorizontalPicker picker = (HorizontalPicker) findViewById(id);

        // initialize it and attach a listener
        picker.setListener(this)
                .setDays(20)
                .setOffset(10)
                .setDateSelectedColor(getResources().getColor(R.color.smallmint))
                .setDateSelectedTextColor(getResources().getColor(R.color.white))
                .setMonthAndYearTextColor(getResources().getColor(R.color.soft_black))
                .setTodayButtonTextColor(getResources().getColor(R.color.smallmint))
                .setTodayDateTextColor(getResources().getColor(R.color.white))
                .setTodayDateBackgroundColor(getResources().getColor(R.color.white))
                .setUnselectedDayTextColor(getResources().getColor(R.color.soft_black))
                .setDayOfWeekTextColor(getResources().getColor(R.color.soft_black))
                .setUnselectedDayTextColor(getResources().getColor(R.color.soft_black))
                .showTodayButton(false)
                .init();

        // or on the View directly after init was completed
        picker.setBackgroundColor(Color.WHITE);
        picker.setDate(new DateTime().plusDays(4));






    }

}
