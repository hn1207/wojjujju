package com.rootup.friendzoo.friendzoo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.rootup.friendzoo.friendzoo.R;

import java.util.ArrayList;


public class TutorialUltraPagerAdapter extends PagerAdapter {
    private boolean isMultiScr;
    private ArrayList<Integer> dataList;
    Context con;


    public TutorialUltraPagerAdapter(boolean isMultiScr, ArrayList<Integer> dataList, Context con) {
        this.isMultiScr = isMultiScr;
        this.dataList= dataList;
        this.con=con;
    }


    public TutorialUltraPagerAdapter(boolean isMultiScr) {
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
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(container.getContext()).inflate(R.layout.activity_ultra_viewpager_tutorial_child, null);
        //new LinearLayout(container.getContext());

//        TextView textView = (TextView) linearLayout.findViewById(R.id.bg_image);
//        textView.setText(position + "");
//        linearLayout.setId(R.id.item_id);

        if(dataList!=null) {
            linearLayout.setBackgroundResource(dataList.get(position));
//            ImageView bg = linearLayout.findViewById(R.id.bg_image);
//            Glide.with(con)
//                    .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
//                    .load(dataList.get(position))
//                    .into(bg);
            container.addView(linearLayout);

        }else {


            switch (position) {
                case 0:
//


                    linearLayout.setBackgroundResource(R.drawable.beautyshop);
//                linearLayout.setBackgroundResource(R.drawable.fragment_home_tarco);
                    break;
                case 1:
                    linearLayout.setBackgroundResource(R.drawable.beautyshop2);
//                linearLayout.setBackgroundResource(R.drawable.fragment_home_chicken);
                    break;
                case 2:
                    linearLayout.setBackgroundResource(R.drawable.beautyshop3);
//                linearLayout.setBackgroundResource(R.drawable.fragment_home_tarco);
                    break;
                case 3:
                    linearLayout.setBackgroundResource(R.drawable.beautyshop4);
//                linearLayout.setBackgroundResource(R.drawable.fragment_home_chicken);
                    break;
                case 4:
                    linearLayout.setBackgroundResource(R.drawable.beautyshop5);
//                linearLayout.setBackgroundResource(R.drawable.fragment_home_chicken);
                    break;
            }
            container.addView(linearLayout);
//        linearLayout.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, container.getContext().getResources().getDisplayMetrics());
//        linearLayout.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, container.getContext().getResources().getDisplayMetrics());
        }
        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LinearLayout view = (LinearLayout) object;
        container.removeView(view);
    }
}