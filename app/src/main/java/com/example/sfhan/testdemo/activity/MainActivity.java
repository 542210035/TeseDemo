package com.example.sfhan.testdemo.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.sfhan.testdemo.R;
import com.example.sfhan.testdemo.util.MyDialogUtil;

public class MainActivity extends BaseActivity {
    private Button btn;
    Button btn2, btn3;
    private MyDialogUtil adu;
    private Context mContext=MainActivity.this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                initView();
            }
        });

        initView();
    }
    private void initView(){
        adu=new MyDialogUtil(mContext,R.layout.item_alertdialog,R.style.MyDialogStyle);
        adu.showAlertDialog();

                btn2= (Button) adu.getAduView().findViewById(R.id.btn2);
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adu.dismissAlertDialog();
                    }
                });
        btn3= (Button) adu.getAduView().findViewById(R.id.clean);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adu.dismissAlertDialog();
            }
        });



    }
}
