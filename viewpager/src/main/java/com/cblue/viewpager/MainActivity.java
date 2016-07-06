package com.cblue.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager实现引导页面
 *  实现创建不同View
 *  然后把View放到适配器中
 *
 *  通过Fragment实现的主界面效果
 *
 * */


public class MainActivity extends FragmentActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {


    private LinearLayout ll1,ll2,ll3;
    private Fragment01 fragment01;
    private Fragment02 fragment02;
    private Fragment03 fragment03;
    private List<Fragment> fragments;
    private ViewPager viewPager;

    private TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll1 =(LinearLayout) findViewById(R.id.ll1);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        ll3 = (LinearLayout)findViewById(R.id.ll3);
        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);

        fragments = new ArrayList<Fragment>();
        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();
        fragments.add(fragment01);
        fragments.add(fragment02);
        fragments.add(fragment03);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);

        viewPager =(ViewPager) findViewById(R.id.myviewpager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(this);

        setTabColor(0);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //设置文字颜色
    @Override
    public void onPageSelected(int position) {
         setTabColor(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //设置标题的颜色
    private void setTabColor(int position){
        resetTabColor();
        switch (position){
            case 0:
                tv1.setTextColor(Color.parseColor("#ff0000"));
                break;
            case 1:
                tv2.setTextColor(Color.parseColor("#ff0000"));
                break;
            case 2:
                tv3.setTextColor(Color.parseColor("#ff0000"));
                break;
        }
    }
    //重置标题颜色
    private void resetTabColor(){
        tv1.setTextColor(Color.parseColor("#000000"));
        tv2.setTextColor(Color.parseColor("#000000"));
        tv3.setTextColor(Color.parseColor("#000000"));
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll1:
                 viewPager.setCurrentItem(0);
                break;
            case R.id.ll2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll3:
                viewPager.setCurrentItem(2);
                break;
        }
    }
}
