package com.rootup.friendzoo.friendzoo.fragment;

import android.app.Activity;
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

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.activity.BeautyDetailServiceGuideActivity;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.custom.MyMapView;
import com.rootup.friendzoo.friendzoo.custom.RecyclerItemClickListener;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class BeautyDetailInfoFragment extends Fragment implements View.OnTouchListener, ObservableScrollViewCallbacks{

    MyMapView mapView;
    private GoogleMap googleMap;
    private ScrollView scrollView;


    public static final String ARG_SCROLL_Y = "ARG_SCROLL_Y";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_beauty_detail_info, container, false);

        initServiceGuideItemList(view);
        initHairDresserItemList(view);
        initMapView(view, savedInstanceState);



        final ObservableScrollView scrollView = (ObservableScrollView) view.findViewById(R.id.scroll);
        Activity parentActivity = getActivity();
        if (parentActivity instanceof ObservableScrollViewCallbacks) {
            // Scroll to the specified offset after layout
            Bundle args = getArguments();
            if (args != null && args.containsKey(ARG_SCROLL_Y)) {
                final int scrollY = args.getInt(ARG_SCROLL_Y, 0);
                ScrollUtils.addOnGlobalLayoutListener(scrollView, new Runnable() {
                    @Override
                    public void run() {
                        scrollView.scrollTo(0, scrollY);
                    }
                });
            }

            // TouchInterceptionViewGroup should be a parent view other than ViewPager.
            // This is a workaround for the issue #117:
            // https://github.com/ksoichiro/Android-ObservableScrollView/issues/117
            scrollView.setTouchInterceptionViewGroup((ViewGroup) parentActivity.findViewById(R.id.root));
        }
        scrollView.setScrollViewCallbacks(this);



        return view;
    }


    void initMapView(final View v, Bundle savedInstanceState){
        mapView = v.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        mapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;


                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(37.265147, 127.399731)).zoom(15).build();
                googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                cameraPosition = new CameraPosition.Builder().target(new LatLng(37.265147, 127.399731)).zoom(16).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });






    }

    void initServiceGuideItemList(View v){

        ArrayList<Item> dataList = new ArrayList<>();

        Item item = new Item();
        item.setImg("http://13.125.46.183/woojjujju/beautyshop.jpg");
        item.setTitle("행동교정치료");
        item.setPrice("6,7000원");
        dataList.add(item);

        item = new Item();
        item.setImg("http://13.125.46.183/woojjujju/beautyshop2.jpg");
        item.setTitle("행동교정치료");
        item.setPrice("6,7000원");
        dataList.add(item);

        item = new Item();
        item.setImg("http://13.125.46.183/woojjujju/beautyshop3.jpg");
        item.setTitle("행동교정치료");
        item.setPrice("6,7000원");
        dataList.add(item);

        item = new Item();
        item.setImg("http://13.125.46.183/woojjujju/beautyshop4.jpg");
        item.setTitle("행동교정치료");
        item.setPrice("6,7000원");
        dataList.add(item);

        item = new Item();
        item.setImg("http://13.125.46.183/woojjujju/beautyshop5.jpg");
        item.setTitle("행동교정치료");
        item.setPrice("6,7000원");
        dataList.add(item);



        RecyclerView itemListView = (RecyclerView) v.findViewById(R.id.service_guide_item_list);

        itemListView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), itemListView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        startActivity(new Intent(getActivity(), BeautyDetailServiceGuideActivity.class));
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                }));
//        itemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (dataList.size() > 0) {
            itemListView.setAdapter(new BaseRecyclerAdapter(dataList, getContext(), R.layout.items_default_item));
        }
        itemListView.setLayoutManager(layoutManager);
    }



    void initHairDresserItemList(View v){

        ArrayList<Item> hairDresserItemArrayList = new ArrayList<>();
        for(int i=0; i<10; i++){
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/hairdressor.png");
            item.setTitle("김지영\n원장");
            item.setPrice("6,7000원");
            hairDresserItemArrayList.add(item);
        }

        RecyclerView itemListView = (RecyclerView) v.findViewById(R.id.employer_item_list);
//        itemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (hairDresserItemArrayList.size() > 0) {
            itemListView.setAdapter(new BaseRecyclerAdapter(hairDresserItemArrayList, getContext(), R.layout.items_hairdresser_item));
        }
        itemListView.setLayoutManager(layoutManager);
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }



    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        if (getActivity() != null && getActivity() instanceof ObservableScrollViewCallbacks) {
            ((ObservableScrollViewCallbacks) getActivity()).onScrollChanged(scrollY, firstScroll, dragging);
        }
    }

    @Override
    public void onDownMotionEvent() {
        if (getActivity() != null && getActivity() instanceof ObservableScrollViewCallbacks) {
            ((ObservableScrollViewCallbacks) getActivity()).onDownMotionEvent();
        }
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        if (getActivity() != null && getActivity() instanceof ObservableScrollViewCallbacks) {
            ((ObservableScrollViewCallbacks) getActivity()).onUpOrCancelMotionEvent(scrollState);
        }

    }

}

