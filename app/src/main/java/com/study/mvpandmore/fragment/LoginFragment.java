package com.study.mvpandmore.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.study.mvpandmore.R;
import com.study.mvpandmore.entity.ReturnMsg;
import com.study.mvpandmore.mvp.contract.IContract;
import com.study.mvpandmore.mvp.model.LoginModel;
import com.study.mvpandmore.mvp.presenter.LoginPresenter;
import com.study.mybase.presenter.IPresenter;
import com.study.mybase.view.BaseFragment;

public
class LoginFragment extends BaseFragment<LoginPresenter> implements IContract.ILoginView {

    private EditText loginUsernameEdit;
    private EditText loginPasswordEdit;
    private Button loginBtn;

    @Override
    public void initView() {

        loginUsernameEdit = (EditText) findViewById(R.id.login_username_edit);
        loginPasswordEdit = (EditText) findViewById(R.id.login_password_edit);
        loginBtn = (Button) findViewById(R.id.login_btn);
    }

    @Override
    public void initData() {
        presenter = new LoginPresenter(this,new LoginModel());
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(loginUsernameEdit.getText().toString(),loginPasswordEdit.getText().toString());
            }
        });
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoginMsg(ReturnMsg msg) {
        if (msg.getErrorCode()==0){
            showToast("登录成功");
            ARouter.getInstance().build("/test/index").navigation();
        }else {
            showToast("登录失败"+"   "+msg.getErrorMsg());
        }
    }
}
