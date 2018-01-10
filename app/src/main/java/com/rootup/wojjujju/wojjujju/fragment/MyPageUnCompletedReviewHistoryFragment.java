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
import com.rootup.wojjujju.wojjujju.activity.MyPageCancelHistoryActivity;
import com.rootup.wojjujju.wojjujju.adapter.BaseHeaderListViewAdapter;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.adapter.HomeSaleItemAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class MyPageUnCompletedReviewHistoryFragment extends Fragment {
    final int HEADER = 0;
    final int CONTENTS = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_mypage_uncompleted_review_history, container, false);

        initItem(view);

        return view;
    }



    void initItem(View v){

        ArrayList<Item> dataList = new ArrayList<>();

        Item item = new Item();
        item.setTitle("쇼핑");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("푹신푹신 허그미 쿠션 ");
            item.setDescription("특대사이즈 100cm red");
            item.setPrice("12,000원");
            item.setDate("2017.12.03 도착");
            item.setLabel("후기 쓰기");
            item.setImg(null);
            item.setType(CONTENTS);

            dataList.add(item);
        }

        item = new Item();
        item.setTitle("미용");
        item.setType(HEADER);
        dataList.add(item);

        for(int i=0; i<5; i++){
            item = new Item();
            item.setTitle("[댕댕이 미용]");
            item.setDescription("");
//            item.setPrice("12,000원");
            item.setDate("2017.12.29. 16:00 예약 ");
            item.setLabel("후기 쓰기");
            item.setImg(null);
            item.setType(CONTENTS);
            dataList.add(item);
        }




        ListView dataListView = (ListView) v.findViewById(R.id.data_list);

        dataListView.setAdapter(new BaseHeaderListViewAdapter(dataList, getActivity(), R.layout.items_mypage_cancel_history));




    }

}

