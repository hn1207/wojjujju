package com.rootup.friendzoo.friendzoo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rootup.friendzoo.friendzoo.R;

import java.util.ArrayList;


public class BaseUltraPagerAdapter extends PagerAdapter {
    private boolean isMultiScr;
    private ArrayList<String> dataList;
    Context con;


    public BaseUltraPagerAdapter(boolean isMultiScr, ArrayList<String> dataList, Context con) {
        this.isMultiScr = isMultiScr;
        this.dataList= dataList;
        this.con=con;
    }


    public BaseUltraPagerAdapter(boolean isMultiScr) {
        this.isMultiScr = isMultiScr;
//        this.dataList= dataList;
//        this.con=con;
    }

    @Override
    public int getCount() {
        if(dataList != null){
            return dataList.size();
        }


        return 5;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView img = (ImageView) LayoutInflater.from(container.getContext()).inflate(R.layout.activity_ultra_viewpager_child, null);
        //new LinearLayout(container.getContext());

//        TextView textView = (TextView) linearLayout.findViewById(R.id.bg_image);
//        textView.setText(position + "");
//        linearLayout.setId(R.id.item_id);
//        ImageView bg_image =

        if(dataList!=null) {
            try{
                Glide.with(con).applyDefaultRequestOptions(RequestOptions.centerCropTransform()).load(dataList.get(position)).into(img);}catch (Exception e){};
//            ImageView bg = linearLayout.findViewById(R.id.bg_image);
//            Glide.with(con)
//                    .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
//                    .load(dataList.get(position))
//                    .into(bg);
            container.addView(img);

        }else {


            switch (position) {
                case 0:
//
                    img.setBackgroundResource(R.drawable.beautyshop);
//                linearLayout.setBackgroundResource(R.drawable.fragment_home_tarco);
                    break;
                case 1:
                    img.setBackgroundResource(R.drawable.beautyshop2);
//                linearLayout.setBackgroundResource(R.drawable.fragment_home_chicken);
                    break;
                case 2:
                    img.setBackgroundResource(R.drawable.beautyshop3);
//                linearLayout.setBackgroundResource(R.drawable.fragment_home_tarco);
                    break;
                case 3:
                    img.setBackgroundResource(R.drawable.beautyshop4);
//                linearLayout.setBackgroundResource(R.drawable.fragment_home_chicken);
                    break;
                case 4:
                    img.setBackgroundResource(R.drawable.beautyshop5);
//                linearLayout.setBackgroundResource(R.drawable.fragment_home_chicken);
                    break;
            }
            container.addView(img);
//        linearLayout.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, container.getContext().getResources().getDisplayMetrics());
//        linearLayout.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, container.getContext().getResources().getDisplayMetrics());
        }
        return img;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView view = (ImageView) object;
        container.removeView(view);
    }
}