package com.knoxpo.recyclertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Tejas Sherdiwala on 11/21/2016.
 * &copy; Knoxpo
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    public abstract Fragment getContentFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(getContainerId());

        if (fragment == null) {
            fm.beginTransaction().replace(getContainerId(), getContentFragment()).commit();
        }
    }

    protected int getContainerId() {
        return R.id.fragment_container;
    }
}
