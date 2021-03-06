package com.study.mybase.presenter;

import com.study.mybase.model.IModel;
import com.study.mybase.view.IView;

public abstract
class BasePresenter<V extends IView,M extends IModel> implements IPresenter{

    protected V view;
    protected M model;

    public BasePresenter(V view, M model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void destroy() {
        if (model!=null){
            model.destroy();
            model = null;
        }
    }
}
