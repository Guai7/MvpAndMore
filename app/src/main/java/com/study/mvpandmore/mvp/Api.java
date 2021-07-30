package com.study.mvpandmore.mvp;

import com.study.mvpandmore.entity.GirlEntity;
import com.study.mvpandmore.entity.ReturnMsg;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public
interface Api {
    @GET
    Observable<GirlEntity> getGirl(@Url String url);    //int page,int count

    @POST("login")
    @FormUrlEncoded
    Observable<ReturnMsg> login(@Field("username")String username,@Field("password")String password);

    @POST("register")
    @FormUrlEncoded
    Observable<ReturnMsg> register(@Field("username")String username,@Field("password")String password,@Field("repassword")String repassword);

}
