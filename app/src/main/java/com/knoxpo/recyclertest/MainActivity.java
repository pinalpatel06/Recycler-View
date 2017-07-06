package com.knoxpo.recyclertest;

import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity{

    @Override
    public Fragment getContentFragment() {
        return new Fragment2();
    }

}
