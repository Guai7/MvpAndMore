package com.study.mvpandmore.activity;

import android.os.Handler;
import android.view.animation.AlphaAnimation;

import com.alibaba.android.arouter.launcher.ARouter;
import com.study.mvpandmore.R;
import com.study.mybase.view.BaseActivity;

public class ADActivity extends BaseActivity{


    private android.widget.ImageView adImg;

    @Override
    public void initView() {

        adImg = findViewById(R.id.ad_img);
    }

    @Override
    public void initData() {
        AlphaAnimation animation = new AlphaAnimation(0,1);
        animation.setDuration(2000);
        adImg.setAnimation(animation);
        animation.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ARouter.getInstance().build("/test/login").navigation();
            }
        },2000);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_ad;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}