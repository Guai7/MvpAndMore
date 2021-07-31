package com.study.mvpandmore.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.study.mvpandmore.R;
import com.study.mybase.view.BaseActivity;

@Route(path = "/test/index")
public
class IndexActivity extends BaseActivity {

    private com.google.android.material.tabs.TabLayout indexTabs;
    private androidx.viewpager.widget.ViewPager indexVp;

    @Override
    public void initView() {


        indexTabs = findViewById(R.id.index_tabs);
        indexVp = findViewById(R.id.index_vp);
    }

    @Override
    public void initData() {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_index;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
