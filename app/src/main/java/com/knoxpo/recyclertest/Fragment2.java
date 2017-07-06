package com.knoxpo.recyclertest;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tejas Sherdiwala on 11/21/2016.
 * &copy; Knoxpo
 */

public class Fragment2 extends Fragment {

    private static final String
            TAG = Fragment2.class.getSimpleName(),
            STATE_LIST = TAG + "..STATE_LIST";

    private RecyclerView mItemsRV;
    private ArrayList<Person> mPersonList;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2, container, false);
        init(v);

        if(savedInstanceState!=null && savedInstanceState.containsKey(STATE_LIST)){
            mPersonList = savedInstanceState.getParcelableArrayList(STATE_LIST);
        }else{
            fillData();
        }

        mItemsRV.setAdapter(new MyAdapter());
        mItemsRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    private void init(View v) {
        mItemsRV = (RecyclerView) v.findViewById(R.id.rv_items);
        mPersonList = new ArrayList<>();
    }

    private void fillData(){
        Person person;
        for (int i = 0; i < 100; i++) {
            person = new Person();
            person.setFname("Fname" + i);
            person.setLname("Lname" + i);

            int randomNo = (int) (Math.random() * 100);
            person.setAge(randomNo);
            mPersonList.add(person);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
       outState.putParcelableArrayList(STATE_LIST,mPersonList);
        super.onSaveInstanceState(outState);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private LayoutInflater mInflater;

        public MyAdapter() {
            mInflater = LayoutInflater.from(getActivity());
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = mInflater.inflate(R.layout.item_list, parent, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bindItem(mPersonList.get(position));
        }

        @Override
        public int getItemCount() {
            return mPersonList.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNameTV, mAgeTV;
        private String mTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            mNameTV = (TextView) itemView.findViewById(R.id.tv_first_name);
            mAgeTV = (TextView) itemView.findViewById(R.id.tv_age);
        }

        public void bindItem(Person person) {
            mNameTV.setText(
                        getString(R.string.person_name, person.getFname(), person.getLname())
            );
            mAgeTV.setText(String.valueOf(person.getAge()));

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "Item Clicked: " + mTitle);
        }
    }

    private static class Person implements Parcelable{
        private String mFname, mLname;
        private int mAge;

        public Person() {
            this(null, null, 0);
        }

        public Person(String fname, String lname, int age) {
            mFname = fname;
            mLname = lname;
            mAge = age;
        }

        protected Person(Parcel in) {
            mFname = in.readString();
            mLname = in.readString();
            mAge = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(mFname);
            dest.writeString(mLname);
            dest.writeInt(mAge);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Person> CREATOR = new Creator<Person>() {
            @Override
            public Person createFromParcel(Parcel in) {
                return new Person(in);
            }

            @Override
            public Person[] newArray(int size) {
                return new Person[size];
            }
        };

        public String getFname() {
            return mFname;
        }

        public void setFname(String fname) {
            mFname = fname;
        }

        public String getLname() {
            return mLname;
        }

        public void setLname(String lname) {
            mLname = lname;
        }

        public int getAge() {
            return mAge;
        }

        public void setAge(int age) {
            this.mAge = age;
        }


    }
}
