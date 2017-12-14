package com.example.sfhan.testdemo.activity;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sfhan.testdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPageWXh extends BaseActivity implements ViewPager.OnPageChangeListener {
    private Context mContext=ViewPageWXh.this;
    private ViewPager viewPager;
    private TextView title;
    private LinearLayout dotGroup;
    private RelativeLayout activityMain;

    private int [] imageUrl={
            R.mipmap.xxx,
            R.mipmap.ccc,
            R.mipmap.vvv,
            R.mipmap.bbb,
            R.mipmap.nnn,
            R.mipmap.mmm
    };

    private List<ImageView> imageList;
    private LinearLayout dot_group;  //小圆点
    private String [] imageDescArrs;
    private static final String TAG="2017-12-14";
    private boolean isSwitchPager=false;  //默认不切换
    private int previousPosition=0;//默认为0

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page_wxh);
        initView();
    }


    private void initView(){
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        title= (TextView) findViewById(R.id.title);
        dotGroup= (LinearLayout) findViewById(R.id.dot_group);
        activityMain= (RelativeLayout) findViewById(R.id.activity_main);
        initViewPagerData();
        viewPager.setAdapter(new MyViewPager());

        //设置当前viewPager要显示的第几个条目
        int item = Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2 % imageList.size());
        Log.d(TAG, "item=" + item);

        /**在使用ViewPager的过程中，有需要直接跳转到某一个页面的情况，这个时候就需要用到ViewPager的setCurrentItem方法了，它的意思是跳转到ViewPager的指定页面
         */
        viewPager.setCurrentItem(item);

        //把第一个小圆点设置成白色，显示第一个TExtView内容
        dotGroup.getChildAt(previousPosition).setEnabled(true);
        title.setText(imageDescArrs[previousPosition]);
        //设置viewPager滑动监听事件
        viewPager.addOnPageChangeListener(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isSwitchPager){
                    SystemClock.sleep(3000);
                    handler.sendEmptyMessage(0);
                }
            }
        }).start();
    }


    private void initViewPagerData()
    {
        imageDescArrs=new String[]{"二大傻","卡卡西","我爱罗","二小傻","鸣人","大小傻"};
        imageList=new ArrayList<ImageView>();

        ImageView im;
        View dotView;
        for (int i=0;i<imageUrl.length;i++){
            im=new ImageView(mContext);

            //好用Glide需要导入jar包
            Glide.with(this).load(imageUrl[i])
                    .crossFade()
                    .centerCrop()
                    .into(im);
            imageList.add(im);
            //准备小圆点数据
            dotView=new View(getApplicationContext());
            dotView.setBackgroundResource(R.drawable.selector_dot);

            //设置小圆点宽和高
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(10,10);
            //设置每个小圆点之间的距离
            if (i !=0){
                params.leftMargin=13;
            }
            dotView.setLayoutParams(params);
            //设置小圆点状态
            dotView.setEnabled(false);
            //把dotView加入到线性布局中
            dotGroup.addView(dotView);

        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int newPostion = position % imageList.size();
        //取出postion的位置小圆点设置为true
        dotGroup.getChildAt(newPostion).setEnabled(true);
        //把一个小圆点设置为false
        dotGroup.getChildAt(previousPosition).setEnabled(false);
        title.setText(imageDescArrs[newPostion]);
        previousPosition = newPostion;

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isSwitchPager = false;
    }


//Apapder
    private class MyViewPager extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }
    //初始化每个条目要显示的内容
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPostion = position % imageList.size();
        //获取到条目要显示的内容imageView
        ImageView img = imageList.get(newPostion);
        container.addView(img);
        return img;
    }


        //是否复用当前view
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

    //销毁条目
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }
    }
}
