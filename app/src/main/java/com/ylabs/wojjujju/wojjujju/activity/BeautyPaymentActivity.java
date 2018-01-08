package com.ylabs.wojjujju.wojjujju.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.ylabs.wojjujju.wojjujju.R;
import com.ylabs.wojjujju.wojjujju.adapter.DateTimePickerAdapter;
import com.ylabs.wojjujju.wojjujju.adapter.PaymentItemAdapter;
import com.ylabs.wojjujju.wojjujju.entity.PaymentItem;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class BeautyPaymentActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_payment);

        initPaymentList();

//        findViewById(R.id.complete).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
    }



    void initPaymentList(){



        ArrayList<PaymentItem> paymentItemArrayList = new ArrayList<>();
        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));
        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));






        RecyclerView paymentListView = (RecyclerView) findViewById(R.id.payment_item_list);
        paymentListView.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyPaymentActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (paymentItemArrayList.size() > 0) {
            paymentListView.setAdapter(new PaymentItemAdapter(paymentItemArrayList, BeautyPaymentActivity.this, R.layout.items_beauty_payment_item));
        }
        paymentListView.setLayoutManager(layoutManager);

    }

}
