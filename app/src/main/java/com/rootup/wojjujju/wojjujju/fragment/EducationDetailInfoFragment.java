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
import com.rootup.wojjujju.wojjujju.activity.EducationDetailServiceGuideActivity;
import com.rootup.wojjujju.wojjujju.activity.EducationDetailServiceGuideItemActivity;
import com.rootup.wojjujju.wojjujju.activity.HospitalDetailServiceGuideItemActivity;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.custom.MyMapView;
import com.rootup.wojjujju.wojjujju.custom.RecyclerItemClickListener;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class EducationDetailInfoFragment extends Fragment {

    MyMapView mapView;
    private GoogleMap googleMap;
    private ScrollView scrollView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_education_detail_info, container, false);

//        initServiceGuideItemList(view);
//        initHairDresserItemList(view);
//        initMapView(view, savedInstanceState);


        view.findViewById(R.id.service_guide_item_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), EducationDetailServiceGuideActivity.class));
            }
        });
        return view;
    }

}

