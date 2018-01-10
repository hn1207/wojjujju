package com.rootup.wojjujju.wojjujju.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.HomeSaleItemAdapter;
import com.rootup.wojjujju.wojjujju.adapter.MyPageCompletedReviewItemAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class MyPageCompletedReviewHistoryFragment extends Fragment {

    final int POST = 0;
    final int REVIEW = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_mypage_completed_review_history, container, false);

        initListView(view);
        return view;
    }


    void initListView(View v){

        ArrayList<Item> dataList = new ArrayList<Item>();

        for(int i=0; i<10; i++){
            Item item = new Item();

            switch (i%2){
                case POST:
                    item.setTitle("푹신푹신 허그미  쿠션 제목이 길면 밑으로 내려갑니다. ");
                    break;
                case REVIEW:
                    item.setUserName("몽실이 엄마");
                    item.setContents("후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다. 후기내용이 들어갑니다.후기내용이 들어갑니다.");
                    item.setDate("2017.09.23");
                    item.setGrade(4);
                    item.setImg("http://13.125.46.183/woojjujju/user.png");

                    break;
            }
            item.setType(i%2);

            dataList.add(item);


        }


        ListView beautyDefaultListView = v.findViewById(R.id.data_list);


        if (dataList.size() > 0) {
            beautyDefaultListView.setAdapter(new MyPageCompletedReviewItemAdapter(dataList, getActivity(), R.layout.items_mypage_completed_review));
        }


    }




}

