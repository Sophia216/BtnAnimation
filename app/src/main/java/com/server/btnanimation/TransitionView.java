package com.server.btnanimation;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TransitionView extends RelativeLayout {

    private View mVSpread;
    private ImageView mIMCheckMark;
    private TextView mTVSignOut;

    private OnAnimationEndListener mOnAnimationEndListener;

    public TransitionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TransitionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        View mRootView = inflate(getContext(), R.layout.view_transtion, this);

        mVSpread = mRootView.findViewById(R.id.spread);
        mIMCheckMark = mRootView.findViewById(R.id.check_mark);
        mTVSignOut = mRootView.findViewById(R.id.sign_out);
    }

    public void startAnimation() {
        this.setVisibility(View.VISIBLE);

        AnimationHelper.spreadAni(mVSpread, new AnimationHelper.SimpleAnimatorListener() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startCheckMarkAni();
            }
        });
    }

    private void startCheckMarkAni() {
        AnimationHelper.checkMarkAni(mIMCheckMark, new AnimationHelper.SimpleAnimatorListener() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startSignOutAni();
            }
        });
    }

    private void startSignOutAni() {
        AnimationHelper.SignOutAni(mTVSignOut, new AnimationHelper.SimpleAnimatorListener() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (mOnAnimationEndListener != null) {
                    mOnAnimationEndListener.onEnd();
                }
            }
        });
    }

    void setOnAnimationEndListener(OnAnimationEndListener onAnimationEndListener) {
        this.mOnAnimationEndListener = onAnimationEndListener;
    }

    interface OnAnimationEndListener {
        void onEnd();
    }
}
