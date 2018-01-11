package com.rootup.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.TabViewAdapter;
import com.rootup.wojjujju.wojjujju.custom.SwipeViewPager;
import com.rootup.wojjujju.wojjujju.entity.Item;
import com.rootup.wojjujju.wojjujju.fragment.ShopCatFragment;
import com.rootup.wojjujju.wojjujju.fragment.ShopDogFragment;

import java.util.ArrayList;

public class ShoppingActivity extends BaseDrawerActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        initToolbar("쇼핑");

        initTabView();
//        initBeautySelectedItemList();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = ShoppingActivity.this.getMenuInflater();
        inflater.inflate(R.menu.toolbar_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        switch (id) {
            case R.id.action_search:
//                startActivity(new Intent(CommunityActivity.this, CommunityPostSearchActivity.class));
//                Toast.makeText(getApplicationContext(), R.string.search, Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



    void initTabView(){
        ShopDogFragment shopDogFragment= new ShopDogFragment();
        ShopCatFragment shopCatFragment = new ShopCatFragment();


        SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.tab_viewpager);
        TabViewAdapter adapter = new TabViewAdapter(getSupportFragmentManager());
        adapter.addFragment(shopDogFragment, "강아지");
        adapter.addFragment(shopCatFragment, "고양이");


        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_primary)));

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.color_primary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.warm_grey), getResources().getColor(R.color.color_primary));

        tabLayout.setupWithViewPager(viewPager);




    }



    void initBeautySelectedItemList(){

        ArrayList<Item> beautySelectedItemArrayList = new ArrayList<Item>();

        for(int i=0; i<3; i++) {
            Item item = new Item();
            item.setImg("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ");
            item.setTitle("예약일시 12.29 (화) 16:00");
            item.setPrice("9,900원");
            beautySelectedItemArrayList.add(item);
        }

//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//        beautySelectedItemArrayList.add(new SelectedItem("무슨 무슨 컷 이름이 길면 밑으로 내려갑니다. 내려갑니다. ", "예약일시 12.29 (화) 16:00", "9,900원"));
//
//


        RecyclerView beautySelectedItemListView = (RecyclerView) findViewById(R.id.select_goods_list);
        beautySelectedItemListView.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(ShoppingActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (beautySelectedItemArrayList.size() > 0) {
            beautySelectedItemListView.setAdapter(new BaseRecyclerAdapter(beautySelectedItemArrayList, ShoppingActivity.this, R.layout.items_beauty_select_goods_item));
        }
        beautySelectedItemListView.setLayoutManager(layoutManager);


        final LinearLayout linearLayout = findViewById(R.id.selected_list);
        linearLayout.setVisibility(View.GONE);


    }



}
