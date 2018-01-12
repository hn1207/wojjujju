package com.rootup.wojjujju.wojjujju.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.activity.BasePlaceFilterActivity;
import com.rootup.wojjujju.wojjujju.activity.SellDetailActivity;
import com.rootup.wojjujju.wojjujju.adapter.BaseGridAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class SellAllFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_sell_all, container, false);

        initSpinner(view);
        initGridView(view);

        return view;
    }


    void initSpinner(View v) {

        Spinner defaultSpinner = (Spinner) v.findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sell_default_filter, R.layout.spinner);
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

    void initGridView(View v) {
        ArrayList<Item> dataList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Item item = new Item();
            item.setTitle("귀여운 포메라니안 흰색");
            item.setImg("http://13.125.46.183/woojjujju/dog.jpg");
            item.setGrade(3.5f);
            item.setAddress("서울시 역삼동");
            item.setUserName("강아지세상");
            item.setLabel("1");
            dataList.add(item);
        }


        GridView gridView = v.findViewById(R.id.data_list);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getActivity(), SellDetailActivity.class));
            }
        });

        gridView.setAdapter(new BaseGridAdapter(dataList, getActivity(), R.layout.items_sell_item));

    }
}




