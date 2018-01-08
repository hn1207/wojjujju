package com.ylabs.wojjujju.wojjujju.custom;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.google.android.gms.maps.MapView;

public class MyMapView extends MapView {
//    public MyMapView(Context context, String apiKey) {
//        super(context, apiKey);
//    }

    public MyMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyMapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction();
        this.getParent().requestDisallowInterceptTouchEvent(true);
//        switch (action) {
//            case (MotionEvent.ACTION_DOWN):
//                Log.i("HoneyMap", "TouchDown");
//                break;
//            case (MotionEvent.ACTION_UP):
//                Log.i("HoneyMap", "TouchUp");
//                break;
//            default:
//                break;
//        }
        return super.dispatchTouchEvent(event);
    }


}
