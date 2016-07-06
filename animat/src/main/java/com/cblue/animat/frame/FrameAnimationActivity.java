package com.cblue.animat.frame;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cblue.animat.R;

public class FrameAnimationActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn1,btn2;
    ImageView iv;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        btn1 = (Button)findViewById(R.id.frame_animation_btn01);
        btn2 = (Button)findViewById(R.id.frame_animation_btn02);
        iv = (ImageView)findViewById(R.id.frame_animation_iv);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        animationDrawable = (AnimationDrawable) iv.getBackground();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frame_animation_btn01:
                animationDrawable.start();
                break;

            case R.id.frame_animation_btn02:
                animationDrawable.stop();
                break;
        }
    }
}
