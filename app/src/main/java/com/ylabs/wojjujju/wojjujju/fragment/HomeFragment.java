package com.ylabs.wojjujju.wojjujju.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.HomeHotItemAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.HomeSaleItemAdapter;
import com.ylabs.wojjujju.wojjujju.entity.HomeHotItem;
import com.ylabs.wojjujju.wojjujju.entity.HomeSaleItem;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_home, container, false);


        initHotItemList(view);
        initSaleItemList(view);


        return view;
    }


    void initHotItemList(View view){

        ArrayList<HomeHotItem> homeHotItemArrayList = new ArrayList<>();
        homeHotItemArrayList.add(new HomeHotItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new HomeHotItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new HomeHotItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new HomeHotItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new HomeHotItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new HomeHotItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new HomeHotItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new HomeHotItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new HomeHotItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));
        homeHotItemArrayList.add(new HomeHotItem(null, "푹신푹신 허그미 쿠션" , "6,7000원"));



        RecyclerView hotItemListView = (RecyclerView) view.findViewById(R.id.hot_item_list);
        hotItemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (homeHotItemArrayList.size() > 0) {
            hotItemListView.setAdapter(new HomeHotItemAdapter(homeHotItemArrayList, getContext()));
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

}

