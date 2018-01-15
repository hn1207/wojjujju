package com.rootup.friendzoo.friendzoo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.rootup.friendzoo.friendzoo.R;

import java.util.ArrayList;

/**
 * Created by jerryjung on 2017. 12. 8..
 */

public class FAQExpandableAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private final ArrayList<String> mGroupList;
    private final ArrayList<String> mChildList;

    public FAQExpandableAdapter(final Context context, final ArrayList<String> groupList, final ArrayList<String> childList) {
        this.mContext = context;
        this.mGroupList = groupList;
        this.mChildList = childList;
    }

    @Override
    public int getGroupCount() {
        return mGroupList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return mGroupList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mChildList.get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            view = inflater.inflate(R.layout.listview_row_faq, viewGroup, false);
        }

        final String postTitle = mGroupList.get(i);

        final TextView tvPostId = view.findViewById(R.id.faq_tv_post_id);
        tvPostId.setText(String.valueOf(i + 1) + ".");


        final TextView tvPostTitle = view.findViewById(R.id.faq_tv_post_title);
        tvPostTitle.setText(postTitle);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            view = inflater.inflate(R.layout.listview_row_faq_detail, viewGroup, false);
        }

        final String postContents = mChildList.get(i);

        final TextView tvPostContents = view.findViewById(R.id.faq_tv_post_contents);
        tvPostContents.setText(postContents);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
