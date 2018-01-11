package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class EducationPaymentActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_payment);

        initPaymentList();


        findViewById(R.id.complete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EducationPaymentActivity.this, EducationPaymentCompleteActivity.class));
                finish();
            }
        });
        findViewById(R.id.coupon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EducationPaymentActivity.this, MyPageCouponHistoryActivity.class));

            }
        });
    }





    void initPaymentList(){



        ArrayList<Item> paymentItemArrayList = new ArrayList<>();

        for(int i=0; i<3; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/beauty2.png");
            item.setTitle("상품의 전체제목이 들어갑니다.");
            item.setPrice("12,000원");
            item.setDate("예약일시 12.29 (화) 13:00 ");
            item.setContents("행동교정치료 365패키지 옵션내용이 들어감.");
            item.setCnt(i%7);
            paymentItemArrayList.add(item);
        }






        RecyclerView paymentListView = (RecyclerView) findViewById(R.id.payment_item_list);
        paymentListView.setHasFixedSize(true);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyPaymentActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(EducationPaymentActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (paymentItemArrayList.size() > 0) {
            paymentListView.setAdapter(new BaseRecyclerAdapter(paymentItemArrayList, EducationPaymentActivity.this, R.layout.items_shop_payment_item));
        }
        paymentListView.setLayoutManager(layoutManager);

    }

}
