package com.example.sfhan.testdemo.Fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sfhan.testdemo.R;
import com.example.sfhan.testdemo.ViewPage.ViewPageMAX;
import com.example.sfhan.testdemo.ViewPage.ViewPageWXh;
import com.example.sfhan.testdemo.activity.BaseActivity;
import com.example.sfhan.testdemo.activity.LoginActivity;
import com.example.sfhan.testdemo.activity.MainActivity;

public class FragmentAll extends BaseActivity implements AdapterView.OnItemClickListener {

    private Context mContext=FragmentAll.this;
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
            "Fragment",
            "Fragment",
            "Fragment",
            "Fragment",
            "Fragment"
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_all);
        initView();
    }


    private void initView(){
        gridView= (GridView) findViewById(R.id.gr_login);
        gridView.setAdapter(new adaptern());
        gridView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position)
        {
            case 0:
                intent=new Intent(mContext,MainActivity.class);
                startActivity(intent);
                break;

            case 1:
                intent=new Intent(mContext,ViewPageMAX.class);
                startActivity(intent);
                break;

            case 2:
                intent=new Intent(mContext,MainActivity.class);
                startActivity(intent);
                break;


            case 3:
                intent=new Intent(mContext,ViewPageWXh.class);
                startActivity(intent);
                break;





        }
    }

    private class adaptern extends BaseAdapter {

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
