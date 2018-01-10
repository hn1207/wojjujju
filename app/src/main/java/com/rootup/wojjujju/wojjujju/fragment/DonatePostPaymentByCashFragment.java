package com.rootup.wojjujju.wojjujju.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.activity.DonatePostPaymentDetailByCashActivity;

public class DonatePostPaymentByCashFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_donate_payment_by_cash, container, false);

        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DonatePostPaymentDetailByCashActivity.class));
            }
        });


        return view;
    }





}

