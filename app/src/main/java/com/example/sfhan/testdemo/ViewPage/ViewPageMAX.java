package com.example.sfhan.testdemo.ViewPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sfhan.testdemo.R;
import com.example.sfhan.testdemo.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewPageMAX extends BaseActivity implements AdapterView.OnItemClickListener{

    private Context mContext=ViewPageMAX.this;
    private GridView gridView;
    private Intent intent;
    private int [] itemImage=new int[]{
            R.color.bbb,
            R.color.aaa,
            R.color.ccc,
            R.color.ddd,
            R.color.eee

    };
    private String [] strNick= new String[]{
            "滑动填充字体颜色",
            "无限循环带圆点",
            "ViewPageTab",
            "ViewPage",
            "ViewPage"
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page_max);
        initView();
    }


    private void initView(){
        gridView= (GridView) findViewById(R.id.gr_loginn);
        gridView.setAdapter(new adapterr());
        gridView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position)
        {
            case 0:
                intent=new Intent(mContext,ViewPageDEemo.class);
                startActivity(intent);
                break;

            case 1:
                intent=new Intent(mContext,ViewPageWXh.class);
                startActivity(intent);
                break;

            case 2:
                intent=new Intent(mContext,ViewPageTab.class);
                startActivity(intent);
                break;


            case 3:
                intent=new Intent(mContext,ViewPageWXh.class);
                startActivity(intent);
                break;
        }
    }


    private class adapterr extends BaseAdapter {
        @Override
        public int getCount() {
            return itemImage.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view= LayoutInflater.from(mContext).inflate(R.layout.gr_adapter_content,null);
            ImageView iv= (ImageView) view.findViewById(R.id.ap_iV);
            iv.setImageResource(itemImage[position]);
            TextView tv= (TextView) view.findViewById(R.id.ap_tv);
            tv.setText(""+strNick[position]);
            return view;
        }
    }
}
