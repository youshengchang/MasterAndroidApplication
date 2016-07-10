package com.infotech.masterandroidapplication;


import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.infotech.masterandroidapplication.fragments.DetailFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);



/*
        DetailFragment detailFragment = DetailFragment.newInstance(0);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, detailFragment);
        ft.addToBackStack(null);
        ft.commit();
*/
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)&&(getSupportFragmentManager().getBackStackEntryCount() > 0)){
            getSupportFragmentManager().popBackStack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
