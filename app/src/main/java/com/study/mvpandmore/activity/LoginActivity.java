package com.study.mvpandmore.activity;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.study.mvpandmore.R;
import com.study.mvpandmore.adapter.FragmentAdapter;
import com.study.mvpandmore.fragment.LoginFragment;
import com.study.mvpandmore.fragment.RegisterFragment;
import com.study.mybase.view.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/test/login")
public
class LoginActivity extends BaseActivity {
    private com.google.android.material.tabs.TabLayout loginTabs;
    private androidx.viewpager.widget.ViewPager loginVp;

    @Override
    public void initView() {
        EventBus.getDefault().register(this);
        loginTabs = findViewById(R.id.login_tabs);
        loginVp = findViewById(R.id.login_vp);
    }

    @Override
    public void initData() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LoginFragment());
        fragments.add(new RegisterFragment());

        List<String> titles = new ArrayList<>();
        titles.add("登录");
        titles.add("注册");

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragments,titles);
        loginVp.setAdapter(fragmentAdapter);
        loginTabs.setupWithViewPager(loginVp);


    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void RegSuccess(String st){
        if (st.equals("1")){
            loginVp.setCurrentItem(0);
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
