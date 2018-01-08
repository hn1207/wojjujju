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
import com.ylabs.wojjujju.wojjujju.adapter.HomeHotPlaceItemAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.HomeRecommendItemAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.HomeSaleItemAdapter;
import com.ylabs.wojjujju.wojjujju.entity.HomeHotItem;
import com.ylabs.wojjujju.wojjujju.entity.HomeHotPlaceItem;
import com.ylabs.wojjujju.wojjujju.entity.HomeRecommendItem;
import com.ylabs.wojjujju.wojjujju.entity.HomeSaleItem;
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
        homeHotItemArrayList.add(new Item(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new Item(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new Item(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new Item(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new Item(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new Item(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new Item(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new Item(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new Item(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new Item(null, "푹신푹신 허그미 쿠션" , "6,7000원"));



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

        ArrayList<HomeSaleItem> homeSaleItemList = new ArrayList<>();
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));
        homeSaleItemList.add(new HomeSaleItem(null, "미니피니 강아지 모자" , "8,7000원", "6,700원", "10%"));




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

        ArrayList<HomeRecommendItem> homeRecommendItemArrayList = new ArrayList<>();
        homeRecommendItemArrayList.add(new HomeRecommendItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeRecommendItemArrayList.add(new HomeRecommendItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeRecommendItemArrayList.add(new HomeRecommendItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeRecommendItemArrayList.add(new HomeRecommendItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeRecommendItemArrayList.add(new HomeRecommendItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeRecommendItemArrayList.add(new HomeRecommendItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeRecommendItemArrayList.add(new HomeRecommendItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeRecommendItemArrayList.add(new HomeRecommendItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeRecommendItemArrayList.add(new HomeRecommendItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeRecommendItemArrayList.add(new HomeRecommendItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));



        RecyclerView recommendItemListView = (RecyclerView) view.findViewById(R.id.recommend_item_list);
        recommendItemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (homeRecommendItemArrayList.size() > 0) {
            recommendItemListView.setAdapter(new HomeRecommendItemAdapter(homeRecommendItemArrayList, getContext()));
        }
        recommendItemListView.setLayoutManager(layoutManager);
    }

    void initHotPlaceItemList(View view){

        ArrayList<HomeHotPlaceItem> homeHotPlaceItemArrayList = new ArrayList<>();
        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotPlaceItemArrayList.add(new HomeHotPlaceItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));



        RecyclerView hotPlaceItemListView = (RecyclerView) view.findViewById(R.id.hot_place_item_list);
        hotPlaceItemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (homeHotPlaceItemArrayList.size() > 0) {
            hotPlaceItemListView.setAdapter(new HomeHotPlaceItemAdapter(homeHotPlaceItemArrayList, getContext()));
        }
        hotPlaceItemListView.setLayoutManager(layoutManager);
    }

}

