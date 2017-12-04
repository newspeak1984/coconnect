package com.example.ivanchow.portablepc;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;



public class MyGroups extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_groups);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout =(TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager);
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return FirstFragment.newInstance("All News");
                case 1: return FirstFragment.newInstance("Sports and Clubs");
                case 2: return FirstFragment.newInstance("Trends");
                case 3: return FirstFragment.newInstance("Entertainment");
                case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 1");
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {

                case 0: return ("All News");
                case 1: return ("Sports and Clubs");
                case 2: return ("Trends");
                case 3: return ("Entertainment");
                case 4: return ("Edits");
                default: return null;
            }
        }
    }
}
