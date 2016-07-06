package com.cblue.animat.frame;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cblue.animat.R;

public class FrameAnimationActivity_Java extends AppCompatActivity implements View.OnClickListener {


    Button btn1,btn2;
    ImageView iv;
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation_activity__java);
        btn1 = (Button)findViewById(R.id.frame_animation_java_btn1);
        btn2 = (Button)findViewById(R.id.frame_animation_java_btn2);
        iv = (ImageView)findViewById(R.id.frame_animation_java_iv);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        //完成每帧动画的加载
        animationDrawable = new AnimationDrawable();
        for(int i=1;i<=6;i++){
            //根据包名，类名，文件名从R文件获得资源ID
           int RsID =   getResources().getIdentifier("pic"+i,"drawable","com.cblue.animat");
            //根据资源ID获得资源对象
            Drawable drawable =  getResources().getDrawable(RsID);
            //给动画添加图片
            animationDrawable.addFrame(drawable,200);
            animationDrawable.setOneShot(false);
        }
        //让我们的动画与ImageView产生关联关系
        iv.setImageDrawable(animationDrawable);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frame_animation_java_btn1:
                animationDrawable.start();

                break;
            case R.id.frame_animation_java_btn2:
                animationDrawable.stop();
                break;
        }

    }
}
