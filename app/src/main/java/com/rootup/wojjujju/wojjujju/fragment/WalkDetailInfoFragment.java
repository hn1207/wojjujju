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
import com.rootup.wojjujju.wojjujju.activity.WalkDetailServiceGuideActivity;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.custom.MyMapView;
import com.rootup.wojjujju.wojjujju.custom.RecyclerItemClickListener;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class WalkDetailInfoFragment extends Fragment implements View.OnTouchListener {

    MyMapView mapView;
    private GoogleMap googleMap;
    private ScrollView scrollView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_walk_detail_info, container, false);

        initServiceGuideItemList(view);

        initMapView(view, savedInstanceState);


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



        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/beautyshop.jpg");
            item.setTitle("디럭스 스위트 룸1");
            item.setPrice("34,000원 / 1d");
            dataList.add(item);
        }



        RecyclerView itemListView = (RecyclerView) v.findViewById(R.id.service_guide_item_list);

        itemListView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), itemListView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        startActivity(new Intent(getActivity(), WalkDetailServiceGuideActivity.class));
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                }));
//        itemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (dataList.size() > 0) {
            itemListView.setAdapter(new BaseRecyclerAdapter(dataList, getContext(), R.layout.items_walk_detail_service_guide));
        }
        itemListView.setLayoutManager(layoutManager);
    }



    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}

