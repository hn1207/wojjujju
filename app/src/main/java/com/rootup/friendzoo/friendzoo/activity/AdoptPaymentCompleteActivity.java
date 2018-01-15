package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.widget.TextView;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseRecyclerAdapter;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;

public class AdoptPaymentCompleteActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_payment_complete);

        String strFront = "*잠깐! 아직 ";
        String strFront2 = "<font color=\"#f62b4c\">입양확정이 아닙니다.</font><br>";
        String strChange = "<b>오프라인으로 면담 진행 후 </b>";
        String strChange2 = "확정 결과를 알 수 있어요.<br>애정과 책임감으로 반려동물을 키울 사람을<br>찾기 위한 과정이므로 이해부탁드려요. :)";

        TextView tv = findViewById(R.id.adopt_text);
        tv.setText(Html.fromHtml(strFront + strFront2 + strChange + strChange2));

        initCompleteList();

//        findViewById(R.id.complete).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

    }



    void initCompleteList(){



        ArrayList<Item> paymentItemArrayList = new ArrayList<>();

        for(int i=0; i<3; i++) {
            Item item = new Item();
            item.setImg("http://13.125.46.183/woojjujju/beauty2.png");
            item.setTitle("애교가 많고 귀여운 포리");
            item.setContents("스피츠 / 1세 / 여 / 3.3kg");
            item.setCnt(2);
            paymentItemArrayList.add(item);
        }


//        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));
//        paymentItemArrayList.add(new PaymentItem(null,"[댕댕이 미용] ","12,000원","예약일시 12.29 (화) 16:00 ","무슨무슨 컷 서비스 내용이 들어갑니다."));






        RecyclerView paymentListView = (RecyclerView) findViewById(R.id.payment_complete_item_list);
        paymentListView.setHasFixedSize(true);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(BeautyPaymentActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(AdoptPaymentCompleteActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (paymentItemArrayList.size() > 0) {
            paymentListView.setAdapter(new BaseRecyclerAdapter(paymentItemArrayList, AdoptPaymentCompleteActivity.this, R.layout.items_sell_payment));
        }
        paymentListView.setLayoutManager(layoutManager);

    }

}
