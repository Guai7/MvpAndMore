package com.study.mvpandmore.mvp.model;

import com.study.mvpandmore.entity.ReturnMsg;
import com.study.mvpandmore.mvp.Api;
import com.study.mvpandmore.mvp.contract.IContract;
import com.study.mvpandmore.mvp.utils.RegisterUtils;
import com.study.mybase.model.BaseModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public
class RegisterModel extends BaseModel implements IContract.IRegModel {
    @Override
    public void requestReg(String username, String password, String repassword, Observer<ReturnMsg> observer) {
        RegisterUtils.getInstance()
                .getRetrofit()
                .create(Api.class)
                .register(username,password,repassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
