package com.ylabs.wojjujju.wojjujju.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.BaseItemAdapter;
import com.ylabs.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class BeautyDetailInfoFragment extends Fragment {

    MapView mapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_beauty_detail_info, container, false);

        initServiceGuideItemList(view);
        initHairDresserItemList(view);
        initMapView(view, savedInstanceState);
        return view;
    }

    void initMapView(View v, Bundle savedInstanceState){
        mapView = (MapView) v.findViewById(R.id.map);
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

        ArrayList<Item> beautyServiceGuideItemArrayList = new ArrayList<>();
        beautyServiceGuideItemArrayList.add(new Item("http://13.125.46.183/woojjujju/beautyshop.jpg", "행동교정치료" , "6,7000원"));
        beautyServiceGuideItemArrayList.add(new Item("http://13.125.46.183/woojjujju/beautyshop2.jpg", "행동교정치료" , "6,7000원"));
        beautyServiceGuideItemArrayList.add(new Item("http://13.125.46.183/woojjujju/beautyshop3.jpg", "행동교정치료" , "6,7000원"));
        beautyServiceGuideItemArrayList.add(new Item("http://13.125.46.183/woojjujju/beautyshop4.jpg", "행동교정치료" , "6,7000원"));
        beautyServiceGuideItemArrayList.add(new Item("http://13.125.46.183/woojjujju/beautyshop5.jpg", "행동교정치료" , "6,7000원"));
        beautyServiceGuideItemArrayList.add(new Item("http://13.125.46.183/woojjujju/beautyshop.jpg", "행동교정치료" , "6,7000원"));
        beautyServiceGuideItemArrayList.add(new Item("http://13.125.46.183/woojjujju/beautyshop2.jpg", "행동교정치료" , "6,7000원"));
        beautyServiceGuideItemArrayList.add(new Item("http://13.125.46.183/woojjujju/beautyshop3.jpg", "행동교정치료" , "6,7000원"));




        RecyclerView itemListView = (RecyclerView) v.findViewById(R.id.service_guide_item_list);
//        itemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (beautyServiceGuideItemArrayList.size() > 0) {
            itemListView.setAdapter(new BaseItemAdapter(beautyServiceGuideItemArrayList, getContext(), R.layout.items_default_item));
        }
        itemListView.setLayoutManager(layoutManager);
    }


    void initHairDresserItemList(View v){

        ArrayList<Item> hairDresserItemArrayList = new ArrayList<>();
        hairDresserItemArrayList.add(new Item("http://13.125.46.183/woojjujju/hairdressor.jpg", "김지영\n원장" , "6,7000원"));
        hairDresserItemArrayList.add(new Item("http://13.125.46.183/woojjujju/hairdressor.jpg", "김지영\n원장" , "6,7000원"));
        hairDresserItemArrayList.add(new Item("http://13.125.46.183/woojjujju/hairdressor.jpg", "김지영\n원장" , "6,7000원"));
        hairDresserItemArrayList.add(new Item("http://13.125.46.183/woojjujju/hairdressor.jpg", "김지영\n원장" , "6,7000원"));
        hairDresserItemArrayList.add(new Item("http://13.125.46.183/woojjujju/hairdressor.jpg", "김지영\n원장" , "6,7000원"));
        hairDresserItemArrayList.add(new Item("http://13.125.46.183/woojjujju/hairdressor.jpg", "김지영\n원장" , "6,7000원"));
        hairDresserItemArrayList.add(new Item("http://13.125.46.183/woojjujju/hairdressor.jpg", "김지영\n원장" , "6,7000원"));
        hairDresserItemArrayList.add(new Item("http://13.125.46.183/woojjujju/hairdressor.jpg", "김지영\n원장" , "6,7000원"));
        hairDresserItemArrayList.add(new Item("http://13.125.46.183/woojjujju/hairdressor.jpg", "김지영\n원장" , "6,7000원"));



        RecyclerView itemListView = (RecyclerView) v.findViewById(R.id.hairdresser_item_list);
//        itemListView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (hairDresserItemArrayList.size() > 0) {
            itemListView.setAdapter(new BaseItemAdapter(hairDresserItemArrayList, getContext(), R.layout.items_hairdresser_item));
        }
        itemListView.setLayoutManager(layoutManager);
    }



}

