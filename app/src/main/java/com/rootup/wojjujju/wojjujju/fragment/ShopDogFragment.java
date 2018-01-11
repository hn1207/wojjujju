package com.rootup.wojjujju.wojjujju.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.activity.BeautyDetailServiceGuideActivity;
import com.rootup.wojjujju.wojjujju.activity.ShoppingSelectCategoryActivity;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.HomeSaleItemAdapter;
import com.rootup.wojjujju.wojjujju.custom.MyMapView;
import com.rootup.wojjujju.wojjujju.custom.RecyclerItemClickListener;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class ShopDogFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_shop_dog, container, false);

        initHotItemList(view);
        initSaleItemList(view);
        initRecommendItemList(view);

        view.findViewById(R.id.feed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShoppingSelectCategoryActivity.class));
            }
        });
        view.findViewById(R.id.snack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShoppingSelectCategoryActivity.class));
            }
        });
        view.findViewById(R.id.supplies).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShoppingSelectCategoryActivity.class));
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

