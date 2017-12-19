package com.example.sfhan.testdemo.ViewPage;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by sfhan on 2017/12/18.
 */

public class DepthPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position) {
        //getMeasuredWidth()获取的是view原始的大小，也就是这个view在XML文件中配置或者是代码中设置的大小。
        // getWidth（）获取的是这个view最终显示的大小，这个大小有可能等于原始的大小也有可能不等于原始大小。
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // 这个页面在屏幕左边。
            //setAlpha(0)透明度，变化范围是0.0f到1.0f之间，一般用于渐变动画，或者手势滑动view的渐变效果
            view.setAlpha(0);

        } else if (position <= 0) { // [-1,0]
            // 在移动到左边页时使用默认幻灯片转换
            view.setAlpha(1);
            //函数setTranslationX和setTranslationY，api版本为11，是设置view相对原始位置的偏移量
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);

        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1 - position);

            //抵消默认滑动过渡
            view.setTranslationX(pageWidth * -position);

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else { // (1,+Infinity]
            // 这一页离右边的屏幕太远了。
            view.setAlpha(0);
        }
    }
}


