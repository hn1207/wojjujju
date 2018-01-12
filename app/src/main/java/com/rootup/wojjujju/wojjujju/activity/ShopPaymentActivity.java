package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.BaseRecyclerAdapter;
import com.rootup.wojjujju.wojjujju.entity.Item;

import java.util.ArrayList;

public class ShopPaymentActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_payment);

        initPaymentList();
        initSpinner();

        findViewById(R.id.complete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopPaymentActivity.this, ShopPaymentCompleteActivity.class));
                finish();
            }
        });
        findViewById(R.id.coupon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopPaymentActivity.this, MyPageCouponHistoryActivity.class));

            }
        });

        String strFront = "<u>결제대행 서비스 표준이용약관</u>";
        String strChange = "에 동의합니다.";
        String strBack = " <font color=\"#f62b4c\">(필수)</font>";
        TextView tv = findViewById(R.id.payment_text);
        tv.setText(Html.fromHtml(strFront + strChange + strBack));



    }



    void initSpinner(){
        // Spinner
        Spinner defaultSpinner = (Spinner)findViewById(R.id.delivery_memo);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.delivery_memo, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defaultSpinner.setAdapter(adapter);






    }


    void initPaymentList(){



        ArrayList<Item> paymentItemArrayList = new ArrayList<>();

        for(int i=0; i<3; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/feed.png");
            item.setTitle("캣만두 라이프 500g ");
            item.setPrice("12,000원");
//            item.setDate("예약일시 12.29 (화) 16:00 ");
            item.setContents("옵션내용이 들어갑니다. 옵션내용이 들어갑니다.");
            item.setCnt(i%7);
            paymentItemArrayList.add(item);
        }


//        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));
//        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));






        RecyclerView paymentListView = (RecyclerView) findViewById(R.id.payment_item_list);
        paymentListView.setHasFixedSize(true);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyPaymentActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ShopPaymentActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (paymentItemArrayList.size() > 0) {
            paymentListView.setAdapter(new BaseRecyclerAdapter(paymentItemArrayList, ShopPaymentActivity.this, R.layout.items_shop_payment_item));
        }
        paymentListView.setLayoutManager(layoutManager);

    }

}
