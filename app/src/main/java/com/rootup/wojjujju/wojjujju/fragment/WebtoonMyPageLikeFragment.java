package com.rootup.wojjujju.wojjujju.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.MyPageCompletedReviewItemAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class WebtoonMyPageLikeFragment extends Fragment {

    final int POST = 0;
    final int REVIEW = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_webtoon_mypage_like, container, false);

        initListView(view);
        return view;
    }


    void initListView(View v){

        ArrayList<Item> dataList = new ArrayList<Item>();

        for(int i=0; i<10; i++){
            Item item = new Item();


            item.setUserName("웹툰의 제목이 들어갑니다.길면\n밑으로 내려갑니다.");
            item.setUserName("작가이름");
            item.setLike(i%2);

            dataList.add(item);


        }


        RecyclerView beautyDefaultListView = v.findViewById(R.id.data_list);


        if (dataList.size() > 0) {
            beautyDefaultListView.setAdapter(new BaseRecyclerAdapter(dataList, getActivity(), R.layout.items_webtoon_mypage));
        }


    }




}

