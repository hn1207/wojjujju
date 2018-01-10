package com.ylabs.wojjujju.wojjujju.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.activity.MyPageAdoptHistoryActivity;
import com.ylabs.wojjujju.wojjujju.activity.MyPageBookHistoryActivity;
import com.ylabs.wojjujju.wojjujju.activity.MyPageCancelHistoryActivity;
import com.ylabs.wojjujju.wojjujju.activity.MyPageProfileActivity;
import com.ylabs.wojjujju.wojjujju.activity.MyPagePurchaseHistoryActivity;

public class MyPageFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        view.findViewById(R.id.profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPageProfileActivity.class));

            }
        });

        view.findViewById(R.id.adopt_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPageAdoptHistoryActivity.class));

            }
        });

        view.findViewById(R.id.book_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPageBookHistoryActivity.class));

            }
        });


        view.findViewById(R.id.cancel_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPageCancelHistoryActivity.class));

            }
        });


        view.findViewById(R.id.purchase_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPagePurchaseHistoryActivity.class));

            }
        });




        return view;
    }




}

