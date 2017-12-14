package com.example.sfhan.testdemo.activity;

/**
 * Created by sfhan on 2017/12/13.
 */
import java.util.Random;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TabFragment extends Fragment {

    public static final int TITLE =0;
    private int mTitle = 0;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mTitle = getArguments().getInt(String.valueOf(TITLE));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        ImageView tv = new ImageView(getActivity());
//        tv.setTextSize(60);
        Random r = new Random();
//        tv.setBackgroundColor(Color.argb(r.nextInt(120), r.nextInt(255),
//                r.nextInt(255), r.nextInt(255)));


      tv.setScaleType(ImageView.ScaleType.CENTER);
        tv.setImageResource(mTitle);

        return tv;

    }

    public static TabFragment newInstance(int title)
    {
        TabFragment tabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(String.valueOf(TITLE), title);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

}