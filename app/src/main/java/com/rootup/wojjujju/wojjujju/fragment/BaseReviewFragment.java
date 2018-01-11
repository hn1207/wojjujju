package com.rootup.wojjujju.wojjujju.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.activity.BaseReviewEditActivity;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class BaseReviewFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_beauty_review, container, false);
        initBeautyReviewItemList(view);

        view.findViewById(R.id.review_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BaseReviewEditActivity.class));
            }
        });

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

