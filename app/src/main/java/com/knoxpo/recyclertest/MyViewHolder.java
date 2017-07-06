package com.knoxpo.recyclertest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Tejas Sherdiwala on 11/21/2016.
 * &copy; Knoxpo
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitleTV, mSubTitleTV;

    public MyViewHolder(View itemView) {
        super(itemView);
       // mTitleTV = (TextView)itemView.findViewById(R.id.tv_title);
       // mSubTitleTV = (TextView)itemView.findViewById(R.id.tv_sub_title);
    }

    public void bindMyHolder(String str){
        mTitleTV.setText(str);
        mSubTitleTV.setText("Sub Title");
    }
}
