package com.example.sfhan.testdemo.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by sfhan on 2017/12/7.
 */

public class MyDialogUtil {

    private Context context;
    private int layout;
    private View view;
    private AlertDialog dialog;
    private int style;


    public MyDialogUtil(Context context, int layout,int style) {
        this.context = context;
        this.layout = layout;
        this.style=style;
    }


    public void showAlertDialog(){

        AlertDialog.Builder builder=new AlertDialog.Builder(context,style);

        view= LayoutInflater.from(context).inflate(layout,null);

        builder.setView(view);

        dialog=builder.create();

        dialog.setCancelable(false);

        dialog.show();

    }

    public View getAduView(){

        return view!=null?view:null;
    }

    public void dismissAlertDialog(){
        dialog.dismiss();
    }

}
