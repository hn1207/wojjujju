package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.dialog.BaseGuideDialog;

public class SignInActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        findViewById(R.id.find_pw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseGuideDialog baseGuideDialog = new BaseGuideDialog(SignInActivity.this, R.layout.dialog_find_pw);
                baseGuideDialog.show();
            }
        });
    }

    public void clickSignInBtn(View v){
        startActivity(new Intent(SignInActivity.this, MainActivity.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    public void clickSignUpBtn(View v){
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

}
