package com.rootup.friendzoo.friendzoo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.activity.ShopSelectCategoryActivity;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.adapter.HomeSaleItemAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class ShopDogFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_shop_dog, container, false);

        initHotItemList(view);
        initSaleItemList(view);
        initRecommendItemList(view);

        String strFront = "놓칠수 없는 ";
        String strChange = "<font color=\"#f62b4c\">1 DAY</font>";
        String strBack = " 특가";
        TextView tv = view.findViewById(R.id.oneday_text);
        tv.setText(Html.fromHtml(strFront + strChange + strBack));


        view.findViewById(R.id.feed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShopSelectCategoryActivity.class));
            }
        });
        view.findViewById(R.id.snack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShopSelectCategoryActivity.class));
            }
        });
        view.findViewById(R.id.supplies).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShopSelectCategoryActivity.class));
            }
        });

        return view;
    }

    void initHotItemList(View view){


        ArrayList<Item> homeHotItemArrayList = new ArrayList<>();

        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/cushion.jpg");
            item.setTitle("푹신푹신 허그미 쿠션");
            item.setPrice("25,000원");
            homeHotItemArrayList.add(item);
        }

//        homeHotItemArrayList.add(new HomeHotItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeHotItemArrayList.add(new HomeHotItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeHotItemArrayList.add(new HomeHotItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeHotItemArrayList.add(new HomeHotItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeHotItemArrayList.add(new HomeHotItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeHotItemArrayList.add(new HomeHotItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeHotItemArrayList.add(new HomeHotItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeHotItemArrayList.add(new HomeHotItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeHotItemArrayList.add(new HomeHotItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeHotItemArrayList.add(new HomeHotItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));




        RecyclerView hotItemListView = (RecyclerView) view.findViewById(R.id.hot_item_list);
        hotItemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (homeHotItemArrayList.size() > 0) {
            hotItemListView.setAdapter(new BaseRecyclerAdapter(homeHotItemArrayList, getContext(), R.layout.items_hot_item));
        }
        hotItemListView.setLayoutManager(layoutManager);
    }


    void initSaleItemList(View view){

        ArrayList<Item> homeSaleItemList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/fassion.jpg");
            item.setTitle("미니피니 강아지 모자");
            item.setPrice("7,600원");
            item.setPercent("10%");
            item.setSaledPrice("6,900원");
            homeSaleItemList.add(item);
        }
//        homeSaleItemList.add(new HomeSaleItem("http://13.125.46.183/woojjujju/fassion.jpg", "미니피니 강아지 모자" , "7,600원", "  6,900원", "↓10%"));
//        homeSaleItemList.add(new HomeSaleItem("http://13.125.46.183/woojjujju/fassion.jpg", "미니피니 강아지 모자" , "7,600원", "  6,900원", "↓10%"));
//        homeSaleItemList.add(new HomeSaleItem("http://13.125.46.183/woojjujju/fassion.jpg", "미니피니 강아지 모자" , "7,600원", "  6,900원", "↓10%"));
//        homeSaleItemList.add(new HomeSaleItem("http://13.125.46.183/woojjujju/fassion.jpg", "미니피니 강아지 모자" , "7,600원", "  6,900원", "↓10%"));
//        homeSaleItemList.add(new HomeSaleItem("http://13.125.46.183/woojjujju/fassion.jpg", "미니피니 강아지 모자" , "7,600원", "  6,900원", "↓10%"));
//        homeSaleItemList.add(new HomeSaleItem("http://13.125.46.183/woojjujju/fassion.jpg", "미니피니 강아지 모자" , "7,600원", "  6,900원", "↓10%"));
//        homeSaleItemList.add(new HomeSaleItem("http://13.125.46.183/woojjujju/fassion.jpg", "미니피니 강아지 모자" , "7,600원", "  6,900원", "↓10%"));
//        homeSaleItemList.add(new HomeSaleItem("http://13.125.46.183/woojjujju/fassion.jpg", "미니피니 강아지 모자" , "7,600원", "  6,900원", "↓10%"));
//        homeSaleItemList.add(new HomeSaleItem("http://13.125.46.183/woojjujju/fassion.jpg", "미니피니 강아지 모자" , "7,600원", "  6,900원", "↓10%"));
//        homeSaleItemList.add(new HomeSaleItem("http://13.125.46.183/woojjujju/fassion.jpg", "미니피니 강아지 모자" , "7,600원", "  6,900원", "↓10%"));
//


        RecyclerView saleItemListView = (RecyclerView) view.findViewById(R.id.sale_item_list);
        saleItemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (homeSaleItemList.size() > 0) {
            saleItemListView.setAdapter(new HomeSaleItemAdapter(homeSaleItemList, getContext()));
        }
        saleItemListView.setLayoutManager(layoutManager);
    }

    void initRecommendItemList(View view){

        ArrayList<Item> homeRecommendItemArrayList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/cushion.jpg");
            item.setTitle("푹신푹신 허그미 쿠션");
            item.setPrice("25,000원");
            homeRecommendItemArrayList.add(item);
        }
//        homeRecommendItemArrayList.add(new HomeRecommendItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeRecommendItemArrayList.add(new HomeRecommendItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeRecommendItemArrayList.add(new HomeRecommendItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeRecommendItemArrayList.add(new HomeRecommendItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeRecommendItemArrayList.add(new HomeRecommendItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeRecommendItemArrayList.add(new HomeRecommendItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeRecommendItemArrayList.add(new HomeRecommendItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeRecommendItemArrayList.add(new HomeRecommendItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeRecommendItemArrayList.add(new HomeRecommendItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));
//        homeRecommendItemArrayList.add(new HomeRecommendItem("http://13.125.46.183/woojjujju/cushion.jpg", "푹신푹신 허그미 쿠션" , "25,000원"));






        RecyclerView recommendItemListView = (RecyclerView) view.findViewById(R.id.recommend_item_list);
        recommendItemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (homeRecommendItemArrayList.size() > 0) {
            recommendItemListView.setAdapter(new BaseRecyclerAdapter(homeRecommendItemArrayList, getContext(), R.layout.items_recommend_item));
        }
        recommendItemListView.setLayoutManager(layoutManager);
    }

}

