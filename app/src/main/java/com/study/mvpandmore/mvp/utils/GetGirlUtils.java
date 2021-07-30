package com.study.mvpandmore.mvp.utils;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public
class GetGirlUtils {
    private static GetGirlUtils girlUtils;
    private Retrofit retrofit;

    public static GetGirlUtils getInstance() {
        if (girlUtils==null){
            girlUtils = new GetGirlUtils();
        }
        return girlUtils;
    }

    public Retrofit getRetrofit() {
//        "page/1/count/10"
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder()
                            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                            .build())
                    .baseUrl("https://gank.io/api/v2/data/category/Girl/type/Girl/")
                    .build();
        }
        return retrofit;
    }
}
