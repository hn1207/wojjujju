package com.rootup.friendzoo.friendzoo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.SearchHeaderListViewAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

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
        item.setTitle("쇼핑");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("도비 밸런스(올스테이지용) 애견사료, 중소형견 5kg");
            item.setDescription("무슨무슨 컷 (+10,000원 발톱정리) ");
            item.setPrice("12,000원");
            item.setDate("예약일시 12.29 (화) 16:00");
            item.setImg("http://13.125.46.183/woojjujju/feed.png");
            item.setLabel("15%할인");
            item.setSaledPrice("9970원");
            item.setLike(i%2);
            item.setType(CONTENTS);

            dataList.add(item);
        }

        item = new Item();
        item.setTitle("데이트");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("[남한 산성 애견카페] 강아지 수영장이 있는 코코밸리 ");
            item.setDescription("무슨 무슨 룸인지 옵션내용이 들어갑니다.");
//            item.setPrice("12,000원");
            item.setSaledPrice("120,000원");
            item.setDate("입실 12.29 (화) ~ 퇴실 12.31 (목) ");
            item.setImg("http://13.125.46.183/woojjujju/sweetroom.png");
            item.setType(CONTENTS);
            item.setLike(i%2);
            dataList.add(item);
        }


        ListView dataListView = (ListView) v.findViewById(R.id.data_list);

        dataListView.setAdapter(new SearchHeaderListViewAdapter(dataList, getActivity(), R.layout.items_search));




    }



}

