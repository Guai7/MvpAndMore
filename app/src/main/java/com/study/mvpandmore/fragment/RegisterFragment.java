package com.study.mvpandmore.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.study.mvpandmore.R;
import com.study.mvpandmore.entity.ReturnMsg;
import com.study.mvpandmore.mvp.contract.IContract;
import com.study.mvpandmore.mvp.model.RegisterModel;
import com.study.mvpandmore.mvp.presenter.RegisterPresenter;
import com.study.mybase.view.BaseFragment;

import org.greenrobot.eventbus.EventBus;

public
class RegisterFragment extends BaseFragment<RegisterPresenter> implements IContract.IRegView {
    private EditText registerUsernameEdit;
    private EditText registerPasswordEdit;
    private EditText registerRPasswordEdit;
    private Button registerBtn;

    @Override
    public void initView() {

        registerUsernameEdit = (EditText) findViewById(R.id.register_username_edit);
        registerPasswordEdit = (EditText) findViewById(R.id.register_password_edit);
        registerRPasswordEdit = (EditText) findViewById(R.id.register_r_password_edit);
        registerBtn = (Button) findViewById(R.id.register_btn);
    }

    @Override
    public void initData() {
        presenter = new RegisterPresenter(this,new RegisterModel());

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.register(registerUsernameEdit.getText().toString(),
                        registerPasswordEdit.getText().toString(),
                        registerRPasswordEdit.getText().toString()
                );
            }
        });
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_register;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRegMsg(ReturnMsg msg) {
        if (msg.getErrorCode()==0){
            showToast("注册成功");
            EventBus.getDefault().postSticky("1");
        }else {
            showToast("注册失败"+"   "+msg.getErrorMsg());
        }
    }
}
