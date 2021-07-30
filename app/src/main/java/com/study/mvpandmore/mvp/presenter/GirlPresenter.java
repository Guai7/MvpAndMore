package com.study.mvpandmore.mvp.presenter;

import com.blankj.utilcode.util.ToastUtils;
import com.study.mvpandmore.entity.GirlEntity;
import com.study.mvpandmore.mvp.contract.IContract;
import com.study.mybase.presenter.BasePresenter;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public
class GirlPresenter extends BasePresenter<IContract.IGirlView, IContract.IGirlModel> {
    public GirlPresenter(IContract.IGirlView view, IContract.IGirlModel model) {
        super(view, model);
    }

    public void getGirl(int page,int count){
        String url = "page/"+page+"/count/"+count;
        model.getGirl(url, new Observer<GirlEntity>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {

            }

            @Override
            public void onNext(@NotNull GirlEntity girlEntity) {
                view.showGirl(girlEntity.getData());
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
