package com.rootup.friendzoo.friendzoo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseLikeDefaultItemAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class WebtoonMyPageLikeFragment extends Fragment {


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
            if(i%2==0){
                item.setImg("http://13.125.46.183/woojjujju/webtoon_second.png");
            }
            else{item.setImg("http://13.125.46.183/woojjujju/webtoon_first.png");}
            item.setTitle("웹툰의 제목이 들어갑니다.길면\n밑으로 내려갑니다.");
            item.setUserName("작가이름");
            item.setLike(i%2);

            dataList.add(item);


        }


        RecyclerView recyclerView = v.findViewById(R.id.data_list);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        if (dataList.size() > 0) {
            recyclerView.setAdapter(new BaseLikeDefaultItemAdapter(dataList, getActivity(), R.layout.items_webtoon_mypage));
        }
        recyclerView.setLayoutManager(layoutManager);

    }




}

