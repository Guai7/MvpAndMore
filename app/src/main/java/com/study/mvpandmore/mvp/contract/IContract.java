package com.study.mvpandmore.mvp.contract;

import com.study.mvpandmore.entity.GirlEntity;
import com.study.mvpandmore.entity.ReturnMsg;
import com.study.mybase.model.IModel;
import com.study.mybase.view.IView;

import java.util.List;

import io.reactivex.Observer;

public
interface IContract {
    /**
     *  用于获取”Girl“数据的接口
     */
    interface IGirlModel extends IModel {
        void getGirl(String url,Observer<GirlEntity> observer);
    }

    /**
     * 用于展示”Girl“数据的接口
     */
    interface IGirlView extends IView {
        void showGirl(List<GirlEntity.DataBean> list);
    }

    /**
     * 用于请求登录数据的接口
     */
    interface ILoginModel extends IModel{
        void requestLogin(String username,String password,Observer<ReturnMsg> observer);
    }

    /**
     * 用于展示登录结果的接口
     */
    interface ILoginView extends IView{
        void showLoginMsg(ReturnMsg msg);
    }

    /**
     * 用于请求注册数据的接口
     */
    interface IRegModel extends IModel{
        void requestReg(String username,String password,String repassword,Observer<ReturnMsg> observer);
    }

    /**
     * 用于展示注册结果的接口
     */
    interface IRegView extends IView{
        void showRegMsg(ReturnMsg msg);
    }
}
