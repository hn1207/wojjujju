package com.ylabs.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.ylabs.wojjujju.wojjujju.R;

public class DonatePostPaymentDetailByCashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_post_payment_detail_by_cash);

        findViewById(R.id.donate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonatePostPaymentDetailByCashActivity.this, DonatePostPaymentCompleteActivity.class));
                finish();
            }
        });

        TextView textView = findViewById(R.id.donate_text);
        textView.setText(Html.fromHtml("<u>" + "후원 약관 동의" + "</u>"));

    }






}

