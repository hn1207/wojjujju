package com.rootup.friendzoo.friendzoo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.activity.DonatePostPaymentCompleteActivity;

public class DonatePostPaymentByPointFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_donate_payment_by_point, container, false);



        view.findViewById(R.id.donate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), DonatePostPaymentCompleteActivity.class));
                getActivity().finish();
            }
        });

        return view;
    }





}

