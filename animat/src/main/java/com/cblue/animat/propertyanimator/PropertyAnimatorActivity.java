package com.cblue.animat.propertyanimator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cblue.animat.R;

public class PropertyAnimatorActivity extends AppCompatActivity {

    ImageView iv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animator);
        iv = (ImageView)findViewById(R.id.property_animator_iv);
    }

    public void show(View view){
        Toast.makeText(PropertyAnimatorActivity.this,"show",Toast.LENGTH_LONG).show();
    }

    public void move(View view){
       //动画效果
//        TranslateAnimation translateAnimation =new TranslateAnimation(0,200,0,0);
//        translateAnimation.setFillAfter(true);
//        translateAnimation.setDuration(2000);
//        iv.startAnimation(translateAnimation);

        //位移效果
  /*      ObjectAnimator.ofFloat(iv,"translationX",0,200f).setDuration(2000).start();
        //旋转效果
        ObjectAnimator.ofFloat(iv,"rotation",0F,260F).setDuration(2000).start();*/


        //动画的叠加效果(google优化Animator)
      /*  PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationY",0,200f);
        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("rotation",0,360f);
        ObjectAnimator.ofPropertyValuesHolder(iv,p1,p2).setDuration(2000).start();*/

        //动画叠加
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator oa1 = ObjectAnimator.ofFloat(iv,"translationX",0,200f);
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(iv,"alpha",0,1.0f);
        //animatorSet.playTogether(oa1,oa2);
        //animatorSet.playSequentially(oa1,oa2);
        animatorSet.play(oa2).after(oa1);
        animatorSet.setDuration(2000).start();

        //添加监听
       /* animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
              Toast.makeText(PropertyAnimatorActivity.this,"动画结束",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
*/
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(PropertyAnimatorActivity.this,"动画结束",Toast.LENGTH_LONG).show();
            }
        });





    }
}
