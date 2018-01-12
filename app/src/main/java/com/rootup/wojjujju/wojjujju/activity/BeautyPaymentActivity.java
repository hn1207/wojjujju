package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class BeautyPaymentActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_payment);

        initPaymentList();

        findViewById(R.id.complete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BeautyPaymentActivity.this, BeautyPaymentCompleteActivity.class));
                finish();
            }
        });

        String strFront = "<font color=\"#f62b4c\"><u>공정거래 위약금</u></font>에 따라 결제취소 및 노쇼( No-show : 사전연<br>락없이 예약된 숙소를 이용하지 않음)의 경우 요금이 100%정<br>상 청구됩니다.";
        TextView tv = findViewById(R.id.noshow_text);
        tv.setText(Html.fromHtml(strFront));


        String strFront2 = "<b><u>결제대행 서비스 표준이용약관</u></b>에 동의합니다. <font color=\"#f62b4c\">(필수)</font>";
        TextView tv2 = findViewById(R.id.service_text);
        tv2.setText(Html.fromHtml(strFront2));


        String strFront3 = "약관을 읽고 이해하였으며, 이에 동의합니다. <font color=\"#f62b4c\">(필수)</font>";
        TextView tv3 = findViewById(R.id.agree_text);
        tv3.setText(Html.fromHtml(strFront3));

    }



    void initPaymentList(){



        ArrayList<Item> paymentItemArrayList = new ArrayList<>();

        for(int i=0; i<3; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/beauty2.png");
            item.setTitle("[댕댕이 미용] ");
            item.setPrice("12,000원");
            item.setDate("예약일시 12.29 (화) 16:00 ");
            item.setContents("무슨무슨 컷 서비스 내용이 들어갑니다.");
            paymentItemArrayList.add(item);
        }


//        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));
//        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));






        RecyclerView paymentListView = (RecyclerView) findViewById(R.id.payment_item_list);
        paymentListView.setHasFixedSize(true);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyPaymentActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyPaymentActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (paymentItemArrayList.size() > 0) {
            paymentListView.setAdapter(new BaseRecyclerAdapter(paymentItemArrayList, BeautyPaymentActivity.this, R.layout.items_beauty_payment_item));
        }
        paymentListView.setLayoutManager(layoutManager);

    }

}
