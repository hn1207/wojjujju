package com.rootup.wojjujju.wojjujju.activity;

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
import com.rootup.wojjujju.wojjujju.R;


import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;


import org.joda.time.DateTime;

import java.util.ArrayList;

public class BasePickDateActivity extends AppCompatActivity implements DatePickerListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_pick_date);

        initDatePicker();


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

    void initDatePicker(){

        // find the picker
        HorizontalPicker picker = (HorizontalPicker) findViewById(R.id.datePicker);

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





        ArrayList<Item> dateTimeList = new ArrayList<>();
        for(int i=12; i<24; i+=2){
            Item item = new Item();
            item.setDate(i + ":00");
            dateTimeList.add(item);
        }
//        dateTimeList.add(new String("10:00"));
//        dateTimeList.add(new String("12:00"));
//        dateTimeList.add(new String("14:00"));
//        dateTimeList.add(new String("16:00"));
//        dateTimeList.add(new String("18:00"));
//        dateTimeList.add(new String("20:00"));
//        dateTimeList.add(new String("22:00"));
//        dateTimeList.add(new String("24:00"));






        RecyclerView dateTimeListView = (RecyclerView) findViewById(R.id.date_time_list);
        dateTimeListView.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(BasePickDateActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (dateTimeList.size() > 0) {
            dateTimeListView.setAdapter(new BaseRecyclerAdapter(dateTimeList, BasePickDateActivity.this, R.layout.items_date_time_picker_item));
        }
        dateTimeListView.setLayoutManager(layoutManager);

    }

}
