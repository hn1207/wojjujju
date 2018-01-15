package com.rootup.friendzoo.friendzoo.fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.activity.BasePlaceFilterActivity;
import com.rootup.friendzoo.friendzoo.activity.WalkDetailActivityByCash;
import com.rootup.friendzoo.friendzoo.activity.WalkDetailActivityByNotCash;
import com.rootup.friendzoo.friendzoo.adapter.BaseLikeDefaultItemAdapter;
import com.rootup.friendzoo.friendzoo.custom.RecyclerItemClickListener;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class WalkAllFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_walk_all, container, false);

        initSpinner(view);

        initItemList(view);


        return view;
    }


    void initItemList(View view){

        ArrayList<Item> dataList = new ArrayList<Item>();

        for(int i=0; i<5; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/walk_item.png");
            item.setTitle("[남한 산성 애견카페] 강아지 수영장이 있는 코코밸리");
            item.setSaledPrice("9,970원");
            item.setPrice("14,000원");
            item.setAddress("서울시 서초구 서초동");
            item.setGrade(4);
            item.setCommentCnt(785);
            item.setLabel("예약 특가");
            item.setLike(i % 2);
            dataList.add(item);
        }

        for(int i=0; i<5; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/beauty.jpeg");
            item.setTitle("반려견과 함께갈 수 있는 공원을 소개합니다! 어린이 대공원 강아지 놀이터");
            item.setAddress("서울시 서초구 서초동");
            item.setLike(i % 2);
            dataList.add(item);
        }

        


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.data_list);
        recyclerView.setHasFixedSize(true);


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        startActivity(new Intent(getContext(), WalkDetailActivityByCash.class));
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                        startActivity(new Intent(getContext(), WalkDetailActivityByNotCash.class));

                    }
                }));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (dataList.size() > 0) {

            recyclerView.setAdapter(new BaseLikeDefaultItemAdapter(dataList, getContext(), R.layout.items_walk_default_item));
        }
        recyclerView.setLayoutManager(layoutManager);

    }



    void initSpinner(View v) {

        Spinner defaultSpinner = (Spinner) v.findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.walk_default_filter, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defaultSpinner.setAdapter(adapter);

        TextView placeSpinner = (TextView)v.findViewById(R.id.place_filter);
        placeSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BasePlaceFilterActivity.class));
            }
        });

    }


}




