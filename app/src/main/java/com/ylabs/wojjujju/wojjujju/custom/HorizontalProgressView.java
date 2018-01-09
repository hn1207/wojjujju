package com.ylabs.wojjujju.wojjujju.custom;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

public class HorizontalProgressView extends RoundCornerProgressBar {
    private final int ANIMATION_DURATION = 2000; //milliseconds

    public HorizontalProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void animateView(int fromProgress, int toProgress) {
        ValueAnimator mProgressAnimator = new ValueAnimator();

        mProgressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                HorizontalProgressView.this.setProgress((Integer) animation.getAnimatedValue());
            }
        });

        mProgressAnimator.setDuration(ANIMATION_DURATION);
        mProgressAnimator.setIntValues(fromProgress, toProgress);
        mProgressAnimator.start();
    }
}