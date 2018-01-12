package com.rootup.wojjujju.wojjujju.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.MyPageCompletedReviewItemAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class WebtoonMyPageCurrentFragment extends Fragment {

    final int POST = 0;
    final int REVIEW = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_webtoon_mypage_current, container, false);

        initListView(view);
        return view;
    }


    void initListView(View v){

        ArrayList<Item> dataList = new ArrayList<Item>();

        for(int i=0; i<10; i++){
            Item item = new Item();


            item.setUserName("몽실이 엄마");
            item.setContents("후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다.");
            item.setDate("2017.09.23");
            item.setGrade(4);
            item.setImg("http://13.125.46.183/woojjujju/cushion.jpg");
            item.setType(REVIEW);

            dataList.add(item);


        }


        ListView beautyDefaultListView = v.findViewById(R.id.data_list);


        if (dataList.size() > 0) {
            beautyDefaultListView.setAdapter(new MyPageCompletedReviewItemAdapter(dataList, getActivity(), R.layout.items_webtoon_mypage));
        }


    }




}

