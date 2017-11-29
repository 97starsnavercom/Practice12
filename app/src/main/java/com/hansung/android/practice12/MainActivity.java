package com.hansung.android.practice12;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mfirework;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mfirework = (ImageView) findViewById(R.id.fire);


    }


    @Override
    protected void onResume() {
        super.onResume();
        startFireWorksObjectPropertyAnimation();

    }

    private void startFireWorkPropertyAnimation() {
        ValueAnimator alphaAnimator = ValueAnimator.ofFloat(1, 0);
        alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator){
                float value = (float) valueAnimator.getAnimatedValue();
                mfirework.setAlpha(value);
            }
        });

        ValueAnimator scaleAnimator = ValueAnimator.ofFloat(0, 1);
        scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                mfirework.setScaleX(value);
                mfirework.setScaleY(value);
            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.play(alphaAnimator).with(scaleAnimator);
//        animatorSet.setStartDelay(2000);
        animatorSet.setDuration(2000);
        animatorSet.start();
//        animatorSet.addListener(animatorListener);

    }

    private void startFireWorkObjectPropertyAnimation() {
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mfirework, "alpha",
                1, 0);
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(mfirework,"scaleX",1,0.1f);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(mfirework,"scaleY",1,0.1f);

        AnimatorSet scaleanimatorSet = new AnimatorSet();
        scaleanimatorSet.playTogether(scaleXAnimator,scaleYAnimator);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alphaAnimator).after(scaleanimatorSet);

        animatorSet.setDuration(2000);
        animatorSet.setStartDelay(2000);
        animatorSet.start();
//        animatorSet.addListener(animatorListener);

    }

    private void startFireWorksObjectPropertyAnimation(){
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mfirework, "alpha",
                1, 0);
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(mfirework,"scaleX",1,0.1f);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(mfirework,"scaleY",1,0.1f);



        AnimatorSet scaleanimatorSet = new AnimatorSet();
        scaleanimatorSet.playTogether(scaleXAnimator,scaleYAnimator);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alphaAnimator).after(scaleanimatorSet);

        AnimatorSet scaleanimatorSet2 = new AnimatorSet();
        scaleanimatorSet2.playTogether(scaleXAnimator2,scaleYAnimator2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(alphaAnimator2).after(scaleanimatorSet2);

        animatorSet.setDuration(2000);
        animatorSet.setStartDelay(2000);
        animatorSet.start();
        animatorSet.addListener(animatorListener);



        animatorSet2.setDuration(2000);
        animatorSet2.setStartDelay(4000);
        animatorSet2.start();


    }

    Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animator) {
            Log.i(TAG, "onAnimationStart");
        }

        @Override
        public void onAnimationEnd(Animator animator) {
            Log.i(TAG, "onAnimationEnd");
        }

        @Override
        public void onAnimationCancel(Animator animator) {
            Log.i(TAG, "onAnimationCancel");
        }

        @Override
        public void onAnimationRepeat(Animator animator) {
            Log.i(TAG, "onAnimationRepeat");
        }
    };

    Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
            Log.i(TAG, "onAnimationStart");
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Log.i(TAG, "onAnimationEnd");
            finish();
            startActivity(new Intent(getApplicationContext(), SecondActivity.class));
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            Log.i(TAG, "onAnimationRepeat");
        }
    };




}
