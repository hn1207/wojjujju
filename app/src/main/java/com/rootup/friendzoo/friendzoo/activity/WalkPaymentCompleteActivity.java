package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class WalkPaymentCompleteActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_payment_complete);

        initPaymentCompleteList();

//        findViewById(R.id.complete).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
    }



    void initPaymentCompleteList(){



        ArrayList<Item> paymentItemArrayList = new ArrayList<>();

        for(int i=0; i<1; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/sweetroom2.png");
            item.setTitle("상품의 전체제목이 들어갑니다.");
//            item.setPrice("12,000원");
//            item.setDate("예약일시 12.29 (화) 16:00 ");
            item.setContents("디럭스 스위트 룸 1 옵션내용이 들어갑니다.");
            paymentItemArrayList.add(item);
        }


//        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));
//        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));






        RecyclerView paymentListView = (RecyclerView) findViewById(R.id.payment_complete_item_list);
        paymentListView.setHasFixedSize(true);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyPaymentActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(WalkPaymentCompleteActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (paymentItemArrayList.size() > 0) {
            paymentListView.setAdapter(new BaseRecyclerAdapter(paymentItemArrayList, WalkPaymentCompleteActivity.this, R.layout.items_beauty_payment_item));
        }
        paymentListView.setLayoutManager(layoutManager);

    }

}
