package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rootup.friendzoo.friendzoo.R;

public class HospitalDetailServiceGuideItemActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_detail_service_guide_item);

        TextView textView = findViewById(R.id.cut_name);
        textView.setText("슬개골 탈구 수술");

    }


}
