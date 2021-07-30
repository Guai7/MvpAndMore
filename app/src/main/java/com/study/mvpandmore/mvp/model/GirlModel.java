package com.study.mvpandmore.mvp.model;

import com.study.mvpandmore.entity.GirlEntity;
import com.study.mvpandmore.mvp.Api;
import com.study.mvpandmore.mvp.contract.IContract;
import com.study.mvpandmore.mvp.utils.GetGirlUtils;
import com.study.mybase.model.BaseModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public
class GirlModel extends BaseModel implements IContract.IGirlModel {
    @Override
    public void getGirl(String url, Observer<GirlEntity> observer) {
        GetGirlUtils.getInstance()
                .getRetrofit()
                .create(Api.class)
                .getGirl(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
}
