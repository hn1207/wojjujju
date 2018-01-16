package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;


public class CommunityPostDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_post_detail);


        initDonatePostReviewList();


        TextView textView = findViewById(R.id.post_comment);


        RecyclerView recyclerView = findViewById(R.id.donate_post_review_list);

        recyclerView.setFocusable(false);


    }


    void initDonatePostReviewList() {

        ArrayList<Item> dataList = new ArrayList<Item>();

        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/user.png");
            item.setContents("댓글 내용이 들어갑니다. 댓글 내용이 들어갑니다. 댓글 내용이 들어갑니다.");
            item.setUserName("장지후");
            item.setDate("2017.10.03");
            dataList.add(item);
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.donate_post_review_list);
        recyclerView.setHasFixedSize(true);

//
//        recyclerView.addOnItemTouchListener(
//                new RecyclerItemClickListener(DonatePostActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int position) {
//                        // do whatever
////                        startActivity(new Intent(DonatePostActivity.this, BeautyDetailActivity.class));
//                    }
//
//                    @Override
//                    public void onLongItemClick(View view, int position) {
//                        // do whatever
//                    }
//                }));


        LinearLayoutManager layoutManager = new LinearLayoutManager(CommunityPostDetailActivity.this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        if (dataList.size() > 0) {
            recyclerView.setAdapter(new BaseRecyclerAdapter(dataList, CommunityPostDetailActivity.this, R.layout.items_donate_post_review));
        }
        recyclerView.setLayoutManager(layoutManager);

    }
}
