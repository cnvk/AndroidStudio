package com.cblue.animat.tween;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.cblue.animat.R;

public class TweenAnimationActivity_XML extends AppCompatActivity implements View.OnClickListener {


    Button btn1,btn2,btn3,btn4,btn5;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation_activity__xml);
        btn1 = (Button)findViewById(R.id.tween_animation_alpha_btn);
        btn2 = (Button)findViewById(R.id.tween_animation_scale_btn);
        btn3 = (Button)findViewById(R.id.tween_animation_translate_btn);
        btn4 = (Button)findViewById(R.id.tween_animation_rotate_btn);
        btn5 = (Button)findViewById(R.id.tween_animation_set_btn);

        iv = (ImageView)findViewById(R.id.tween_animation_iv);

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
                Animation animation = AnimationUtils.loadAnimation(TweenAnimationActivity_XML.this,R.anim.alpha_test);
                iv.startAnimation(animation);
                break;

            case R.id.tween_animation_scale_btn:
                //缩放动画
                Animation animation1  = AnimationUtils.loadAnimation(TweenAnimationActivity_XML.this,R.anim.scale_test);
               /* iv.setAnimation(animation1);
                animation1.startNow();*/
                iv.startAnimation(animation1);
                break;

            case R.id.tween_animation_translate_btn:
                //位移动画
                Animation animation2 = AnimationUtils.loadAnimation(TweenAnimationActivity_XML.this,R.anim.translate_test);
                iv.startAnimation(animation2);
                break;

            case R.id.tween_animation_rotate_btn:
                //旋转动画
                Animation animation3 = AnimationUtils.loadAnimation(TweenAnimationActivity_XML.this,R.anim.rotate_test);
                iv.startAnimation(animation3);
                break;

            case R.id.tween_animation_set_btn:
                //集合动画
                Animation animation4 = AnimationUtils.loadAnimation(TweenAnimationActivity_XML.this,R.anim.set_test);
                iv.startAnimation(animation4);
                break;

        }
    }
}
