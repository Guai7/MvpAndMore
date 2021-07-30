package com.study.mvpandmore.mvp.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public
class RegisterUtils {
    private static RegisterUtils registerUtils;
    private Retrofit retrofit;

    public static RegisterUtils getInstance() {
        if (registerUtils==null){
            registerUtils = new RegisterUtils();
        }
        return registerUtils;
    }

    public Retrofit getRetrofit() {
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder()
                            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                            .build())
                    .baseUrl("https://www.wanandroid.com/user/")
                    .build();
        }
        return retrofit;
    }
}
