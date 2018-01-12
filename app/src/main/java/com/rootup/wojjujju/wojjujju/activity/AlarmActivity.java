package com.rootup.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.adapter.FAQExpandableAdapter;

import java.util.ArrayList;


public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        ExpandableListView listView = findViewById(R.id.data_list);


        final ArrayList<String> groupList = new ArrayList<>();
        final ArrayList<String> childList = new ArrayList<>();


        for (int i=0; i<20; i++) {
            groupList.add("우쭈쭈에서 첫 구매를 하시면 포인트가!");
            childList.add("알림에 대한 내용이 들어갑니다. 알림에 대한 내용이 들어갑니다. 알림에 대한 내용이 들어갑니다. 알림에 대한 내용이 들어갑니다. 알림에 대한 내용이 들어갑니다. 알림에 대한 내용이 들어갑니다. \n" +
                    "알림에 대한 내용이 들어갑니다. 알림에 대한 내용이 들어갑니다. 알림에 대한 내용이 들어갑니다. 알림에 대한 내용이 들어갑니다. 알림에 대한 내용이 들어갑니다. \n" +
                    "알림에 대한 내용이 들어갑니다. 알림에 대한 내용이 들어갑니다. \n" +
                    "알림에 대한 내용이 들어갑니다. 알림에 대한 내용이.\n\n2017.02.24");

        }


        listView.setAdapter(new FAQExpandableAdapter(getApplicationContext(), groupList, childList));



    }


}
