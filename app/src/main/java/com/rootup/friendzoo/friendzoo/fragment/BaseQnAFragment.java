package com.rootup.friendzoo.friendzoo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.activity.BaseQuestionEditActivity;
import com.rootup.friendzoo.friendzoo.adapter.QnaItemAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class BaseQnAFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_beauty_qna, container, false);

        initBeautyQnaItemList(view);

        view.findViewById(R.id.question_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BaseQuestionEditActivity.class));
            }
        });
        return view;
    }


    void initBeautyQnaItemList(View v){

        ArrayList<Item> beautyQnaItemArrayList = new ArrayList<Item>();
        for(int i=0; i<10; i++){
            Item item = new Item();
            switch (i%2){
                case 0:

                    item.setTitle("Q 질문이 들어갑니다");
                    item.setContents("질문내용이 들어갑니다. 질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.");
                    break;
                case 1:
                    item.setTitle("A 답변이 들어갑니다");
                    item.setContents("답변내용이 들어갑니다. 답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.");
                    break;
            }

            item.setDate("2017.09.23");
            item.setType(i%2);

            beautyQnaItemArrayList.add(item);
        }
//        beautyQnaItemArrayList.add(new QnaItem("Q 질문이 들어갑니다", "질문내용이 들어갑니다. 질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.", "  2017.09.23", 0));
//        beautyQnaItemArrayList.add(new QnaItem("A 답변이 들어갑니다", "답변내용이 들어갑니다. 답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.", "  2017.09.23", 1));
//        beautyQnaItemArrayList.add(new QnaItem("Q 질문이 들어갑니다", "질문내용이 들어갑니다. 질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.", "  2017.09.23", 0));
//        beautyQnaItemArrayList.add(new QnaItem("A 답변이 들어갑니다", "답변내용이 들어갑니다. 답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.", "  2017.09.23", 1));
//        beautyQnaItemArrayList.add(new QnaItem("Q 질문이 들어갑니다", "질문내용이 들어갑니다. 질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.", "  2017.09.23", 0));
//        beautyQnaItemArrayList.add(new QnaItem("A 답변이 들어갑니다", "답변내용이 들어갑니다. 답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.", "  2017.09.23", 1));
//        beautyQnaItemArrayList.add(new QnaItem("Q 질문이 들어갑니다", "질문내용이 들어갑니다. 질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.", "  2017.09.23", 0));
//        beautyQnaItemArrayList.add(new QnaItem("A 답변이 들어갑니다", "답변내용이 들어갑니다. 답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.", "  2017.09.23", 1));
//        beautyQnaItemArrayList.add(new QnaItem("Q 질문이 들어갑니다", "질문내용이 들어갑니다. 질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.질문내용이 들어갑니다.", "  2017.09.23", 0));
//        beautyQnaItemArrayList.add(new QnaItem("A 답변이 들어갑니다", "답변내용이 들어갑니다. 답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.답변내용이 들어갑니다.", "  2017.09.23", 1));




        RecyclerView beautyDefaultListView = (RecyclerView) v.findViewById(R.id.beauty_qna_list_view);
        beautyDefaultListView.setHasFixedSize(true);




//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);



        if (beautyQnaItemArrayList.size() > 0) {
            beautyDefaultListView.setAdapter(new QnaItemAdapter(beautyQnaItemArrayList, getActivity(), R.layout.items_beauty_detail_qna_item));
        }
        beautyDefaultListView.setLayoutManager(layoutManager);

    }




}

