package com.rootup.wojjujju.wojjujju.fragment;

import android.content.Intent;
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

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.activity.AlarmActivity;
import com.rootup.wojjujju.wojjujju.activity.SearchActivity;
import com.rootup.wojjujju.wojjujju.activity.WebtoonDetailActivity;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.custom.RecyclerItemClickListener;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class WebtoonFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_webtoon, container, false);

        initItemList(view, R.id.data_list);
        initItemList(view, R.id.data_list2);
        initItemList(view, R.id.data_list3);


        return view;
    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                startActivity(new Intent(getContext(), SearchActivity.class));

                return true;
            case R.id.action_alarm:
                startActivity(new Intent(getContext(), AlarmActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }




    void initItemList(View view, int layout){


        ArrayList<Item> dataList = new ArrayList<>();

        for(int i=0; i<10; i++) {
            Item item = new Item();
            if(i%2==0){
                item.setImg("http://13.125.46.183/woojjujju/webtoon_second.png");
            }
            else{item.setImg("http://13.125.46.183/woojjujju/webtoon_first.png");}
            item.setTitle("내 어린 고양이와 늙은 개");
            item.setDescription(i + " 화");
            item.setLabel("new");
            dataList.add(item);
        }




        RecyclerView recyclerView = (RecyclerView) view.findViewById(layout);
        recyclerView.setHasFixedSize(true);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        startActivity(new Intent(getContext(), WebtoonDetailActivity.class));
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                }));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (dataList.size() > 0) {
            recyclerView.setAdapter(new BaseRecyclerAdapter(dataList, getContext(), R.layout.items_webtoon));
        }
        recyclerView.setLayoutManager(layoutManager);
    }



}

