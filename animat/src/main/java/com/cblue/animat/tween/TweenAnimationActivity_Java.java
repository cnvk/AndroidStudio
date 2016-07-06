package com.cblue.animat.tween;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.cblue.animat.R;

/**
 * Created by pavel on 2016/7/5.
 */
public class TweenAnimationActivity_Java extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5;
    ImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation_activity__xml);
        initView();
        intiListener();
    }


    private void initView() {
        btn1 = (Button)findViewById(R.id.tween_animation_alpha_btn);
        btn2 = (Button)findViewById(R.id.tween_animation_scale_btn);
        btn3 = (Button)findViewById(R.id.tween_animation_translate_btn);
        btn4 = (Button)findViewById(R.id.tween_animation_rotate_btn);
        btn5 = (Button)findViewById(R.id.tween_animation_set_btn);
        iv = (ImageView)findViewById(R.id.tween_animation_iv);

    }

    private void intiListener() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tween_animation_alpha_btn:
             //透明度动画
                Animation a1 = new AlphaAnimation(0f,1.0f);
                a1.setDuration(2000);
                iv.startAnimation(a1);
                break;
            case R.id.tween_animation_scale_btn:
             //缩放动画
                Animation a2 = new ScaleAnimation(1.0f,0,1.0f,0,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                a2.setRepeatCount(2);
                a2.setDuration(1000);
                iv.startAnimation(a2);
                break;

            case R.id.tween_animation_translate_btn:
               //位移动画
                Animation a3 = new TranslateAnimation(0,200,0,0);
                //accelerate_decelerate_interpolator
                a3.setInterpolator(new AccelerateDecelerateInterpolator());
                a3.setDuration(2000);
                iv.startAnimation(a3);
                break;

            case R.id.tween_animation_rotate_btn:
               //旋转动画
                Animation a4 = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                a4.setDuration(2000);
                iv.startAnimation(a4);

                break;

            case R.id.tween_animation_set_btn:
                //集合动画
                AnimationSet set = new AnimationSet(false);

                AlphaAnimation alphaAnimation = new AlphaAnimation(0,1.0f);
                alphaAnimation.setDuration(1000);
                set.addAnimation(alphaAnimation);

                TranslateAnimation tranlateAnimation = new TranslateAnimation(0,200,0,0);
                tranlateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                tranlateAnimation.setDuration(2000);
                set.addAnimation(tranlateAnimation);

                iv.startAnimation(set);

                break;


        }
    }
}
