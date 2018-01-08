package com.ylabs.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.BeautyDefaultItemAdapter;
import com.ylabs.wojjujju.wojjujju.entity.BeautyItem;

import java.util.ArrayList;

public class BeautyActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);




        toolbar.setTitle("미용");
        toolbar.setNavigationIcon(R.drawable.toolbar_nav_icon);
        toolbar.setTitleTextColor(getResources().getColor(R.color.color_primary));


        setSupportActionBar(toolbar);


        initSpinner();
        initBeautyDefaultItemList();



    }

    void initSpinner(){
        // Spinner
        Spinner defaultSpinner = (Spinner)findViewById(R.id.default_filter);
        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.default_filter, R.layout.spinner);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defaultSpinner.setAdapter(yearAdapter);

        Spinner placeSpinner = (Spinner)findViewById(R.id.place_filter);
        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(this,
                R.array.place_filter, R.layout.spinner);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        placeSpinner.setAdapter(monthAdapter);


    }

    void initBeautyDefaultItemList(){

        ArrayList<BeautyItem> beautyItemArrayList = new ArrayList<BeautyItem>();

        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 0));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));
        beautyItemArrayList.add(new BeautyItem("http://13.125.46.183/woojjujju/beauty.jpeg", "댕댕이 미용", "0", "서울시 서초구 서초동", 4, 785, "예약취소 연기 가능","예약특가", 1));





        RecyclerView beautyDefaultListView = (RecyclerView) findViewById(R.id.beauty_default_item);
        beautyDefaultListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (beautyItemArrayList.size() > 0) {
            beautyDefaultListView.setAdapter(new BeautyDefaultItemAdapter(beautyItemArrayList, BeautyActivity.this));
        }
        beautyDefaultListView.setLayoutManager(layoutManager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        switch (id) {
            case R.id.action_search:
                Toast.makeText(BeautyActivity.this, R.string.search , Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_alarm:
                Toast.makeText(BeautyActivity.this, R.string.alarm , Toast.LENGTH_SHORT).show();
                return true;
        }



        return super.onOptionsItemSelected(item);
    }

}
