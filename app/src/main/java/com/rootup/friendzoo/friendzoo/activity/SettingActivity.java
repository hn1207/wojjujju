package com.rootup.friendzoo.friendzoo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.dialog.BaseGuideDialog;

public class SettingActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        findViewById(R.id.leave_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BaseGuideDialog baseGuideDialog = new BaseGuideDialog(SettingActivity.this, R.layout.dialog_leave_account);
                baseGuideDialog.show();

            }
        });



    }












}
