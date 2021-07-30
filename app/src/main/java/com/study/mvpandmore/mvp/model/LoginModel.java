package com.study.mvpandmore.mvp.model;

import com.study.mvpandmore.entity.ReturnMsg;
import com.study.mvpandmore.mvp.Api;
import com.study.mvpandmore.mvp.contract.IContract;
import com.study.mvpandmore.mvp.utils.LoginUtils;
import com.study.mybase.model.BaseModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public
class LoginModel extends BaseModel implements IContract.ILoginModel {
    @Override
    public void requestLogin(String username, String password, Observer<ReturnMsg> observer) {
        LoginUtils.getInstance()
                .getRetrofit()
                .create(Api.class)
                .login(username,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
