package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.rootup.wojjujju.wojjujju.R;
import com.rootup.wojjujju.wojjujju.dialog.BaseGuideDialog;
import com.rootup.wojjujju.wojjujju.dialog.BaseInnerHTMLDialog;

public class SplashActivity extends AppCompatActivity {

    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        videoView = (VideoView) findViewById(R.id.video);
        videoView.requestFocus();


        int videoName = R.raw.friend_zoo_bg;

        final String path = "android.resource://" + getPackageName() + "/" + videoName;

        videoView.setVideoURI(Uri.parse(path));



        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                playVideo();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playVideo();
            }
        });


        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, TutorialActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });



//        ReliefNumberGuideDialog reliefNumberGuideDialog = new ReliefNumberGuideDialog(SplashActivity.this, R.layout.dialog_relief_number);
//        reliefNumberGuideDialog.show();
//
//        ReliefPickUpGuideDialog reliefPickUpGuideDialog = new ReliefPickUpGuideDialog(SplashActivity.this, R.layout.dialog_relief_number);
//        reliefPickUpGuideDialog.show();


//        BaseInnerHTMLDialog baseGuideDialog = new BaseInnerHTMLDialog(SplashActivity.this, R.layout.dialog_memories_level_up,R.string.memories_level_up);
//        baseGuideDialog.show();

//        BaseGuideDialog baseGuideDialog = new BaseGuideDialog(SplashActivity.this, R.layout.dialog_find_pw);
//        baseGuideDialog.show();


    }

    private void playVideo() {
        videoView.seekTo(0);
        videoView.start();
    }

}
