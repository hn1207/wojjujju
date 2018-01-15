package com.rootup.friendzoo.friendzoo.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.FAQExpandableAdapter;

import java.util.ArrayList;


public class FAQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        ExpandableListView listView = findViewById(R.id.data_list);


        final ArrayList<String> groupList = new ArrayList<>();
        final ArrayList<String> childList = new ArrayList<>();

        for (int i=0; i<20; i++) {
            groupList.add("질문이 들어갑니다. 질문이 들어갑니다.");
            childList.add("질문에 대한 답이 들어갑니다. 질문에 대한 답이 들어갑니다.질문에 대한 답이 들어갑니다.질문에 대한 답이 들어갑니다.질문에 대한 답이 들어갑니다.");
        }


        listView.setAdapter(new FAQExpandableAdapter(getApplicationContext(), groupList, childList));



    }


}
