package com.study.mvpandmore.mvp.presenter;

import com.blankj.utilcode.util.ToastUtils;
import com.study.mvpandmore.entity.ReturnMsg;
import com.study.mvpandmore.mvp.contract.IContract;
import com.study.mybase.presenter.BasePresenter;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public
class LoginPresenter extends BasePresenter<IContract.ILoginView, IContract.ILoginModel> {
    public LoginPresenter(IContract.ILoginView view, IContract.ILoginModel model) {
        super(view, model);
    }

    public void login(String username,String password){
        model.requestLogin(username, password, new Observer<ReturnMsg>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {

            }

            @Override
            public void onNext(@NotNull ReturnMsg returnMsg) {
                view.showLoginMsg(returnMsg);
            }

            @Override
            public void onError(@NotNull Throwable e) {
                ToastUtils.showShort(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
