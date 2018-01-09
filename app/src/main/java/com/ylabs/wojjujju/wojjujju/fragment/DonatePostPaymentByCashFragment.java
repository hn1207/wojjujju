package com.ylabs.wojjujju.wojjujju.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.activity.DonatePostActivity;
import com.ylabs.wojjujju.wojjujju.activity.DonatePostPaymentDetailByCashActivity;
import com.ylabs.wojjujju.wojjujju.adapter.BaseGridAdapter;
import com.ylabs.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class DonatePostPaymentByCashFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.items_donate_payment_by_cash, container, false);

        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DonatePostPaymentDetailByCashActivity.class));
            }
        });


        return view;
    }





}

