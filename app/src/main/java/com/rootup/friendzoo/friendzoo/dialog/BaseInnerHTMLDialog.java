package com.rootup.friendzoo.friendzoo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Html;
import android.view.Window;
import android.widget.TextView;

import com.rootup.friendzoo.friendzoo.R;


public class BaseInnerHTMLDialog extends Dialog {
    private int layout;
    private Context con;
    private int string;

    public BaseInnerHTMLDialog(@NonNull Context context, int layout, int string) {
        super(context);
        this.layout = layout;
        this.con = context;
        this.string  = string;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(layout);

        TextView guideText = findViewById(R.id.guide_text);
        guideText.setText(Html.fromHtml(con.getResources().getString(string)));


    }





}
