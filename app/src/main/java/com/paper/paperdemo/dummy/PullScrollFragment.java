package com.paper.paperdemo.dummy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.paper.customview.PullToZoomScrollViewEx;
import com.paper.paperdemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PullScrollFragment extends Fragment {
    private PullToZoomScrollViewEx scrollView;

    public PullScrollFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pull_scroll, container, false);
        scrollView =(PullToZoomScrollViewEx)view.findViewById(R.id.scroll_view);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollView.setHeaderLayoutParams(localObject);
        scrollView.setZoomEnabled(true);
        return view;
    }


}
