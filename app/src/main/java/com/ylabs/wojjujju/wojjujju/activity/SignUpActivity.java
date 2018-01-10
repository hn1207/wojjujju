package com.ylabs.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.ylabs.wojjujju.wojjujju.R;

public class SignUpActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView textview = findViewById(R.id.personal);
        textview.setText(Html.fromHtml("<u>" + "개인 정보 취급 방침" + "</u>" + "  및  " + "<u>" + "이용 약관" + "</u>"));

    }



    public void clickSignUpBtn(View v){
        startActivity(new Intent(SignUpActivity.this, SignInProfileActivity.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

}
