package com.study.mvpandmore.mvp.presenter;

import com.blankj.utilcode.util.ToastUtils;
import com.study.mvpandmore.entity.ReturnMsg;
import com.study.mvpandmore.mvp.contract.IContract;
import com.study.mybase.presenter.BasePresenter;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public
class RegisterPresenter extends BasePresenter<IContract.IRegView, IContract.IRegModel> {
    public RegisterPresenter(IContract.IRegView view, IContract.IRegModel model) {
        super(view, model);
    }
    public void register(String username,String password,String repassword){
        model.requestReg(username, password, repassword, new Observer<ReturnMsg>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {

            }

            @Override
            public void onNext(@NotNull ReturnMsg returnMsg) {
                view.showRegMsg(returnMsg);
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
