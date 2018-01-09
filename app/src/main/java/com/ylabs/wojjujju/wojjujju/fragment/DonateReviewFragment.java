package com.ylabs.wojjujju.wojjujju.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.BaseGridAdapter;
import com.ylabs.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class DonateReviewFragment extends Fragment {


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
            item.setDate(null);
            item.setLabel("기부후기");
            item.setContents("여러분의 사랑으로 몽실이가 건강해졌어요!");
            item.setImg(null);
            dataList.add(item);
        }

        GridView gridView = v.findViewById(R.id.donate_info_list);

        gridView.setAdapter(new BaseGridAdapter(dataList, getActivity(), R.layout.items_donate_review));

    }



}

