package com.server.btnanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class AnimationHelper {

    /**
     * 扩散动画
     */
    public static void spreadAni(View target, SimpleAnimatorListener endListener) {
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(target, "ScaleX", 0, 1);
        scaleXAnimator.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet animSet = new AnimatorSet();
        animSet.play(scaleXAnimator);
        animSet.setDuration(500);
        animSet.start();

        animSet.addListener(endListener);
    }

    /**
     * 对号动画
     */
    public static void checkMarkAni(View target, SimpleAnimatorListener endListener) {
        target.setVisibility(View.VISIBLE);
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(target, "alpha", 0, 1, 0);
        scaleXAnimator.setInterpolator(new DecelerateAccelerateInterpolator());

        AnimatorSet animSet = new AnimatorSet();
        animSet.play(scaleXAnimator);
        animSet.setDuration(1500);
        animSet.start();

        animSet.addListener(endListener);
    }

    /**
     * 签出文字动画
     */
    public static void SignOutAni(View target, SimpleAnimatorListener endListener) {
        target.setVisibility(View.VISIBLE);

        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(target, "alpha", 0, 1);
        scaleXAnimator.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet animSet = new AnimatorSet();
        animSet.play(scaleXAnimator);
        animSet.setDuration(200);
        animSet.start();

        animSet.addListener(endListener);
    }

    /**
     * 动画监听
     */
    static abstract class SimpleAnimatorListener implements Animator.AnimatorListener {
        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }

        @Override
        public void onAnimationStart(Animator animation) {

        }
    }
}
