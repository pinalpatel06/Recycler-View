package com.knoxpo.recyclertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Tejas Sherdiwala on 11/21/2016.
 * &copy; Knoxpo
 */

public class MainFragment extends Fragment {

    private RecyclerView mItemsRV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main,container,false);

        init(v);

        ArrayList<String> items = new ArrayList<>();
        for(int i=0;i<100;i++){
            items.add("Item #"+i);
        }

        ItemAdapter adapter = new ItemAdapter(getActivity(),items);
        mItemsRV.setAdapter(adapter);

        mItemsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    private void init(View v){
        mItemsRV = (RecyclerView)v.findViewById(R.id.rv_items);
    }
}
