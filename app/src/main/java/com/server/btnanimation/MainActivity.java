package com.server.btnanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TransitionView mAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAnimView = findViewById(R.id.ani_view);

        mAnimView.setOnAnimationEndListener(new TransitionView.OnAnimationEndListener()
        {
            @Override
            public void onEnd()
            {
                //TODO 动画结束后跳转业务逻辑
            }
        });
    }

    public void singIn(View view)
    {
        mAnimView.startAnimation();
    }
}
