package com.cblue.viewpager.pagetabstrip;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

import com.cblue.viewpager.Fragment01;
import com.cblue.viewpager.Fragment02;
import com.cblue.viewpager.Fragment03;
import com.cblue.viewpager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用PageTabStrip标签实现主界面效果
 */
public class Main2Activity extends FragmentActivity {


    PagerTabStrip pagerTabStrip;
    ViewPager viewPager;

    List<Fragment> fragments = new ArrayList<Fragment>();
    Fragment01 fragment01;
    Fragment02 fragment02;
    Fragment03 fragment03;
    String [] titls={"标题1","标题2","标题3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pagerTabStrip = (PagerTabStrip)findViewById(R.id.pts);
        pagerTabStrip.setTabIndicatorColor(Color.parseColor("#0000ff"));
        pagerTabStrip.setBackgroundColor(Color.parseColor("#00ff00"));

        viewPager = (ViewPager)findViewById(R.id.pagetabstrip_vp);
        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03  = new Fragment03();
        fragments.add(fragment01);
        fragments.add(fragment02);
        fragments.add(fragment03);

        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));

    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter{

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titls[position];
        }
    }

}
