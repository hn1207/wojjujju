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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.activity.MyPageBookHistoryActivity;
import com.rootup.wojjujju.wojjujju.activity.WalkDetailServiceGuideActivity;
import com.rootup.wojjujju.wojjujju.adapter.BaseHeaderListViewAdapter;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.SearchHeaderListViewAdapter;
import com.rootup.wojjujju.wojjujju.custom.MyMapView;
import com.rootup.wojjujju.wojjujju.custom.RecyclerItemClickListener;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class SearchAllFragment extends Fragment {


    final int HEADER = 0;
    final int CONTENTS = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_search_all, container, false);

        initSearchItem(view);
        initSpinner(view);
        return view;
    }



    void initSpinner(View view){
        // Spinner
        Spinner defaultSpinner = (Spinner)view.findViewById(R.id.default_filter);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.community_default_filter, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defaultSpinner.setAdapter(adapter);



    }


    void initSearchItem(View v){

        ArrayList<Item> dataList = new ArrayList<>();

        Item item = new Item();
        item.setTitle("미용");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("[댕댕이 미용]");
            item.setDescription("무슨무슨 컷 (+10,000원 발톱정리) ");
            item.setPrice("12,000원");
            item.setDate("예약일시 12.29 (화) 16:00");
            item.setImg("http://13.125.46.183/woojjujju/beauty.jpeg");
            item.setLabel("15%할인");
            item.setSaledPrice("9970원");
            item.setType(CONTENTS);

            dataList.add(item);
        }

        item = new Item();
        item.setTitle("데이트");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("상품의 제목이 들어갑니다. 길면밑으로\n내려갑니다.");
            item.setDescription("무슨 무슨 룸인지 옵션내용이 들어갑니다.");
            item.setPrice("12,000원");
            item.setDate("입실 12.29 (화) ~ 퇴실 12.31 (목) ");
            item.setImg("http://13.125.46.183/woojjujju/dog.jpg");
            item.setType(CONTENTS);
            dataList.add(item);
        }


        ListView dataListView = (ListView) v.findViewById(R.id.data_list);

        dataListView.setAdapter(new SearchHeaderListViewAdapter(dataList, getActivity(), R.layout.items_search));




    }



}

