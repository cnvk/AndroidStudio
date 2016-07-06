package com.cblue.animat.tween.listener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import com.cblue.animat.R;

public class StartTweenAnimationActivity extends AppCompatActivity {

    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_tween_animation);
        iv = (ImageView)findViewById(R.id.start_tween_animation_iv);

        Animation animation = new AlphaAnimation(0,1.0f);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(StartTweenAnimationActivity.this, "动画执行完毕", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation.setDuration(5000);
        iv.startAnimation(animation);

    }
}
