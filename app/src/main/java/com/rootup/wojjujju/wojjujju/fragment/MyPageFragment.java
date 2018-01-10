package com.rootup.wojjujju.wojjujju.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.activity.FAQActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPageAdoptHistoryActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPageBookHistoryActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPageCancelHistoryActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPageCouponHistoryActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPageCurrentHistoryActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPageLikeHistoryActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPageOpinionHistoryActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPagePointHistoryActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPagePostHistoryActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPageProfileActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPagePurchaseHistoryActivity;
import com.rootup.wojjujju.wojjujju.activity.MyPageReviewHistoryActivity;

public class MyPageFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_mypage, container, false);



        view.findViewById(R.id.faq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), FAQActivity.class));

            }
        });
        view.findViewById(R.id.review_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPageReviewHistoryActivity.class));

            }
        });

        view.findViewById(R.id.opinion_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPageOpinionHistoryActivity.class));

            }
        });

        view.findViewById(R.id.post_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPagePostHistoryActivity.class));

            }
        });

        view.findViewById(R.id.coupon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPageCouponHistoryActivity.class));

            }
        });

        view.findViewById(R.id.current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPageCurrentHistoryActivity.class));

            }
        });
        view.findViewById(R.id.profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPageProfileActivity.class));

            }
        });

        view.findViewById(R.id.point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPagePointHistoryActivity.class));

            }
        });
        view.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyPageLikeHistoryActivity.class));

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

