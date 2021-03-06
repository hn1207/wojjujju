package com.rootup.friendzoo.friendzoo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.activity.DonatePostActivity;
import com.rootup.friendzoo.friendzoo.adapter.BaseGridAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class DonateHistoryFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_donate_info, container, false);


        initGridView(view);

        return view;
    }


    void initGridView(View v){
        ArrayList<Item> dataList = new ArrayList<>();
        for(int i=0; i<10; i++){
            Item item = new Item();
            item.setDate("5일 남음");
            item.setPercent("94%");
            item.setContents("간신히 구조된 후 갈 곳을 잃은 두마리의 강아지");
            item.setImg("http://13.125.46.183/woojjujju/donate2.png");
            dataList.add(item);
        }

        GridView gridView = v.findViewById(R.id.donate_info_list);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getContext(), DonatePostActivity.class));
            }
        });

        gridView.setAdapter(new BaseGridAdapter(dataList, getActivity(), R.layout.items_donate_info));

    }



}

