package com.rootup.wojjujju.wojjujju.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Html;
import android.view.Window;
import android.widget.TextView;

import com.rootup.wojjujju.wojjujju.R;


public class BaseGuideDialog extends Dialog {
    private int layout;
    private Context con;

    public BaseGuideDialog(@NonNull Context context, int layout) {
        super(context);
        this.layout = layout;
        this.con = context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(layout);




    }





}
