package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.rootup.friendzoo.friendzoo.R;
import com.rootup.friendzoo.friendzoo.adapter.BaseGridAdapter;
import com.rootup.friendzoo.friendzoo.dialog.BaseGuideDialog;
import com.rootup.friendzoo.friendzoo.dialog.BaseInnerHTMLDialog;
import com.rootup.friendzoo.friendzoo.entity.Item;

import java.util.ArrayList;


public class MemoriesAlbumProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories_album_profile);

        findViewById(R.id.update_nickname).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MemoriesAlbumProfileActivity.this, UpdateNickNameActivity.class));
            }
        });

        findViewById(R.id.delete_memories_album).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseGuideDialog baseGuideDialog = new BaseGuideDialog(MemoriesAlbumProfileActivity.this, R.layout.dialog_delete_memories_album);
                baseGuideDialog.show();
            }
        });




    }

}
