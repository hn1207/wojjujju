package com.ylabs.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.BeautyDefaultItemAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.HomeHotPlaceItemAdapter;
import com.ylabs.wojjujju.wojjujju.entity.BeautyItem;

import java.util.ArrayList;

public class BeautyActivity extends BaseDrawerActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty);


        initToolbar("미용");



        initSpinner();
        initBeautyDefaultItemList();



    }

    void initSpinner(){
        // Spinner
        Spinner defaultSpinner = (Spinner)findViewById(R.id.default_filter);
        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.default_filter, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defaultSpinner.setAdapter(yearAdapter);

        Spinner placeSpinner = (Spinner)findViewById(R.id.place_filter);
        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(this,
                R.array.place_filter, android.R.layout.simple_spinner_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        placeSpinner.setAdapter(monthAdapter);


    }

    void initBeautyDefaultItemList(){

        ArrayList<BeautyItem> beautyItemArrayList = new ArrayList<BeautyItem>();

        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 2, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem(null, "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));





        RecyclerView beautyDefaultListView = (RecyclerView) findViewById(R.id.beauty_default_item);
        beautyDefaultListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (beautyItemArrayList.size() > 0) {
            beautyDefaultListView.setAdapter(new BeautyDefaultItemAdapter(beautyItemArrayList, BeautyActivity.this));
        }
        beautyDefaultListView.setLayoutManager(layoutManager);

    }


}
