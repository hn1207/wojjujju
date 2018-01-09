package com.ylabs.wojjujju.wojjujju.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylabs.wojjujju.wojjujju.R;

import com.ylabs.wojjujju.wojjujju.adapter.BaseItemAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.HomeSaleItemAdapter;
import com.ylabs.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_home, container, false);


        initHotItemList(view);
        initSaleItemList(view);
        initRecommendItemList(view);
        initHotPlaceItemList(view);


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
            hotItemListView.setAdapter(new BaseItemAdapter(homeHotItemArrayList, getContext(), R.layout.items_hot_item));
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
            recommendItemListView.setAdapter(new BaseItemAdapter(homeRecommendItemArrayList, getContext(), R.layout.items_recommend_item));
        }
        recommendItemListView.setLayoutManager(layoutManager);
    }

    void initHotPlaceItemList(View view){

        ArrayList<Item> homeHotPlaceItemArrayList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/park.jpg");
            item.setTitle("반려견들과 산책가능한 공원");
            item.setPrice("6,700원");
            homeHotPlaceItemArrayList.add(item);
        }
//        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem("http://13.125.46.183/woojjujju/park.jpg", "반려견들과 산책가능한 공원에서 놀아보아…" , "6,7000원"));
//        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem("http://13.125.46.183/woojjujju/park.jpg", "반려견들과 산책가능한 공원에서 놀아보아…" , "6,7000원"));
//        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem("http://13.125.46.183/woojjujju/park.jpg", "반려견들과 산책가능한 공원에서 놀아보아…" , "6,7000원"));
//        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem("http://13.125.46.183/woojjujju/park.jpg", "반려견들과 산책가능한 공원에서 놀아보아…" , "6,7000원"));
//        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem("http://13.125.46.183/woojjujju/park.jpg", "반려견들과 산책가능한 공원에서 놀아보아…" , "6,7000원"));
//        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem("http://13.125.46.183/woojjujju/park.jpg", "반려견들과 산책가능한 공원에서 놀아보아…" , "6,7000원"));
//        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem("http://13.125.46.183/woojjujju/park.jpg", "반려견들과 산책가능한 공원에서 놀아보아…" , "6,7000원"));
//        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem("http://13.125.46.183/woojjujju/park.jpg", "반려견들과 산책가능한 공원에서 놀아보아…" , "6,7000원"));
//        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem("http://13.125.46.183/woojjujju/park.jpg", "반려견들과 산책가능한 공원에서 놀아보아…" , "6,7000원"));
//        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem("http://13.125.46.183/woojjujju/park.jpg", "반려견들과 산책가능한 공원에서 놀아보아…" , "6,7000원"));


        RecyclerView hotPlaceItemListView = (RecyclerView) view.findViewById(R.id.hot_place_item_list);
        hotPlaceItemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (homeHotPlaceItemArrayList.size() > 0) {
            hotPlaceItemListView.setAdapter(new BaseItemAdapter(homeHotPlaceItemArrayList, getContext(), R.layout.items_default_item));
        }
        hotPlaceItemListView.setLayoutManager(layoutManager);
    }

}

