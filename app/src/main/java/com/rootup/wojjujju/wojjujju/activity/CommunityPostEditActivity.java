package com.rootup.wojjujju.wojjujju.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rootup.wojjujju.wojjujju.R;


public class CommunityPostEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_post_edit);




        initSpinner();








    }


    void initSpinner(){
        Spinner categorySpinner = (Spinner)findViewById(R.id.category_filter);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.community_post_category_filter, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);




    }


}
