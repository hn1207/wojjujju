package com.ylabs.wojjujju.wojjujju.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.ylabs.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class BeautyReviewFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_beauty_review, container, false);
        initBeautyReviewItemList(view);

        return view;
    }


    void initBeautyReviewItemList(View v){

        ArrayList<Item> beautyReviewItemArrayList = new ArrayList<Item>();

        for(int i=0; i<10; i++){
            Item item = new Item();
            item.setUserName("몽실이 엄마");
            item.setContents("후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다.");
            item.setDate("2017.09.23");
            item.setGrade(4);
            item.setImg("http://13.125.46.183/woojjujju/user.png");

            beautyReviewItemArrayList.add(item);


        }

//        beautyReviewItemArrayList.add(new ReviewItem("몽실이 엄마","후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.", "2017.09.23", 4, null));
//        beautyReviewItemArrayList.add(new ReviewItem("몽실이 엄마","후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.", "2017.09.23", 4, null));
//        beautyReviewItemArrayList.add(new ReviewItem("몽실이 엄마","후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.", "2017.09.23", 4, null));
//        beautyReviewItemArrayList.add(new ReviewItem("몽실이 엄마","후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.", "2017.09.23", 4, null));
//        beautyReviewItemArrayList.add(new ReviewItem("몽실이 엄마","후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.", "2017.09.23", 4, null));
//        beautyReviewItemArrayList.add(new ReviewItem("몽실이 엄마","후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.", "2017.09.23", 4, null));
//        beautyReviewItemArrayList.add(new ReviewItem("몽실이 엄마","후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.", "2017.09.23", 4, null));
//        beautyReviewItemArrayList.add(new ReviewItem("몽실이 엄마","후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.", "2017.09.23", 4, null));
//        beautyReviewItemArrayList.add(new ReviewItem("몽실이 엄마","후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.", "2017.09.23", 4, null));



        RecyclerView beautyDefaultListView = v.findViewById(R.id.beauty_review_list_view);
        beautyDefaultListView.setHasFixedSize(true);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (beautyReviewItemArrayList.size() > 0) {
            beautyDefaultListView.setAdapter(new BaseRecyclerAdapter(beautyReviewItemArrayList, getActivity(), R.layout.items_beauty_detail_review_item));
        }
        beautyDefaultListView.setLayoutManager(layoutManager);

    }




}

