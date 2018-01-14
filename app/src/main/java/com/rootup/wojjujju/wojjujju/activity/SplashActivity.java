package com.rootup.wojjujju.wojjujju.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.rootup.wojjujju.wojjujju.R;

public class SplashActivity extends AppCompatActivity {

    Handler handler;


    public final static String VIDEO_URL = "http://13.125.46.183/woojjujju/splash_bg.mov";
    public final static int URL = 1;
    public final static int SDCARD = 2;
    VideoView videoView;
    Button btnStart, btnStop;


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
                startActivity(new Intent(SplashActivity.this, SignInActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });


    }

    private void playVideo() {
        videoView.seekTo(0);
        videoView.start();
    }

}
