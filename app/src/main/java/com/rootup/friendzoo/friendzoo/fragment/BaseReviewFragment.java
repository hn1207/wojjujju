package com.rootup.friendzoo.friendzoo.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.activity.BaseReviewEditActivity;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class BaseReviewFragment extends Fragment implements ObservableScrollViewCallbacks{

    public static final String ARG_SCROLL_Y = "ARG_SCROLL_Y";



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



        final ObservableScrollView scrollView = (ObservableScrollView) view.findViewById(R.id.scroll);
        Activity parentActivity = getActivity();
        if (parentActivity instanceof ObservableScrollViewCallbacks) {
            // Scroll to the specified offset after layout
            Bundle args = getArguments();
            if (args != null && args.containsKey(ARG_SCROLL_Y)) {
                final int scrollY = args.getInt(ARG_SCROLL_Y, 0);
                ScrollUtils.addOnGlobalLayoutListener(scrollView, new Runnable() {
                    @Override
                    public void run() {
                        scrollView.scrollTo(0, scrollY);
                    }
                });
            }

            // TouchInterceptionViewGroup should be a parent view other than ViewPager.
            // This is a workaround for the issue #117:
            // https://github.com/ksoichiro/Android-ObservableScrollView/issues/117
            scrollView.setTouchInterceptionViewGroup((ViewGroup) parentActivity.findViewById(R.id.root));
        }
        scrollView.setScrollViewCallbacks(this);
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


    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        if (getActivity() != null && getActivity() instanceof ObservableScrollViewCallbacks) {
            ((ObservableScrollViewCallbacks) getActivity()).onScrollChanged(scrollY, firstScroll, dragging);
        }
    }

    @Override
    public void onDownMotionEvent() {
        if (getActivity() != null && getActivity() instanceof ObservableScrollViewCallbacks) {
            ((ObservableScrollViewCallbacks) getActivity()).onDownMotionEvent();
        }
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        if (getActivity() != null && getActivity() instanceof ObservableScrollViewCallbacks) {
            ((ObservableScrollViewCallbacks) getActivity()).onUpOrCancelMotionEvent(scrollState);
        }

    }



}

