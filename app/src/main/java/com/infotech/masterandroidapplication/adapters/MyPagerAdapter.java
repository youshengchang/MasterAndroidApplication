package com.infotech.masterandroidapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.infotech.masterandroidapplication.fragments.ContactFragment;
import com.infotech.masterandroidapplication.fragments.ContactListFragment;
import com.infotech.masterandroidapplication.fragments.ListFragment;
import com.infotech.masterandroidapplication.fragments.SettingsFragment;

/**
 * Created by youshengchang on 7/9/16.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new ListFragment();
            case 1:
                return new ContactListFragment();
            case 2:
                return new SettingsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0 :
                return "LIST";
            case 1 :
                return "CONTACT";
            case 2 :
                return "SETTINGS";
            default:
                return null;
        }
    }
}
