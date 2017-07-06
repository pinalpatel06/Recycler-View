package com.knoxpo.recyclertest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Tejas Sherdiwala on 11/21/2016.
 * &copy; Knoxpo
 */

public class ItemAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<String> mItems;

    public ItemAdapter(Context context,ArrayList<String> items){
        mInflater = LayoutInflater.from(context);
        mItems = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.item_list,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindMyHolder(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
