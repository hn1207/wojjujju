package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class SellPaymentActivityByNotPickUp extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_payment_by_not_pickup);

        initPaymentList();
//        initSpinner();

        findViewById(R.id.complete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SellPaymentActivityByNotPickUp.this, SellPaymentCompleteActivity.class));
                finish();
            }
        });
        findViewById(R.id.coupon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SellPaymentActivityByNotPickUp.this, MyPageCouponHistoryActivity.class));

            }
        });
    }



    void initPaymentList(){



        ArrayList<Item> paymentItemArrayList = new ArrayList<>();

        for(int i=0; i<1; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/beauty2.png");
            item.setTitle("귀여운 시바견 하쿠");
            item.setPrice("320,000원 ");
            item.setDate("방문일시 12.29 (화) 15:00~18:00 ");
//            item.setContents("옵션내용이 들어갑니다. 옵션내용이 들어갑니다.");
//            item.setCnt(i%7);
            paymentItemArrayList.add(item);
        }


//        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));
//        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));






        RecyclerView paymentListView = (RecyclerView) findViewById(R.id.payment_item_list);
        paymentListView.setHasFixedSize(true);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyPaymentActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(SellPaymentActivityByNotPickUp.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (paymentItemArrayList.size() > 0) {
            paymentListView.setAdapter(new BaseRecyclerAdapter(paymentItemArrayList, SellPaymentActivityByNotPickUp.this, R.layout.items_sell_payment));
        }
        paymentListView.setLayoutManager(layoutManager);

    }

}
